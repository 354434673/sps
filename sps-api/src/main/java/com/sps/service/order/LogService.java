package com.sps.service.order;

import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrder;

import java.util.List;
import java.util.Map;

public interface LogService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsLog log);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsLog findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsLog> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

}
