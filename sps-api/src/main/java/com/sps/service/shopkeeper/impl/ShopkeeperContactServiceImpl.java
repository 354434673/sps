package com.sps.service.shopkeeper.impl;

import com.sps.dao.goods.SpsShopkeeperContactMapper;
import com.sps.dao.goods.SpsShopkeeperPicMapper;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.service.shopkeeper.ShopkeeperContactService;
import com.sps.service.shopkeeper.ShopkeeperPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopkeeperContactServiceImpl implements ShopkeeperContactService {
    @Resource
    private SpsShopkeeperContactMapper spsShopkeeperContactMapper;


    @Override
    public List<SpsShopkeeperContact> findList(String shopkeeperNum) {
        return spsShopkeeperContactMapper.findByCustomerNum(shopkeeperNum);
    }
    @Override
    public SpsShopkeeperContact findByCustomerNum(String shopkeeperNum) {
        return null;
    }
}
