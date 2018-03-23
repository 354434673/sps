package com.sps.system.security.matcher;

import com.sps.entity.user.SpsUser;
import com.sps.system.security.UsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;

public class HashedCredentialsMatcher extends org.apache.shiro.authc.credential.HashedCredentialsMatcher{

	/**
	 * 改变加密匹配MD5到DES
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//        Object tokenHashedCredentials = hashProvidedCredentials(token, info);
		//        Object accountCredentials = getCredentials(info);

		SpsUser memberToken = ((UsernamePasswordToken)token).getUser();

		PrincipalCollection principalCollection = info.getPrincipals();
		if (!principalCollection.isEmpty()){
			SpsUser memberInfo = (SpsUser) principalCollection.getPrimaryPrincipal();
			if (memberInfo.getUserPassword().equals(memberToken.getUserPassword()))
				return true;
		}
		return false;
		//return equals(tokenHashedCredentials, accountCredentials);
	}

}
