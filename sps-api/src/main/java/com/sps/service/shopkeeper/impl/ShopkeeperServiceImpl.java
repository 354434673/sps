package com.sps.service.shopkeeper.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.SpsShopkeeperDao;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.service.shopkeeper.ShopkeeperService;
@Service
public class ShopkeeperServiceImpl implements ShopkeeperService{
	@Resource
	private SpsShopkeeperDao spsShopkeeperDao;
	@Override
	public SpsShopkeeper queryShopkeeperList(String shopkeeperCustomerid) {
		
		SpsShopkeeperExample example = new SpsShopkeeperExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		
		List<SpsShopkeeper> selectByExample = spsShopkeeperDao.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}

}
