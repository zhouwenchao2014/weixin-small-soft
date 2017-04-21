package cn.myhomespace.zhou.po;

import java.util.Date;

/**
 * Created by zhouwenchao on 2017/4/16.
 */
public class KindleBookManage {

    private String uuid;
    private String openId;
    private String bookId;
    private String bookName;
    private int type;
    private Date createTime;

    @Override
    public String toString() {
        return "KindleBookManage{" +
                "uuid='" + uuid + '\'' +
                ", openId='" + openId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
