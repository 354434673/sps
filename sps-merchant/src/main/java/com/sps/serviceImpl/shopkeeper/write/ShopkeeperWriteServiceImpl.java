package com.sps.serviceImpl.shopkeeper.write;

import java.util.HashMap;

import javax.annotation.Resource;

import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.shopkeeper.write.SpsShopkeeperAccountWriteMapper;
@Service(timeout = 2000, group = "dianfu-dev")
public class ShopkeeperWriteServiceImpl implements ShopkeeperWriteService {
	@Resource
	private SpsShopkeeperAccountWriteMapper accountWrite;
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

}
