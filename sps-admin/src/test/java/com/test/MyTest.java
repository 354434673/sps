package com.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import javax.json.Json;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.sps.util.HttpClientUtil;

public class MyTest {
	
	@Test
	public void test1(){
	HashMap<String, Object> hashMap = new HashMap<String,Object>();
	BigDecimal totalQuota = new BigDecimal(4000.456);
	BigDecimal monthQuota = new BigDecimal(7000.789);
	BigDecimal firstMonthQuota = new BigDecimal(9000.123);
	hashMap.put("application", "dianfu");
	hashMap.put("totalQuota", totalQuota);
	hashMap.put("monthQuota", monthQuota);
	hashMap.put("firstMonthQuota", firstMonthQuota);
	hashMap.put("businessId", "DF20180136191770");
	hashMap.put("approvedDate", new Date());
	hashMap.put("signDateStart", new Date());
	String json = JSON.toJSONString(hashMap);
	String url = "http://dev.app.chezhubaitiao.com/api/business/init";
	try {
		String doPostJson = HttpClientUtil.doPostJson(url, json);
		System.out.println(doPostJson);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
