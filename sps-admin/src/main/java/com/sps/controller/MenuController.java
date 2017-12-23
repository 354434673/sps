package com.sps.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sps.dao.user.SpsMenuMapper;
import com.sps.entity.user.SpsMenu;
import com.sps.entity.user.SpsMenuExample;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.MenuService;
import com.sps.util.MenuUtil;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/getMenu.json")
	public @ResponseBody String getMenuList(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		HashMap<String, List<MenuUtil>> menu = menuService.getMenu();
		
		String jsonString = JSON.toJSONString(menu);
		
		return jsonString;
	}

}