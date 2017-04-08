package cn.myhomespace.zhou.utils;

import java.io.File;

/**
 * Created by zhouwenchao on 2016/12/2.
 */
public class SendKindle {
    private String downloadPath;
    private String mailHost;
    private String mailUserName;
    private String mailPassword;
    private String mailFromMail;
    private String message;

    /**
     * send kindle ebook to email
     * @param email
     * @param mobiBookName
     * @return
     */
    public boolean sendKindle(String email,String mobiBookName){
        SendEmailWithFile sendmail = new SendEmailWithFile();

        sendmail.setHost(this.mailHost);
        sendmail.setUserName(this.mailUserName);
        sendmail.setPassWord(this.mailPassword);
        //sendmail.setTo("8618368817487@KINDLE.com");
        sendmail.setTo(email);
        sendmail.setFrom(this.mailFromMail);
        sendmail.setSubject("kindle推送");
        sendmail.setContent(this.message);
        // Mail sendmail = new
        // Mail("dujiang@sricnet.com","du_jiang@sohu.com","smtp.sohu.com","du_jiang","31415926","你好","胃，你好吗？");
        sendmail.attachfile(this.downloadPath+mobiBookName);
        boolean isSeand=sendmail.sendMail();
        if(isSeand){
            File file=new File(this.downloadPath+mobiBookName);
            if(file.exists()){
                file.delete();
            }
        }
        return isSeand;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailUserName(String mailUserName) {
        this.mailUserName = mailUserName;
    }

    public String getMailUserName() {
        return mailUserName;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailFromMail(String mailFromMail) {
        this.mailFromMail = mailFromMail;
    }

    public String getMailFromMail() {
        return mailFromMail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
