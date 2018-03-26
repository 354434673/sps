package com.sps.serviceImpl.merchant.write;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.Subject;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.entity.merchant.SpsChannelSalesmanExample;
import org.sps.service.merchant.write.ChannelSalesmanWriteService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelSalesmanReadMapper;
import com.sps.dao.merchant.write.SpsChannelSalesmanWriteMapper;
@Service(timeout=2000,group="dianfu")
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
	}
	@Override
	public HashMap<String, Object> updateSalesmanState(String state, Integer id) {
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		try {
			SpsChannelSalesman record = new SpsChannelSalesman();
			
			record.setBei1(state);
			
			SpsChannelSalesmanExample example = new SpsChannelSalesmanExample();
			
			example.createCriteria().andSalesmanIdEqualTo(id);
			
			int updateByExampleSelective = salesmanWrite.updateByExampleSelective(record, example);
			
			hashMap.put("msg", "删除成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			hashMap.put("msg", "删除失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> updateSalesman(SpsChannelSalesman salesman) {
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		try {
			salesmanWrite.updateByPrimaryKeySelective(salesman);
			
			hashMap.put("msg", "修改成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			hashMap.put("msg", "修改失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	};
}
