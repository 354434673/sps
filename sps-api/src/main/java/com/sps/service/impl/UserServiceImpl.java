package com.sps.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sps.common.Md5Util;
import com.sps.common.Message;
import com.sps.dao.SpsUserDao;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;


@RestController
public class UserServiceImpl {
	@Resource
	private SpsUserDao dao;

	@RequestMapping(value="/api/login", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
	public HashMap<String, Object> userLogin(String userName, String password){
		
		SpsUser user = getUser(userName);
		
		HashMap<String, Object> result = new HashMap<String, Object>();
		if(userName == null){
			result.put("msg", Message.USERNOT_REGIST_MSG);
			result.put("state", Message.USERNOT_REGIST_CODE);
		}else if(Md5Util.getMd5(password, user.getUserSalt()).equals(user.getUserPassword())){
			//查询通过后,获取店主商户信息
			result.put("msg", Message.SUCCESS_CODE);
			result.put("state", Message.SUCCESS_MSG);
		}else{
			result.put("msg", Message.FAILURE_CODE);
			result.put("state", Message.FAILURE_MSG);
		}
		return result;
	}
	@RequestMapping(value="/api/getUser", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
	public SpsUser getUser(String userName){
		SpsUserExample example = new SpsUserExample();

		Criteria createCriteria = example.createCriteria();

		createCriteria.andUserUsernameEqualTo(userName);

		List<SpsUser> selectByExample = dao.selectByExample(example);

		return selectByExample.size() != 0 ? selectByExample.get(0) : null;
	}
	@RequestMapping(value="/api/add", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
	public HashMap<String, Object> insertUser(SpsUser user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsUser spsUser = getUser(user.getUserUsername());//查重
			if(spsUser == null){
				String salt = Md5Util.getSalt(4);//4位盐

				user.setUserSalt(salt);

				user.setUserPassword(Md5Util.getMd5(user.getUserPassword(), salt));

				user.setUserState(0);

				user.setUserCreattime(new Date());

				user.setUserUpdatetime(new Date());
				int insertSelective = dao.insertSelective(user);
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


	@RequestMapping(value="/api/uptPwd", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
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

			dao.updateByPrimaryKeySelective(user);

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

				dao.updateByPrimaryKeySelective(user);

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
	

	@RequestMapping(value="/api/uptUser", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
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

			dao.updateByExampleSelective(record, example);

			map.put("msg", "用户信息修改成功");
			map.put("icon", "1");
			map.put("state", "success");
		} catch (Exception e) {
			map.put("msg", "用户信息修改失败");
			map.put("icon", "2");
			map.put("state", "error");
			e.printStackTrace();
		}
		return map;
	}
	

	@RequestMapping(value="/api/uptUserState", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
	public HashMap<String, Object> updateUserState(String userName, Integer state) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			SpsUser record = new SpsUser();
			record.setUserState(state);
			SpsUserExample example = new SpsUserExample();
			example.createCriteria().andUserUsernameEqualTo(userName);
			dao.updateByExampleSelective(record, example);
			map.put("msg", "用户删除成功");
			map.put("icon", "1");
			map.put("state", "success");
		} catch (Exception e) {
			map.put("msg", "用户删除失败");
			map.put("icon", "2");
			map.put("state", "error");
			e.printStackTrace();
		}
		return map;
	}

}
