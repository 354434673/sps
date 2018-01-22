package com.sps.system.security.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyFilter extends AuthorizationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    protected boolean isAccessAllowed(ServletRequest arg1, ServletResponse arg2, Object mappedValue) throws IOException {
        String[] ms = (String[]) mappedValue;
        logger.info("mappedValue value is:"+ms);
        Subject subject = getSubject(arg1, arg2);
        Object object = subject.getPrincipal();
//        return object != null && subject.isAuthenticated();
        return true;
        //false 进入onAccessDenied
    }

    @Override
    protected boolean onAccessDenied(ServletRequest arg1, ServletResponse arg2) throws IOException {
        saveRequest(arg1);

        HttpServletResponse response = (HttpServletResponse) arg2;

        PrintWriter print = response.getWriter();
        print.write("{\"msg\":\"not login\",\"code\":\"1001\"}");
        print.flush();
        print.close();

        return false;
    }


}
