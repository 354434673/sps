package com.sps.service.user;

import java.util.HashMap;
import java.util.List;

import com.sps.entity.user.SpsUser;

public interface UserService {
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
	List<SpsUser> userList();
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
	HashMap<String, Object> insertUser(String...strs);
}
