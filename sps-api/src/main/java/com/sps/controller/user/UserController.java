package com.sps.controller.user;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.LoginInfo;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.authorization.IDianfuPassportService;
import com.juzifenqi.usercenter.vo.LoginDto;
import com.juzifenqi.usercenter.vo.RegisterDto;
import com.jzfq.auth.core.api.FaceAuthApi;
import com.jzfq.auth.core.api.entiy.face.AuthFaceIdCard;
import com.jzfq.auth.core.api.vo.JsonResult;
import com.sps.common.StringUtil;
import com.sps.service.user.UserService;

import io.swagger.models.auth.In;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Resource
	private UserService userService;
/*	@Reference(group = "${dubbo.group}")*/
	@Reference(group = "member-center-dev1")
	private ISmsCommonService iSmsCommonService;
	@Reference(group = "member-center-dev1")
	private IDianfuPassportService iDianfuPassportService;
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
	@RequestMapping("/regist")
	public ServiceResult<LoginInfo> userL(String mobile, String code, String password, String saleSrc){
		
/*			JSONObject parseObject = JSON.parseObject(data);

			String mobile = parseObject.getString("phone");
			String code = parseObject.getString("code");
			String password = parseObject.getString("password");
			String saleSrc = parseObject.getString("saleSrc");*/

			RegisterDto arg0 = new RegisterDto();

			arg0.setMobile(mobile);

			arg0.setCode(code);

			arg0.setPassword(password);

			arg0.setSaleSrc(saleSrc);

			ServiceResult<LoginInfo> serviceResult = iDianfuPassportService.memberRegister4Browser(arg0);

			return serviceResult;
	}
	@RequestMapping("/login")
	public HashMap<String, Object> userLogin(String imei, String ip, String mobile,
			String mobileBrand, String mobileMaker, String password, Integer source){
		LoginDto arg0 = new LoginDto();
		arg0.setImei(imei);
		arg0.setIp(ip);
		arg0.setMobile(mobile);
		arg0.setMobileMaker(mobileMaker);
		arg0.setMobileBrand(mobileBrand);
		arg0.setPassword(password);
		arg0.setSource(source);
		ServiceResult<LoginInfo> login4Browser = iDianfuPassportService.login4Native(arg0);
		
		HashMap<String, Object> userLogin = userService.userLogin(mobile, password);

		return userLogin;
	}
}
