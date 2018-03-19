package com.sps.service.goods.impl;

import com.sps.common.EntityUtiles;
import com.sps.dao.goods.SpsGoodShopMapper;
import com.sps.dao.goods.SpsGoodShopSkuMapper;
import com.sps.dao.goods.SpsGoodsAlbumMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsGoods;
import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.service.goods.ApiGoodShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ApiGoodShopServiceImpl implements ApiGoodShopService {
    @Resource
    private SpsGoodShopMapper spsGoodShopMapper;
    @Resource
    private SpsGoodsMapper spsGoodsMapper;
    @Resource
    private SpsGoodsAlbumMapper spsGoodsAlbumMapper;
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper;

    @Override
    public void saveOrUpdate(SpsGoodShop goods) {

    }

    @Override
    public SpsGoodShop findById(Integer id) {
        SpsGoodShop goodShop = null;
        goodShop = spsGoodShopMapper.findById(id);
        //根据商户商品的商品ID查询品台商品信息
        if (goodShop != null && goodShop.getgGoodsId() != null) {
            SpsGoods goods = spsGoodsMapper.findById(goodShop.getgGoodsId());
            goodShop.setgDetails(goods.getgDetails());
            goodShop.setgRemark(goods.getgRemark());
            Map<String, Object> map = new HashMap<>();
            map.put("goodsId", goodShop.getgGoodsId());
            List<SpsGoodsAlbum> albumList = spsGoodsAlbumMapper.findListAllWithMap(map);
            if(albumList!=null&&albumList.size()>0){
                //主图
                List<SpsGoodsAlbum> mainPic = new ArrayList<>();
                //详情图
                List<SpsGoodsAlbum> detailPic = new ArrayList<>();
                for (SpsGoodsAlbum pic : albumList) {
                    if (pic.getAlbumType()==0) {
                        mainPic.add(pic);
                    } else if (pic.getAlbumType()==1) {
                        detailPic.add(pic);
                    }
                }
                String[] pro1 = new String[]{"albumId","albumUrl","albumType"};
                goodShop.setAlbumList((List<SpsGoodsAlbum>) EntityUtiles.reloadListPropertyValue(mainPic, pro1));
                goodShop.setAlbumDetailList((List<SpsGoodsAlbum>) EntityUtiles.reloadListPropertyValue(detailPic, pro1));
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("goodsId", goodShop.getgId());
        List<SpsGoodShopSku> skuList = spsGoodShopSkuMapper.findListAllWithMap(map);
        //获取SKU中最小的价格
        if (skuList != null && skuList.size() > 0) {
            if (skuList.size() != 1) {
                List<BigDecimal> price = new ArrayList<>();
                for (SpsGoodShopSku sku : skuList) {
                    price.add(sku.getgPrice());
                }
                goodShop.setgMinPrice(Collections.min(price));
            } else {
                goodShop.setgMinPrice(skuList.get(0).getgPrice());
            }

        }
        return goodShop;
    }

    @Override
    public List<SpsGoodShop> findList(Map<String, Object> map) {
        return spsGoodShopMapper.findListAllWithMap(map);
    }

    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus, Integer flowStatus, String endTime, String startTime, String shopNum) {
        return null;
    }

    @Override
    public SpsGoodShop findLastId() {
        return null;
    }

    @Override
    public Integer getEntityBySearchLimit(String gSpuNo, String spuName) {
        return null;
    }

    @Override
    public void setSale(Integer id, String state) {

    }

    @Override
    public void setRecommend(Integer id, String state) {

    }

    @Override
    public HashMap<String, Object> findAutidGoodsList(Integer page, Integer limit, String shopName, String goodsName, String shopNumber, Integer shopStatus, String endTime, String startTime) {
        return null;
    }

    @Override
    public void auditShopGood(SpsGoodShop goods) {

    }

    @Override
    public HashMap<String, Object> findForceGoodsList(Integer page, Integer limit, String shopName, String goodsName, String shopNumber, Integer shopStatus, String endTime, String startTime, String spuNo) {
        return null;
    }

    @Override
    public void forceShopGood(SpsGoodShop goods) {

    }

    @Override
    public HashMap<String, Object> findShopGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus, Integer flowStatus, String endTime, String startTime, String shopNum, String spuNo) {
        return null;
    }
}
