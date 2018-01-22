package com.sps.common;

import java.util.Random;

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
	/**
	 * 
	 * @Title: getSalt   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param n位数
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2017年12月27日 下午2:30:14
	 * @return: String      
	 * @throws
	 */
	public static String getSalt(int n){
		char[] randChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(randChar[new Random().nextInt(randChar.length)]);
		}
		return sb.toString();
	}
}
