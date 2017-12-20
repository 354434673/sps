package com.sps.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		model.addAttribute("user", "aaaa");
		System.out.println("11");
		return "login";
	}
	/**
	 * @Title: userLogin   
	 * @Description: 用户登录
	 * @param: @param request
	 * @param: @param model
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月7日 下午3:17:41
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = {"userLogin.html"})
	public String userLogin() {
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("abc", "123");
		
		usernamePasswordToken.setRememberMe(true);
	    try {  
	    	SecurityUtils.getSubject().login(usernamePasswordToken);
	    } catch (UnknownAccountException ex) {  
	        System.out.println("用户不存在或者密码错误！");
	        return "login";
	    } catch (IncorrectCredentialsException ex) {  
	    	System.out.println("用户不存在或者密码错误！");
	    	return "login";
	    } catch (AuthenticationException ex) {  
	    	System.out.println("自定义");
	        //return ex.getMessage(); // 自定义报错信息  
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        System.out.println("内部错误，请重试！");
	    }  
		return "index";
	}
	
}