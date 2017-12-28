package com.sps.service.user.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.user.SpsRoleMapper;
import com.sps.entity.user.SpsRole;
import com.sps.entity.user.SpsRoleExample;
import com.sps.entity.user.SpsRoleExample.Criteria;
import com.sps.service.user.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private SpsRoleMapper spsRoleMapper;
	@Override
	public HashMap<String, Object> getRoleList(Integer page, Integer limit, String roleName) {
		SpsRoleExample example = new SpsRoleExample();
		
		if(roleName != null){
			Criteria createCriteria = example.createCriteria();
			
			createCriteria.andRoleNameLike("%"+roleName+"%");
		}
		List<SpsRole> selectByExample = null;
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		
		PageInfo pageInfo = null;
		if(page == null || page == 0){
			selectByExample = spsRoleMapper.selectByExample(example);
		}else{
			PageHelper.startPage(page,limit);
			selectByExample = spsRoleMapper.selectByExample(example);
			pageInfo = new PageInfo(selectByExample);
		}
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count",pageInfo == null ? 0 : pageInfo.getTotal());
		hashMap.put("data", selectByExample);
		return hashMap;
		
		
	}

}
