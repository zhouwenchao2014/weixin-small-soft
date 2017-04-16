package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.KindleBookManageType;
import cn.myhomespace.zhou.mapper.KindleBookManageMapper;
import cn.myhomespace.zhou.mapper.KindleEbookMapper;
import cn.myhomespace.zhou.po.KindleBookManage;
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
import java.util.UUID;

/**
 * Created by zhouw on 2017/4/11.
 */
@RestController
@RequestMapping("/weixin/bookCount")
public class BookCountController {

    private Logger logger = LoggerFactory.getLogger(KindleMessageController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @Autowired
    private KindleBookManageMapper kindleBookManageMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String id = request.getParameter("id");
        String readTimes = request.getParameter("readTimes");
        String sendTimes = request.getParameter("sendTimes");
        String openId=request.getParameter("openId");

        Map<String,Object> params = new HashMap<>();
        if(readTimes!=null){
            params.put("readTimes","1");
        }
        if(sendTimes!=null){
            params.put("sendTimes","1");
        }
        params.put("id",id);
        int updateNum= kindleEbookMapper.updateById(params);
        List<KindleEbook> kindleEbooks = kindleEbookMapper.queryByParams(params);
        if(readTimes!=null&&updateNum>0){
            KindleBookManage kindleBookManage = new KindleBookManage();
            kindleBookManage.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
            kindleBookManage.setOpenId(openId);
            kindleBookManage.setBookId(kindleEbooks.get(0).getId()+"");
            kindleBookManage.setBookName(kindleEbooks.get(0).getBookName());
            kindleBookManage.setType(KindleBookManageType.READ.getCode());
            kindleBookManageMapper.insert(kindleBookManage);
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
        String openId=request.getParameter("openId");

        Map<String,Object> params = new HashMap<>();
        if(readTimes!=null){
            params.put("readTimes","1");
        }
        if(sendTimes!=null){
            params.put("sendTimes","1");
        }
        params.put("id",id);
        int updateNum= kindleEbookMapper.updateById(params);
        List<KindleEbook> kindleEbooks = kindleEbookMapper.queryByParams(params);
        if(readTimes!=null&&updateNum>0){
            KindleBookManage kindleBookManage = new KindleBookManage();
            kindleBookManage.setUuid(UUID.randomUUID().toString().replaceAll("-",""));
            kindleBookManage.setOpenId(openId);
            kindleBookManage.setBookId(kindleEbooks.get(0).getId()+"");
            kindleBookManage.setBookName(kindleEbooks.get(0).getBookName());
            kindleBookManage.setType(KindleBookManageType.READ.getCode());
            kindleBookManageMapper.insert(kindleBookManage);
            return JSON.toJSONString("增加一次浏览");
        }else if(sendTimes!=null&&updateNum>0){
            return JSON.toJSONString("增加发送Kindle");
        }else{
            return JSON.toJSONString("浏览失败或发送Kindle失败");
        }
    }
}
