package com.sps.serviceImpl.balance.read;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.balance.Balance;
import org.sps.entity.balance.BalanceExample;
import org.sps.service.balance.read.BalanceReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.balance.read.BalanceReadMapper;

@Service
@org.springframework.stereotype.Service
@Transactional(readOnly = true)
public class BalanceReadServiceImpl implements BalanceReadService{
	@Resource
	private BalanceReadMapper balanceReadMapper;
	@Override
	public HashMap<String, Object> queryBalanceList(Integer page, Integer limit, String clientNum) {
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		try {
			BalanceExample example = new BalanceExample();
			
			if(clientNum != null){
				example.createCriteria().andBalanceClientNumEqualTo(clientNum);
			}
			PageHelper.startPage(page, limit);
			
			List<Balance> selectByExample = balanceReadMapper.selectByExample(example);
			
			PageInfo pageInfo = new PageInfo(selectByExample);
			hashMap.put("code", 0);
			hashMap.put("msg", "获取成功");
			hashMap.put("count", pageInfo.getTotal());
			hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		} catch (Exception e) {
			e.printStackTrace();
			hashMap.put("code", 0);
			hashMap.put("msg", "获取失败");
			hashMap.put("count", 0);
			hashMap.put("data", null);
		}
		
		return hashMap;
	}

	
}
