package com.sps.serviceImpl.merchant.read;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.entity.merchant.SpsChannelSalesmanExample;
import org.sps.entity.merchant.SpsChannelSalesmanExample.Criteria;
import org.sps.service.merchant.read.ChannelSalesmanReadService;
import org.sps.util.StringUtil;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.merchant.read.SpsChannelSalesmanReadMapper;

@Service(timeout=2000,group="dianfu")
@Transactional(readOnly = true)
public class ChannelSalesmanReadServiceImpl implements ChannelSalesmanReadService{
	@Resource
	private SpsChannelSalesmanReadMapper salesmanRead;
	@Override
	public HashMap<String, Object> getSalesmanList(String salesmanName, String salesmanIdcard, 
			String salesmanPhone, String salesmanEmail, String bei1, Integer page, Integer limit) {
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		try {
			SpsChannelSalesmanExample example = new SpsChannelSalesmanExample();
			
			Criteria createCriteria = example.createCriteria();
			
			if(!StringUtil.isEmpty(salesmanName)){
				createCriteria.andSalesmanNameLike("%"+salesmanName+"%");
			}
			if(!StringUtil.isEmpty(salesmanIdcard)){
				createCriteria.andSalesmanIdcardLike("%"+salesmanIdcard+"%");
			}
			if(!StringUtil.isEmpty(salesmanPhone)){
				createCriteria.andSalesmanPhoneLike("%"+salesmanPhone+"%");
			}
			if(!StringUtil.isEmpty(salesmanEmail)){
				createCriteria.andSalesmanEmailLike("%"+salesmanEmail+"%");
			}
			if(!StringUtil.isEmpty(bei1)){
				createCriteria.andBei1EqualTo(bei1);
			}
			
			long count = 0;
			List<SpsChannelSalesman> selectByExample = null;
			if(page != null&&limit!=null){
				PageHelper.startPage(page, limit);
				selectByExample = salesmanRead.selectByExample(example);
				PageInfo pageInfo = new PageInfo(selectByExample);
				count = pageInfo.getTotal();
			}else{
				selectByExample = salesmanRead.selectByExample(example);
			}
			
			hashMap.put("code", 0);
			hashMap.put("msg", "获取成功");
			hashMap.put("count",count);
			hashMap.put("data", selectByExample.size() != 0 ? selectByExample : null);
		} catch (Exception e) {
			hashMap.put("code", 1);
			hashMap.put("msg", "失败");
			e.printStackTrace();
		}
		return hashMap;
	}
	@Override
	public SpsChannelSalesman getSalesman(String salesmanIdcard) {
		
		SpsChannelSalesmanExample example = new SpsChannelSalesmanExample();
		
		example.createCriteria().andSalesmanIdcardEqualTo(salesmanIdcard);
		
		List<SpsChannelSalesman> selectByExample = salesmanRead.selectByExample(example);
		
		return selectByExample.size() != 0 ? selectByExample.get(0) : null;
	}
	
}
