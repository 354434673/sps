package com.sps.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.sps.dao.user.SpsMenuMapper;
import com.sps.entity.user.SpsMenu;
import com.sps.entity.user.SpsMenuExample;
import com.sps.entity.user.SpsRole;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.MenuService;
import com.sps.service.user.UserService;
import com.sps.util.MenuUtil;
@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Resource
	private UserService userService;
	@Resource
	private SpsMenuMapper spsMenuMapper;
	@Override
	public List<MenuUtil> getMenu() {
/*		List<Integer> roldId = new ArrayList<Integer>();
		roldId.add(2);
		roldId.add(3);
		List<MenuUtil> seletMenuList = spsMenuMapper.seletMenuList(roldId);
		
		return seletMenuList;*/
		List<Integer> roleList = new ArrayList<Integer>();
		
		String userName = (String) SecurityUtils.getSubject().getPrincipal();//获得当前用户
		
		SpsUser user = userService.getUser(userName);
		
		List<SpsRole> role = user.getRole();
		for (SpsRole spsRole : role) {//获得当前用户的所有角色
			roleList.add(spsRole.getRoleId());
		}
 		SpsMenuExample example = new SpsMenuExample();
 		
 		example.setOrderByClause("m1.menu_sort");
		example.createCriteria()
						.andMenuNodetypeEqualTo(1)
						.andMenuStateEqualTo(0)
						.andRoleIdIn(roleList);
		List<MenuUtil> list = new ArrayList<MenuUtil>();
		
		List<SpsMenu> selectByExample = spsMenuMapper.selectByExample(example);
		MenuUtil menuUtil= null;
		for (SpsMenu spsMenu : selectByExample) {
			//只遍历nodeType为1的，如果nodeType为1，说明为父节点
			if(spsMenu.getMenuNodetype() == 1){
				List<MenuUtil> getSubMenu = getSub(spsMenu.getMenuId(),roleList);
				menuUtil = new MenuUtil();
				menuUtil.setId(spsMenu.getMenuId());
				menuUtil.setTitle(spsMenu.getMenuName());
				menuUtil.setMenuParentid(spsMenu.getMenuParentid());
				menuUtil.setMenuNodetype(spsMenu.getMenuNodetype());
				menuUtil.setHref(spsMenu.getMenuUrl());
				menuUtil.setSort(spsMenu.getMenuSort());
				menuUtil.setChildren(getSubMenu);
			}
			list.add(menuUtil);
		}
		return list;
	}
	@Override
	public List<MenuUtil> getSpecificMenu() {
/*		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		List<Integer> roldId = new ArrayList<Integer>();
		
		roldId.add(1);
		List<MenuUtil> seletMenuList = spsMenuMapper.seletMenuList(roldId);
		
		ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
		for (MenuUtil menuUtil : seletMenuList) {
			hashMap.put("id", menuUtil.getId());
			hashMap.put("name", menuUtil.getTitle());
			hashMap.put("children", menuUtil.getChildren());
			arrayList.add(hashMap);
		}*/
		List<MenuUtil> seletMenuList = spsMenuMapper.seletMenuList();
		
		return seletMenuList;
	}
		private List<MenuUtil> getSub(Integer id,List<Integer> roleList){
		SpsMenuExample example2 = new SpsMenuExample();
		example2.createCriteria()
								.andMenuParentidEqualTo(id)
								.andMenuStateEqualTo(0)
								.andRoleIdIn(roleList);
		List<SpsMenu> selectByExample2 = spsMenuMapper.selectByExample(example2);
		MenuUtil menuUtil= null;
		List<MenuUtil> list2 = new ArrayList<MenuUtil>();
		for (SpsMenu spsMenu : selectByExample2) {
			menuUtil = new MenuUtil();
			menuUtil.setId(spsMenu.getMenuId());
			menuUtil.setTitle(spsMenu.getMenuName());
			menuUtil.setMenuParentid(spsMenu.getMenuParentid());
			menuUtil.setMenuNodetype(spsMenu.getMenuNodetype());
			menuUtil.setHref(spsMenu.getMenuUrl());
			menuUtil.setChildren(null);
			list2.add(menuUtil);
		}
		return list2;
	}
}
