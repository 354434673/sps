package com.sps.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.user.SpsUserMapper;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;
import com.sps.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private SpsUserMapper spsUserMapper;
	/**
	 * 获得用户
	 * @Title: getUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月23日 上午11:59:27
	 * @return: SpsUser      
	 * @throws
	 */
	public SpsUser getUser(String userName){
		SpsUserExample example = new SpsUserExample();
		
		Criteria createCriteria = example.createCriteria();
		
		createCriteria.andUserUsernameEqualTo(userName);
		
		List<SpsUser> selectByExample = spsUserMapper.selectByExample(example);
	
		return selectByExample.size() != 0 ? selectByExample.get(0) : null;
	}
}
