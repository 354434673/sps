package com.sps.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Md5Util;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.SpsShopkeeperAccountDao;
import com.sps.dao.SpsUserDao;
import com.sps.entity.shopkeeper.SpsShopkeeperAccount;
import com.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;
import com.sps.service.base.BaseOperate;


@RestController
public class UserServiceImpl extends BaseOperate{
	@Resource
	private SpsUserDao dao;
	@Resource
	private SpsShopkeeperAccountDao accountDao;
	/**
	 * 用户登录
	 * @Title: userLogin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param password
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月12日 下午2:57:58
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value="/api/login", method=RequestMethod.POST)
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
	public HashMap<String, Object> userLogin(@RequestBody String data){
		
		JSONObject parseObject = JSON.parseObject(data);
		
		HashMap<String, Object> result = null;
		if(!StringUtil.isEmpty(data)){
			
			String userName = parseObject.getString("userName");
			
			String password = parseObject.getString("password");
			
			SpsUser user = getUser(userName);
			
			if(userName == null){
				result = Message.resultMap(Message.USERNOT_REGIST_CODE, Message.USERNOT_REGIST_MSG,
						Message.USERNOT_REGIST_MSG, 0, null);
			}else if(Md5Util.getMd5(password, user.getUserSalt()).equals(user.getUserPassword())){
				//查询通过后,获取店主账户信息
				SpsShopkeeperAccountExample example = new SpsShopkeeperAccountExample();
				
				example.createCriteria().andAccountNumEqualTo(userName);
				
				List<SpsShopkeeperAccount> selectByExample = accountDao.selectByExample(example);
				
				if(selectByExample.size() == 0){
					result = Message.resultMap(Message.USERNOT_REGIST_CODE, Message.USERNOT_REGIST_MSG,
							Message.USERNOT_REGIST_MSG, 0, null);
				}else{
					result = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG,
							Message.SUCCESS_MSG, 1, selectByExample.get(0).getShopkeeperCustomerid());
				}
			}else{
				result = Message.resultMap(Message.FAILURE_CODE, Message.FAILURE_CODE,
						Message.FAILURE_MSG, 0, null);
			}
		}else{
			result = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG, 
					Message.FAILURE_MSG,null, null);
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
	public HashMap<String, Object> insertUser(@RequestBody String data) {
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(data)){
			
			JSONObject parseObject = JSON.parseObject(data);
			
			String phone = parseObject.getString("phone");
			
			String password = parseObject.getString("password");
			
			try {
				String salt = Md5Util.getSalt(4);//4位盐
				
				SpsUser user = new SpsUser();
				
				user.setUserUsername(phone);
				
				user.setUserSalt(salt);
				
				user.setUserPassword(Md5Util.getMd5(password, salt));
				
				user.setUserPhone(phone);
				
				user.setUserState(0);
				
				user.setUserMark(2);
				
				user.setUserCreattime(new Date());
				
				user.setUserUpdatetime(new Date());
				
				super.logger.info("手机号为:"+phone+"的用户注册成功");
				
				dao.insertSelective(user);
				
				hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG, 
						Message.SUCCESS_MSG,null, null);
			} catch (Exception e) {
				
				super.logger.info("手机号为:"+phone+"的用户注册失败,原因:Exception");
				
				hashMap = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG, 
						Message.FAILURE_MSG,null, null);
			}
		}else{
			super.logger.info("注册失败,失败原因:参数异常");
			hashMap = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG, 
					Message.FAILURE_MSG,null, null);
		}
		return hashMap;
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
