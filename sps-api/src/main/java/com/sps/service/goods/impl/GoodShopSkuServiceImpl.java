package com.sps.service.goods.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsGoodShopMapper;
import com.sps.dao.goods.SpsGoodShopSkuMapper;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsGoods;
import com.sps.service.goods.GoodShopSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodShopSkuServiceImpl implements GoodShopSkuService {
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper;
    @Resource
    private SpsGoodShopMapper spsGoodShopMapper;

    @Override
    public void saveOrUpdate(SpsGoodShopSku goods) {
        if (goods.getgId() != null) {
            goods.setgUpdateTime(new Date());
            spsGoodShopSkuMapper.update(goods);
        } else {
            SpsGoodShop spsGoodShop = spsGoodShopMapper.findById(goods.getgGid());
            if (!"".equals(spsGoodShop.getgSkuIds())) {
                String[] ids = spsGoodShop.getgSkuIds().split(",");
                for (String id : ids) {
                    if (Integer.valueOf(id).equals(goods.getgSkuId())) {
                        goods.setgCreateTime(new Date());
                        goods.setgDeleteFlag(0);
                        spsGoodShopSkuMapper.insert(goods);
                    }
                }
            }
        }
    }

    @Override
    public SpsGoodShopSku findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsGoodShopSku> findList(Map<String, Object> map) {
        List<SpsGoodShopSku> list = spsGoodShopSkuMapper.findListAllWithMap(map);
        if (list!=null &&list.size()>0){
            for (SpsGoodShopSku skuList:  list){
                skuList.setColorSize(skuList.getgColor()+","+skuList.getgSize());
            }
        }
        return list;
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

    @Override
    public HashMap<String, Object> findSkuList(Integer page, Integer limit, String goodsName, String spec, String goodSku, String endTime, String startTime, String shopNum) {
        Map<String, Object> map = new HashMap<>();
        map.put("shopNum", shopNum);
        map.put("goodsName", goodsName);
        map.put("spec", spec);
        map.put("goodSku", goodSku);
        if (endTime != null && !"".equals(endTime)) {
            map.put("endTime", endTime + " 23:59:59");
        }
        if (startTime != null && !"".equals(startTime)) {
            map.put("startTime", startTime + " 00:00:00");
        }

        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoodShopSku> goodsList = spsGoodShopSkuMapper.findList(map);
        PageInfo pageInfo = new PageInfo(goodsList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", pageInfo.getTotal());
        hashMap.put("data", goodsList.size() != 0 ? goodsList : null);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> updatePriceOrStock(List<SpsGoodShopSku> goodShopSku) {

        return null;
    }
}
