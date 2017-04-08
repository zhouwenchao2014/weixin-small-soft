package cn.myhomespace.zhou.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouwenchao on 2016/10/17.
 */
public class SendMessage {

    private Logger logger =Logger.getLogger(SendMessage.class);

    private final String SOURCE_URL="http://www.tuling123.com/openapi/api";

    private final String ALICE_KEY="11b9d5b01fe444a5851feca3262addde";
    private final String Masato_KEY="e0f4b7b4bb984d838dd9615f2163d5cb";
    private final String NICE_KEY="cac5a7b1aa8f43f8aa50571c62a29c61";

    public void getConnectionByHttpClinetPost(){
        CloseableHttpClient closeableHttpClient= HttpClients.createDefault();
        HttpPost httpPost =new HttpPost(SOURCE_URL);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("key", NICE_KEY));
        list.add(new BasicNameValuePair("info", "杭州天气"));
        list.add(new BasicNameValuePair("userId", "djksafhjkdshkj"));
        CloseableHttpResponse closeableHttpResponse=null;
        try {
            UrlEncodedFormEntity urlEncodedFormEntity=new UrlEncodedFormEntity(list);
            httpPost.setEntity(urlEncodedFormEntity);
            closeableHttpResponse=closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity=closeableHttpResponse.getEntity();
            if(httpEntity!=null){
                logger.info(httpEntity.toString());
                System.out.println(httpEntity.toString());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(closeableHttpResponse!=null){
                    closeableHttpResponse.close();
                }
                if(closeableHttpClient!=null){
                    closeableHttpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String randomKey(String ip){
        String[] ip_pointer=null;
        int ipNum=0;
        if(ip!=null){
            ip_pointer =ip.split("\\.");
            ipNum=Integer.parseInt(ip_pointer[3]);
        }
        int result=ipNum%3;
        if(result==0){
            return ALICE_KEY;
        }else if(result==1){
            return Masato_KEY;
        }else{
            return NICE_KEY;
        }
    }

    public String getConnectionByPost(String info,String ip){

        String url=SOURCE_URL+"?key="+randomKey(ip)+"&info="+info;
        URL getURL= null;
        HttpURLConnection connection=null;
        BufferedReader reader=null;
        StringBuffer sb=null;
        try {
            getURL = new URL(url);
            connection=(HttpURLConnection) getURL.openConnection();
            connection.setRequestProperty("Accept-Charset","UTF-8");
            connection.connect();
            //connection.setRequestMethod("post");
            reader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            sb=new StringBuffer();
            String line="";
            while ((line=reader.readLine())!=null) {
                sb.append(line);
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        SendMessage sendMessage = new SendMessage();
//        StringBuffer sb=sendMessage.getConnectionByPost("鱼香肉丝");
//        MeunReslut meunReslut= JSONObject.parseObject(sb.toString(), MeunReslut.class);
//        String message = JSONObject.toJSONString(meunReslut);
    }
}
