package com.sps.controller.system;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.entity.user.SpsRole;
import com.sps.service.user.RoleService;

@Controller
@RequestMapping(value = "role")
public class RoleController {
	@Resource
	private RoleService roleService;

	/**
	 * 获得所有角色列表 @Title: getRoleList @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param page @param: @param
	 * limit @param: @param roleName @param: @return @author YangNingSheng @date
	 * 2018年1月12日 下午4:19:01 @return: HashMap<String,Object> @throws
	 */
	@RequestMapping(value = "roleList.json")
	public @ResponseBody HashMap<String, Object> getRoleList(Integer page, Integer limit, String roleName) {

		HashMap<String, Object> roleList = roleService.getRoleList(page, limit, roleName);

		return roleList;
	}

	@RequestMapping(value = "getRole")
	public @ResponseBody HashMap<String, Object> getRoleByID(String roleId) {
		return roleService.getRoleByID(roleId);
	}

	@RequestMapping(value = "deleteRole")
	public @ResponseBody HashMap<String, String> deleteRole(String roleID) {
		return roleService.deleteRole(roleID);
	}
	@RequestMapping(value = "getRoleForUserId")
	public @ResponseBody HashMap<String, Object> getRoleForUserId(Integer id) {
		
		HashMap<String, Object> roleForUserId = roleService.getRoleForUserId(id);
		
		return roleForUserId;
	}

	/**
	 * 添加角色 @Title: insertRole @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param roleName @param: @param
	 * describe @param: @param menuList @param: @return @author
	 * YangNingSheng @date 2018年1月12日 下午4:19:12 @return: HashMap
	 * <String,String> @throws
	 */
	@RequestMapping(value = "insertRole")
	public @ResponseBody HashMap<String, String> insertRole(String roleName, String describe,
			@RequestParam(value = "menuList[]") List<Integer> menuList) {
		HashMap<String, String> insertRole = roleService.insertRole(roleName, describe, menuList);

		return insertRole;
	}
}
