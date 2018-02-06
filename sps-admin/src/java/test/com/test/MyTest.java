package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jboss.netty.handler.codec.http.HttpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.sps.dao.user.SpsRoleMapper;
import com.sps.entity.user.SpsRole;
import com.sps.util.ExcelUtil;
import com.sps.util.Md5Util;
import com.sun.media.sound.InvalidFormatException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mybatis.xml")  
public class MyTest {
	@Resource
	private SpsRoleMapper mapper;
	
	@Test
	public void test1() {
		List<SpsRole> selectRoleForUserId = mapper.selectRoleForUserId(1);
		System.out.println(JSON.toJSONString(selectRoleForUserId));
	}
}
