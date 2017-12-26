package com.sps.service.user;

import com.sps.entity.user.SpsUserandrole;

/**
 * 用户与角色service层
 * @ClassName:  UserAndRoleService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2017年12月27日 下午7:36:13
 */
public interface UserAndRoleService {
	/**
	 * 添加关系表
	 * @Title: insertUserAndRole   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param roleList
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月27日 下午8:28:30
	 * @return: int      
	 * @throws
	 */
	int insertUserAndRole(String userName, int[] roleList);
	/**
	 * 查找
	 * @Title: getUserAndrole   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月27日 下午8:30:07
	 * @return: SpsUserandrole      
	 * @throws
	 */
	SpsUserandrole getUserAndrole(int userId, int roleId);
}
