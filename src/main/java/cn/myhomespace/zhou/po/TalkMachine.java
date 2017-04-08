package cn.myhomespace.zhou.po;

import java.io.Serializable;

/**
 * Created by zhouwenchao on 2016/10/17.
 */
public class TalkMachine implements Serializable{

    private String name;
    private boolean isFinish;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }
}
