package com.sps.controller.system;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.entity.user.SpsRole;
import com.sps.service.user.RoleService;

@Controller
@RequestMapping(value="role")
public class RoleController {
	@Resource
	private RoleService roleService;
	@RequestMapping(value="roleList.html")
	public @ResponseBody HashMap<String, Object> getRoleList(
			Integer page, Integer limit,String roleName){
		
		HashMap<String, Object> roleList = 
				roleService.getRoleList(page, limit, roleName);
		
		return roleList;
	}
	@RequestMapping(value="insertRole.html")
	public @ResponseBody HashMap<String, String> insertRole(
			String roleName, String describe){
		HashMap<String, String> insertRole = 
				roleService.insertRole(roleName, describe);
		
		return insertRole;
	}
}
