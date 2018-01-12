package com.sps.merchant.serviceImpl.write;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.entity.merchant.SpsChannelSalesmanExample;
import org.sps.service.merchant.read.ChannelSalesmanReadService;
import org.sps.service.merchant.write.ChannelSalesmanWriteService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelSalesmanReadMapper;
import com.sps.dao.merchant.write.SpsChannelSalesmanWriteMapper;
@Service(timeout=12000)
@Transactional
public class ChannelSalesmanWriteServiceImpl implements ChannelSalesmanWriteService{
	@Resource
	private SpsChannelSalesmanWriteMapper salesmanWrite;
	@Resource
	private SpsChannelSalesmanReadMapper salesmanRead;
	@Override
	public HashMap<String, Object> insertSalesman(SpsChannelSalesman salesman) {
		SpsChannelSalesman channelSalesman = getSalesman(salesman.getSalesmanIdcard());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			if(channelSalesman == null){
				salesmanWrite.insertSelective(salesman);
				hashMap.put("msg", "用户添加成功");
				hashMap.put("state", FinalData.STATE_SUCCESS);
			}else{
				hashMap.put("msg", "用户重复");
				hashMap.put("state", FinalData.STATE_EXIST);
			}
		} catch (Exception e) {
			hashMap.put("msg", "用户添加失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	}
	private SpsChannelSalesman getSalesman(String idCard){
		SpsChannelSalesmanExample example = new SpsChannelSalesmanExample();
		
		example.createCriteria().andSalesmanIdcardEqualTo(idCard);
		
		List<SpsChannelSalesman> selectByExample = salesmanRead.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	};
}
