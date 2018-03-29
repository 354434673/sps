package com.sps.serviceImpl.merchant.write;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.entity.merchant.SpsChannelSalesmanExample;
import org.sps.service.merchant.write.ChannelSalesmanWriteService;
import org.sps.util.FinalData;
import org.sps.util.HttpClientUtil;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.dao.merchant.read.SpsChannelSalesmanReadMapper;
import com.sps.dao.merchant.write.SpsChannelSalesmanWriteMapper;
@Service(timeout=2000,group="dianfu")
@Transactional
public class ChannelSalesmanWriteServiceImpl implements ChannelSalesmanWriteService{
	private static final String URL = "http://test1-spay.juzifenqi.com/sps/updateMerchant";
	@Resource
	private SpsChannelSalesmanWriteMapper salesmanWrite;
	@Resource
	private SpsChannelSalesmanReadMapper salesmanRead;
	@Override
	@Transactional(readOnly = false, rollbackFor=java.lang.Exception.class)
	public HashMap<String, Object> insertSalesman(SpsChannelSalesman salesman) {
		
		SpsChannelSalesman channelSalesman = getSalesman(salesman.getSalesmanIdcard());
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			if(channelSalesman == null){
				salesmanWrite.insertSelective(salesman);
				//风控进件
				salesmanEntry(salesman);
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
	private void salesmanEntry(SpsChannelSalesman salesman){
		
		JSONObject centerMerchantInfo = new JSONObject();
		/**
		 * 推向风控
		 */
		centerMerchantInfo.put("merchantCode", salesman.getSalesmaneChannelNum());//商户编号
		centerMerchantInfo.put("bussinessName", salesman.getSalesmanName());//店付业务员姓名
		centerMerchantInfo.put("certNo", salesman.getSalesmanIdcard());//店付业务员身份证
		centerMerchantInfo.put("city", salesman.getSalesmanCity());//所在城市
		centerMerchantInfo.put("updateTime",  new Date());//更新时间
		
		JSONObject data = new JSONObject();
		
		data.put("merchantInfo", centerMerchantInfo);
		
		String jsonString = JSON.toJSONString(data);
		
		String doPostJson = HttpClientUtil.doPostJson(URL, jsonString);
		
	}
}
