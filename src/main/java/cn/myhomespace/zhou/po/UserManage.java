package cn.myhomespace.zhou.po;

/**
 * Created by zhouw on 2017/4/12.
 */
public class UserManage {

    private String uuid;
    private String openId;
    private String isVip;
    private String isCode;
    private String isCommon;

    @Override
    public String toString() {
        return "UserManage{" +
                "uuid='" + uuid + '\'' +
                ", openId='" + openId + '\'' +
                ", isVip='" + isVip + '\'' +
                ", isCode='" + isCode + '\'' +
                ", isCommon='" + isCommon + '\'' +
                '}';
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getIsCode() {
        return isCode;
    }

    public void setIsCode(String isCode) {
        this.isCode = isCode;
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
}
