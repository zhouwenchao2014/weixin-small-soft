package cn.myhomespace.zhou.mapper;

import cn.myhomespace.zhou.po.KindleEbook;

import java.util.List;
import java.util.Map;

/**
 * Created by zhouwenchao on 2016/12/9.
 */
public interface KindleEbookMapper {

    public void insert(KindleEbook kindleEbook);

    public List<KindleEbook> queryAll();
    List<KindleEbook> queryByParam(String bookName);
    List<KindleEbook> queryByParams(Map<String,Object> params);
}
