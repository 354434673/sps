package com.sps.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.LoginInfo;
import com.sps.common.Md5Util;
import com.sps.common.Message;
import com.sps.dao.SpsUserDao;
import com.sps.dao.shopkeeper.SpsShopkeeperAccountDao;
import com.sps.dao.shopkeeper.SpsShopkeeperInvitationDao;
import com.sps.entity.shopkeeper.SpsShopkeeperAccount;
import com.sps.entity.shopkeeper.SpsShopkeeperAccountExample;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitationExample;
import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.entity.user.SpsUserExample.Criteria;
import com.sps.service.base.BaseOperate;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sps.service.user.UserService;
@Service
public class UserServiceImpl extends BaseOperate implements UserService{
	@Resource
	private SpsUserDao dao;
	@Resource
	private SpsShopkeeperAccountDao accountDao;
	@Resource
	private SpsShopkeeperInvitationDao invitationDao;
	@Resource
	private ShopkeeperService shopkeeperService;
	@Override
	public HashMap<String, Object> userLogin(String userName, String password, Integer userId) {
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
				
				data.put("userId", userId);
				
				data.put("phone", userName);
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
	public ServiceResult<LoginInfo> insertUser(String phone, String password, String clientNum, 
			String channelNum, String salemanPhone, String channelPhone) {
		ServiceResult<LoginInfo> serviceResult = new ServiceResult<LoginInfo>();

		try {
			SpsUser u = getUser(phone);
			
			if(u == null){
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
				/*
				 * 添加user表
				 */
				dao.insertSelective(user);
				
				SpsShopkeeperAccount record = new SpsShopkeeperAccount();
				
				record.setAccountNum(phone);
				
				record.setAccountState(0);
				
				record.setShopkeeperCustomerid(clientNum);
				/*
				 * 添加店主账户表
				 */
				accountDao.insertSelective(record );
				/*
				 * 注册成功后将状态改为已接收(状态码为1)
				 */
				shopkeeperService.updateShopkeeperInvitationState("1", phone);
				/*
				 * 注册成功后将状态改为待激活(状态码为2)
				 */
				shopkeeperService.updateShopkeeperState(2, clientNum);
				
				super.logger.info("手机号为:"+phone+"的用户注册成功");
			}else{
				serviceResult.setMessage("该用户已注册");
				
				serviceResult.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			serviceResult.setMessage("平台端注册失败");
			
			serviceResult.setSuccess(false);
		}
		
		return serviceResult;
	}
	@Override
	public SpsShopkeeperInvitation queryShopInvitation(String phone, String clientNum) {
		
		SpsShopkeeperInvitationExample example = new SpsShopkeeperInvitationExample();
		
		example.createCriteria().andInvitationPhoneEqualTo(phone);
		
		List<SpsShopkeeperInvitation> selectByExample = invitationDao.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample.get(0);
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
