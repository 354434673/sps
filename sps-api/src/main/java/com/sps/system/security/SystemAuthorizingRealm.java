package com.sps.system.security;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sps.entity.user.SpsUser;


public class SystemAuthorizingRealm extends AuthorizingRealm {

	private Logger logger = LoggerFactory.getLogger(getClass());


	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		try {
			//获取令牌  
			UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
			SpsUser u = token.getUser();

			//二次验证，验证位置可挪动
			if(u != null){

				this.setSession("currentUser", u);
				//String pwd = CustomCredentialsMatcher.string2MD5(member.getPassword());
				String pwd = u.getUserPassword();

				//值得注意的是SimpleAuthenticationInfo中的password要与token的password要一致
				//否则就是密码错误！
				//在login一步一步下去中会发现，登录的过程就是在realm放回的SimpleAuthenticationInfo与token信息验证的过程！
				//SimpleAuthenticationInfo的pwd不能传入，token.getPassword()
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(u, pwd.toCharArray(), getName());
				return authcInfo;
			}else{
				logger.info("账号或密码错误");
				throw new org.apache.shiro.authz.UnauthenticatedException("账号或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		try {
			SpsUser u = (SpsUser)super.getAvailablePrincipal(principals);
			if(u == null){
				logger.info("用户不存在");
				throw new Exception("用户不存在");
			}

			SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();

			return simpleAuthorInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	private void setSession(Object key, Object value){
		Session session = getSession();
		if(session != null){
			logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
			session.setAttribute(key, value);
		}
	}


	private Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			logger.info("获取session出错");
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public void checkPermission(PrincipalCollection subjectIdentifier, String permission) throws AuthorizationException {
		org.apache.shiro.authz.Permission p = getPermissionResolver().resolvePermission(permission);
		checkPermission(subjectIdentifier, p);
	}

	@Override
	public void checkPermission(PrincipalCollection principal, org.apache.shiro.authz.Permission permission) throws AuthorizationException {
		AuthorizationInfo info = getAuthorizationInfo(principal);
		checkPermission(permission, info);
	}

	@Override
	protected void checkPermission(org.apache.shiro.authz.Permission permission, AuthorizationInfo info) {
		if (!isPermitted(permission, info)) {
			String msg = "User is not permitted [" + permission + "]";
			throw new UnauthorizedException(msg);
		}
	}

	private boolean isPermitted(org.apache.shiro.authz.Permission permission, AuthorizationInfo info) {
		return false;
	}

	@Override
	public void checkPermissions(PrincipalCollection subjectIdentifier, String... permissions) throws AuthorizationException {
		if (permissions != null) {
			for (String permString : permissions) {
				checkPermission(subjectIdentifier, permString);
			}
		}
	}

	@Override
	public void checkPermissions(PrincipalCollection principal, Collection<org.apache.shiro.authz.Permission> permissions) throws AuthorizationException {
		AuthorizationInfo info = getAuthorizationInfo(principal);
		checkPermissions(permissions, info);
	}

	@Override
	protected void checkPermissions(Collection<org.apache.shiro.authz.Permission> permissions, AuthorizationInfo info) {
		if (permissions != null && !permissions.isEmpty()) {
			for (org.apache.shiro.authz.Permission p : permissions) {
				checkPermission(p, info);
			}
		}
	}
}  