package com.sps.merchant.serviceImpl.read;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.service.merchant.read.ChannelReadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelEnterpriseReadMapper;


@Service(timeout=12000)
public class ChannelReadServiceImpl implements ChannelReadService{
	@Resource
	private SpsChannelEnterpriseReadMapper enterpriseRead;
	@Override
	public HashMap<String, Object> getChannelList(String channelNum, Integer channelState, 
			Integer page, Integer limit) {
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsChannel channel = new SpsChannel();
			if(!(channelNum == null||channelNum.equals(""))){
				channel.setChannelNum("%"+channelNum+"%");
			}
			if(channelState != null){
				channel.setChannelState(channelState);
			}
			PageHelper.startPage(page, limit);
			List<SpsChannelEnterprise> selectChannel = enterpriseRead.selectChannel(channel);
			
			for (SpsChannelEnterprise spsChannelEnterprise : selectChannel) {
				System.out.println(spsChannelEnterprise.getChannelNum());
			}
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
	

}
