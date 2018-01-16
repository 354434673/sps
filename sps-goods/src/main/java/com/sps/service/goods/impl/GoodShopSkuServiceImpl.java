package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.goods.SpsGoodShopSkuMapper;
import org.sps.entity.goods.SpsGoodShopSku;
import org.sps.entity.goods.SpsGoods;
import org.sps.service.goods.GoodShopSkuService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000)
public class GoodShopSkuServiceImpl implements GoodShopSkuService {
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper;
    @Override
    public void saveOrUpdate(SpsGoodShopSku goods) {
        if(goods.getgId()!=null){
            spsGoodShopSkuMapper.update(goods);
        }else{
            spsGoodShopSkuMapper.insert(goods);
        }

    }

    @Override
    public SpsGoodShopSku findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsGoodShopSku> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, String spuNo) {
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
}
