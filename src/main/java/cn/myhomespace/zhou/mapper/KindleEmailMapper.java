package cn.myhomespace.zhou.mapper;

import cn.myhomespace.zhou.po.KindleEmail;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouwenchao on 2017/4/15.
 */
public interface KindleEmailMapper {

    List<KindleEmail> queryByParams(Map<String,Object> params);

    int insert(KindleEmail kindleEmail);
}
