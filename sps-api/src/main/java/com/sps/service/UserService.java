package com.sps.service;

import java.util.HashMap;

import com.sps.entity.user.SpsUser;

public interface UserService {
	SpsUser getUser(String userName);
	HashMap<String, Object> insertUser(SpsUser user);
	HashMap<String, Object> updatePassword(String oldPassword, String newPassword);
	HashMap<String, Object> updateUser(SpsUser spsUser);
	HashMap<String, Object> updateUserState(String userName, Integer state);
}
