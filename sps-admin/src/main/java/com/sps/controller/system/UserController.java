package com.sps.controller.system;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private UserAndRoleService userAndRoleService;
	@RequestMapping("/userList.html")
	public @ResponseBody HashMap<String, Object> userList(String page, String limit) {
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		List<SpsUser> userList = userService.userList();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", userList.size());
		hashMap.put("data", userList);
		return hashMap;
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
	public @ResponseBody String userLogin(String user, String pass, 
			String code, boolean rememberMe) {
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
	@RequestMapping(value="insertUser.html")
	@ResponseBody
	public  HashMap<String, Object> insertUser(String username, String password, String name, 
			String phone, String email, @RequestParam(value = "roleList[]") int[] roleList) {
		HashMap<String, Object> insertUser = 
				userService.insertUser(username, password, 
						name, phone, email);//用户添加
		userAndRoleService.insertUserAndRole(username, roleList);//为该用户添加角色
		return insertUser;
	}
}