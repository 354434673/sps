package com.sps.service.order.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sps.dao.order.SpsOrderRepayDetailMapper;
import com.sps.entity.order.SpsOrderRepayDetail;
import com.sps.service.order.OrderRepayDetailService;

@Service
public class OrderRepayDetailServiceImpl implements OrderRepayDetailService{
    @Resource
    private SpsOrderRepayDetailMapper spsOrderRepayDetailMapper;
   
	@Override
	public void saveOrUpdate(SpsOrderRepayDetail order) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SpsOrderRepayDetail findEntityById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SpsOrderRepayDetail> findList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return spsOrderRepayDetailMapper.findListAllWithMap(map);
	}
	@Override
	public void falseDeletion(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SpsOrderRepayDetail findById(Integer id) {
		// TODO Auto-generated method stub
		return spsOrderRepayDetailMapper.findById(id);
	}


}
