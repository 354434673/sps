package com.sps.service.user;

import com.sps.entity.user.SpsUser;

import java.util.HashMap;

import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.LoginInfo;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;

public interface UserService {
	/**
	 * 店主登陆
	 * @Title: userLogin   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userName
	 * @param: @param password
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 上午10:05:37
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> userLogin(String userName, String password, Integer userId);
	/**
	 * 店主注册
	 * @Title: insertUser   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param phone
	 * @param: @param password
	 * @param: @param clientNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 上午10:05:43
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	ServiceResult<LoginInfo> insertUser(String phone, String password, String clientNum, 
					String channelNum, String salemanPhone, String channelPhone);
	/**
	 * 查询店主是否邀请
	 * @Title: queryShopInvitation   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param phone
	 * @param: @param password
	 * @param: @param clientNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月12日 上午10:06:26
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	SpsShopkeeperInvitation queryShopInvitation(String phone, String clientNum);
	
	SpsUser findUserByUserName(String userName);

}	
