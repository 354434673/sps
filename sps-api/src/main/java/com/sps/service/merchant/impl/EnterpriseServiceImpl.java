package com.sps.service.merchant.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.ChannelEnterpriseDao;
import com.sps.dao.SpsShopkeeperDao;
import com.sps.entity.merchant.SpsChannelBusiness;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.service.base.BaseOperate;
import com.sps.service.merchant.EnterpriseService;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sun.mail.util.SharedByteArrayOutputStream;
@Service
public class EnterpriseServiceImpl extends BaseOperate implements EnterpriseService {
	@Resource
	private ChannelEnterpriseDao enterpriseDao;
	@Resource
	private ShopkeeperService shopkeeperService;
	@Override
	@Transactional(readOnly = true)
	public HashMap<String, Object> queryMerchantList(String data) {
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		ArrayList<String> arrayList = null;
		if(!StringUtil.isEmpty(data)){
			JSONObject parseObject = JSON.parseObject(data);
			
			String shopkeeperCustomerid = parseObject.getString("shopkeeperCustomerid");
			
			SpsShopkeeper queryShopkeeperList = shopkeeperService.queryShopkeeperList(shopkeeperCustomerid);
			
			String shopkeeperBusinessType = queryShopkeeperList.getShopkeeperBusinessType();
			
			String[] split = shopkeeperBusinessType.split(",");
			
			arrayList = new ArrayList<String>();
			for (String string : split) {
				
				arrayList.add(string);
			}
			try {
				List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(arrayList, 1);
				super.logger.error(Message.SUCCESS_MSG);
				
				hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG, 
						Message.SUCCESS_MSG,queryBusinessForApi.size(), queryBusinessForApi);
			} catch (Exception e) {
				e.printStackTrace();
				super.logger.error(Message.SYSTEM_ERROR_MSG);
				
				hashMap = Message.resultMap( Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG, 
						Message.FAILURE_MSG,null, null);
			}
		}else{
			hashMap = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG, 
					Message.FAILURE_MSG,null, null);
		}
		return hashMap;
	}
}
