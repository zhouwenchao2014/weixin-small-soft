package cn.myhomespace.zhou.controller;

import cn.myhomespace.zhou.common.BookType;
import cn.myhomespace.zhou.common.Content;
import cn.myhomespace.zhou.mapper.KindleEbookMapper;
import cn.myhomespace.zhou.po.KindleEbook;
import cn.myhomespace.zhou.po.ResponseObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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
@RequestMapping("/weixin/kindleHome")
public class KindleMessageController {

    private Logger logger = LoggerFactory.getLogger(KindleMessageController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String method = request.getParameter("page");
        List<ResponseObject> responseObjects = new ArrayList<>();
        if(Content.PAGE_FROM_HOME.equals(method)){
            BookType[] values = BookType.values();
            for(BookType bookType : values){
                Map<String,Object> params = new HashMap<>();
                params.put("type", bookType.getValue());
                params.put("limit","1");
                params.put("pstart",0);
                params.put("psize",3);
                List<KindleEbook> kindleEbooks = kindleEbookMapper.queryByParams(params);
                ResponseObject responseObject = new ResponseObject();
                responseObject.setKindleEbooks(kindleEbooks);
                responseObject.setType(bookType.getValue());
                responseObjects.add(responseObject);
            }
        }
        return JSON.toJSONString(responseObjects);
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String method = request.getParameter("page");
        List<ResponseObject> responseObjects = new ArrayList<>();
        if(Content.PAGE_FROM_HOME.equals(method)){
            BookType[] values = BookType.values();
            for(BookType bookType : values){
                Map<String,Object> params = new HashMap<>();
                params.put("type", bookType.getValue());
                params.put("limit","1");
                params.put("pstart",0);
                params.put("psize",3);
                List<KindleEbook> kindleEbooks = kindleEbookMapper.queryByParams(params);
                ResponseObject responseObject = new ResponseObject();
                responseObject.setKindleEbooks(kindleEbooks);
                responseObject.setType(bookType.getValue());
                responseObjects.add(responseObject);

            }
        }
        return JSON.toJSONString(responseObjects);
    }
}
