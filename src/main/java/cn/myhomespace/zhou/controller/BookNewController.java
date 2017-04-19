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
import java.sql.Date;
import java.util.*;

/**
 * Created by zhouw on 2017/4/18.
 */
@RestController
@RequestMapping("/weixin/bookNew")
public class BookNewController {

    private Logger logger = LoggerFactory.getLogger(BookNewController.class);

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String get(HttpServletRequest request) {
        String type = request.getParameter("type");
        int psize = Integer.parseInt(request.getParameter("psize"));
        int pstart = Integer.parseInt(request.getParameter("pstart"));
        Map<String,Object> params = new HashMap<>();
        params.put("limit","1");
        params.put("type",type);
        params.put("psize",psize);
        params.put("pstart",pstart);
        List<KindleEbook> kindleEbooks = kindleEbookMapper.queryNew(params);
        List<KindleEbook> kindleEbooks1 = kindleEbookMapper.queryNewByType(params);
        Map<String,Object> result = new HashMap<>();
        result.put("new",kindleEbooks);
        for(KindleEbook kindleEbook : kindleEbooks1){
            List<KindleEbook> list = (List<KindleEbook>) result.get(kindleEbook.getType());
            if(list==null||list.size()==0){
                List<KindleEbook> types= new ArrayList<>();
                types.add(kindleEbook);
                result.put(kindleEbook.getType(),types);
            }else{
                list.add(kindleEbook);
            }
        }
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(HttpServletRequest request) {
        String type = request.getParameter("type");
        int psize = Integer.parseInt(request.getParameter("psize"));
        int pstart = Integer.parseInt(request.getParameter("pstart"));
        Map<String,Object> params = new HashMap<>();
        params.put("limit","1");
        params.put("type",type);
        params.put("psize",psize);
        params.put("pstart",pstart);
        List<KindleEbook> kindleEbooks = kindleEbookMapper.queryNew(params);
        List<KindleEbook> kindleEbooks1 = kindleEbookMapper.queryNewByType(params);
        Map<String,Object> result = new HashMap<>();
        result.put("new",kindleEbooks);
        for(KindleEbook kindleEbook : kindleEbooks1){
            List<KindleEbook> list = (List<KindleEbook>) result.get(kindleEbook.getType());
            if(list==null||list.size()==0){
                List<KindleEbook> types= new ArrayList<>();
                types.add(kindleEbook);
                result.put(kindleEbook.getType(),types);
            }else{
                list.add(kindleEbook);
            }
        }
        return JSON.toJSONString(result);
    }
}
