package com.sps.service.risk.impl;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.util.FinalUrl;
import org.sps.util.HttpClientUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.service.risk.RiskService;
@Service
public class RiskServiceImpl implements RiskService{
	private static final String URL = FinalUrl.RISK_URL+"/sps/updateMerchant";
	private static final String URL_APPLY_INSERT = FinalUrl.RISK_URL+"/sps/insertShopApplyInfo";
	@Override	
	public void salesmanEntry(SpsChannelSalesman salesman) {
		
		JSONObject centerMerchantInfo = new JSONObject();
		/**
		 * 推向风控
		 */
		centerMerchantInfo.put("merchantCode", salesman.getSalesmaneChannelNum());//商户编号
		centerMerchantInfo.put("bussinessName", salesman.getSalesmanName());//店付业务员姓名
		centerMerchantInfo.put("certNo", salesman.getSalesmanIdcard());//店付业务员身份证
		centerMerchantInfo.put("city", salesman.getSalesmanCity());//所在城市
		centerMerchantInfo.put("updateTime",  new Date());//更新时间
		
		JSONObject data = new JSONObject();
		
		data.put("merchantInfo", centerMerchantInfo);
		
		String jsonString = JSON.toJSONString(data);
		
		String doPostJson = HttpClientUtil.doPostJson(URL, jsonString);
		
	}
	@Override
	public void invitationEntry(String channelNum, String clientNum) {
		
		JSONObject shopApplyInfo = new JSONObject();

		shopApplyInfo.put("shopCode", clientNum);

		shopApplyInfo.put("applyTime", new Date());

		shopApplyInfo.put("registerChannel", "web");

		shopApplyInfo.put("customerChannel",  "商户邀请");

		shopApplyInfo.put("centerMerchantCode",  channelNum);

		shopApplyInfo.put("createTime",  new Date());

		JSONObject data = new JSONObject();

		data.put("shopApplyInfo", shopApplyInfo);

		HttpClientUtil.doPostJson(URL_APPLY_INSERT, JSON.toJSONString(data));
	}

}
