package com.sps.service.user;

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
}
