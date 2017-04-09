package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.BookType;
import cn.myhomespace.zhou.common.Content;
import cn.myhomespace.zhou.mapper.KindleEbookMapper;
import cn.myhomespace.zhou.po.KindleEbook;
import cn.myhomespace.zhou.po.ResponseObject;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhouw on 2017/4/9.
 */
@RestController
@RequestMapping("/weixin/bookDetail")
public class BookMessageController {

    private Logger logger = LoggerFactory.getLogger(KindleMessageController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        List<KindleEbook> kindleEbooks= kindleEbookMapper.queryByParam(bookName);
        return JSON.toJSONString(kindleEbooks);
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String bookName = request.getParameter("bookName");
        List<KindleEbook> kindleEbooks= kindleEbookMapper.queryByParam(bookName);
        return JSON.toJSONString(kindleEbooks);
    }
}
