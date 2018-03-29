package com.sps.common;


import java.util.Date;
import java.util.Random;

/**
 * 张磊
 * Created by 37126 on 2018/3/3.
 */
public class OrderCodeCreateUtil {

    public static String orderCode(String mark){
        String numRandom = RuleUtil.getNumRandom(6);

        String DateFormat = DateUtil.format(new Date(), "yyyyMMss");

        String channelNum = mark+DateFormat+numRandom;

        return channelNum;
    }
}
