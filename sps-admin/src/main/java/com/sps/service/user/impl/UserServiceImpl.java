package com.sps.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.user.SpsUserMapper;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;
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
	public HashMap<String, Object> userList(Integer page, Integer limit, 
			String username, String name) {
		SpsUserExample example = new SpsUserExample();
		
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserStateEqualTo(0);
		//如果查询条件不为空,则进入模糊查询
		if(username != null){
			createCriteria.andUserUsernameLike("%"+username+"%");
		}else if(name != null){
			createCriteria.andUserUsernameLike("%"+name+"%");
		}
		//分页
		PageHelper.startPage(page,limit);
		
		List<SpsUser> selectByExample = spsUserMapper.selectByExample(example);
		//转为pageinfo
		PageInfo pageInfo = new PageInfo(selectByExample);
		//放入map
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		
		return hashMap;
	}
	@Override
	public HashMap<String, Object> insertUser(String...strs) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsUser user = getUser(strs[0]);//查重
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
				spsUser.setUserMark(Integer.parseInt(strs[5]));
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
		} catch (NumberFormatException e) {
			map.put("msg", "程序错误");
			map.put("state", "error");
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public HashMap<String, Object> updatePassword(String oldPassword, String newPassword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//获取当前token中的用户
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		
		SpsUser user = getUser(userName);
		
		String salt = Md5Util.getSalt(4);//4位盐
		if(oldPassword==null||newPassword==null){//如果为空则重置密码
			user.setUserPassword(Md5Util.getMd5("123456", salt));
			
			user.setUserSalt(salt);
			
			user.setUserUpdatetime(new Date());
			
			spsUserMapper.updateByPrimaryKeySelective(user);
			
			map.put("msg", "密码重置成功");
			map.put("icon", "1");
			map.put("state", "reset");
		}else{//有数据则修改密码
			String userPassword = user.getUserPassword();
			
			String md5Password = Md5Util.getMd5(oldPassword, user.getUserSalt());
			
			if(userPassword.equals(md5Password)){
				
				user.setUserPassword(Md5Util.getMd5(newPassword, salt));
				
				user.setUserSalt(salt);
				
				user.setUserUpdatetime(new Date());
				
				spsUserMapper.updateByPrimaryKeySelective(user);
				
				map.put("msg", "修改成功");
				map.put("icon", "1");
				map.put("state", "success");
			}else{
				map.put("msg", "原始密码错误");
				map.put("icon", "2");
				map.put("state", "error");
			}
		}
		return map;
	}
}
