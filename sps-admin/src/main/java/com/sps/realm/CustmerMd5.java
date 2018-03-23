package com.sps.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import com.sps.dao.user.SpsUserMapper;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserService;

public class CustmerMd5 extends AuthenticatingRealm{
	@Resource
	private UserService userService;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		//获取token中主身份信息
		String userName = (String) token.getPrincipal();
		
		SpsUser user = userService.getUser(userName);
		//根据主身份查询数据库
		if(userName.equals(user.getUserUsername())){
			return new SimpleAuthenticationInfo(userName, user.getUserPassword(),ByteSource.Util.bytes(user.getUserSalt()) ,this.getName());
		}
		return null;
	}

}
