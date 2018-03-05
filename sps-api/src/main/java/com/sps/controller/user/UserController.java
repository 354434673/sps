package com.sps.controller.user;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jdk.nashorn.internal.ir.annotations.Reference;

@RestController
@RequestMapping("/user")
public class UserController {
	@Reference(group = "auth_dev1")
	private FaceAuthApi faceAuthApi;
/*	@Reference(group="dianfu")
	private ChannelReadService channelReadService;*/
	/**
	 * 用户认证,调核心接口
	 * @Title: authentication   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月28日 下午4:35:32
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/authentication")
	public HashMap<String, Object> authentication(){
/*		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		
		arg0.setBackImagePath("123124124");
		arg0.setChannel("DF");
		arg0.setRequestNo("12321312");
		arg0.setSource("h5");
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getBackIdCardResult(arg0);
		SpsChannelEnterprise channelOne = channelReadService.getChannelOne("DF20180136191770", null);
		System.out.println(JSON.toJSONString(channelOne));*/
		return null;
	}
	@RequestMapping("/test")
	public HashMap<String, Object> test(){
				AuthFaceIdCard arg0 = new AuthFaceIdCard();
		
		arg0.setBackImagePath("123124124");
		arg0.setChannel("DF");
		arg0.setRequestNo("12321312");
		arg0.setSource("h5");
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getIDCardResult(arg0);
		return null;
	}
}
