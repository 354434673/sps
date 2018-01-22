package com.sps.common;

import com.alibaba.fastjson.JSONObject;

public class Message {

	//请求成功
	public static String SUCCESS_CODE = "1";
	public static String SUCCESS_MSG = "success";

	//请求失败
	public static String FAILURE_CODE = "0";
	public static String FAILURE_MSG = "failure";

	//系统错误
	public static String SYSTEM_ERROR_CODE = "-1";
	public static String SYSTEM_ERROR_MSG = "system error";

	//无权限
	public static String UNAUTHORIZED_CODE = "403";
	public static String UNAUTHORIZED_MSG = "unauthorized request";

	//发生错误，code为1000，msg自定义
	public static String DIY_CODE = "1000";

	//未登录
	public static String UNAUTHENTICATED_CODE = "1001";
	public static String UNAUTHENTICATED_MSG = "not login";

	//账号被锁定
	public static String ACCOUNT_LOCK_CODE = "1002";
	public static String ACCOUNT_LOCK_MSG = "account is locked";

	//参数为空
	public static String PARAM_NONE_CODE = "1003";
	public static String PARAM_NONE_MSG = "param is null";

	//参数不合法
	public static String PARAM_ILLEGAL_CODE = "1004";
	public static String PARAM_ILLEGAL_MSG = "param is illegal";
	//设备不存在
	public static String DEV_NOTEXIST_CODE = "2001";
	public static String DEV_NOTEXIST_MSG = "dev not exist";
	//设备已经存在
	public static String DEV_YETEXIST_CODE = "2002";
	public static String DEV_YETEXIST_MSG = "dev already existed";
	
	//设备未上报数据
	public static String DEV_NOT_REPORTING_CODE = "2005";
	public static String DEV_NOT_REPORTING_MSG = "dev is not reporting data";
	
	//域已存在
	public static String DOMAIN_YETEXIST_CODE = "2003";
	public static String DOMAIN_YETEXIST_MSG = "domain already existed";
	//域不存在
	public static String DOMAIN_NOTEXIST_CODE = "2004";
	public static String DOMAIN_NOTEXIST_MSG = "domain not exist";
	
	//电价时间段非法
	public static String RULES_ILLEGAL_CODE = "3001";
	public static String RULES_ILLEGAL_MSG = "price rules illegal";
	//域默认电价不存在
	public static String DOMAIN_NODEFAULT_CODE = "3002";
	public static String DOMAIN_NODEFAULT_MSG= "domain has no default price rules";
	
	//参数类型不合法 比如abc的转成123
	public static String PARAM_TYPE_CODE = "1005";
	public static String PARAM_TYPE_MSG = "param type error";

	//参数格式不合法 不是json
	public static String PARAM_FORMAT_CODE = "1006";
	public static String PARAM_FORMAT_MSG = "param format error";
	//用户没有绑定域
	public static String USERNOT_BINDDOMAIN_CODE = "1007";
	public static String USERNOT_BINDDOMAIN_MSG = "the user not bind domain";
	//用户没注册
	public static String USERNOT_REGIST_CODE = "1008";
	public static String USERNOT_REGIST_MSG = "the user not regist";

	public static String responseStr(String code, String msg){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("msg", msg);
		return jsonObject.toJSONString();
	}

	public static String responseStr(String code, String msg, String key, Object result){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("msg", msg);
		jsonObject.put(key, result);
		return jsonObject.toJSONString();
	}


	public static String responseSystemError(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", SYSTEM_ERROR_CODE);
		jsonObject.put("msg", SYSTEM_ERROR_MSG);
		return jsonObject.toJSONString();
	}
}
