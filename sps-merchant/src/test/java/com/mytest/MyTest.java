package com.mytest;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sps.entity.shopkeeper.SpsShopkeeper;

import com.alibaba.fastjson.JSON;
import com.sps.dao.shopkeeper.read.SpsShopkeeperReadMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class MyTest {
	@Resource
	private SpsShopkeeperReadMapper read;
	@Test
	public void test1(){
		List<SpsShopkeeper> selectListForJoin = read.selectListForJoin("44", null, null);
		
		System.out.println(JSON.toJSONString(selectListForJoin));
	}
}
