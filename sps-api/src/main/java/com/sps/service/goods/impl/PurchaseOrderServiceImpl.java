package com.sps.service.goods.impl;

import com.sps.common.NumberUtil;
import com.sps.common.OrderCodeCreateUtil;
import com.sps.dao.goods.*;
import com.sps.dao.order.SpsOrderGoodsMapper;
import com.sps.dao.order.SpsOrderLogMapper;
import com.sps.dao.order.SpsOrderMapper;
import com.sps.dao.shopkeeper.SpsShopkeeperCompanyDao;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsGoods;
import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.entity.order.SpsOrderLog;
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
    @Resource
    private SpsOrderLogMapper spsOrderLogMapper;


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
        return list;
    }

    @Override
    public void falseDeletion(String ids) {
    	String [] ides= ids.split(",");
    	for(String id:ides){
    		SpsPurchaseOrder order = new SpsPurchaseOrder();
	        order.setOrderId(Integer.valueOf(id));
	        order.setOrderDeleteFlag(1);
	        order.setOrderUpdateTime(new Date());
	        spsPurchaseOrderMapper.update(order);
    	}
    }

    @Override
    public Map<String, Object> saveOrder(List<SpsPurchaseOrder> order) {
        Map<String, Object> map = new HashMap<>();
        String orderCode = OrderCodeCreateUtil.orderCode();
        StringBuffer sb = new StringBuffer();
        if (order != null && order.size() > 0) {
            if (order.get(0).getCustomerId() != null) {
                Boolean flag = shopkeeperServiceImpl.queryAccount(order.get(0).getCustomerId());
                if (flag) {
                    for (SpsPurchaseOrder orderList : order) {
                        if (orderList.getOrderSkuId() != null) {
                            SpsGoodShopSku sku = spsGoodShopSkuMapper.findById(orderList.getOrderSkuId());
                            //判断是否删除
                            if (sku.getgDeleteFlag() == 1) {
                                map.put("flag", 2);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断是否上架
                            if (sku.getGroundingFlag() != 2) {
                                map.put("flag", 3);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断价格是否发生变化
                            if (sku.getgPrice() != null) {
                                if (!sku.getgPrice().setScale(4).equals(orderList.getPrice().setScale(4))) {
                                    map.put("flag", 4);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                            //判断库存是否充足
                            if (sku.getgStock() != null) {
                                if (sku.getgStock() < orderList.getOrderGoodsNum()) {
                                    map.put("flag", 5);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                        }
                        //插入订单商品表
                        SpsOrderGoods goods = new SpsOrderGoods();
                        goods.setColor(orderList.getColor());
                        goods.setAmount(orderList.getOrderGoodsNum());
                        goods.setMemory(orderList.getSize());
                        goods.setPrice(orderList.getPrice());
                        Double sum = NumberUtil.mul(orderList.getPrice().doubleValue(), orderList.getOrderGoodsNum());
                        goods.setSummation(sum);
                        goods.setSku(orderList.getOrderSkuId().toString());
                        goods.setSkuname(orderList.getGoodsName());
                        goods.setOrderid(orderCode);
                        spsOrderGoodsMapper.insert(goods);
                        sb.append(orderList.getGoodsName() + "的商品,尺寸:" + orderList.getSize() + "颜色：" + orderList.getColor() + "价格：" + orderList.getPrice() + "数量:" + orderList.getOrderGoodsNum() + "总价" + sum + "。");
                    }
                    //插入订单表
                    SpsOrder spsOrder = new SpsOrder();
                    SpsShopkeeper shopkeeper = shopkeeperServiceImpl.queryShopkeeperList(order.get(0).getCustomerId());
                    spsOrder.setShopkeeper(shopkeeper.getShopkeeperDefaultChannelNum());
                    spsOrder.setShopkeepername(shopkeeper.getShopkeeperDefaultChannelName());
                    spsOrder.setSelfemployed(shopkeeper.getShopkeeperUsername());
                    spsOrder.setUnit("元");
                    spsOrder.setFlag(1);
                    spsOrder.setAddress(order.get(0).getAddress());
                    spsOrder.setPhone(order.get(0).getPhone());
                    spsOrder.setName(order.get(0).getName());
                    spsOrder.setOrderid(orderCode);
                    spsOrder.setPayment(order.get(0).getPayment());
                    spsOrder.setServicemoney(order.get(0).getServiceMoney().doubleValue());
                    spsOrder.setIsdelete(0);
                    spsOrder.setShopPayMoney(order.get(0).getShopPayMoney());
                    spsOrder.setServicescale(0.7);
                    spsOrder.setCreatetime(new Date());
                    spsOrder.setRemark(order.get(0).getRemark());
                    spsOrder.setSelfname(order.get(0).getSelfName());
                    spsOrder.setScale(order.get(0).getScale());
                    spsOrder.setMoney(NumberUtil.add(order.get(0).getPayment().doubleValue(), NumberUtil.add(order.get(0).getServiceMoney().doubleValue(), order.get(0).getShopPayMoney().doubleValue())));
                    spsOrder.setSumMoney(BigDecimal.valueOf(NumberUtil.add(order.get(0).getPayment().doubleValue(), order.get(0).getShopPayMoney().doubleValue())));
                    spsOrderMapper.insert(spsOrder);
                    //插入日志
                    SpsOrderLog log = new SpsOrderLog();
                    log.setLogCreateTime(new Date());
                    log.setLogName(order.get(0).getCustomerId());
                    log.setLogType(1);
                    log.setLogDes("订单编号为：" + orderCode + "的订单创建成功,订单商品信息： " + sb.toString());
                    spsOrderLogMapper.insert(log);
                    map.put("orderCode", orderCode);
                } else {
                    map.put("flag", 6);
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
        if (order != null && order.size() > 0) {
            if (order.get(0).getCustomerId() != null) {
                Boolean flag = shopkeeperServiceImpl.queryAccount(order.get(0).getCustomerId());
                if (flag) {
                    for (SpsPurchaseOrder orderList : order) {
                        if (orderList.getOrderSkuId() != null) {
                            SpsGoodShopSku sku = spsGoodShopSkuMapper.findById(orderList.getOrderSkuId());
                            //判断是否删除
                            if (sku.getgDeleteFlag() == 1) {
                                map.put("flag", 2);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断是否上架
                            if (sku.getGroundingFlag() ==1 ) {
                                map.put("flag", 3);
                                map.put("goodsName", sku.getSpuName());
                                return map;
                            }
                            //判断价格是否发生变化
                            if (sku.getgPrice() != null) {
                                if (!sku.getgPrice().setScale(4).equals(orderList.getPrice().setScale(4))) {
                                    map.put("flag", 4);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                            //判断库存是否充足
                            if (sku.getgStock() != null) {
                                if (sku.getgStock() < orderList.getOrderGoodsNum()) {
                                    map.put("flag",5);
                                    map.put("goodsName", sku.getSpuName());
                                    return map;
                                }
                            }
                        }
                    }
                    HashMap<String, Object> data = new HashMap<String, Object>();//封装对象
                    SpsShopkeeperCompany company = spsShopkeeperCompanyDao.queryCompanyJoin(order.get(0).getCustomerId());
                    data.put("companyShopName", company.getCompanyShopName());
                    data.put("companyBusinessAddr", company.getCompanyBusinessAddr());
                    data.put("personalPhone", company.getPersonal().getPersonalPhone());
                    map.put("company", data);
                    map.put("flag", 0);
                } else {
                    map.put("flag", 6);
                }
            }
        }
        return map;
    }
}
