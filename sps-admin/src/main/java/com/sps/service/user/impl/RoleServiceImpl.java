package com.sps.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.user.SpsRoleMapper;
import com.sps.dao.user.SpsRoleandmenuMapper;
import com.sps.entity.user.SpsRole;
import com.sps.entity.user.SpsRoleExample;
import com.sps.entity.user.SpsRoleandmenu;
import com.sps.entity.user.SpsRoleExample.Criteria;
import com.sps.service.user.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private SpsRoleMapper spsRoleMapper;
	@Resource
	private SpsRoleandmenuMapper spsRoleandmenuMapper;

	@Override
	public HashMap<String, Object> getRoleList(Integer page, Integer limit, String roleName) {
		SpsRoleExample example = new SpsRoleExample();

		if (roleName != null) {
			Criteria createCriteria = example.createCriteria();

			createCriteria.andRoleNameLike("%" + roleName + "%");
		}
		List<SpsRole> selectByExample = null;

		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		PageInfo pageInfo = null;
		if (page == null || page == 0) {
			selectByExample = spsRoleMapper.selectByExample(example);
		} else {
			PageHelper.startPage(page, limit);
			selectByExample = spsRoleMapper.selectByExample(example);
			pageInfo = new PageInfo(selectByExample);
		}
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo == null ? 0 : pageInfo.getTotal());
		hashMap.put("data", selectByExample);
		return hashMap;

	}

	@Override
	public HashMap<String, String> insertRole(String roleName, String describe, List<Integer> menuList) {

		SpsRoleExample example = new SpsRoleExample();

		example.createCriteria().andRoleNameEqualTo(roleName);

		List<SpsRole> selectByExample = spsRoleMapper.selectByExample(example);

		HashMap<String, String> map = new HashMap<String, String>();
		
		if (selectByExample.size() ==0) {
			String creater = (String) SecurityUtils.getSubject().getPrincipal();
			SpsRole role = new SpsRole();
			role.setRoleName(roleName);
			role.setRoleDescribe(describe);
			role.setRoleCreater(creater);
			role.setRoleCreattime(new Date());
			role.setRoleUpdatetime(new Date());
			role.setRoleState(0);
			int insertSelective = spsRoleMapper.insertSelective(role);
			if (insertSelective == 1) {
				int insertRoleAndMenu = insertRoleAndMenu(role.getRoleId(), menuList);
				if (insertRoleAndMenu == 1) {
					map.put("msg", "角色添加成功");
					map.put("state", "success");
				} else {
					map.put("msg", "角色权限添加失败");
					map.put("state", "menuError");
				}
			} else {
				map.put("msg", "添加失败,联系管理员");
				map.put("state", "error");
			}
		} else {
			map.put("msg", "角色重复");
			map.put("state", "exist");
		}
		return map;
	}

	public HashMap<String, Object> getRoleByID(String roleID) {
		SpsRole role = spsRoleMapper.selectByPrimaryKey(Integer.getInteger(roleID));
		List<SpsRole> list = new ArrayList<SpsRole>();
		list.add(role);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("data", list.size() > 0 ? list : null);
		hashMap.put("count", 1);
		return hashMap;

	}

	public HashMap<String, String> deleteRole(String roleId) {
		int count = spsRoleMapper.deleteByPrimaryKey(Integer.getInteger(roleId));
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if (count > 0) {
			hashMap.put("msg", "删除成功");
			hashMap.put("state", "success");
		}else{
			hashMap.put("msg", "删除失败");
			hashMap.put("state", "error");
		}
		return hashMap;
	}

	/**
	 * 添加角色菜单关联表 @Title: insertRoleAndMenu @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param roleName @param: @param
	 * menuList @param: @return @author YangNingSheng @date 2018年1月2日
	 * 下午3:50:24 @return: int @throws
	 */
	private int insertRoleAndMenu(Integer roleId, List<Integer> menuList) {
		try {
			SpsRoleandmenu roleandmenu = new SpsRoleandmenu();

			for (int menuId : menuList) {
				roleandmenu.setRoleId(roleId);
				roleandmenu.setMenuId(menuId);
				roleandmenu.setCreatTime(new Date());
				roleandmenu.setUpdateTime(new Date());
				roleandmenu.setState(0);
				spsRoleandmenuMapper.insert(roleandmenu);
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public HashMap<String, Object> getRoleForUserId(Integer id) {
		
		List<SpsRole> selectRoleForUserId = spsRoleMapper.selectRoleForUserId(id);
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("data", selectRoleForUserId);
		return hashMap;
	}
}
