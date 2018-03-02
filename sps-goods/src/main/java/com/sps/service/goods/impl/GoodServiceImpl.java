package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.*;
import org.sps.entity.goods.*;
import org.sps.service.goods.GoodsService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000,group="dianfu")
public class GoodServiceImpl implements GoodsService {
    @Resource
    private SpsGoodsMapper spsGoodsMapper;
    @Resource
    private SpsGoodSkuMapper spsGoodSkuMapper;
    @Resource
    private SpsGoodsAlbumMapper spsGoodsAlbumMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;
    @Resource
    private SpsGoodShopMapper spsGoodShopMapper;
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper ;

    @Override
    public void saveOrUpdate(SpsGoods goods) {
        if (goods.getgId() != null) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("goodsId", goods.getgId());
            spsGoodsAlbumMapper.deleteDetailPic(map1);
            //如果UpdateDetailFlag不为空 则删除 改商品的详情图
      /*      if (goods.getUpdateDetailFlag() != null) {
                Map<String, Object> map = new HashMap<>();
                map.put("goodsId", goods.getgId());
                map.put("updateDetailFlag", goods.getUpdateDetailFlag());
                spsGoodsAlbumMapper.deleteDetailPic(map);
            }
            //如果UpdatePicFlag 则删除 改商品的主图
            if (goods.getUpdatePicFlag() != null) {
                Map<String, Object> map = new HashMap<>();
                map.put("goodsId", goods.getgId());
                map.put("updatePicFlag", goods.getUpdatePicFlag());
                spsGoodsAlbumMapper.deleteDetailPic(map);
            }*/
            //删除sku中的商品数据
            spsGoodSkuMapper.deleteSku(goods.getgId());
            goods.setgUpdateTime(new Date());
            spsGoodsMapper.update(goods);
        } else {
            goods.setgDeleteFlag(0);
            goods.setgCreateTime(new Date());
            spsGoodsMapper.insert(goods);
        }
    }

    @Override
    public SpsGoods findEntityById(Integer id) {
        return spsGoodsMapper.findById(id);
    }

    @Override
    public List<SpsGoods> findList(Map<String, Object> map) {
        map.put("flowStatus", "3");
        return spsGoodsMapper.findListAllWithMap(map);
    }

    @Override
    public void falseDeletion(Integer id) {
        //删除平台商品
        SpsGoods goods = new SpsGoods();
        goods.setgId(id);
        goods.setgDeleteFlag(1);
        goods.setgUpdateTime(new Date());
        spsGoodsMapper.update(goods);
        //逻辑删除平台sku下的sku
        SpsGoodSku spsGoodSku = new SpsGoodSku();
        spsGoodSku.setgDeleteFlag(1);
        spsGoodSku.setgUpdateTime(new Date());
        spsGoodSku.setgGid(id);
        spsGoodSkuMapper.updateByGoodsId(spsGoodSku);
        //逻辑删除核心商户的商品
        SpsGoodShop spsGoodShop = new SpsGoodShop();
        spsGoodShop.setgUpdateTime(new Date());
        /*spsGoodShop.setgDeleteFlag(1);*/
        //2为已经删除
        spsGoodShop.setgGroundingFlag("2");
        spsGoodShop.setgGoodsId(id);
        spsGoodShopMapper.updateByGoodsId(spsGoodShop);
        //逻辑删除核心商户sku的商品sku
        SpsGoodShopSku spsGoodShopSku = new SpsGoodShopSku();
        spsGoodShopSku.setgUpdateTime(new Date());
        spsGoodShopSku.setgDeleteFlag(1);
        spsGoodShopSku.setgGoodsId(id);
        spsGoodShopSkuMapper.updateByGoodsId(spsGoodShopSku);
    }

    @Override
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, String goodsNo,String flowStatus,String categoryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("flowStatus", flowStatus);
        map.put("goodsName", goodsName);
        map.put("categoryId", categoryId);
        map.put("goodsNo", goodsNo);
        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoods> goodsList = spsGoodsMapper.findListAllWithMap(map);
        if (goodsList != null && goodsList.size() > 0) {
            for (SpsGoods list : goodsList) {
                String[] ids = list.getgCategoryIds().split(",");
                if (ids != null && ids.length > 0) {
                    String categoryNames = "";
                    for (String id : ids) {
                        SpsGoodCategory category = spsGoodCategoryMapper.findById(Integer.valueOf(id));
                        categoryNames += ">" + category.getCategoryName();
                    }
                    list.setgCategoryNames(categoryNames.substring(1));
                }
            }
        }
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
    public SpsGoods findLastId() {
        return spsGoodsMapper.findLastId();
    }

    @Override
    public Integer getEntityBySearchLimit(String gSpuNo) {
        return spsGoodsMapper.getEntityBySearchLimit(gSpuNo);
    }

    @Override
    public List<SpsGoods> findAuditList(Map<String, Object> map) {
        return spsGoodsMapper.findListAllWithMap(map);
    }
}
