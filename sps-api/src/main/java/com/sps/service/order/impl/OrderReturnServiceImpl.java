package com.sps.service.order.impl;

import com.sps.common.EntityUtiles;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.order.SpsOrderGoodsMapper;
import com.sps.dao.order.SpsOrderLogMapper;
import com.sps.dao.order.SpsOrderMapper;
import com.sps.dao.order.SpsOrderReturnMapper;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.entity.order.SpsOrderLog;
import com.sps.entity.order.SpsOrderReturn;
import com.sps.service.order.OrderReturnService;
import com.sps.service.order.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderReturnServiceImpl implements OrderReturnService {
    @Resource
    private SpsOrderReturnMapper spsOrderReturnMapper;
    @Resource
    private SpsOrderLogMapper spsOrderLogMapper;


    @Override
    public void saveOrUpdate(SpsOrderReturn order) {
        try {
            if (order.getId() != null) {
                order.setUpdateTime(new Date());
                spsOrderReturnMapper.update(order);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                order.setOrderTime(sdf.parse(order.getOrderCreateTime()));
                order.setCreateTime(new Date());
                order.setDeleteFlag(0);
                spsOrderReturnMapper.insert(order);
                //插入日志
                SpsOrderLog log = new SpsOrderLog();
                log.setLogCreateTime(new Date());
                log.setLogType(2);
                log.setLogDes("订单编号为：" + order.getOrderNum() + "的订单申请退货");
                spsOrderLogMapper.insert(log);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SpsOrderReturn findEntityById(Integer id) {
        return null;
    }

    @Override
    public List<SpsOrderReturn> findList(Map<String, Object> map) {
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {

    }
}
