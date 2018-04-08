package com.sps.serviceImpl.balance.write;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.balance.Balance;
import org.sps.entity.balance.BalanceExample;
import org.sps.service.balance.read.BalanceReadService;
import org.sps.service.balance.write.BalanceWriteService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.balance.read.BalanceReadMapper;
import com.sps.dao.balance.write.BalanceWriteMapper;

@Service(group = "dianfu")
public class BalanceWriteServiceImpl implements BalanceWriteService{
	@Resource
	private BalanceWriteMapper balanceWrite;
	@Resource
	private BalanceReadService balanceRead;
	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public HashMap<String, Object> insertBalance(Balance balance) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		Balance queryBalance = balanceRead.queryBalance(balance.getBalanceClientNum(), balance.getBalanceType());
		try {
			if(queryBalance == null){
				balance.setCreateTime(new Date());
				balance.setUpdateTime(new Date());
				balance.setBalanceState(0);
				int insertSelective = balanceWrite.insertSelective(balance);
				
				hashMap.put("msg", "添加成功");
				hashMap.put("success", true);
				hashMap.put("code", 1);
			}else{
				hashMap.put("msg", "重复添加");
				hashMap.put("success", false);
				hashMap.put("code", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("msg", "添加失败");
			hashMap.put("success", false);
			hashMap.put("code", 0);
		}
		return hashMap;
	}

	
}
