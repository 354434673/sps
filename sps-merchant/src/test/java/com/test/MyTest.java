package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBusiness;

import com.alibaba.fastjson.JSON;
import com.mysql.fabric.xmlrpc.base.Array;
import com.sps.dao.merchant.read.SpsChannelBusinessReadMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")
public class MyTest {
	@Resource
	private SpsChannelBusinessReadMapper mapper;
	@Resource
	private SpsChannelBankWriteMapper bankwrite1;
	@Test
	public void test1(){

		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.add("86");
		arrayList.add("82");
		List<SpsChannelBusiness> queryBusinessForApi = mapper.queryBusinessForApi(arrayList,0);

		System.out.println(JSON.toJSONString(queryBusinessForApi));
	}
	@Test
	public void test2(){
		SpsChannelBank bank = new SpsChannelBank();
		bank.setAvailableBalance(new BigDecimal(20));
		bank.setUserId("1386c950-be2a-4633-aecc-20f1cf6c3887");
		bankwrite1.updateBank( bank);

	}
}
