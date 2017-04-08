package cn.myhomespace.zhou.worker;

import cn.myhomespace.zhou.po.KindleEbook;
import cn.myhomespace.zhou.utils.DownLoadFile;
import cn.myhomespace.zhou.utils.SendKindle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/12/30.
 */
public class SendKindleThread implements Callable {

    private List<KindleEbook> kindleEbooks;

    private String[] message;

    public SendKindleThread(List<KindleEbook> kindleEbooks, String[] message) {
        this.kindleEbooks = kindleEbooks;
        this.message = message;
    }

    @Autowired
    private SendKindle sendKindle;

    @Override
    public Object call() throws Exception {
        boolean isSend=false;
        boolean isdown= DownLoadFile.downLoadFileWithPath(kindleEbooks.get(0).getUrl(),kindleEbooks.get(0).getBookName(),sendKindle.getDownloadPath());
        if (isdown&&message[0].equals("SendKindle")) {
            isSend = sendKindle.sendKindle(message[2], message[1]);
        }
        if(isSend){
            return "发送成功";
        }else{
            return "发送失败!电子书不存在或者邮箱错误";
        }
    }
}
