package com.sps.util;
/**
 * 输出日志
 * @ClassName:  LogUtil   
 * @Description:用来记录日志 
 * @author YangNingSheng
 * @date 2017年12月19日 上午11:39:05
 */
public class LogUtil {
	    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("gift");

	    public static void info(Object message) {
	    	log.info(message);
	    }
	    
	    public static void info(String message) {
	        log.info(message);
	    }

	    public static void warn(String message) {
	        log.warn(message);
	    }

	    public static void error(String message) {
	        log.error(message);
	    }

	    public static void error(String message, Throwable t) {
	        log.error(message, t);
	    }
}
