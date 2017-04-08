package cn.myhomespace.zhou.po;

import java.util.Date;

/**
 * Created by zhouw on 2017/1/1.
 */
public class SendTimeToday {
    private String id;
    private Date sendTime;
    private Date sendDay;

    public SendTimeToday() {
    }

    @Override
    public String toString() {
        return "SendTimeToday{" +
                "id='" + id + '\'' +
                ", sendTime=" + sendTime +
                ", sendDay=" + sendDay +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSendDay() {
        return sendDay;
    }

    public void setSendDay(Date sendDay) {
        this.sendDay = sendDay;
    }
}
