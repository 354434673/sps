package com.sps.service.goods;


import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.entity.goods.SpsPurchaseOrder;

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

}
