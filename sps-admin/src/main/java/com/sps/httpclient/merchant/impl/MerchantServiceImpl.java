package com.sps.httpclient.merchant.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.sps.httpclient.merchant.MerchantService;
import com.sps.util.HttpClientUtil;
@Service
@Transactional(readOnly = true)
public class MerchantServiceImpl implements MerchantService{

	@Override
	public String init(String businessId, Double totalQuota, Double monthQuota, Double firstMonthQuota) {
		final String url = "http://dev.app.chezhubaitiao.com/api/business/init";
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("application", "dianfu");
		hashMap.put("totalQuota", new BigDecimal(totalQuota));
		hashMap.put("monthQuota", new BigDecimal(monthQuota));
		hashMap.put("firstMonthQuota", new BigDecimal(firstMonthQuota));
		hashMap.put("businessId", businessId);
		hashMap.put("approvedDate", new Date());
		hashMap.put("signDateStart", new Date());
		String json = JSON.toJSONString(hashMap);
		
		String doPostJson = HttpClientUtil.doPostJson(url, json);
		
		return doPostJson;
	}

}
