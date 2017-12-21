package com.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import com.sps.util.Md5Util;

public class MyTest {
		
	@Test
	public void test(){
		Md5Hash md5Hash = new Md5Hash("12345678", "SALT", 1024);
		System.out.println(md5Hash.toString());
	}
}
