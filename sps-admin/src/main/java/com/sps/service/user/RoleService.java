package com.sps.service.user;

import java.util.List;

import com.sps.entity.user.SpsRole;

public interface RoleService {
	/**
	 * 获得角色列表
	 * @Title: getRoleList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月26日 下午5:17:58
	 * @return: List<SpsRole>      
	 * @throws
	 */
	List<SpsRole> getRoleList();
}
