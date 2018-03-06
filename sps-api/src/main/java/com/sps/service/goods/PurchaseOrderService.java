package com.sps.service.goods;


import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.order.SpsOrder;

import java.util.List;
import java.util.Map;

public interface PurchaseOrderService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsPurchaseOrder spsPurchaseOrder);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsPurchaseOrder findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsPurchaseOrder> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

    /**
     * 提交进货单
     * @param order
     * @return
     */
    Map<String,Object> saveOrder(List<SpsPurchaseOrder> order, SpsOrder spsOrder);

    /**
     * 校验进货单数据
     * @param order
     * @return
     */
    Map<String,Object> verificationOrder(List<SpsPurchaseOrder> order);
}
