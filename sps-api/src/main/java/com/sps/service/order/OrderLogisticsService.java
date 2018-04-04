package com.sps.service.order;

import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrderLogistics;

import java.util.List;
import java.util.Map;

public interface OrderLogisticsService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsOrderLogistics log);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsOrderLogistics findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsOrderLogistics> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

}
