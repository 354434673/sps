package com.sps.service.user;

import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.LoginInfo;
import com.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import com.sps.entity.user.SpsUser;

import java.util.HashMap;

public interface UserService {
	
	public HashMap<String, Object> userLogin(String userName, String password);

	public ServiceResult<LoginInfo> insertUser(String phone, String password, String clientNum);
	public SpsUser findUserByUserName(String userName);
	SpsShopkeeperInvitation queryShopInvitation(String phone, String clientNum);

}	
