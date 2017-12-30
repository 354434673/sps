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
		List<Integer> roldId = new ArrayList<Integer>();
		
		roldId.add(3);
		List<MenuUtil> seletMenuList = spsMenuMapper.seletMenuList(roldId);
		
		return seletMenuList;
	}
	@Override
	public List<HashMap<String, Object>> getSpecificMenu() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		List<Integer> roldId = new ArrayList<Integer>();
		
		roldId.add(1);
		roldId.add(2);
		List<MenuUtil> seletMenuList = spsMenuMapper.seletMenuList(roldId);
		
		ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
		for (MenuUtil menuUtil : seletMenuList) {
			hashMap.put("id", menuUtil.getId());
			hashMap.put("name", menuUtil.getTitle());
			hashMap.put("children", menuUtil.getChildren());
			arrayList.add(hashMap);
		}
		return arrayList;
	}
}
