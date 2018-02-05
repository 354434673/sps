package com.sps.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Service;
import org.sps.util.FinalData;

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
			String username, String name,String phone,Integer mark) {
		SpsUserExample example = new SpsUserExample();
		
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserStateNotEqualTo(1)
					.andUserMarkEqualTo(mark);
		//如果查询条件不为空,则进入模糊查询
		if( !(username == null || username.equals(""))){
			createCriteria.andUserUsernameLike("%"+username+"%");
		}
		if( !(name == null || name.equals(""))){
			createCriteria.andUserNameLike("%"+name+"%");
		}
		if( !(phone == null || phone.equals(""))){
			createCriteria.andUserPhoneLike("%"+phone+"%");
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
	public HashMap<String, Object> insertUser(SpsUser user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsUser spsUser = getUser(user.getUserUsername());//查重
			if(spsUser == null){
				String salt = Md5Util.getSalt(4);//4位盐
				
				user.setUserSalt(salt);
				
				String password = null;
				
				password = user.getUserPassword() == null ? Md5Util.PASSWORD : user.getUserPassword();
				
				String Md5Password = Md5Util.getMd5(password, salt);
				
				user.setUserPassword(Md5Password);
				
				user.setUserState(0);
				
				user.setUserCreattime(new Date());
				
				user.setUserUpdatetime(new Date());
				
				int insertSelective = spsUserMapper.insertSelective(user);
				if(insertSelective == 1){
					map.put("msg", "添加成功");
					map.put("state", FinalData.STATE_SUCCESS);
				}else{
					map.put("msg", "添加失败,联系管理员");
					map.put("state", FinalData.STATE_ERROR);
				}
			}else{
				map.put("msg", "用户重复");
				map.put("state", FinalData.STATE_EXIST);
			}
		} catch (Exception e) {
			map.put("msg", "程序错误");
			map.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public HashMap<String, Object> updatePassword(String username, String oldPassword, String newPassword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		//获取当前token中的用户
		if(username == null || username.equals("")){
			String userName = (String) SecurityUtils.getSubject().getPrincipal();
		}
		
		SpsUser user = getUser(username);
		
		String salt = Md5Util.getSalt(4);//4位盐
		if(oldPassword==null||newPassword==null){//如果为空则重置密码
			user.setUserPassword(Md5Util.getMd5(Md5Util.PASSWORD, salt));
			
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
				map.put("state", FinalData.STATE_SUCCESS);
			}else{
				map.put("msg", "原始密码错误");
				map.put("icon", "2");
				map.put("state", FinalData.STATE_ERROR);
			}
		}
		return map;
	}
	@Override
	public HashMap<String, Object> updateUser(SpsUser spsUser) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsUser record = new SpsUser();
			String salt = Md5Util.getSalt(4);//4位盐
			record.setUserName(spsUser.getUserName());
			record.setUserPassword(Md5Util.getMd5(spsUser.getUserPassword(), salt));
			record.setUserPhone(record.getUserPhone());
			record.setUserUpdatetime(new Date());
			record.setUserSalt(salt);
			record.setUserEmail(spsUser.getUserEmail());
			SpsUserExample example = new SpsUserExample();
			
			example.createCriteria().andUserUsernameEqualTo(spsUser.getUserUsername());
			
			spsUserMapper.updateByExampleSelective(record, example);
			
			map.put("msg", "用户信息修改成功");
			map.put("icon", "1");
			map.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			map.put("msg", "用户信息修改失败");
			map.put("icon", "2");
			map.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public HashMap<String, Object> updateUserState(String userName, Integer state) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsUser record = new SpsUser();
			record.setUserState(state);
			SpsUserExample example = new SpsUserExample();
			example.createCriteria().andUserUsernameEqualTo(userName);
			spsUserMapper.updateByExampleSelective(record, example);
			map.put("msg", "用户删除成功");
			map.put("icon", "1");
			map.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			map.put("msg", "用户删除失败");
			map.put("icon", "2");
			map.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public String userLogin(String user, String pass, String code, boolean rememberMe) {
		UsernamePasswordToken usernamePasswordToken = 
				new UsernamePasswordToken(user, pass);
		
		usernamePasswordToken.setRememberMe(true);
		HashMap<String, String> loginData = new HashMap<String,String>();
	    try {  
	    	SecurityUtils.getSubject().login(usernamePasswordToken);
	    	
	    } catch (UnknownAccountException ex) {  
	    	ex.printStackTrace(); 
	        System.out.println("用户不存在或者密码错误！");
	        return "inexistence";
	    } catch (IncorrectCredentialsException ex) { 
	    	ex.printStackTrace(); 
	    	System.out.println("用户不存在或者密码错误！");
	    	return "inexistence";
	    } catch (AuthenticationException ex) {  
	    	ex.printStackTrace(); 
	    	System.out.println("自定义");
	    	return "inexistence";
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        System.out.println("内部错误，请重试！");
	        return "error";
	    }  
	    
		return "success";
	}
	@Override
	public String userLogout() {
		//清除令牌中的信息
		SecurityUtils.getSubject().logout();
		
		return "login";
	}
}
