package com.sps.controller.merchant;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.controller.common.UploadController;
import com.sps.service.user.UserService;
import com.sps.util.ControllerLsit;


@Controller
@RequestMapping(value="/merchant")
public class MerchantController {
	@Reference
	private ChannelWriteService chanelWriteService;
	@Reference
	private ChannelReadService channelReadService;
	@Resource
	private UserService userService;
	@RequestMapping(value="/insertChannel.html")
	@ResponseBody
	public HashMap<String, String> getChannel(
			SpsChannel channel, 
			SpsChannelEnterprise enterprise, 
			SpsChannelBusiness business, 
			SpsChannelGuarantee guarantee,
			SpsChannelFinanceTarget financeTarget,
			SpsChannelLogistics logistics , 
			SpsChannelOpenAccount openAccount){
		
		HashMap<String, String> result = chanelWriteService.insertAll(channel, enterprise, 
				business, guarantee, financeTarget, 
				logistics, openAccount);
		//添加后增加到user表
		if(result.get("state").equals("success")){
			userService.insertUser(openAccount.getOpenAdminNum(),"123456",openAccount.getOpenAdminNum(), 
					openAccount.getOpenAdminPhone(),null,"1");
		}
		return result;
	}
	@RequestMapping(value="/getGatherList.html")
	@ResponseBody
	public HashMap<String, Object> getGatherList(Integer page, Integer limit, String channelNum){
		
		HashMap<String, Object> gatherList = channelReadService.getGatherList(page, limit, channelNum);
		
		return gatherList;
		
	}
	@RequestMapping(value="/getChannelList.html")
	@ResponseBody
	public HashMap<String, Object> getChannelList(String channelNum, Integer channelState,  
			Integer channelFlowState, Integer page, Integer limit){
		
		HashMap<String, Object> channelList = channelReadService.getChannelList(
				channelNum, channelState, channelFlowState, page, limit);
		
		return channelList;
		
	}
	@RequestMapping(value="/insertGather.html")
	@ResponseBody
	public HashMap<String, Object> insertGather(SpsChannelGather gather){
		
		HashMap<String, Object> insertGather = chanelWriteService.insertGather(gather);
		
		return insertGather;
	}
/*	@RequestMapping(value="/insertGather.html")
	@ResponseBody
	public HashMap<String, Object> uploadPic(SpsChannelGather gather){
		
		HashMap<String, Object> insertGather = chanelWriteService.insertGather(gather);
		
		return insertGather;
	}*/
}
