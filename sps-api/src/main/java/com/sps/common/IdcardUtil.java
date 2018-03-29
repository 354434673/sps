package com.sps.common;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public static int IdNOToAge(String IdNO){
        int leh = IdNO.length();
        String dates="";
        if (leh == 18) {
            int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year=df.format(new Date());
            int u=Integer.parseInt(year)-Integer.parseInt(dates);
            return u;
        }else{
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }

    }
}
