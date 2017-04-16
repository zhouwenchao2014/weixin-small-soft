package cn.myhomespace.zhou.common;

/**
 * Created by zhouwenchao on 2017/4/16.
 */
public enum KindleBookManageType {
    READ(1,"浏览"),
    SEND(2,"订阅");

    private int code;
    private String name;

    KindleBookManageType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
