package com.sps.controller.system;

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
	public @ResponseBody List<SpsRole> getRoleList(){
		
		List<SpsRole> roleList = roleService.getRoleList();
		
		return roleList;
	}
}
