package com.sps.service.user;

import com.sps.entity.user.SpsUser;

import java.util.HashMap;

public interface UserService {
	
	public HashMap<String, Object> userLogin(String userName, String password);
	
	public HashMap<String, Object> insertUser(String phone, String password, String clientNum);
	public SpsUser findUserByUserName(String userName);

}	
