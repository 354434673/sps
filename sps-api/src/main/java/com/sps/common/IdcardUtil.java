package com.sps.common;

public class IdcardUtil {
	
	public static String  getSex(String idCard){
		
		String sex = idCard.substring(16, 17);
		
		if(Integer.parseInt(sex)%2==0){
			sex = "女";
		}else{
			sex = "男";
			
		}
		return sex;
	}
}
