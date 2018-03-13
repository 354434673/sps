package com.sps.service.shopkeeper.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.common.StringUtil;
import com.sps.dao.shopkeeper.SpsShopkeeperAccountDao;
import com.sps.dao.shopkeeper.SpsShopkeeperDao;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperAccount;
import com.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.service.shopkeeper.ShopkeeperService;
/**
 * 店主相关业务层
 * @ClassName:  ShopkeeperServiceImpl   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月2日 上午11:02:39
 */
@Service
public class ShopkeeperServiceImpl implements ShopkeeperService{
	@Resource
	private SpsShopkeeperDao spsShopkeeperDao;
	@Resource
	private SpsShopkeeperAccountDao spsShopkeeperAccountDao;
	@Override
	public SpsShopkeeper queryShopkeeperList(String shopkeeperCustomerid) {
		
		SpsShopkeeperExample example = new SpsShopkeeperExample();
		
		if(!StringUtil.isEmpty(shopkeeperCustomerid)){
			example.createCriteria().andShopkeeperCustomeridEqualTo(shopkeeperCustomerid);
		}
		List<SpsShopkeeper> selectByExample = spsShopkeeperDao.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
	@Override
	public boolean queryAccount(String customerId) {
		
		SpsShopkeeperAccountExample example = new SpsShopkeeperAccountExample();
		
		example.createCriteria().andShopkeeperCustomeridEqualTo(customerId);
		
		List<SpsShopkeeperAccount> selectByExample = spsShopkeeperAccountDao.selectByExample(example);
		
		return selectByExample.get(0).getAccountState() == 0 ? true : false;
	}

}
