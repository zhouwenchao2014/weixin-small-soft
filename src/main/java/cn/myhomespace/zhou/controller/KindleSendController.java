package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.Content;
import cn.myhomespace.zhou.common.ErrorMessage;
import cn.myhomespace.zhou.common.KindleBookManageType;
import cn.myhomespace.zhou.mapper.*;
import cn.myhomespace.zhou.po.*;
import cn.myhomespace.zhou.utils.DownLoadFile;
import cn.myhomespace.zhou.utils.SendKindle;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
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
@RequestMapping("/weixin/kindleSend")
public class KindleSendController {

    private Logger logger = LoggerFactory.getLogger(KindleSendController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @Autowired
    private SendKindle sendKindle;

    @Autowired
    private KindleEmailMapper kindleEmailMapper;

    @Autowired
    private KindleBookManageMapper kindleBookManageMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        String openId=request.getParameter("openId");
        Map<String,Object> params = new HashMap<>();
        params.put("openId",openId);
        params.put("isMasterEmail",1);
        List<KindleEmail> kindleEmails = kindleEmailMapper.queryByParams(params);
        Map<String,String> result = new HashMap<>();

        if(kindleEmails!=null&&kindleEmails.size()>0){
            List<KindleEbook> kindleEbooks= kindleEbookMapper.queryByParam(bookName);
            String kindleName=kindleEmails.get(0).getKindleEmail();
            bookName = kindleEbooks.get(0).getBookName();
            if(!bookName.contains(".mobi")){
                bookName=bookName+".mobi";
            }
            boolean isSend=false;
            //boolean isdown= DownLoadFile.downLoadFileWithPath(kindleEbooks.get(0).getUrl(),bookName,sendKindle.getDownloadPath());
            boolean isdown=true;
            if (isdown) {
                isSend = sendKindle.sendKindle(kindleName, bookName);
            }else{
                result.put("sendStatus","false");
                result.put("code", ErrorMessage.DOWNLOAD_FAIL.getCode());
                result.put("message", ErrorMessage.DOWNLOAD_FAIL.getMessage());
                return JSONObject.toJSONString(result);
            }
            if(isSend){
                KindleBookManage kindleBookManage = new KindleBookManage();
                kindleBookManage.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
                kindleBookManage.setOpenId(openId);
                kindleBookManage.setBookId(kindleEbooks.get(0).getId()+"");
                kindleBookManage.setBookName(kindleEbooks.get(0).getBookName());
                kindleBookManage.setType(KindleBookManageType.SEND.getCode());
                kindleBookManage.setCreateTime(new Date(System.currentTimeMillis()));
                kindleBookManageMapper.insert(kindleBookManage);
                Map<String,Object> params1 = new HashMap<>();
                params1.put("sendTimes","1");
                params1.put("id",kindleEbooks.get(0).getId());
                kindleEbookMapper.updateById(params1);
                result.put("sendStatus","true");
                result.put("code", ErrorMessage.SEND_SUCCESS.getCode());
                result.put("message", ErrorMessage.SEND_SUCCESS.getMessage());
                return JSONObject.toJSONString(result);
            }else{
                result.put("sendStatus","false");
                result.put("code", ErrorMessage.SEND_FAIL.getCode());
                result.put("message", ErrorMessage.SEND_FAIL.getMessage());
                return JSONObject.toJSONString(result);
            }
        }else {
            result.put("sendStatus","false");
            result.put("code", ErrorMessage.NO_MASTER_EMAIL.getCode());
            result.put("message", ErrorMessage.NO_MASTER_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }

    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        String openId=request.getParameter("openId");
        Map<String,Object> params = new HashMap<>();
        params.put("openId",openId);
        params.put("isMasterEmail",1);
        List<KindleEmail> kindleEmails = kindleEmailMapper.queryByParams(params);
        Map<String,String> result = new HashMap<>();

        if(kindleEmails!=null&&kindleEmails.size()>0){
            List<KindleEbook> kindleEbooks= kindleEbookMapper.queryByParam(bookName);
            String kindleName=kindleEmails.get(0).getKindleEmail();
            bookName = kindleEbooks.get(0).getBookName();
            if(!bookName.contains(".mobi")){
                bookName=bookName+".mobi";
            }
            boolean isSend=false;
            //boolean isdown= DownLoadFile.downLoadFileWithPath(kindleEbooks.get(0).getUrl(),bookName,sendKindle.getDownloadPath());
            boolean isdown=true;
            if (isdown) {
                isSend = sendKindle.sendKindle(kindleName, bookName);
            }else{
                result.put("sendStatus","false");
                result.put("code", ErrorMessage.DOWNLOAD_FAIL.getCode());
                result.put("message", ErrorMessage.DOWNLOAD_FAIL.getMessage());
                return JSONObject.toJSONString(result);
            }
            if(isSend){
                KindleBookManage kindleBookManage = new KindleBookManage();
                kindleBookManage.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
                kindleBookManage.setOpenId(openId);
                kindleBookManage.setBookId(kindleEbooks.get(0).getId()+"");
                kindleBookManage.setBookName(kindleEbooks.get(0).getBookName());
                kindleBookManage.setType(KindleBookManageType.SEND.getCode());
                kindleBookManage.setCreateTime(new Date(System.currentTimeMillis()));
                kindleBookManageMapper.insert(kindleBookManage);
                Map<String,Object> params1 = new HashMap<>();
                params1.put("sendTimes","1");
                params1.put("id",kindleEbooks.get(0).getId());
                kindleEbookMapper.updateById(params1);
                result.put("sendStatus","true");
                result.put("code", ErrorMessage.SEND_SUCCESS.getCode());
                result.put("message", ErrorMessage.SEND_SUCCESS.getMessage());
                return JSONObject.toJSONString(result);
            }else{
                result.put("sendStatus","false");
                result.put("code", ErrorMessage.SEND_FAIL.getCode());
                result.put("message", ErrorMessage.SEND_FAIL.getMessage());
                return JSONObject.toJSONString(result);
            }
        }else {
            result.put("sendStatus","false");
            result.put("code", ErrorMessage.NO_MASTER_EMAIL.getCode());
            result.put("message", ErrorMessage.NO_MASTER_EMAIL.getMessage());
            return JSONObject.toJSONString(result);
        }
    }
}
