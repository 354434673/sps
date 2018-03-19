package com.sps.common;


import java.util.Random;

/**
 * 张磊
 * Created by 37126 on 2018/3/3.
 */
public class OrderCodeCreateUtil {

    public static String orderCode(){
        StringBuffer sb = new StringBuffer("df");
        sb.append(UUIDFactory.getNumberUUIDStr());
        Random random = new Random();
        sb.append(random.nextInt(10));
        return sb.toString();
    }
}
