package com.sps.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
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
	public @ResponseBody String userLogin(String user, String pass, String code) {
		UsernamePasswordToken usernamePasswordToken = 
				new UsernamePasswordToken(user, pass);
		
		usernamePasswordToken.setRememberMe(true);
		HashMap<String, String> loginData = new HashMap<String,String>();
	    try {  
	    	SecurityUtils.getSubject().login(usernamePasswordToken);
	    	
	    } catch (UnknownAccountException ex) {  
	    	ex.printStackTrace(); 
	        System.out.println("用户不存在或者密码错误！");
	        return "inexistence";
	    } catch (IncorrectCredentialsException ex) { 
	    	ex.printStackTrace(); 
	    	System.out.println("用户不存在或者密码错误！");
	    	return "inexistence";
	    } catch (AuthenticationException ex) {  
	    	ex.printStackTrace(); 
	    	System.out.println("自定义");
	    	return "inexistence";
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        System.out.println("内部错误，请重试！");
	        return "error";
	    }  
	    
		return "success";
	}
	
}