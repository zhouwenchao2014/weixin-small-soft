package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.Content;
import cn.myhomespace.zhou.common.ErrorMessage;
import cn.myhomespace.zhou.mapper.InviteCodeMapper;
import cn.myhomespace.zhou.mapper.UserManageMapper;
import cn.myhomespace.zhou.po.InviteCode;
import cn.myhomespace.zhou.po.UserManage;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhouw on 2017/4/15.
 */
@RestController
@RequestMapping("/weixin/bandingKindleEmail")
public class BandingKindleEmailController {

    private Logger logger = LoggerFactory.getLogger(KindleMessageController.class);

    @Autowired
    private InviteCodeMapper inviteCodeMapper;

    @Autowired
    private UserManageMapper userManageMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String openId=request.getParameter("openId");
        String kindleEmail=request.getParameter("kindleEmail");
        String code=request.getParameter("code");
        Map<String,String> result = new HashMap<>();
        if(!kindleEmail.endsWith(Content.END_WITH)){
            result.put("bandingStatus","false");
            result.put("errorCode", ErrorMessage.ERROE_KINDLE_EMAIL.getCode());
            result.put("errorMessage", ErrorMessage.ERROE_KINDLE_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(kindleEmail);
        if(!m.matches()){
            result.put("bandingStatus","false");
            result.put("errorCode", ErrorMessage.ERROE_EMAIL.getCode());
            result.put("errorMessage", ErrorMessage.ERROE_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
        UserManage userManage = new UserManage();
        userManage.setUuid(UUID.randomUUID().toString().replace("-",""));
        userManage.setKindleEmail(kindleEmail);
        userManage.setOpenId(openId);
        if(code!=null){
            List<InviteCode> contain = inviteCodeMapper.isContain(code);
            if(contain==null&&contain.size()<=0){
                result.put("bandingStatus","false");
                result.put("code", ErrorMessage.ERROR_INVITE_CODE.getCode());
                result.put("message", ErrorMessage.ERROR_INVITE_CODE.getMessage());
                return JSONObject.toJSONString(result);
            }else{
                userManage.setIsCode("1");
                userManage.setIsVip("0");
                userManage.setIsCommon("0");
            }
        }else{
            userManage.setIsCode("0");
            userManage.setIsVip("0");
            userManage.setIsCommon("1");
        }
        int insert = userManageMapper.insert(userManage);
        if(insert>0){
            result.put("bandingStatus","true");
            result.put("code", ErrorMessage.SUCCESS_BANDING_EMAIL.getCode());
            result.put("message", ErrorMessage.SUCCESS_BANDING_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
        result.put("bandingStatus","false");
        result.put("code", ErrorMessage.ERROR_BANDING_EMAIL.getCode());
        result.put("message", ErrorMessage.ERROR_BANDING_EMAIL.getMessage());
        return JSONObject.toJSONString(result);
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String openId=request.getParameter("openId");
        String kindleEmail=request.getParameter("kindleEmail");
        String code=request.getParameter("code");
        Map<String,String> result = new HashMap<>();
        if(!kindleEmail.endsWith(Content.END_WITH)){
            result.put("bandingStatus","false");
            result.put("errorCode", ErrorMessage.ERROE_KINDLE_EMAIL.getCode());
            result.put("errorMessage", ErrorMessage.ERROE_KINDLE_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(kindleEmail);
        if(!m.matches()){
            result.put("bandingStatus","false");
            result.put("errorCode", ErrorMessage.ERROE_EMAIL.getCode());
            result.put("errorMessage", ErrorMessage.ERROE_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
        UserManage userManage = new UserManage();
        userManage.setUuid(UUID.randomUUID().toString().replace("-",""));
        userManage.setKindleEmail(kindleEmail);
        userManage.setOpenId(openId);
        if(code!=null){
            List<InviteCode> contain = inviteCodeMapper.isContain(code);
            if(contain==null&&contain.size()<=0){
                result.put("bandingStatus","false");
                result.put("code", ErrorMessage.ERROR_INVITE_CODE.getCode());
                result.put("message", ErrorMessage.ERROR_INVITE_CODE.getMessage());
                return JSONObject.toJSONString(result);
            }else{
                userManage.setIsCode("1");
                userManage.setIsVip("0");
                userManage.setIsCommon("0");
            }
        }else{
            userManage.setIsCode("0");
            userManage.setIsVip("0");
            userManage.setIsCommon("1");
        }
        int insert = userManageMapper.insert(userManage);
        if(insert>0){
            result.put("bandingStatus","true");
            result.put("code", ErrorMessage.SUCCESS_BANDING_EMAIL.getCode());
            result.put("message", ErrorMessage.SUCCESS_BANDING_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
        result.put("bandingStatus","false");
        result.put("code", ErrorMessage.ERROR_BANDING_EMAIL.getCode());
        result.put("message", ErrorMessage.ERROR_BANDING_EMAIL.getMessage());
        return JSONObject.toJSONString(result);
    }
}
