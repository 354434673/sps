package com.sps.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.areas.AreasMapper;
import com.sps.entity.areas.Areas;
import com.sps.entity.areas.AreasExample;
import com.sps.service.user.AreasService;
@Service
public class AreasServiceImpl implements AreasService{
	@Resource
	private AreasMapper areasMapper;
	@Override
	public List<Areas> getAreasList(String parentId) {
		
		AreasExample example = new AreasExample();
		example.createCriteria()
				.andParentIdEqualTo(parentId);
		List<Areas> selectByExample = areasMapper.selectByExample(example);
		
		return selectByExample.size() == 0 ? null : selectByExample;
	}

}
