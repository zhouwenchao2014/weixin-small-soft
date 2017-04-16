package cn.myhomespace.zhou.common;

import static cn.myhomespace.zhou.common.Content.KINDLE_BANDING_SIZE;

/**
 * Created by zhouw on 2017/4/15.
 */
public enum ErrorMessage {
    SUCCESS_BANDING_EMAIL("600","绑定成功"),
    ERROE_KINDLE_EMAIL("601","绑定失败，非KindleEmail"),
    ERROE_EMAIL("602","绑定失败，Email格式不正确"),
    ERROR_INVITE_CODE("603","绑定失败，邀请码错误"),
    ERROR_BANDING_EMAIL("604","绑定失败"),
    THE_EMAIL_ISBANDING("605","绑定失败,当前账户已经绑定当前Email"),
    BANDING_EMAIL_IS_FULL("606","绑定失败,每个账户只能绑定"+KINDLE_BANDING_SIZE+"个"),
    SEND_SUCCESS("700","订阅成功，请稍后检查KINDLE，是否已收到"),
    NO_MASTER_EMAIL("701","没有master邮箱"),
    SEND_FAIL("702","发送失败"),
    DOWNLOAD_FAIL("703","下载失败");
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
