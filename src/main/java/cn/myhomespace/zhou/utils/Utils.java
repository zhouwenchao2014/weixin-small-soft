package cn.myhomespace.zhou.utils;

/**
 * Created by zhouw on 2016/12/31.
 */
public class Utils {

    public static String getIp(){
        return getRandomString(255)+"."+getRandomString(255)+"."+getRandomString(255)+"."+getRandomString(255);
    }

    public static String getRandomString(int size){
       return Math.floor(Math.random()*(size-1)+1)+"";
    }
}
