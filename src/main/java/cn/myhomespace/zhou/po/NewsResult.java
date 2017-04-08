package cn.myhomespace.zhou.po;

import java.util.List;

/**
 * Created by zhouwenchao on 2016/10/17.
 */
public class NewsResult extends Result {

    private List<News> newList;

    public List<News> getNewList() {
        return newList;
    }

    public void setNewList(List<News> newList) {
        this.newList = newList;
    }
}
