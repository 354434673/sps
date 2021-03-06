package com.sps.service.order.impl;

import com.sps.dao.order.SpsBankTradeInfoMapper;
import com.sps.dao.order.SpsOrderMapper;
import com.sps.entity.order.SpsBankTradeInfo;
import com.sps.service.order.TradeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TradeInfoServiceImpl implements TradeInfoService {
    @Resource
    private SpsBankTradeInfoMapper bankTradeInfoMapper;

    @Override
    public int saveOrUpdate(SpsBankTradeInfo order) {
       return bankTradeInfoMapper.insert(order);
    }

    @Override
    public SpsBankTradeInfo findBySerialNumber(String serialNumber) {
        return bankTradeInfoMapper.findBySerialNumber(serialNumber);
    }

    @Override
    public int updateBySerialNumber(SpsBankTradeInfo bankTradeInfo) {
        return bankTradeInfoMapper.updateBySerialNumber(bankTradeInfo);
    }

    @Override
    public boolean insert(SpsBankTradeInfo bankTradeInfo) {
        return bankTradeInfoMapper.insert(bankTradeInfo)>0;
    }


}
