package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.po.TextResult;
import cn.myhomespace.zhou.service.PublicService;
import cn.myhomespace.zhou.service.WeixinService;
import cn.myhomespace.zhou.utils.SendMessage;
import cn.myhomespace.zhou.utils.Utils;
import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import static cn.myhomespace.zhou.common.Content.MESSAGE_TYPE_SEND_KINDLE;

/**
 * @author Binary Wang
 */
@RestController
@RequestMapping("/weixin/security")
public class WxMpPortalController {
  @Autowired
  private WeixinService wxService;

  @Autowired
  private PublicService publicService;
  
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @ResponseBody
  @GetMapping(produces = "text/plain;charset=utf-8")
  public String authGet(@RequestParam(name = "signature", required = false) String signature,
      @RequestParam(name = "timestamp", required = false) String timestamp,
      @RequestParam(name = "nonce", required = false) String nonce,
      @RequestParam(name = "echostr", required = false) String echostr) {
    this.logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature, timestamp, nonce, echostr);

    if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
      throw new IllegalArgumentException("请求参数非法，请核实!");
    }

    if (this.getWxService().checkSignature(timestamp, nonce, signature)) {
      return echostr;
    }

    return "非法请求";
  }

  @ResponseBody
  @PostMapping(produces = "application/xml; charset=UTF-8")
  public String post(@RequestBody String requestBody, @RequestParam("signature") String signature,
      @RequestParam(name = "encrypt_type", required = false) String encType,
      @RequestParam(name = "msg_signature", required = false) String msgSignature,
      @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce) {
    this.logger.info(
        "\n接收微信请求：[signature=[{}], encType=[{}], msgSignature=[{}],"
            + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
        signature, encType, msgSignature, timestamp, nonce, requestBody);

    if (!this.wxService.checkSignature(timestamp, nonce, signature)) {
      throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
    }

    String out = null;
    if (encType == null) {
      // 明文传输的消息
      WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
      String content=inMessage.getContent();
      String[] msg=content.split("\\|\\|");
//      this.logger.debug("\n用户发送的内容：\n{} ", content);

      if(msg.length==3){
        String msgType=msg[0];
        String bookName=msg[1];
        String kindleEmail=msg[2];
        if(MESSAGE_TYPE_SEND_KINDLE.equals(msgType)){
          String message=publicService.publicService(msg);
          inMessage.setContent(message);
        }

      }else{
        SendMessage sendMessage = new SendMessage();
        String sb=sendMessage.getConnectionByPost(content, Utils.getIp());
        TextResult textResult = JSONObject.parseObject(sb, TextResult.class);
        logger.info(textResult.toString());
        inMessage.setContent(textResult.getText());
      }
      this.logger.debug("\n用户发送的内容：\n{} ", inMessage.getContent());
      //WxMpXmlOutMessage outMessage = this.getWxService().route(inMessage);
      WxMpXmlOutTextMessage outMessage = WxMpXmlOutMessage.TEXT().content(inMessage.getContent())
              .fromUser(inMessage.getToUser()).toUser(inMessage.getFromUser())
              .build();
      if (outMessage == null) {
        return "";
      }

      out = outMessage.toXml();
    } else if ("aes".equals(encType)) {
      // aes加密的消息
      WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(requestBody,
          this.getWxService().getWxMpConfigStorage(), timestamp, nonce, msgSignature);
      this.logger.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
      WxMpXmlOutMessage outMessage = this.getWxService().route(inMessage);
      if (outMessage == null) {
        return "";
      }

      out = outMessage.toEncryptedXml(this.getWxService().getWxMpConfigStorage());
    }

    this.logger.debug("\n组装回复信息：{}", out);

    return out;
  }

  protected WeixinService getWxService() {
    return this.wxService;
  }

}
