package com.sps.service.order;

import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderReturn;

import java.util.List;
import java.util.Map;

public interface OrderReturnService {

    /**
     * 新增或者修改品牌
     */
    boolean saveOrUpdate(SpsOrderReturn order);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsOrderReturn findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsOrderReturn> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);



}
