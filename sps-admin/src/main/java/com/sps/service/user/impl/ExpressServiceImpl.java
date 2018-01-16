package com.sps.service.user.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.express.SpsExpressMapper;
import com.sps.entity.express.SpsExpress;
import com.sps.entity.express.SpsExpressExample;
import com.sps.service.user.ExpressService;
@Service
public class ExpressServiceImpl implements ExpressService{
	@Resource
	private SpsExpressMapper express;
	@Override
	public HashMap<String, Object> getExpress(String name,Integer page, Integer limit) {
		SpsExpressExample example = new SpsExpressExample();
		
		if(!(name == null || name.equals(""))){
			example.createCriteria().andNameLike("%"+name+"%");
		}
		PageHelper.startPage(page, limit);
		List<SpsExpress> selectByExample = express.selectByExample(example);
		
		//转为pageinfo
		PageInfo pageInfo = new PageInfo(selectByExample);
		//放入map
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		
		return hashMap;
	}
	@Override
	public int insertExpress(String name) {
		SpsExpress record = new SpsExpress();
		
		record.setName(name);
		
		express.insertSelective(record);
		
		return 0;
	}
	
}
