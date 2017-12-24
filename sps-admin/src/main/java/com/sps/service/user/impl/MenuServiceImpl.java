package com.sps.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.user.SpsMenuMapper;
import com.sps.entity.user.SpsMenu;
import com.sps.entity.user.SpsMenuExample;
import com.sps.service.user.MenuService;
import com.sps.util.MenuUtil;
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Resource
	private SpsMenuMapper spsMenuMapper;
	@Override
	public List<MenuUtil> getMenu() {
/*		SpsMenuExample example = new SpsMenuExample();
		
		com.sps.entity.user.SpsMenuExample.Criteria createCriteria = example.createCriteria();
		
		createCriteria.andMenuNodetypeEqualTo(1);
		
		List<MenuUtil> list = new ArrayList<MenuUtil>();
		
		
		List<SpsMenu> selectByExample = spsMenuMapper.selectByExample(example );
		MenuUtil menuUtil= null;
		for (SpsMenu spsMenu : selectByExample) {
			//只遍历nodeType为1的，如果nodeType为1，说明为父节点
			if(spsMenu.getMenuNodetype() == 1){
				List<MenuUtil> getSubMenu = getSub(spsMenu.getMenuId());
				menuUtil = new MenuUtil();
				menuUtil.setMenuId(spsMenu.getMenuId());
				menuUtil.setName(spsMenu.getMenuName());
				menuUtil.setMenuNodetype(spsMenu.getMenuNodetype());
				menuUtil.setScript(spsMenu.getMenuUrl());
				if(getSubMenu.size()!= 0){
					menuUtil.setSubMenu(getSubMenu);
				}
			}
			list.add(menuUtil);
		}*/
		List<MenuUtil> seletMenuList = spsMenuMapper.seletMenuList();
		
		return seletMenuList;
	}
/*	private List<MenuUtil> getSub(Integer id){
		SpsMenuExample example2 = new SpsMenuExample();
		example2.createCriteria().andMenuParentidEqualTo(id);
		List<SpsMenu> selectByExample2 = spsMenuMapper.selectByExample(example2);
		MenuUtil menuUtil= null;
		List<MenuUtil> list2 = new ArrayList<MenuUtil>();
		for (SpsMenu spsMenu : selectByExample2) {
			menuUtil = new MenuUtil();
			menuUtil.setMenuId(spsMenu.getMenuId());
			menuUtil.setName(spsMenu.getMenuName());
			menuUtil.setMenuNodetype(spsMenu.getMenuNodetype());
			menuUtil.setScript(spsMenu.getMenuUrl());
			list2.add(menuUtil);
		}
		return list2;
	}*/
}
