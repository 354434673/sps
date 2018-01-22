package com.sps.system.security;

import com.sps.entity.user.SpsUser;

/**
 * 令牌类
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;
	private SpsUser user;

	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, String password, SpsUser user, boolean rememberMe){
		super(username, password, rememberMe);
		this.user = user;
	}

	public UsernamePasswordToken(String username, String password, SpsUser user, String captcha, boolean rememberMe){
		super(username, password, rememberMe);
		this.user = user;
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public SpsUser getUser() {
		return user;
	}

	public void setUser(SpsUser user) {
		this.user = user;
	}

	
}