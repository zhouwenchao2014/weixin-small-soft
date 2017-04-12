package cn.myhomespace.zhou.po;

/**
 * Created by zhouw on 2017/4/12.
 */
public class UserManage {

    private String uuid;
    private String openId;
    private String kindleEmail;

    @Override
    public String toString() {
        return "UserManage{" +
                "uuid='" + uuid + '\'' +
                ", openId='" + openId + '\'' +
                ", kindleEmail='" + kindleEmail + '\'' +
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
}
