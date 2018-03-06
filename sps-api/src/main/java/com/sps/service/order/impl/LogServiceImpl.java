package com.sps.service.order.impl;

import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrder;
import com.sps.service.order.LogService;
import com.sps.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    private SpsBrandMapper spsBrandMapper;
    @Resource
    private SpsGoodsMapper SpsGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;


    @Override
    public void saveOrUpdate(SpsLog log) {

    }

    @Override
    public SpsLog findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsLog> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
