package com.sps.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.entity.order.SpsOrder;
import com.sps.service.goods.BrandService;
import com.sps.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private SpsBrandMapper spsBrandMapper;
    @Resource
    private SpsGoodsMapper SpsGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;


    @Override
    public void saveOrUpdate(SpsOrder order) {

    }

    @Override
    public SpsOrder findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsOrder> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
