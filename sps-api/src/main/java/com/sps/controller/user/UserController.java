package com.sps.controller.user;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.LoginInfo;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.authorization.IBaitiaoPassportService;
import com.juzifenqi.usercenter.service.authorization.IDianfuPassportService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
import com.juzifenqi.usercenter.vo.RegisterDto;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.common.StringUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	@Reference(group = "auth_dev1")
	private FaceAuthApi faceAuthApi;
	@Reference(group = "member-center-dev1")
	private ISmsCommonService iSmsCommonService;
/*	@Reference(group = "member-center-dev1")
	private IDianfuPassportService iDianfuPassportService;*/
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
		AuthFaceIdCard arg0 = new AuthFaceIdCard();
		arg0.setBackImagePath("123124124");
		arg0.setChannel("DF");
		arg0.setRequestNo("12321312");
		arg0.setSource("h5");
		arg0.setUserId(123412412);
		
		JsonResult<AuthFaceIdCard> backIdCardResult = faceAuthApi.getBackIdCardResult(arg0);
		return null;
	}
	/**
	 * 注册密码短信验证码
	 * @Title: getPhoneCode   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param data
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月6日 下午1:56:42
	 * @return: ServiceResult<Boolean>      
	 * @throws
	 */
	@RequestMapping("/getPhoneCode/regist")
	public ServiceResult<Boolean> registForPhoneCode(String mobile, Integer category){
		
			ServiceResult<Boolean> sendRegisterSms = iSmsCommonService.sendRegisterSms(mobile, category);
			
			return sendRegisterSms;
	}
	/**
	 * 修改密码短信验证码
	 * @Title: updatePwsForPhoneCode   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param data
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月6日 下午3:06:19
	 * @return: ServiceResult<Boolean>      
	 * @throws
	 */
	@RequestMapping("/getPhoneCode/update")
	public ServiceResult<Boolean> updatePwsForPhoneCode(@RequestBody String data){
		
		if(!StringUtil.isEmpty(data)){
			JSONObject parseObject = JSON.parseObject(data);
			
			String phone = parseObject.getString("phone");
			
			Integer category = parseObject.getInteger("category");
			
			ServiceResult<Boolean> sendRegisterSms = iSmsCommonService.sendForgetPasswordSms(phone, category);
			
			return sendRegisterSms;
			
		}else{
			return null;
		}
	}
	/**
	 * 用户注册
	 * @Title: userRegist   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param data
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月6日 下午3:07:13
	 * @return: ServiceResult<Boolean>      
	 * @throws
	 */
/*	@RequestMapping("/regist")
	public ServiceResult<LoginInfo> userRegist(@RequestBody String data){
		
		ServiceResult<LoginInfo> serviceResult = null;
		if(!StringUtil.isEmpty(data)){
			JSONObject parseObject = JSON.parseObject(data);
			
			String mobile = parseObject.getString("phone");
			String code = parseObject.getString("code");
			String password = parseObject.getString("password");
			String saleSrc = parseObject.getString("saleSrc");
			
			RegisterDto arg0 = new RegisterDto();
			arg0.setMobile(mobile);
			arg0.setCode(code);
			arg0.setPassword(password);
			arg0.setSaleSrc(saleSrc);
			iDianfuPassportService.login4Browser(arg0);
		}
		return serviceResult;
	}*/
	
}
