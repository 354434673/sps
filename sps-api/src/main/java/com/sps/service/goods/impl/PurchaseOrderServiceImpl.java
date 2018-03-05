package com.sps.service.goods.impl;

import com.sps.dao.goods.SpsGoodsAlbumMapper;
import com.sps.dao.goods.SpsPurchaseOrderMapper;
import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.service.goods.GoodsAlbumService;
import com.sps.service.goods.PurchaseOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Resource
    private SpsPurchaseOrderMapper spsPurchaseOrderMapper;

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
}
