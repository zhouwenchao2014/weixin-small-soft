package cn.myhomespace.zhou.po;

/**
 * 邀请码
 * Created by zhouw on 2017/4/15.
 */
public class InviteCode {
    private String uuid;
    private String code;

    @Override
    public String toString() {
        return "InviteCode{" +
                "uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
