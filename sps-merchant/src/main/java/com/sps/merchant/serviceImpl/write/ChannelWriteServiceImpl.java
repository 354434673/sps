package com.sps.merchant.serviceImpl.write;

import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelWriteService;
import org.sps.util.DateUtil;
import org.sps.util.RuleUtil;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.write.SpsChannelBusinessWriteMapper;
import com.sps.dao.merchant.write.SpsChannelEnterpriseWriteMapper;
import com.sps.dao.merchant.write.SpsChannelFinanceTargetWriteMapper;
import com.sps.dao.merchant.write.SpsChannelGatherWriteMapper;
import com.sps.dao.merchant.write.SpsChannelGuaranteeWriteMapper;
import com.sps.dao.merchant.write.SpsChannelLogisticsWriteMapper;
import com.sps.dao.merchant.write.SpsChannelOpenAccountWriteMapper;
import com.sps.dao.merchant.write.SpsChannelWriteMapper;
@Service(timeout=60000)
public class ChannelWriteServiceImpl implements ChannelWriteService{
	@Resource
	private SpsChannelWriteMapper channelWrite;
	@Resource
	private SpsChannelBusinessWriteMapper businessWrite;
	@Resource
	private SpsChannelEnterpriseWriteMapper enterpriseWrite;
	@Resource
	private SpsChannelGuaranteeWriteMapper guaranteeWrite;
	@Resource
	private SpsChannelFinanceTargetWriteMapper financeTargetWrite;
	@Resource
	private SpsChannelLogisticsWriteMapper logisticsWrite;
	@Resource
	private SpsChannelOpenAccountWriteMapper openAccountWrite;
	@Resource
	private SpsChannelGatherWriteMapper gatherWrite;
	@Resource
	private ChannelReadService channelReadService;
	@Override
	public HashMap<String, String> insertAll(SpsChannel channel, 
							SpsChannelEnterprise enterprise, 
							SpsChannelBusiness business, 
							SpsChannelGuarantee guarantee,
							SpsChannelFinanceTarget financeTarget,
							SpsChannelLogistics logistics , 
							SpsChannelOpenAccount openAccount){
		
			HashMap<String, String> result = new HashMap<String,String>();
			
			SpsChannelEnterprise queryEnterprise = channelReadService.getChannel(enterprise);
			
			if(queryEnterprise == null){
				try {
					String numRandom = RuleUtil.getNumRandom(6);
					
					String DateFormat = DateUtil.format(new Date(), "yyyyMMss");
					
					String channelNum = "DF"+DateFormat+numRandom;
					
					channel.setChannelNum(channelNum);
					
					insertChanel(channel);
					
					insertEnterprise(enterprise,channelNum);
					
					insertBusiness(business, channelNum);
					
					insertGuarantee(guarantee, channelNum);
					
					insertFinanceTarget(financeTarget, channelNum);
					
					insertLogistics(logistics, channelNum);
					
					insertOpenAccount(openAccount, channelNum);
					
					result.put("msg", "添加成功");
					result.put("state", "success");
					result.put("icon", "1");
					result.put("channelNum", channelNum);
				} catch (Exception e) {
					result.put("msg", "添加失败");
					result.put("state", "error");
					result.put("icon", "2");
					e.printStackTrace();
				}
			}else{
				result.put("msg", "该商户已存在");
				result.put("state", "exit");
				result.put("icon", "2");
			}
			return result;
		
	};
	@Override
	public HashMap<String, String> insertChanel(SpsChannel channel) {
		
		HashMap<String, String> result = new HashMap<String,String>();
		
		int insertSelective = channelWrite.insertSelective(channel);
		
		return null;
		
	}
	@Override
	public HashMap<String, String> insertEnterprise(SpsChannelEnterprise enterprise, String channelNum) {
		enterprise.setChannelNum(channelNum);
		enterpriseWrite.insertSelective(enterprise);
		return null;
	}
	@Override
	public HashMap<String, String> insertBusiness(SpsChannelBusiness business, String channelNum) {
		business.setChannelNum(channelNum);
		businessWrite.insertSelective(business);
		return null;
	}
	@Override
	public HashMap<String, Object> insertGather(SpsChannelGather gather) {
		
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		SpsChannelGather queryGather = channelReadService.getGather(gather);
		
		if(queryGather == null){
			try {
				int insertSelective = gatherWrite.insertSelective(gather);
				
				Integer gatherId = gather.getGatherId();
				
				hashMap.put("msg", "银行卡添加成功");
				hashMap.put("state", "success");
				hashMap.put("icon", 1);
			} catch (Exception e) {
				hashMap.put("msg", "银行卡添加失败");
				hashMap.put("state", "error");
				hashMap.put("icon", 2);
				e.printStackTrace();
			}
		}
		return hashMap;

}
	@Override
	public HashMap<String, String> insertLogistics(SpsChannelLogistics logistics, String channelNum) {
		logistics.setChannelNum(channelNum);
		
		logisticsWrite.insertSelective(logistics);
		
		return null;
	}
	@Override
	public HashMap<String, String> insertGuarantee(SpsChannelGuarantee guarantee, String channelNum) {
		guarantee.setChannelNum(channelNum);
		guaranteeWrite.insertSelective(guarantee);
		return null;
	}
	@Override
	public HashMap<String, String> insertFinanceTarget(SpsChannelFinanceTarget financeTarget, String channelNum) {
		financeTarget.setChannelNum(channelNum);
		financeTargetWrite.insertSelective(financeTarget);
		return null;
	}
	@Override
	public HashMap<String, String> insertOpenAccount(SpsChannelOpenAccount account, String channelNum) {
		
		account.setChannelNum(channelNum);
		openAccountWrite.insertSelective(account);
		return null;
	}
}