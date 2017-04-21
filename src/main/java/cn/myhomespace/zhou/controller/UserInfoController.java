package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.KindleBookManageType;
import cn.myhomespace.zhou.mapper.KindleBookManageMapper;
import cn.myhomespace.zhou.mapper.KindleEmailMapper;
import cn.myhomespace.zhou.po.KindleBookManage;
import cn.myhomespace.zhou.po.KindleEmail;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouwenchao on 2017/4/16.
 */
@RestController
@RequestMapping("/weixin/userInfo")
public class UserInfoController{

    @Autowired
    private KindleEmailMapper kindleEmailMapper;

    @Autowired
    private KindleBookManageMapper kindleBookManageMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String openId = request.getParameter("openId");
        Map<String,Object> params = new HashMap<>();
        params.put("openId",openId);
        //查询 该用户绑定的Email
        List<KindleEmail> kindleEmails = kindleEmailMapper.queryByParams(params);
        Map<String,Object> result = new HashMap<>();
        result.put("kindleEmail",kindleEmails);

        //查询该用户流量过的书
        params.put("type", KindleBookManageType.READ.getCode());
        params.put("limit",0);
        params.put("pstart",0);
        params.put("psize",5);
        List<KindleBookManage> kindleBookManages = kindleBookManageMapper.queryByParams(params);
        result.put("read",kindleBookManages);
        //查询该用户订阅过的书
        params.put("type", KindleBookManageType.SEND.getCode());
        List<KindleBookManage> kindleBookManageSend = kindleBookManageMapper.queryByParams(params);
        result.put("send",kindleBookManageSend);

        return JSONObject.toJSONString(result);
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String openId = request.getParameter("openId");
        Map<String,Object> params = new HashMap<>();
        params.put("openId",openId);
        //查询 该用户绑定的Email
        List<KindleEmail> kindleEmails = kindleEmailMapper.queryByParams(params);
        Map<String,Object> result = new HashMap<>();
        result.put("kindleEmail",kindleEmails);

        //查询该用户流量过的书
        params.put("type", KindleBookManageType.READ.getCode());
        params.put("limit",0);
        params.put("pstart",0);
        params.put("psize",5);
        List<KindleBookManage> kindleBookManages = kindleBookManageMapper.queryByParams(params);
        result.put("read",kindleEmails);
        //查询该用户订阅过的书
        params.put("type", KindleBookManageType.SEND.getCode());
        List<KindleBookManage> kindleBookManageSend = kindleBookManageMapper.queryByParams(params);
        result.put("send",kindleBookManageSend);

        return JSONObject.toJSONString(result);
    }
}
