package com.sps.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sps.service.user.MenuService;
import com.sps.util.MenuUtil;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	@Resource
	private MenuService menuService;

	@RequestMapping(value = "/getMenu.json")
	public @ResponseBody List<MenuUtil> getMenuList(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		List<MenuUtil> menu = menuService.getMenu();
		
		return menu;
	}
	@RequestMapping(value = "/getSpecificMenu.json")
	public @ResponseBody List<MenuUtil> getSpecificMenu(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		List<MenuUtil> specificMenu = menuService.getSpecificMenu();
		
		return specificMenu;
	}

}
