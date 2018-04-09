package com.sps.service.merchant.impl;

import com.sps.dao.goods.SpsShopkeeperCompanyMapper;
import com.sps.dao.merchant.SpsChannelOpenAccountMapper;
import com.sps.entity.merchant.SpsChannelOpenAccount;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.service.merchant.ChannelOpenAccountService;
import com.sps.service.shopkeeper.ShopkeeperCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ChannelOpenAccountServiceImpl implements ChannelOpenAccountService {
    @Resource
    private SpsChannelOpenAccountMapper spsChannelOpenAccountMapper;

    @Override
    public SpsChannelOpenAccount findByCustomerNum(String channelNum) {
        return spsChannelOpenAccountMapper.findByNum(channelNum);
    }
}



