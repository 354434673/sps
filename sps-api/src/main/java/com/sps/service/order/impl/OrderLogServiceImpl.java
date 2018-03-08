package com.sps.service.order.impl;

import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrderLog;
import com.sps.service.order.LogService;
import com.sps.service.order.OrderLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Resource
    private SpsBrandMapper spsBrandMapper;
    @Resource
    private SpsGoodsMapper SpsGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;


    @Override
    public void saveOrUpdate(SpsOrderLog log) {


    }

    @Override
    public SpsOrderLog findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsOrderLog> findList(Map<String, Object> map) {
        return null;
    }
}
