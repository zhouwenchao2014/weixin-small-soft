package cn.myhomespace.zhou.service.impl;

import cn.myhomespace.zhou.mapper.KindleEbookMapper;
import cn.myhomespace.zhou.po.KindleEbook;
import cn.myhomespace.zhou.service.PublicService;
import cn.myhomespace.zhou.utils.SendKindle;
import cn.myhomespace.zhou.worker.SendKindleThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhouwenchao on 2016/12/2.
 */
@Service("publicService")
public class PublicServiceImpl implements PublicService {

    @Autowired
    private SendKindle sendKindle;

    @Autowired
    private KindleEbookMapper kindleEbookMapper;

    public String publicService(String[] message) {
        boolean isSend=false;
        KindleEbook kindleEbook=new KindleEbook();
        kindleEbook.setBookName(message[1]);
        List<KindleEbook> kindleEbooks= kindleEbookMapper.queryByParam(message[1]);
        if(kindleEbooks!=null&&kindleEbooks.size()!=0){
            SendKindleThread sendKindleThread = new SendKindleThread(kindleEbooks,message);
            FutureTask futureTask=new FutureTask(sendKindleThread);
            String mes=message[1]+"存在，已发送，请注意查收";
            try {
                mes=futureTask.get(2, TimeUnit.SECONDS).toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }finally {
                return mes;
            }
        }else{
            return "此书不存在";
        }


    }
}
