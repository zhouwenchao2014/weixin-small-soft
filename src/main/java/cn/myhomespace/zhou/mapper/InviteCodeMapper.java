package cn.myhomespace.zhou.mapper;

import cn.myhomespace.zhou.po.InviteCode;

import java.util.List;

/**
 * Created by zhouw on 2017/4/15.
 */
public interface InviteCodeMapper {
    int insert(InviteCode inviteCode);
    List<InviteCode> isContain(String code);
    int deleteUsed(String code);
}
