package com.sps.service.user.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sps.common.Md5Util;
import com.sps.common.Message;
import com.sps.dao.SpsUserDao;
import com.sps.dao.shopkeeper.SpsShopkeeperAccountDao;
import com.sps.entity.shopkeeper.SpsShopkeeperAccount;
import com.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;
import com.sps.service.user.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private SpsUserDao dao;
	@Resource
	private SpsShopkeeperAccountDao accountDao;
	@Override
	public HashMap<String, Object> userLogin(String userName, String password) {
		HashMap<String, Object> result = null;
		
		SpsUser user = getUser(userName);
		
		if(user == null){
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
				HashMap<String, Object> data = new HashMap<String, Object>();
				
				data.put("customerid", selectByExample.get(0).getShopkeeperCustomerid());
				
				result = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG,
						Message.SUCCESS_MSG, 1, data);
			}
		}else{
			result = Message.resultMap(Message.FAILURE_CODE, Message.FAILURE_CODE,
					Message.FAILURE_MSG, 0, null);
		}
	return result;
	}
	@Transactional(readOnly=false, rollbackFor=java.lang.Exception.class)
	public SpsUser getUser(String userName){
		SpsUserExample example = new SpsUserExample();

		Criteria createCriteria = example.createCriteria();

		createCriteria.andUserUsernameEqualTo(userName);

		List<SpsUser> selectByExample = dao.selectByExample(example);

		return selectByExample.size() != 0 ? selectByExample.get(0) : null;
	}
	@Override
	public HashMap<String, Object> insertUser(String phone, String password, String clientNum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SpsUser findUserByUserName(String userName) {
		SpsUserExample example = new SpsUserExample();

		Criteria createCriteria = example.createCriteria();

		createCriteria.andUserUsernameEqualTo(userName);

		List<SpsUser> selectByExample = dao.selectByExample(example);

		return selectByExample.size() != 0 ? selectByExample.get(0) : null;
	}
}
