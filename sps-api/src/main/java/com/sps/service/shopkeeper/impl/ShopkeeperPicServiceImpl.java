package com.sps.service.shopkeeper.impl;

import com.sps.dao.goods.SpsShopkeeperPersonalMapper;
import com.sps.dao.goods.SpsShopkeeperPicMapper;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
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


    @Override
    public List<SpsShopkeeperPic> findList(String shopkeeperNum) {
        return spsShopkeeperPicMapper.findByCustomerNum(shopkeeperNum);
    }

    @Override
    public SpsShopkeeperPic findByCustomerNum(String shopkeeperNum) {
        return null;
    }
}
