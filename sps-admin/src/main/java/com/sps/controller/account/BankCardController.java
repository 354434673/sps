package com.sps.controller.account;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.sps.entity.account.AuthEnums;
import org.sps.entity.account.AuthRequest;
import org.sps.entity.account.AuthResponse;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelBankTransReadService;
import org.sps.service.merchant.write.AuthBindCardWriteService;
import org.sps.service.merchant.write.ChannelBankTransWriteService;
import org.sps.service.merchant.write.ChannelBankWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Result;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;
import com.sps.util.LogUtil;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Reference;
import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

@Controller
@RequestMapping("/bankCard")
public class BankCardController {
	
	@Reference(check=false,group="dianfu")
	private ChannelBankWriteService  bankWriteService;
	@Reference(check=false,group="dianfu")
	private ChannelBankReadService   bankReadService;
	@Reference(check=false,group="dianfu")
	private ChannelBankTransReadService bankTransReadService;
	@Reference(check=false,group="dianfu")
	private ChannelBankTransWriteService bankTransWriteService;
	@Reference(check=false,group="dianfu")
	private AuthBindCardWriteService authBindCardWrite;
	
	@Resource
	private UserService userService;
	@Resource
	private UserAndRoleService userAndRoleService;
	
	@ResponseBody
	public  Map<String, Object> getVerifyCode( Model model,String mobile){	
		//去后台下校验手机号
		HashMap<String, Object> result=new HashMap<String, Object>();
		//转发第三方支付平台
		return  result;
				
	}
	//调用绑卡接口
	@RequestMapping("/bindBankCard")
	@ResponseBody
	public Result bindBankCard(HttpServletRequest request,HttpServletResponse response,SpsChannelBank bankInfo){
		JSONObject body = new JSONObject();
		Result<JSONObject> result = new Result<JSONObject>(body);
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		SpsChannelBank bankCard = bankReadService.getBankInfo(userName);
		LogUtil.info("bankCard ..."+ bankCard.getAccounts());
		if(bankCard != null){
			result.setMsg("已绑过卡，请解绑卡之后再操作");
			return result;
		}
		/*SpsUser user = userService.getUser(userName);
		AuthRequest.AuthParam authParam = new AuthRequest.AuthParam(bankInfo);
		//authParam.setUserId(user.getUserId().toString());
		authParam.setLoginName(userName);
		AuthResponse.AuthResult authResult =authBindCardWrite.request(authParam);
		if(authResult != null){
			body.put("requestNo",authResult.getRequestno());
			body.put("yborderid",authResult.getYborderid());
			String status = authResult.getStatus();
			result.setMsg(AuthEnums.AuthStatus.getValue(status));
			//关注业务点：待验证状态，则进行短信确认
			if(AuthEnums.AuthStatus.TO_VALIDATE.getKey().equals(status)){
				result.success();
			}
			//其他：直接提示
		}*/
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
	public JSONObject bankCardDetail(HttpServletRequest request,String name
			,String identity,String accounts,String bank ,String phone){
		JSONObject result = new JSONObject();
		SpsChannelBank bankInfo = new SpsChannelBank();
		bankInfo.setBank(bank);
		bankInfo.setAccounts(accounts);
		bankInfo.setIdentity(identity);
		bankInfo.setPhone(phone);
		bankInfo.setName(name);
		String userName = (String)SecurityUtils.getSubject().getPrincipal();	
		LogUtil.info("bankCard1++++++"+ userName);
		SpsChannelBank bankCard1 = bankReadService.getBankInfo(userName);
		
		LogUtil.info("bankCard1++++++"+ bankCard1.getAccounts());
		if( bankCard1.getAccounts().equals(null)|| bankCard1.getAccounts()==" "){
			LogUtil.info("保存方法了。。。。。。。");
			//調用第三方支付平台進行綁卡
			Boolean flag = bankWriteService.saveBankInfo(bankInfo, userName);
			if(flag==true){
				
				result.put("mes", "綁卡成功");
				return result;
			}else{
				result.put("mes", "服务端异常");
				return result;
			}
			
			
		}else{
			result.put("bankCard", bankInfo);
			result.put("isDEL",bankInfo == null?"1":"0");
			return result;
		}
		
		
	}
	@RequestMapping("/unbindBackCard")
	@ResponseBody
	public Result unbindBackCard(HttpServletRequest request,String isDEL){
		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		Result result = new Result<Boolean>();
		String msg = "解绑成功";
		boolean delete = true;
		if(isDEL == "1"){
			delete = bankWriteService.removeBankInfoOrNo(userName);
			msg = delete?"解绑成功":"解绑失败";
		}
		result.success();
		result.setBody(delete);
		result.setMsg(msg);
		return result;
	}
	

}

