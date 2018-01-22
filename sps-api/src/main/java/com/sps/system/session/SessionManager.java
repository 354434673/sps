package com.sps.system.session;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import com.sps.common.StringUtil;


/**
 * 自定义WEB会话管理类
 */
public class SessionManager extends DefaultWebSessionManager {

	public SessionManager() {
		super();
	}


	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		Serializable id = null;
		// 如果参数中包含“__sid”参数，则使用此sid会话。 例如：http://localhost/project?__sid=xxx&__cookie=true
		String sid = request.getParameter("__sid");
		if (!StringUtil.isEmpty(sid)) {
			// 是否将sid保存到cookie，浏览器模式下使用此参数。
			if (WebUtils.isTrue(request, "__cookie")){
				HttpServletRequest rq = (HttpServletRequest)request;
				HttpServletResponse rs = (HttpServletResponse)response;
				Cookie template = getSessionIdCookie();
				Cookie cookie = new SimpleCookie(template);
				cookie.setValue(sid); cookie.saveTo(rq, rs);
			}
			// 设置当前session状态
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
					ShiroHttpServletRequest.URL_SESSION_ID_SOURCE); // session来源与url
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sid);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			id = sid;
		}else{
//			HttpServletRequest req = (HttpServletRequest) request;
//			Enumeration headerNames = req.getHeaderNames();
//			while (headerNames.hasMoreElements()) {
//				String key = (String) headerNames.nextElement();
//				String value = req.getHeader(key);
//				logger.info(String.format("key：%s，value：%s", key, value));
//			}
			id = super.getSessionId(request, response);
		}
		return id;
	}

	@Override
	public void validateSessions() {
		super.validateSessions();
	}

	@Override
	protected Session newSessionInstance(SessionContext context) {
		Session session = super.newSessionInstance(context);
		session.setTimeout(getGlobalSessionTimeout());
		return session;
	}

	@Override
	public Session start(SessionContext context) {
		try{
			return super.start(context);
		}catch (NullPointerException e) {
			SimpleSession session = new SimpleSession();
			session.setId(0);
			return session;
		}
	}
}