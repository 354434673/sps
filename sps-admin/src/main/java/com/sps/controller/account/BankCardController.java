package com.sps.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
import com.sps.common.Result;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.account.AuthEnums;
import org.sps.entity.account.AuthRequest;
import org.sps.entity.account.AuthResponse;
import org.sps.entity.merchant.SpsChannelBalance;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelBankTransReadService;
import org.sps.service.merchant.read.SpsBalanceReadService;
import org.sps.service.merchant.write.AuthBindCardWriteService;
import org.sps.service.merchant.write.ChannelBankTransWriteService;
import org.sps.service.merchant.write.ChannelBankWriteService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/bankCard")
public class BankCardController {
	private static  final Log logger= LogFactory.getLog(BankCardController.class);
	
	@Reference(check=false,group="dianfu")
	private ChannelBankWriteService  bankWriteService;
	@Reference(check=false,group="dianfu")
	private SpsBalanceReadService spsBalanceService;


	@Reference(check=false,group="dianfu")
	private ChannelBankReadService   bankReadService;
	@Reference(check=false,group="dianfu")
	private ChannelBankTransReadService bankTransReadService;
	@Reference(check=false,group="dianfu")
	private ChannelBankTransWriteService bankTransWriteService;
	@Reference(check=false,group="dianfu")
	private AuthBindCardWriteService authBindCardWrite;


	/*@Reference(check = false, group = "member-center-dev1")
	private IMemberDianfuService memberDianfuService;


	@Reference(group = "member-center-dev1")
	private ISmsCommonService ismsCommonService;*/
	
	@Resource
	private UserService userService;
	@Resource
	private UserAndRoleService userAndRoleService;


	/*@RequestMapping("/getVerifyCode")
	@ResponseBody
	public ServiceResult<Boolean> getVerifyCode(String phone){
		logger.info("getVerifyCode 方法 开始调用。。。。。。。");
		ServiceResult<Boolean> result = ismsCommonService.sendForgetPasswordSms(phone, 3);
		*//*return sendRegisterSms;
		//去后台下校验手机号
		HashMap<String, Object> result=new HashMap<String, Object>();
		//转发第三方支付平台*//*
		return  result;
				
	}*/
	//调用绑卡接口
	@RequestMapping("/bindBankCard")
	@ResponseBody
	public Result bindBankCard(HttpServletRequest request,HttpServletResponse response,SpsChannelBank bankInfo){
		JSONObject body = new JSONObject();
		Result<JSONObject> result = new Result<JSONObject>(body);
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		//根据用户名 和用户类型查询Balance中是否存在 该用户
		SpsChannelBank bankCard = bankReadService.getBankInfo(userName);
		if(bankCard == null){
			SpsUser user = userService.findByUserName(userName);
			Boolean saveBankInfo = bankWriteService.saveBankInfo(bankInfo, user.getUserId(), user.getUserMark());
			if(saveBankInfo){
				result.success();
				result.setMsg("操作成功");
			}
				return result;
		}
		result.setMsg("已绑过卡，请解绑卡之后再操作");
		return result;
		
	}
	@RequestMapping("/confirm")
	@ResponseBody
	public Result smsConfirm(HttpServletRequest request,AuthRequest.ConfirmParam confirmParam){

		JSONObject body = new JSONObject();
		Result<JSONObject> result = new Result<>(body);
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		SpsUser user = userService.getUser(userName);
		// 设置confirmParam 的用户信息
		AuthResponse.ConfirmResult confirm =authBindCardWrite.confirm(confirmParam);
		if(confirm != null){
			String status = confirm.getStatus();
			AuthEnums.AuthStatus authStatus = AuthEnums.AuthStatus.get(status);
			result.setMsg(authStatus.getValue());
			//业务关注：1.绑卡成功，则跳转至详情页
			if(authStatus == AuthEnums.AuthStatus.BIND_SUCCESS){
				body.put("code",1);
				result.success();
			}
			//业务关注点：2.短信验证码不正确，则提示并重发短信
			if(authStatus == AuthEnums.AuthStatus.TO_VALIDATE || authStatus == AuthEnums.AuthStatus.BIND_ERROR){
				body.put("code",2);
				body.put("requestno",confirm.getRequestno());
				body.put("yborderid",confirm.getYborderid());
				result.success();
			}
			//其他：直接提示
		}
		return result;
	}
	@RequestMapping("/resend")
	@ResponseBody
	public Result smsResend(HttpServletRequest request,AuthRequest.ResendParam resendParam){
		JSONObject body = new JSONObject();
		Result<JSONObject> result = new Result<>(body);
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		SpsUser user = userService.getUser(userName);
		// 设置resendParam 的用户信息
		AuthResponse.ResendResult resendResult = authBindCardWrite.resend(resendParam);
		if(resendResult != null){
			String status = resendResult.getStatus();
			AuthEnums.AuthStatus authStatus = AuthEnums.AuthStatus.get(status);
			result.setMsg(authStatus.getValue());
			//业务关注点：待验证状态，则进行短信确认
			if(authStatus == AuthEnums.AuthStatus.TO_VALIDATE){
				body.put("requestno",resendResult.getRequestno());
				body.put("yborderid",resendResult.getYborderid());
				result.success();
			}
			//其他：直接提示
		}
		return result;
	}

	@RequestMapping("/bankCardDetail")
	@ResponseBody
	public JSONObject bankCardDetail(HttpServletRequest request){
		JSONObject result = new JSONObject();
		String userName = (String)SecurityUtils.getSubject().getPrincipal();	
		SpsChannelBank bankCard = bankReadService.getBankInfoByUserName(userName);
		result.put("bankCard", bankCard);
		result.put("isDEL",bankCard == null?"1":"0");
		return result;
	}
	@RequestMapping("/unbindBackCard")
	@ResponseBody
	public Result unbindBackCard(HttpServletRequest request,String isDEL){
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		Result result = new Result<Boolean>();
		String msg = "解绑成功";
		Boolean delete = bankWriteService.removeBankInfo(userName);
		msg = delete?"解绑成功":"解绑失败";
//		boolean delete = true;
	/*	if("1".equals(isDEL)){
			delete = bankWriteService.removeBankInfo(userName);
			msg = delete?"解绑成功":"解绑失败";
		}*/
//		result.success();
		result.setBody(delete);
		result.setMsg(msg);
		return result;
	}
	

}

