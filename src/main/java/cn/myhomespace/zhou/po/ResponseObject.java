package cn.myhomespace.zhou.po;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouw on 2017/4/9.
 */
public class ResponseObject implements Serializable {
    private String type;
    private List<KindleEbook> kindleEbooks;

    @Override
    public String toString() {
        return "ResponseObject{" +
                "type='" + type + '\'' +
                ", kindleEbooks=" + kindleEbooks +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<KindleEbook> getKindleEbooks() {
        return kindleEbooks;
    }

    public void setKindleEbooks(List<KindleEbook> kindleEbooks) {
        this.kindleEbooks = kindleEbooks;
    }
}
