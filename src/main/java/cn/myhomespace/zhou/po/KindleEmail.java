package cn.myhomespace.zhou.po;

import java.io.Serializable;

/**
 * Created by zhouwenchao on 2017/4/15.
 */
public class KindleEmail implements Serializable{

    private String uuid;
    private String openId;
    private String kindleEmail;
    private int isMasterEmail;

    @Override
    public String toString() {
        return "KindleEmail{" +
                "uuid='" + uuid + '\'' +
                ", openId='" + openId + '\'' +
                ", kindleEmail='" + kindleEmail + '\'' +
                ", isMaster=" + isMasterEmail +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getKindleEmail() {
        return kindleEmail;
    }

    public void setKindleEmail(String kindleEmail) {
        this.kindleEmail = kindleEmail;
    }

    public int getIsMasterEmail() {
        return isMasterEmail;
    }

    public void setIsMasterEmail(int isMasterEmail) {
        this.isMasterEmail = isMasterEmail;
    }
}
