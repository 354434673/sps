package com.sps.merchant.serviceImpl.read;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelEnterpriseExample;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGatherExample;
import org.sps.entity.merchant.SpsChannelGatherExample.Criteria;
import org.sps.service.merchant.read.ChannelReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelEnterpriseReadMapper;
import com.sps.dao.merchant.read.SpsChannelGatherReadMapper;


@Service(timeout=12000)
public class ChannelReadServiceImpl implements ChannelReadService{
	@Resource
	private SpsChannelEnterpriseReadMapper enterpriseRead;
	@Resource
	private SpsChannelGatherReadMapper gatherRead;
	@Override
	public HashMap<String, Object> getChannelList(String channelNum, Integer channelState, 
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
	

}
