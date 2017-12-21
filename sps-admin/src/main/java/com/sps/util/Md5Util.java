package com.sps.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {
	/**
	 * @Title: getMd5   
	 * @Description: md5加密,散列1024次
	 * @param: @param password 密码		
	 * @param: @param salt 盐
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月13日 下午2:24:49
	 * @return: String      
	 * @throws
	 */
	public static String getMd5(String password, String salt){
		/*
		 * 散列1024次
		 */
		Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
		
		return md5Hash.toString();
	}
}
