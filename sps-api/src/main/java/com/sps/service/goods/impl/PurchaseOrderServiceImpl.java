package com.sps.service.goods.impl;

import com.sps.common.NumberUtil;
import com.sps.common.OrderCodeCreateUtil;
import com.sps.dao.goods.*;
import com.sps.dao.order.SpsOrderGoodsMapper;
import com.sps.dao.order.SpsOrderMapper;
import com.sps.dao.shopkeeper.SpsShopkeeperCompanyDao;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsGoods;
import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.service.goods.GoodsAlbumService;
import com.sps.service.goods.PurchaseOrderService;
import com.sps.service.shopkeeper.impl.ShopkeeperServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Resource
    private SpsPurchaseOrderMapper spsPurchaseOrderMapper;
    @Resource
    private SpsGoodShopSkuMapper spsGoodShopSkuMapper;
    @Resource
    private SpsOrderGoodsMapper spsOrderGoodsMapper;
    @Resource
    private SpsOrderMapper spsOrderMapper;
    @Resource
    private ShopkeeperServiceImpl shopkeeperServiceImpl;
    @Resource
    private SpsShopkeeperCompanyDao spsShopkeeperCompanyDao;


    @Override
    public void saveOrUpdate(SpsPurchaseOrder spsPurchaseOrder) {
        if (spsPurchaseOrder.getOrderId() != null) {
            spsPurchaseOrder.setOrderUpdateTime(new Date());
            spsPurchaseOrderMapper.update(spsPurchaseOrder);
        } else {
            spsPurchaseOrder.setOrderDeleteFlag(0);
            spsPurchaseOrder.setOrderCreateTime(new Date());
            spsPurchaseOrderMapper.insert(spsPurchaseOrder);
        }

    }

    @Override
    public SpsPurchaseOrder findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsPurchaseOrder> findList(Map<String, Object> map) {
        List<SpsPurchaseOrder> list = spsPurchaseOrderMapper.findListAllWithMap(map);
        //暂时不用
        /*if(list!=null&&list.size()>0){
            for(SpsPurchaseOrder orderList :list){
                 if (orderList.getGroundingFlag() != null) {
                    if(orderList.getGroundingFlag()!=1){
                        //0为商品下架
                        orderList.setGoodsFlag(0);
                    }else {
                        orderList.setGoodsFlag(1);
                    }
                }
                if (orderList.getStock() != null) {
                    if(orderList.getStock()<=orderList.getOrderGoodsNum()){
                        //2为库存不足
                        orderList.setGoodsFlag(2);
                    }else {
                        orderList.setGoodsFlag(1);
                    }
                }

                if(orderList.getPlatGoodsId()!=null){
                }
            }
        }*/
        return list;
    }

    @Override
    public void falseDeletion(Integer id) {
        SpsPurchaseOrder order = new SpsPurchaseOrder();
        order.setOrderId(id);
        order.setOrderDeleteFlag(1);
        order.setOrderUpdateTime(new Date());
        spsPurchaseOrderMapper.update(order);
    }

    @Override
    public Map<String,Object> saveOrder(List<SpsPurchaseOrder> order,SpsOrder spsOrder) {
        Map<String, Object> map = new HashMap<>();
        String orderCode = OrderCodeCreateUtil.orderCode();
        if(order!=null&&order.size()>0){
            if (order.get(0).getCustomerId()!=null){
                Boolean flag = shopkeeperServiceImpl.queryAccount(order.get(0).getCustomerId());
                if(flag){
                    for(SpsPurchaseOrder orderList: order ){
                        if(orderList.getOrderSkuId()!=null){
                            SpsGoodShopSku sku = spsGoodShopSkuMapper.findById(orderList.getOrderSkuId());
                            //判断是否删除
                            if(sku.getgDeleteFlag()==1){
                                map.put("flag", 1);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断是否上架
                            if(sku.getGroundingFlag()==1){
                                map.put("flag", 2);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断价格是否发生变化
                            if(sku.getgPrice()!=null){
                                if(!sku.getgPrice().setScale(4).equals(orderList.getPrice().setScale(4))){
                                    map.put("flag", 3);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                            //判断库存是否充足
                            if(sku.getgStock()!=null){
                                if(sku.getgStock()>orderList.getOrderGoodsNum()){
                                    map.put("flag", 4);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                        }

                        SpsOrderGoods goods = new SpsOrderGoods();
                        goods.setColor(orderList.getColor());
                        goods.setAmount(orderList.getOrderGoodsNum());
                        goods.setMemory(orderList.getSize());
                        goods.setAmount(orderList.getOrderGoodsNum());
                        goods.setPrice(orderList.getPrice());
                        goods.setSummation(NumberUtil.mul(orderList.getPrice().doubleValue(),orderList.getOrderGoodsNum()));
                        goods.setSku(orderList.getOrderSkuId().toString());
                        goods.setSkuname(orderList.getGoodsName());
                        goods.setOrderid(orderCode);
                        spsOrderGoodsMapper.insert(goods);
                    }
                    SpsShopkeeper shopkeeper = shopkeeperServiceImpl.queryShopkeeperList(order.get(0).getCustomerId());
                    spsOrder.setShopkeeper(shopkeeper.getShopkeeperDefaultChannelNum());
                    spsOrder.setShopkeepername(shopkeeper.getShopkeeperDefaultChannelName());
                    spsOrder.setSelfemployed(shopkeeper.getShopkeeperUsername());
                    spsOrder.setOrderid(orderCode);
                    spsOrder.setIsdelete(0);
                    spsOrder.setCreatetime(new Date());
                    spsOrder.setMoney(NumberUtil.add(spsOrder.getPayment().doubleValue(),NumberUtil.add(spsOrder.getServicemoney(),spsOrder.getShopPayMoney().doubleValue())));
                    spsOrder.setSumMoney(BigDecimal.valueOf(NumberUtil.add(spsOrder.getPayment().doubleValue(),spsOrder.getShopPayMoney().doubleValue())));
                    spsOrderMapper.insert(spsOrder);
                }else {
                    map.put("flag", 5);
                    return map;
                }
                }
        }
        map.put("flag", 0);
        return map;
    }

    @Override
    public Map<String, Object> verificationOrder(List<SpsPurchaseOrder> order) {
        Map<String, Object> map = new HashMap<>();
        if(order!=null&&order.size()>0){
            if (order.get(0).getCustomerId()!=null){
                Boolean flag = shopkeeperServiceImpl.queryAccount(order.get(0).getCustomerId());
                if(flag){
                    for(SpsPurchaseOrder orderList: order ){
                        if(orderList.getOrderSkuId()!=null){
                            SpsGoodShopSku sku = spsGoodShopSkuMapper.findById(orderList.getOrderSkuId());
                            //判断是否删除
                            if(sku.getgDeleteFlag()==1){
                                map.put("flag", 1);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断是否上架
                            if(sku.getGroundingFlag()==1){
                                map.put("flag", 2);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断价格是否发生变化
                            if(sku.getgPrice()!=null){
                                if(!sku.getgPrice().setScale(4).equals(orderList.getPrice().setScale(4))){
                                    map.put("flag", 3);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                            //判断库存是否充足
                            if(sku.getgStock()!=null){
                                if(sku.getgStock()>orderList.getOrderGoodsNum()){
                                    map.put("flag", 4);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                        }
                    }
                    SpsShopkeeperCompany company = spsShopkeeperCompanyDao.queryCompanyJoin(order.get(0).getCustomerId());
                    map.put("company", company);
                    map.put("flag", 0);
                }else {
                    map.put("flag", 5);
                }
            }
        }
        return map;
    }
}
