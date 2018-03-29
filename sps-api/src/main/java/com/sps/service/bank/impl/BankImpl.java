package com.sps.service.bank.impl;

import com.sps.dao.bank.SpsBankMapper;
import com.sps.entity.bank.SpsBank;
import com.sps.service.bank.BankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BankImpl implements BankService {
    @Resource
    private SpsBankMapper spsBankMapper;

    @Override
    public void saveOrUpdate(SpsBank bank) {

    }

    @Override
    public SpsBank findEntityById(Integer id) {
        return spsBankMapper.findById(id);
    }

    @Override
    public SpsBank findEntityByNo(String channlNum) {
        return spsBankMapper.findByChannlNum(channlNum);
    }

    @Override
    public List<SpsBank> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
