package cn.myhomespace.zhou.common;

/**
 * Created by zhouw on 2017/4/9.
 */
public enum BookType {
    DYGW("东野圭吾"),ESSS("二十四史"),LSRW("历史人文"),GDWX("古典文学"),WGWX("外国文学"),TTXS("天天向上");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    BookType(String value) {
        this.value = value;
    }
}
