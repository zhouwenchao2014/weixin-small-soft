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
@RequestMapping("/weixin/bookStatistics")
public class BookStatisticsController {

    private Logger logger = LoggerFactory.getLogger(KindleMessageController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String fieldName = request.getParameter("fieldName");
        String fieldValue = request.getParameter("fieldValue");
        String size = request.getParameter("size");
        Map<String,Object> params = new HashMap<>();
        params.put(fieldName,fieldValue);
        params.put("pstart",0);
        params.put("psize",size);
        List<KindleEbook> kindleEbooks= kindleEbookMapper.queryBookStatistics(params);
        return JSON.toJSONString(kindleEbooks);
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String fieldName = request.getParameter("fieldName");
        String fieldValue = request.getParameter("fieldValue");
        String size = request.getParameter("size");
        Map<String,Object> params = new HashMap<>();
        params.put(fieldName,fieldValue);
        params.put("pstart",0);
        params.put("psize",size);
        List<KindleEbook> kindleEbooks= kindleEbookMapper.queryBookStatistics(params);
        return JSON.toJSONString(kindleEbooks);
    }
}
