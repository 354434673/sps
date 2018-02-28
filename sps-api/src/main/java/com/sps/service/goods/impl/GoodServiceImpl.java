package com.sps.service.goods.impl;

import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.goods.SpsGoods;
import com.sps.service.goods.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodServiceImpl implements GoodsService {
    @Resource
    private SpsGoodsMapper dao;

    @Override
    public void saveOrUpdate(SpsGoods goods) {

    }

    public SpsGoods findEntityById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<SpsGoods> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, String spuNo, String flowStatus) {
        return null;
    }

    @Override
    public SpsGoods findLastId() {
        return null;
    }

    @Override
    public Integer getEntityBySearchLimit(String gSpuNo) {
        return null;
    }

    @Override
    public List<SpsGoods> findAuditList(Map<String, Object> map) {
        return null;
    }


}
