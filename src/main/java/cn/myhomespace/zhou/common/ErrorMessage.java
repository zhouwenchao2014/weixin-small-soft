package cn.myhomespace.zhou.common;

/**
 * Created by zhouw on 2017/4/15.
 */
public enum ErrorMessage {
    SUCCESS_BANDING_EMAIL("600","绑定成功"),
    ERROE_KINDLE_EMAIL("601","非KindleEmail"),
    ERROE_EMAIL("602","Email格式不正确"),
    ERROR_INVITE_CODE("603","邀请码错误"),
    ERROR_BANDING_EMAIL("604","绑定失败");
    private String code;
    private String message;

    ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
