package com.sps.system.security.filter;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception  {

        Subject subject = getSubject(request, response);
        try {
            subject.logout();
        } catch (SessionException ise) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
        }

        // 跳转到登出界面
        // ShiroHttpServletResponse shiroResponse = (ShiroHttpServletResponse)response;
        // String logoutUrl = "http://www.baidu.com";
        // shiroResponse.sendRedirect(logoutUrl);

        return true;
    }

}
