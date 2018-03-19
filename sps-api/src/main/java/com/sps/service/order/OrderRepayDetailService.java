package com.sps.service.order;

import java.util.List;
import java.util.Map;
import com.sps.entity.order.SpsOrderRepayDetail;
public interface OrderRepayDetailService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsOrderRepayDetail order);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsOrderRepayDetail findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsOrderRepayDetail> findList(Map<String, Object> map);

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
    SpsOrderRepayDetail findById(Integer id);

   
}
