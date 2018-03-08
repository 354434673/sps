package com.sps.service.order.impl;

import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.service.order.OrderGoodsService;
import com.sps.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
    @Resource
    private SpsBrandMapper spsBrandMapper;
    @Resource
    private SpsGoodsMapper SpsGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;


    @Override
    public void saveOrUpdate(SpsOrderGoods orderGoods) {

    }

    @Override
    public SpsOrderGoods findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsOrderGoods> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
