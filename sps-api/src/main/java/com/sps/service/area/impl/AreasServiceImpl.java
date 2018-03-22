package com.sps.service.area.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.areas.AreasDao;
import com.sps.entity.areas.Areas;
import com.sps.entity.areas.AreasExample;
import com.sps.service.area.AreasService;
@Service
public class AreasServiceImpl implements AreasService{
	@Resource
	private AreasDao areasMapper;
	@Override
	public HashMap<String, Object> getAreasList(String parentId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Areas> selectByExample;
		try {
			AreasExample example = new AreasExample();
			example.createCriteria()
					.andParentIdEqualTo("100000");
			selectByExample = areasMapper.selectByExample(example);
			
			hashMap.put("code", 1);
			hashMap.put("msg", "获取成功");
			hashMap.put("result", selectByExample);
			hashMap.put("count", selectByExample.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			hashMap.put("code", 0);
			hashMap.put("msg", "获取失败");
			hashMap.put("result", null);
			hashMap.put("count", 0);
		}
		return hashMap;
	}
}
