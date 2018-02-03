package com.sps.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.common.logger.Logger;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	//调用短信验证接口
	@RequestMapping("/getVerifyCode")
	public  void  getVerifyCode(String mobile){		
		System.out.println("verify....");
	}
	//调用绑卡接口
	@RequestMapping("/bindBankCard")
	public void bindBankCard(){
		System.out.println("banding.....");
	}
	
}
