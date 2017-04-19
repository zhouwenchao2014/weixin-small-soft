package cn.myhomespace.zhou.po;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by zhouwenchao on 2016/12/9.
 */
public class KindleEbook implements Serializable{

    private int id;
    private String bookName;
    private String author;
    private String tag;
    private String url;
    private String type;
    private String summary;
    private String picName;
    private String createTime;
    private String readTimes;
    private String sendTimes;
    private String isFree;
    private String total;
    private Date create;

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(String readTimes) {
        this.readTimes = readTimes;
    }

    public String getSendTimes() {
        return sendTimes;
    }

    public void setSendTimes(String sendTimes) {
        this.sendTimes = sendTimes;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "KindleEbook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", tag='" + tag + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", summary='" + summary + '\'' +
                ", picName='" + picName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", readTimes='" + readTimes + '\'' +
                ", sendTimes='" + sendTimes + '\'' +
                ", isFree='" + isFree + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
