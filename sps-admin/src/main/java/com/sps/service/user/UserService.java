package com.sps.service.user;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sps.entity.user.SpsUser;

public interface UserService {
	/**
	 * 用户登录
	 * @Title: userLogin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param user
	 * @param: @param pass
	 * @param: @param code
	 * @param: @param rememberMe
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月5日 下午1:51:54
	 * @return: String      
	 * @throws
	 */
	String userLogin(String user, String pass, String code, boolean rememberMe);
	/**
	 * 用户登出
	 * @Title: userLogout   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param:   
	 * @author YangNingSheng    
	 * @date 2018年2月5日 下午1:52:19
	 * @return: void      
	 * @throws
	 */
	String userLogout();
	
	/**
	 * 获得用户
	 * @Title: getUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月23日 下午12:00:54
	 * @return: SpsUser      
	 * @throws
	 */
	SpsUser getUser(String userName);
	/**
	 * 全部用户
	 * @Title: userList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月26日 下午3:09:08
	 * @return: List<SpsUser>      
	 * @throws
	 */
	HashMap<String, Object> userList(Integer page, Integer limit, 
					String username, String name, String phone, Integer mark);
	/**
	 * 添加用户
	 * @Title: insertUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月27日 下午2:16:58
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> insertUser(SpsUser user);
	/**
	 * 修改密码
	 * @Title: updatePassword   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param oldPassword
	 * @param: @param newPassword
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月28日 下午4:19:13
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> updatePassword(String username, String oldPassword, String newPassword);
	/**
	 * 修改用户信息
	 * @Title: updateUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param spsUser
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月11日 下午3:37:43
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> updateUser(SpsUser spsUser);
	/**
	 * 删除该用户,假删除,改字段
	 * @Title: updateUserState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月11日 下午6:38:09
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> updateUserState(String userName, Integer state);
	
	
	
}
