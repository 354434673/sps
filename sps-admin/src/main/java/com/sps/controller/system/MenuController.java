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
	
	/**
	 * 获得菜单
	 * @Title: getMenuList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:18:34
	 * @return: List<MenuUtil>      
	 * @throws
	 */
	@RequestMapping(value = "/getMenu.json")
	public @ResponseBody List<MenuUtil> getMenuList(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		List<MenuUtil> menu = menuService.getMenu();
		
		return menu;
	}
	/**
	 * 封装后的菜单
	 * @Title: getSpecificMenu   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:18:42
	 * @return: List<MenuUtil>      
	 * @throws
	 */
	@RequestMapping(value = "/getSpecificMenu.json")
	public @ResponseBody List<MenuUtil> getSpecificMenu(){
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		List<MenuUtil> specificMenu = menuService.getSpecificMenu();
		
		return specificMenu;
	}

	/**
	 * 获取菜单管理分页
	 * @param page
	 * @param limit
	 * @param roleName
     * @return
     */
//	@RequestMapping(value = "menuList.json")
//	public @ResponseBody HashMap<String, Object> getMenuList(Integer page, Integer limit, String roleName) {
//
//		HashMap<String, Object> roleList = menuService.getRoleList(page, limit, roleName);
//		return roleList;
//	}

}
