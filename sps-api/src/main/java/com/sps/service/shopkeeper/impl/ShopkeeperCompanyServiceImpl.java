package com.sps.service.shopkeeper.impl;

import com.sps.dao.goods.SpsShopkeeperCompanyMapper;
import com.sps.dao.goods.SpsShopkeeperContactMapper;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.service.shopkeeper.ShopkeeperCompanyService;
import com.sps.service.shopkeeper.ShopkeeperContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShopkeeperCompanyServiceImpl implements ShopkeeperCompanyService {
    @Resource
    private SpsShopkeeperCompanyMapper spsShopkeeperCompanyMapper;


    @Override
    public List<SpsShopkeeperCompany> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public SpsShopkeeperCompany findByCustomerNum(String shopkeeperNum) {
        return spsShopkeeperCompanyMapper.findByCustomerNum(shopkeeperNum);
    }
}
