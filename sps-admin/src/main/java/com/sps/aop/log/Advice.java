package com.sps.aop.log;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sps.entity.log.SpsLog;
import com.sps.service.log.LogService;

/**
 * 
 * @ClassName:  aop切面  
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年2月5日 上午10:43:05
 */
@Component//组件
@Aspect//申明切面
public class Advice {
	@Resource
	private LogService logService;
	/*
	 * 用户登录
	 */
	@AfterReturning("execution(* com.sps.service.user.impl.UserServiceImpl.userLogin(..))")
	public void afteruserLoginLog(JoinPoint point,Object result){
/*		System.out.println("当前执行的目标类:" +proceedingJoinPoint.getTarget());
    	System.out.println("当前目标方法的签名:" +proceedingJoinPoint.getSignature().getName());*/
/*        System.out.println("@After：目标方法为：" + 
                point.getSignature().getDeclaringTypeName() + 
                "." + point.getSignature().getName());
        System.out.println(point.getSignature().getDeclaringTypeName());
        System.out.println(point.getSignature().getName());
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@After：被织入的目标对象为：" + point.getTarget());*/
        
        if(result.equals("success")){
        	SpsLog log = new SpsLog();
        	log.setLogName((String)point.getArgs()[0]);
        	log.setLogType(point.getSignature().getName());
        	log.setLogTime(new Date());
        	log.setLogRemark("用户登录");
        	logService.insertLog(log);
        }
	}
	/*
	 * 用户登出(前置通知)
	 */
	@Before("execution(String com.sps.service.user.impl.UserServiceImpl.userLogout(..))")
	public void afteruserLogoutLog(JoinPoint point){
		SpsLog log = new SpsLog();
		log.setLogName((String) SecurityUtils.getSubject().getPrincipal());
		log.setLogType(point.getSignature().getName());
		log.setLogTime(new Date());
		log.setLogRemark("用户登出");
		logService.insertLog(log);
	}
}

