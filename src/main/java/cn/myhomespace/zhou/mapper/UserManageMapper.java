package cn.myhomespace.zhou.mapper;

import cn.myhomespace.zhou.po.UserManage;

import java.util.List;

/**
 * Created by zhouw on 2017/4/12.
 */
public interface UserManageMapper {
    List<UserManage> selectByOpenId(String openId);
    int insert(UserManage userManage);
    int update(UserManage userManage);
}
