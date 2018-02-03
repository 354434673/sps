package com.sps.serviceImpl.shopkeeper.write;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.sps.entity.shopkeeper.SpsShopkeeper;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import org.sps.entity.shopkeeper.SpsShopkeeperExample;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.write.SpsChannelWriteMapper;
import com.sps.dao.shopkeeper.write.SpsShopkeeperAccountWriteMapper;
import com.sps.dao.shopkeeper.write.SpsShopkeeperWriteMapper;
@Service(timeout = 2000, group = "dianfu")
public class ShopkeeperWriteServiceImpl implements ShopkeeperWriteService {
	@Resource
	private SpsShopkeeperAccountWriteMapper accountWrite;
	@Resource
	private SpsShopkeeperWriteMapper write;
	@Override
	public HashMap<String, Object> updateAccount(String shopkeeperCustomerid, SpsShopkeeperAccount account) {
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsShopkeeperAccountExample example = new SpsShopkeeperAccountExample();
			
			example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
			
			int updateByExample = accountWrite.updateByExampleSelective(account, example);
			
			hashMap.put("code", 0);
			hashMap.put("msg", "修改成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("code", 0);
			hashMap.put("msg", "修改失败");
			hashMap.put("state", FinalData.STATE_ERROR);
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> updateState(String shopkeeperCustomerid, Integer state) {
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsShopkeeper record = new SpsShopkeeper();
			
			record.setShopkeeperState(state);
			
			record.setShopkeeperUpdateTime(new Date());
			
			SpsShopkeeperExample example = new SpsShopkeeperExample();
			
			example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
			
			write.updateByExampleSelective(record, example);
			
			hashMap.put("code", 0);
			hashMap.put("msg", "修改成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			hashMap.put("code", 0);
			hashMap.put("msg", "修改失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	}

}
