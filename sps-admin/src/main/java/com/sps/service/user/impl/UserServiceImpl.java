package com.sps.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sps.dao.user.SpsRoleMapper;
import com.sps.dao.user.SpsUserMapper;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;
import com.sps.util.Md5Util;

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
	@Override
	public List<SpsUser> userList() {
		SpsUserExample example = new SpsUserExample();
		
		Criteria createCriteria = example.createCriteria();
		
		List<SpsUser> selectByExample = spsUserMapper.selectByExample(example);
		
		return selectByExample.size() != 0 ? selectByExample : null;
	}
	@Override
	public HashMap<String, Object> insertUser(String...strs) {
		SpsUser user = getUser(strs[0]);//查重
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(user == null){
			String salt = Md5Util.getSalt(4);//4位盐
			SpsUser spsUser = new SpsUser();
			spsUser.setUserUsername(strs[0]);
			spsUser.setUserSalt(salt);
			spsUser.setUserPassword(Md5Util.getMd5(strs[1], salt));
			spsUser.setUserName(strs[2]);
			spsUser.setUserPhone(strs[3]);
			spsUser.setUserEmail(strs[4]);
			spsUser.setUserState(0);
			spsUser.setUserMark(1);
			spsUser.setUserCreattime(new Date());
			spsUser.setUserUpdatetime(new Date());
			int insertSelective = spsUserMapper.insertSelective(spsUser);
			if(insertSelective == 1){
				map.put("msg", "添加成功");
				map.put("state", "success");
			}else{
				map.put("msg", "添加失败,联系管理员");
				map.put("state", "error");
			}
		}else{
			map.put("msg", "用户重复");
			map.put("state", "exist");
		}
		return map;
	}
}
