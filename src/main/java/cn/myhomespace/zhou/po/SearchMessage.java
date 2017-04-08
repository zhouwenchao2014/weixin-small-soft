package cn.myhomespace.zhou.po;

import java.io.Serializable;

/**
 * Created by zhouwenchao on 2016/10/21.
 */
public class SearchMessage implements Serializable {

    private String time;

    private String ip;

    private String ipCity;

    private String searchMessage;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpCity() {
        return ipCity;
    }

    public void setIpCity(String ipCity) {
        this.ipCity = ipCity;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public void setSearchMessage(String searchMessage) {
        this.searchMessage = searchMessage;
    }
}
