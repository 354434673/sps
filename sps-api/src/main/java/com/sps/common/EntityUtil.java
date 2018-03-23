package com.sps.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class EntityUtil {
	
	protected static Logger logger = LoggerFactory.getLogger(EntityUtil.class);
	
	public static Object buildEntity(String jsonString, Class<?> targetClass) throws Exception {
		
		if(StringUtil.isEmpty(jsonString)) {
			logger.error(new StringBuilder().append("param is empty, please check.").toString());
			return null;
		}
		
		JSONObject reqParams = JSON.parseObject(jsonString);
		Object result = targetClass.newInstance();
		for (String key : reqParams.keySet()) {
			String me = key.substring(0, 1).toUpperCase()+key.substring(1);
			if(!isMemberExist(me, targetClass))
				continue;
            Method m1 = targetClass.getMethod("set"+me,String.class);
            m1.invoke(result, reqParams.get(key));
		}
		
		return result;
	}
	
	private static boolean isMemberExist(String name, Class<?> targetClass) {
		String attr = name.substring(0, 1).toLowerCase() + name.substring(1);
		Field[] members = targetClass.getDeclaredFields();
		for(Field f : members) {
			if(attr.equals(f.getName()))
				return true;
		}
		return false;
	}
}
