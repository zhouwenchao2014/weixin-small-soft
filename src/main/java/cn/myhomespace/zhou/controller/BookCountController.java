package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.mapper.KindleEbookMapper;
import cn.myhomespace.zhou.po.KindleEbook;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouw on 2017/4/11.
 */
@RestController
@RequestMapping("/weixin/bookCount")
public class BookCountController {

    private Logger logger = LoggerFactory.getLogger(KindleMessageController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String id = request.getParameter("id");
        String readTimes = request.getParameter("readTimes");
        String sendTimes = request.getParameter("sendTimes");

        Map<String,Object> params = new HashMap<>();
        if(readTimes!=null){
            params.put("readTimes","1");
        }
        if(sendTimes!=null){
            params.put("sendTimes","1");
        }
        params.put("id",id);
        int updateNum= kindleEbookMapper.updateById(params);
        if(readTimes!=null&&updateNum>0){
            return JSON.toJSONString("增加一次浏览");
        }else if(sendTimes!=null&&updateNum>0){
            return JSON.toJSONString("增加发送Kindle");
        }else{
            return JSON.toJSONString("浏览失败或发送Kindle失败");
        }

    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String id = request.getParameter("id");
        String readTimes = request.getParameter("readTimes");
        String sendTimes = request.getParameter("sendTimes");

        Map<String,Object> params = new HashMap<>();
        if(readTimes!=null){
            params.put(readTimes,"1");
        }
        if(sendTimes!=null){
            params.put(sendTimes,"1");
        }
        params.put("id",id);
        int updateNum= kindleEbookMapper.updateById(params);
        if(readTimes!=null&&updateNum>0){
            return JSON.toJSONString("增加一次浏览");
        }else if(sendTimes!=null&&updateNum>0){
            return JSON.toJSONString("增加发送Kindle");
        }else{
            return JSON.toJSONString("浏览失败或发送Kindle失败");
        }
    }
}
