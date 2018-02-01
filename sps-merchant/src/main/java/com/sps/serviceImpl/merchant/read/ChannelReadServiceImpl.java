package com.sps.serviceImpl.merchant.read;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelBusinessExample;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelEnterpriseExample;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelFinanceTargetExample;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGatherExample;
import org.sps.entity.merchant.SpsChannelGatherExample.Criteria;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelGuaranteeExample;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelLogisticsExample;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.entity.merchant.SpsChannelOpenAccountExample;
import org.sps.service.merchant.read.ChannelReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelBusinessReadMapper;
import com.sps.dao.merchant.read.SpsChannelEnterpriseReadMapper;
import com.sps.dao.merchant.read.SpsChannelFinanceTargetReadMapper;
import com.sps.dao.merchant.read.SpsChannelGatherReadMapper;
import com.sps.dao.merchant.read.SpsChannelGuaranteeReadMapper;
import com.sps.dao.merchant.read.SpsChannelLogisticsReadMapper;
import com.sps.dao.merchant.read.SpsChannelOpenAccountReadMapper;


@Service(timeout=2000,group="dianfu-dev")
@Transactional(readOnly = true)
public class ChannelReadServiceImpl implements ChannelReadService{
	@Resource
	private SpsChannelEnterpriseReadMapper enterpriseRead;
	@Resource
	private SpsChannelGatherReadMapper gatherRead;
	@Resource
	private SpsChannelGuaranteeReadMapper guaranteeRead;
	@Resource
	private SpsChannelLogisticsReadMapper logisticsRead;
	@Resource
	private SpsChannelFinanceTargetReadMapper financeTargetRead;
	@Resource
	private SpsChannelOpenAccountReadMapper openAccountRead;
	@Resource
	private SpsChannelBusinessReadMapper businessRead;
	@Override
	public HashMap<String, Object> getChannelList(String channelNum, String name, Integer channelState, 
			Integer channelFlowState, Integer page, Integer limit) {
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsChannel channel = new SpsChannel();
			if(!(channelNum == null||channelNum.equals(""))){
				channel.setChannelNum("%"+channelNum+"%");
			}
			if(channelState != null){
				channel.setChannelState(channelState);
			}
			if(channelFlowState != null){
				channel.setChannelFlowState(channelFlowState);
			}
			PageHelper.startPage(page, limit);
			List<SpsChannelEnterprise> selectChannel = enterpriseRead.selectChannel(channel);
			
			PageInfo pageInfo = new PageInfo(selectChannel);
			hashMap.put("code", 0);
			hashMap.put("msg", "获取成功");
			hashMap.put("count", pageInfo.getTotal());
			hashMap.put("data", selectChannel.size() != 0 ? selectChannel : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public HashMap<String, Object> getGatherList(Integer page, Integer limit, String channelNum) {
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsChannelGatherExample example = new SpsChannelGatherExample();
			
			if(!(channelNum == null ||channelNum.equals(""))){
				Criteria createCriteria = example.createCriteria();
				
				createCriteria.andChannelNumEqualTo(channelNum);
			}
			
			PageHelper.startPage(page, limit);
			
			List<SpsChannelGather> selectByExample = gatherRead.selectByExample(example);
			
			PageInfo pageInfo = new PageInfo(selectByExample);
			
			hashMap.put("code", 0);
			hashMap.put("msg", "获取成功");
			hashMap.put("count", pageInfo.getTotal());
			hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public SpsChannelGather getGather(SpsChannelGather gather) {
		SpsChannelGatherExample example = new SpsChannelGatherExample();
		
		example.createCriteria()
							.andChannelNumEqualTo(gather.getChannelNum())
							.andGatherBankIdEqualTo(gather.getGatherBankId())
							.andGatherIdcardEqualTo(gather.getGatherIdcard());
		List<SpsChannelGather> selectByExample = gatherRead.selectByExample(example);
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
	@Override
	public SpsChannelEnterprise getChannel(SpsChannelEnterprise enterprise) {
		
		SpsChannelEnterpriseExample example = new SpsChannelEnterpriseExample();
		
		example.createCriteria().andEnterpriseBusinesslicenseNoEqualTo(enterprise.getEnterpriseBusinesslicenseNo());
		
		List<SpsChannelEnterprise> selectByExample = enterpriseRead.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
	@Override
	public SpsChannelEnterprise getChannelOne(String channelNum, String state) {
		
		SpsChannel channel = new SpsChannel();
		
		channel.setChannelNum(channelNum);
		
		List<SpsChannelEnterprise> selectChannel = enterpriseRead.selectChannel(channel);
		
		return selectChannel.size() == 0 ? null : selectChannel.get(0);
	}
	@Override
	public SpsChannelGuarantee getGuarantee(String channelNum) {
		
		SpsChannelGuaranteeExample example = new SpsChannelGuaranteeExample();
		
		example.createCriteria().andChannelNumEqualTo(channelNum);
		
		List<SpsChannelGuarantee> selectByExample = guaranteeRead.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
	@Override
	public SpsChannelFinanceTarget getFinanceTarget(String channelNum) {
		
		SpsChannelFinanceTargetExample example = new SpsChannelFinanceTargetExample();
		
		example.createCriteria().andChannelNumEqualTo(channelNum);
		
		List<SpsChannelFinanceTarget> selectByExample = financeTargetRead.selectByExample(example );
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
	@Override
	public SpsChannelLogistics getLogistics(String channelNum) {
		
		SpsChannelLogisticsExample example = new SpsChannelLogisticsExample();
		
		example.createCriteria().andChannelNumEqualTo(channelNum);
		
		List<SpsChannelLogistics> selectByExample = logisticsRead.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);

	}
	@Override
	public SpsChannelOpenAccount getOpenAccount(String channelNum, String username) {
		SpsChannelOpenAccountExample example = new SpsChannelOpenAccountExample();
		
		org.sps.entity.merchant.SpsChannelOpenAccountExample.Criteria createCriteria = example.createCriteria();
		
		if(channelNum != null){
			createCriteria.andChannelNumEqualTo(channelNum);
		}
		if(username != null){
			createCriteria.andOpenAdminNumEqualTo(username);
		}
		List<SpsChannelOpenAccount> selectByExample = openAccountRead.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);

	}
	@Override
	public SpsChannelBusiness getBusiness(String channelNum) {
		
		SpsChannelBusinessExample example = new SpsChannelBusinessExample();
		
		example.createCriteria().andChannelNumEqualTo(channelNum);
		
		List<SpsChannelBusiness> selectByExample = businessRead.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
	}
}
