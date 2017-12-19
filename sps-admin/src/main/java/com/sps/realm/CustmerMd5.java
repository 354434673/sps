package com.sps.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class CustmerMd5 extends AuthenticatingRealm{

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		//获取token中主身份信息
		String userName = (String) token.getPrincipal();
		System.out.println(userName);
		//User loginUser = userDao.loginUser(userName);
		//根据主身份查询数据库
		if(userName.equals("abc")){
			return new SimpleAuthenticationInfo("abc", "cf70eec17cb788846cb78cfa174ef5be",ByteSource.Util.bytes("111") ,this.getName());
			//return new SimpleAuthenticationInfo("abc", "123", this.getName());
		}
		return null;
	}

}
