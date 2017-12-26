package com.sps.service.user.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.user.SpsUserandroleMapper;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserandrole;
import com.sps.entity.user.SpsUserandroleExample;
import com.sps.entity.user.SpsUserandroleExample.Criteria;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;
@Service
public class UserAndRoleServiceImpl implements UserAndRoleService{
	@Resource
	private SpsUserandroleMapper userandroleMapper;
	@Resource
	private UserService userService;
	@Override
	public int insertUserAndRole(String userName, int[] roleList) {
		
		SpsUser user = userService.getUser(userName);
		for (int roleId : roleList) {
			SpsUserandrole userAndrole = 
					getUserAndrole(user.getUserId(), roleId);
			if(userAndrole == null){
				SpsUserandrole spsUserandrole = new SpsUserandrole();
				spsUserandrole.setUserId(user.getUserId());
				spsUserandrole.setRoleId(roleId);
				spsUserandrole.setCreatTime(new Date());
				spsUserandrole.setUpdateTime(new Date());
				spsUserandrole.setState(0);
				userandroleMapper.insert(spsUserandrole);
			}
		}
		return 1;
	}
	@Override
	public SpsUserandrole getUserAndrole(int userId, int roleId) {
		
		SpsUserandroleExample example = new SpsUserandroleExample();
		
		Criteria createCriteria = example.createCriteria();
		
		createCriteria.andUserIdEqualTo(userId)
					  .andRoleIdEqualTo(roleId);
		List<SpsUserandrole> selectByExample = userandroleMapper.selectByExample(example);
		
		return selectByExample.size() != 0 ? selectByExample.get(0) : null;
	}

}
