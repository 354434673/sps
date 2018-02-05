package com.sps.service.log.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.log.SpsLogMapper;
import com.sps.entity.log.SpsLog;
import com.sps.service.log.LogService;
@Service
public class LogServiceImpl implements LogService {
	@Resource
	private SpsLogMapper logMapper;
	@Override
	public void insertLog(SpsLog log) {
		logMapper.insertSelective(log);
	}
}
