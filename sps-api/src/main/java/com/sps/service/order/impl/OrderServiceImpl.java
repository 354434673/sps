package com.sps.service.order.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.common.EntityUtiles;
import com.sps.common.EntityUtils;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.dao.order.SpsOrderGoodsMapper;
import com.sps.dao.order.SpsOrderMapper;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.service.goods.BrandService;
import com.sps.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private SpsOrderMapper spsOrderMapper;
    @Resource
    private SpsOrderGoodsMapper spsOrderGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;


    @Override
    public void saveOrUpdate(SpsOrder order) {

    }

    @Override
    public SpsOrder findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsOrder> findList(Map<String, Object> map) {
        List<SpsOrder> orderList = spsOrderMapper.findListAllWithMap(map);
        if (orderList != null && orderList.size() > 0) {
            for (SpsOrder order : orderList) {
                Map<String, Object> goodsMap = new HashMap<>();
                goodsMap.put("orderNum", order.getOrderid());
                List<SpsOrderGoods> goodsList = spsOrderGoodsMapper.findListAllWithMap(goodsMap);
                String[] pro1 = new String[]{"skuname", "price", "url"};
                if (goodsList != null && goodsList.size() > 0) {
                    order.setOrderGoodsList((List<SpsOrderGoods>) EntityUtiles.reloadListPropertyValue(goodsList, pro1));
                }
            }
        }
        return orderList;
    }

    @Override
    public void falseDeletion(Integer id) {

    }

    @Override
    public SpsOrder findById(Integer id) {
        SpsOrder order = spsOrderMapper.findById(id);
        if (order != null) {
            Map<String, Object> goodsMap = new HashMap<>();
            goodsMap.put("orderNum", order.getOrderid());
            List<SpsOrderGoods> goodsList = spsOrderGoodsMapper.findListAllWithMap(goodsMap);
            String[] pro1 = new String[]{"skuname", "price", "url","amount"};
            if (goodsList != null && goodsList.size() > 0) {
                order.setOrderGoodsList((List<SpsOrderGoods>) EntityUtiles.reloadListPropertyValue(goodsList, pro1));
            }
        }
        return order;
    }

    @Override
    public void cancelOrder(Integer id) {
        SpsOrder order = new SpsOrder();
        order.setoId(id);
        order.setModifytime(new Date());
        order.setFlag(11);
        spsOrderGoodsMapper.update(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        SpsOrder order = new SpsOrder();
        order.setoId(id);
        order.setModifytime(new Date());
        order.setIsdelete(1);
        spsOrderGoodsMapper.update(order);
    }

    @Override
    public void updateStatus(Map<String, Object> map) {
        Integer status = (Integer) map.get("orderStatus");
        String orderNum = (String) map.get("orderNum");
        SpsOrder order = new SpsOrder();
        if (status == 1) {
            order.setFlag(5);
        } else if (status == 0) {
            order.setFlag(19);
        }
        order.setModifytime(new Date());
        order.setOrderid(orderNum);
        spsOrderGoodsMapper.updateToOrderNum(order);
    }

    @Override
    public SpsOrder findByCode(String orderCode) {
        SpsOrder order = spsOrderMapper.findByCode(orderCode);
        if (order != null) {
            Map<String, Object> goodsMap = new HashMap<>();
            goodsMap.put("orderNum", order.getOrderid());
            List<SpsOrderGoods> goodsList = spsOrderGoodsMapper.findListAllWithMap(goodsMap);
            String[] pro1 = new String[]{"skuname", "price", "url","amount"};
            if (goodsList != null && goodsList.size() > 0) {
                order.setOrderGoodsList((List<SpsOrderGoods>) EntityUtiles.reloadListPropertyValue(goodsList, pro1));
            }
        }
        return order;
    }
}
