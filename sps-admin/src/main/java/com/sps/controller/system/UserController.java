package com.sps.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	/**
	 * 用户列表
	 * @Title: userList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param username
	 * @param: @param name
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:19:27
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/userList.json")
	public @ResponseBody HashMap<String, Object> userList(Integer page, Integer limit,
			String username, String name) {
		HashMap<String, Object> userList = userService.userList(page,limit, username, name);
		return userList;
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
	@RequestMapping(value = {"userLogin"})
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
	/**
	 * 添加用户
	 * @Title: insertUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param username
	 * @param: @param password
	 * @param: @param name
	 * @param: @param phone
	 * @param: @param email
	 * @param: @param mark
	 * @param: @param roleList
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:19:40
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value="insertUser")
	@ResponseBody
	public  HashMap<String, Object> insertUser(SpsUser user, @RequestParam(value = "roleList[]") int[] roleList) {
		HashMap<String, Object> insertUser = 
				userService.insertUser(user);//用户添加
		userAndRoleService.insertUserAndRole(user.getUserUsername(), roleList);//为该用户添加角色
		return insertUser;
	}
	/**
	 * 修改用户
	 * @Title: updateUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param user
	 * @param: @param roleList
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:19:47
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value="updateUser")
	@ResponseBody
	public  HashMap<String, Object> updateUser(SpsUser user,  
				@RequestParam(value = "roleList[]") int[] roleList) {
		HashMap<String, Object> updateUser = userService.updateUser(user);
		
		userAndRoleService.updateUserForRole(user.getUserUsername(), roleList);//修改用户角色
		
		return updateUser;
	}
	/**
	 * 修改密码
	 * @Title: updatePassword   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param oldPassword
	 * @param: @param newPassword
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:19:54
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value="updatePassword")
	@ResponseBody
	public  HashMap<String, Object> updatePassword(String oldPassword, String newPassword){
		
		HashMap<String, Object> updatePassword = userService.updatePassword(oldPassword, newPassword);
		
		return updatePassword;
	}
	/**
	 * 删除用户,这里假删除,只改状态
	 * @Title: updateUserState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:20:01
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value="updateUserState")
	@ResponseBody
	public  HashMap<String, Object> updateUserState(String userName, Integer state){
		
		HashMap<String, Object> updateUserState = userService.updateUserState(userName, state);
		
		return updateUserState;
	}
	/**
	 * 登出
	 * @Title: logout   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:20:25
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/logout")
	public String logout(){
		//清除令牌中的信息
		SecurityUtils.getSubject().logout();
		
		return "login";
	}
	
}