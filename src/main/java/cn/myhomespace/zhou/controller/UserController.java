package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.Content;
import cn.myhomespace.zhou.mapper.KindleEbookMapper;
import cn.myhomespace.zhou.mapper.UserManageMapper;
import cn.myhomespace.zhou.po.UserManage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouw on 2017/4/12.
 */
@RestController
@RequestMapping("/weixin/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @Autowired
    private UserManageMapper userManageMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String code = request.getParameter("code");
        HttpGet httpGet=new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid="+ Content.APP_ID+"&secret="+Content.SECRET+"&js_code="+code+"&grant_type="+Content.GRANT_TYPE);
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);// 整个连接池最大连接数
        cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // long len = entity.getContentLength();// -1 表示长度未知
                String result = EntityUtils.toString(entity);
                // httpClient.close();
                JSONObject jasonObject = JSONObject.parseObject(result);
                Map map = (Map)jasonObject;
                Object openId = map.get("openid");
                if(openId!=null){
                    List<UserManage> userManages = userManageMapper.selectByOpenId(openId.toString());
                    if(userManages==null||userManages.size()==0){
                        map.put("isContain","false");
                        map.put("errorMessage","plase band KindleEmail");
                    }
                }else{
                    map.put("errorMessage","openId is null");
                }

                return JSONObject.toJSONString(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String code = request.getParameter("code");
        HttpGet httpGet=new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid="+ Content.APP_ID+"&secret="+Content.SECRET+"&js_code="+code+"&grant_type="+Content.GRANT_TYPE);
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);// 整个连接池最大连接数
        cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
        HttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        try {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // long len = entity.getContentLength();// -1 表示长度未知
                String result = EntityUtils.toString(entity);
                // httpClient.close();
                JSONObject jasonObject = JSONObject.parseObject(result);
                Map map = (Map)jasonObject;
                Object openId = map.get("openid");
                if(openId!=null){
                    List<UserManage> userManages = userManageMapper.selectByOpenId(openId.toString());
                    if(userManages==null||userManages.size()==0){
                        map.put("isContain","false");
                        map.put("errorMessage","plase band KindleEmail");
                    }
                }else{
                    map.put("errorMessage","openId is null");
                }

                return JSONObject.toJSONString(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
