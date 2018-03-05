package com.test;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sps.dao.ChannelBusinessDao;
import com.sps.dao.ChannelEnterpriseDao;
import com.sps.dao.SpsShopkeeperAccountDao;
import com.sps.entity.merchant.SpsChannelBusiness;
import com.sps.entity.shopkeeper.SpsShopkeeperAccount;
import com.sps.entity.user.SpsUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class MyTest {
	@Resource
	private SpsShopkeeperAccountDao dao;
	@Resource
	private ChannelEnterpriseDao aaa;
	@Test
	public void test(){
		
		List<String> businessProduct = new ArrayList<String>();
		List<SpsChannelBusiness> queryBusinessForApi = aaa.queryBusinessForApi(businessProduct , null);
		System.out.println(JSON.toJSONString(queryBusinessForApi));
=======
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class MyTest {
	
	@Test
	public void test1(){

>>>>>>> refs/remotes/origin/backups
	}
}
