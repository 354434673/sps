package org.sps.util;

import java.util.Random;

/**
 * 各类生成规则
 * @ClassName:  RuleUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月8日 下午5:11:18
 */
public class RuleUtil {
	/*
	 * 获得纯数字
	 */
	public static String getNumRandom(int n){
		char[] randChar = "1234567890".toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(randChar[new Random().nextInt(randChar.length)]);
		}
		return sb.toString();
	}
	/*
	 * 纯字母
	 */
	public static String getLetterRandom(int n){
		char[] randChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(randChar[new Random().nextInt(randChar.length)]);
		}
		return sb.toString();
	}
	/*
	 * 字母数字
	 */
	public static String getRandom(int n){
		char[] randChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(randChar[new Random().nextInt(randChar.length)]);
		}
		return sb.toString();
	}
}
