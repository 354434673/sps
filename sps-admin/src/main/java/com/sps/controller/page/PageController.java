package com.sps.controller.page;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入口
 * @ClassName:  PageController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2017年12月29日 下午2:26:29
 */
@Controller
public class PageController {
	private final String LOGIN_PAGE = "login";
	private final String INDEX_PAGE = "index";
	/*
	 * 进入登陆页面
	 */
	@RequestMapping("/login.html")
	public String entrance(){
		
		return LOGIN_PAGE;
	}
	//此方法已经进行过用户校验
	@RequestMapping("/index.html")
	public String intoIndex(){
		
		return INDEX_PAGE;
	}
	@RequestMapping(value="/logout.html")
	public String logout(){
		//清除令牌中的信息
		SecurityUtils.getSubject().logout();
		
		return LOGIN_PAGE;
	}
}
