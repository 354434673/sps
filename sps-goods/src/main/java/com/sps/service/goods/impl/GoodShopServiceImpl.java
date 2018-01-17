package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.*;
import org.sps.entity.goods.SpsGoodShop;
import org.sps.entity.goods.SpsGoods;
import org.sps.service.goods.GoodShopService;
import org.sps.service.goods.GoodsService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000)
public class GoodShopServiceImpl implements GoodShopService {
    @Resource
    private SpsGoodShopMapper spsGoodShopMapper;
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper;
    @Override
    public void saveOrUpdate(SpsGoodShop goods) {
        if(goods.getgId()!=null){
            //删除sku中的商品数据
            spsGoodShopSkuMapper.deleteSku(goods.getgId());
            goods.setgUpdateTime(new Date());
            spsGoodShopMapper.update(goods);
        }else{
            //审核中 1
            goods.setgStatus(1);
            goods.setgDeleteFlag(0);
            goods.setgCreateTime(new Date());
            spsGoodShopMapper.insert(goods);
        }
    }

    @Override
    public SpsGoodShop findEntityById(Integer id) {
        return spsGoodShopMapper.findById(id);
    }

    @Override
    public List<SpsGoodShop> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus,Integer flowStatus) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsName", goodsName);
        map.put("shopStatus", shopStatus);
        map.put("flowStatus", flowStatus);
        //分页
        PageHelper.startPage(page,limit);
        List<SpsGoodShop> goodsList = spsGoodShopMapper.findListAllWithMap(map);
        PageInfo pageInfo = new PageInfo(goodsList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count",  pageInfo.getTotal());
        hashMap.put("data", goodsList.size() != 0 ? goodsList : null);
        return hashMap;
    }

    @Override
    public SpsGoodShop findLastId() {
        return spsGoodShopMapper.findLastId();
    }

    @Override
    public Integer getEntityBySearchLimit(String gSpuNo,String spuName) {
        Map<String, Object> map = new HashMap<>();
        map.put("gSpuNo", gSpuNo);
        map.put("spuName", spuName);
        return spsGoodShopMapper.getSpuCount(map);
    }

    @Override
    public void setSale(Integer id, String state) {
        SpsGoodShop goods = new SpsGoodShop();
        goods.setgId(id);
        goods.setgGroundingFlag(state);
        spsGoodShopMapper.update(goods);
    }

    @Override
    public void setRecommend(Integer id, String state) {
        SpsGoodShop goods = new SpsGoodShop();
        goods.setgId(id);
        goods.setgRecommend(state);
        spsGoodShopMapper.update(goods);
    }
}
