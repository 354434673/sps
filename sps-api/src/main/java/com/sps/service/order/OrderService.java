package com.sps.service.order;

import com.sps.entity.goods.SpsBrand;
import com.sps.entity.order.SpsOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsOrder order);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsOrder findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsOrder> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    SpsOrder findById(Integer id);

    /**
     * 取消订单
     * @param id
     */
    void cancelOrder(Integer id);

    /**
     * 删除订单
     * @param id
     */
    void deleteOrder(Integer id);
}
