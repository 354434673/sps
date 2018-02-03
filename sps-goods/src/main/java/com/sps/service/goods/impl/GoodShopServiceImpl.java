package com.sps.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.*;
import org.springframework.util.StringUtils;
import org.sps.entity.goods.SpsGoodShop;
import org.sps.entity.goods.SpsGoods;
import org.sps.service.goods.GoodShopService;
import org.sps.service.goods.GoodsService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(timeout = 1200000,group="dianfu")
public class GoodShopServiceImpl implements GoodShopService {
    @Resource
    private SpsGoodShopMapper spsGoodShopMapper;
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper;

    @Override
    public void saveOrUpdate(SpsGoodShop goods) {
        if (goods.getgId() != null) {
            //删除sku中的商品数据
            spsGoodShopSkuMapper.deleteSku(goods.getgId());
            goods.setgUpdateTime(new Date());
            //TODO 待提交状态在想想 明天搞
            /*if(goods.getgStatus()==null){
                if (goods.getgGroundingFlag().equals("0")) {
                    //如果不提交上架申请 流程状态为待提交
                    goods.setgStatus(0);
                } else if (goods.getgGroundingFlag().equals("1")) {
                    //如果提交申请 流程状态为审核中
                    goods.setgStatus(1);
                }
            }*/
            spsGoodShopMapper.update(goods);
        } else {

            /*if(goods.getgStatus()==null) {
                if (goods.getgGroundingFlag().equals("0")) {
                    //如果不提交上架申请 流程状态为待提交
                    goods.setgStatus(0);
                } else if (goods.getgGroundingFlag().equals("1")) {
                    //如果提交申请 流程状态为审核中
                    goods.setgStatus(1);
                }
            }*/

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
    public HashMap<String, Object> findGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus, Integer flowStatus, String endTime, String startTime) {
        Map<String, Object> map = new HashMap<>();
        map.put("goodsName", goodsName);

        map.put("flowStatus", flowStatus);
        if (endTime != null && !"".equals(endTime)) {
            map.put("endTime", endTime + " 23:59:59");
        }
        if (startTime != null && !"".equals(startTime)) {
            map.put("startTime", startTime + " 00:00:00");
        }
        if (shopStatus != null && shopStatus == 3) {//未生效
            map.put("noSignature", shopStatus);
        } else if (shopStatus != null && shopStatus == 2) {//已删除
            map.put("deleteFlag", shopStatus);
        } else {
            map.put("shopStatus", shopStatus);
        }
        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoodShop> goodsList = spsGoodShopMapper.findListAllWithMap(map);
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
    public SpsGoodShop findLastId() {
        return spsGoodShopMapper.findLastId();
    }

    @Override
    public Integer getEntityBySearchLimit(String gSpuNo, String spuName) {
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

    @Override
    public HashMap<String, Object> findAutidGoodsList(Integer page, Integer limit, String shopName, String goodsName, String shopNumber, Integer shopStatus, String endTime, String startTime) {
        Map<String, Object> map = new HashMap<>();
        map.put("shopName", shopName);
        map.put("shopNumber", shopNumber);
        map.put("goodsName", goodsName);
        if (endTime != null && !"".equals(endTime)) {
            map.put("endTime", endTime + " 23:59:59");
        }
        if (startTime != null && !"".equals(startTime)) {
            map.put("startTime", startTime + " 00:00:00");
        }
        map.put("shopStatus", shopStatus);
        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoodShop> goodsList = spsGoodShopMapper.findAuditGoodsList(map);
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
    public void auditShopGood(SpsGoodShop goods) {
        if (goods.getgOpinion() != null) {
            goods.setgUpdateTime(new Date());
            goods.setgStatus(3);
            spsGoodShopMapper.update(goods);
        } else {
            goods.setgOpinion("");
            goods.setgUpdateTime(new Date());
            goods.setgStatus(2);
            spsGoodShopMapper.update(goods);
        }
    }

    @Override
    public HashMap<String, Object> findForceGoodsList(Integer page, Integer limit, String shopName, String goodsName, String shopNumber, Integer shopStatus, String endTime, String startTime, String spuNo) {
        Map<String, Object> map = new HashMap<>();
        map.put("shopName", shopName);
        map.put("shopNumber", shopNumber);
        map.put("goodsName", goodsName);
        map.put("spuNo", spuNo);
        if (endTime != null && !"".equals(endTime)) {
            map.put("endTime", endTime + " 23:59:59");
        }
        if (startTime != null && !"".equals(startTime)) {
            map.put("startTime", startTime + " 00:00:00");
        }
        map.put("shopStatus", shopStatus);
        //分页
        PageHelper.startPage(page, limit);
        List<SpsGoodShop> goodsList = spsGoodShopMapper.findForceGoodsList(map);
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
    public void forceShopGood(SpsGoodShop goods) {
        goods.setgUpdateTime(new Date());
        goods.setgGroundingFlag("0");
        goods.setgStatus(0);
        spsGoodShopMapper.update(goods);
    }
}
