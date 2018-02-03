package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.sps.util.ExcelUtil;

public class MyTest {
	
	@Test
	public void test1(){
		String columnNames[] = {"店主名称*","联系电话*"};
		 String keys[] = {"name","phone"};//map中的key
		try {
			ExcelUtil.createWorkBook(keys, columnNames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		try {
			ExcelUtil excelUtil = new ExcelUtil();
			
			InputStream is = new FileInputStream(new File("c:\\sps\\test.xls"));  
			
			List<ArrayList<String>> poiReadXExcel = excelUtil.poiReadXExcel(is);
			
			System.out.println(JSON.toJSONString(poiReadXExcel));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
