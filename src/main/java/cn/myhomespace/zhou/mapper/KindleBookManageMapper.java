package cn.myhomespace.zhou.mapper;

import cn.myhomespace.zhou.po.KindleBookManage;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouwenchao on 2017/4/16.
 */
public interface KindleBookManageMapper {

    int insert(KindleBookManage kindleBookManage);
    List<KindleBookManage> queryByParams(Map<String,Object> params);
}
