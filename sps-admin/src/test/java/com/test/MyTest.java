package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;

import com.alibaba.fastjson.JSON;
import com.sps.dao.user.SpsRoleMapper;
import com.sps.entity.user.SpsRole;
import com.sps.service.user.MenuService;
import com.sps.util.MenuUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class MyTest {
	@Resource
	private MenuService s;
	@Resource
	private SpsRoleMapper m;
	@Test
	public void test1(){
		List<SpsRole> selectRoleForUserId = m.selectRoleForUserId(36);
		System.out.println(JSON.toJSONString(selectRoleForUserId));
	}
}
