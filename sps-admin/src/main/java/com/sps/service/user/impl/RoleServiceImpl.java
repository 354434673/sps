package com.sps.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.user.SpsRoleMapper;
import com.sps.entity.user.SpsRole;
import com.sps.entity.user.SpsRoleExample;
import com.sps.service.user.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private SpsRoleMapper spsRoleMapper;
	@Override
	public List<SpsRole> getRoleList() {
		SpsRoleExample example = new SpsRoleExample();
		
		List<SpsRole> selectByExample = spsRoleMapper.selectByExample(example);
		
		return selectByExample.size() != 0 ? selectByExample : null;
	}

}
