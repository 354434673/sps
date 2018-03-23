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
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import com.sps.service.user.UserService;

/**
 * 用户登录注册接口
 * @ClassName:  UserController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月13日 上午10:25:50
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Resource
	private UserService userService;
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
	@RequestMapping("/sendCommonSms")
	public ServiceResult<Boolean> sendCommonSms(String mobile, Integer category){
		
		String url = "http://123.56.24.208:8480/invitation.html?salemanPhone="+mobile;
		
		String content = "【店付】业务员您好，以下为店主邀请链接，请妥善保存此链接:"+url;
		ServiceResult<Boolean> sendCommonSms = iSmsCommonService.sendCommonSms("18513967345", content, 3);
		
		return sendCommonSms;
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
	public ServiceResult<LoginInfo> userL(String mobile, String code, String password, String saleSrc, 
			String clientNum, String channelNum, String salemanPhone, String channelPhone){
		
			SpsShopkeeperInvitation queryShopInvitation = userService.queryShopInvitation(mobile, null);
			
			ServiceResult<LoginInfo> serviceResult = null;
			if(queryShopInvitation != null){
				
				RegisterDto arg0 = new RegisterDto();
				
				arg0.setMobile(mobile);
				
				arg0.setCode(code);
				
				arg0.setPassword(password);
				
				arg0.setSaleSrc(clientNum);
				
				serviceResult = iDianfuPassportService.memberRegister4Browser(arg0);
				
				if(serviceResult.getSuccess()){
					serviceResult = userService.insertUser(mobile, password, clientNum, channelNum, salemanPhone, channelPhone);
				}
			}else{
				serviceResult = new ServiceResult<LoginInfo>();
				
				serviceResult.setMessage("该店主未邀请,请邀请后注册");
				
				serviceResult.setSuccess(false);
			}

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
		
		HashMap<String, Object> userLogin = null;
		if(login4Browser.getSuccess()){
			userLogin = userService.userLogin(mobile, password, login4Browser.getResult().getMemberId());
		}else{
			userLogin = Message.resultMap(login4Browser.getCode(), login4Browser.getMessage(),
					Message.SYSTEM_ERROR_MSG, 0, null);
		}
		return userLogin;
	}
}
