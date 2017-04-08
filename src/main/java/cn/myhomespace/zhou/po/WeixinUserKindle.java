package cn.myhomespace.zhou.po;

/**
 * Created by zhouw on 2017/1/1.
 */
public class WeixinUserKindle {
    private String id;
    private String kindleEmail;
    private boolean isVip;

    public WeixinUserKindle() {
    }

    @Override
    public String toString() {
        return "WeixinUserKindle{" +
                "id='" + id + '\'' +
                ", kindleEmail='" + kindleEmail + '\'' +
                ", isVip=" + isVip +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKindleEmail() {
        return kindleEmail;
    }

    public void setKindleEmail(String kindleEmail) {
        this.kindleEmail = kindleEmail;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
