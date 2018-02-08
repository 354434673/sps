package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sps.entity.merchant.SpsChannelBusiness;

import com.alibaba.fastjson.JSON;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sps.dao.merchant.read.SpsChannelBusinessReadMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class MyTest {
	@Resource
	private SpsChannelBusinessReadMapper mapper;
	@Test
	public void test1(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("86");
		arrayList.add("82");
		List<SpsChannelBusiness> queryBusinessForApi = mapper.queryBusinessForApi(arrayList,0);
		
		System.out.println(JSON.toJSONString(queryBusinessForApi));
	}
}
