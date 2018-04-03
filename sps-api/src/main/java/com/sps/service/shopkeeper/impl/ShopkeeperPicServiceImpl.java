package com.sps.service.shopkeeper.impl;

import com.sps.dao.goods.SpsShopkeeperPersonalMapper;
import com.sps.dao.goods.SpsShopkeeperPicMapper;
import com.sps.dao.shopkeeper.SpsShopkeeperPicDao;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.entity.shopkeeper.SpsShopkeeperPicExample;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.shopkeeper.ShopkeeperPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShopkeeperPicServiceImpl implements ShopkeeperPicService {
    @Resource
    private SpsShopkeeperPicMapper spsShopkeeperPicMapper;
    @Resource
    private SpsShopkeeperPicDao SpsShopkeeperPicDao;


    @Override
    public List<SpsShopkeeperPic> findList(String shopkeeperNum) {
        return spsShopkeeperPicMapper.findByCustomerNum(shopkeeperNum);
    }

    @Override
    public SpsShopkeeperPic findByCustomerNum(String shopkeeperNum) {
        return null;
    }

	@Override
	public List<SpsShopkeeperPic> queryListForTypeAndId(String shopkeeperNum, Integer type) {
		
		SpsShopkeeperPicExample example = new SpsShopkeeperPicExample();

		example.createCriteria().andPicStateEqualTo(0)
								.andShopkeeperCustomeridEqualTo(shopkeeperNum)
								.andPicTypeEqualTo(type);
		List<SpsShopkeeperPic> selectByExample = SpsShopkeeperPicDao.selectByExample(example );
		
		return selectByExample.size() == 0 ? null : selectByExample;
	}
}
