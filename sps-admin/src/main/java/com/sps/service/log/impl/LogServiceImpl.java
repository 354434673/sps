package com.sps.service.log.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.log.SpsLogMapper;
import com.sps.entity.log.SpsLog;
import com.sps.entity.log.SpsLogExample;
import com.sps.service.log.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Resource
	private SpsLogMapper logMapper;

	@Override
	public void insertLog(SpsLog log) {
		logMapper.insertSelective(log);
	}

	@Override
	public List<SpsLog> getLogByUser(String userName, String logType) {
		SpsLogExample example = new SpsLogExample();
		com.sps.entity.log.SpsLogExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andLogNameEqualTo(userName);
		createCriteria.andLogTypeEqualTo(logType);

		List<SpsLog> list = logMapper.selectByExample(example);
		return list;
	}
}
