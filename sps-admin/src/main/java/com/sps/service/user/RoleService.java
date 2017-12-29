package com.sps.service.user;

import java.util.HashMap;
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
	HashMap<String, Object> getRoleList(Integer page, Integer limit, String roleName);
	/**
	 * 添加角色
	 * @Title: insertRole   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param roleName
	 * @param: @param describe
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月29日 上午11:11:56
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	HashMap<String, String> insertRole(String roleName, String describe);
}
