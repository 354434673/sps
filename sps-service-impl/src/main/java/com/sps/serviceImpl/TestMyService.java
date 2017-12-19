package com.sps.serviceImpl;

import org.sps.service.TestService;

import com.alibaba.dubbo.config.annotation.Service;
@Service
public class TestMyService implements TestService{

	@Override
	public void name() {
		System.out.println("dubbo执行");
		
	}

}
