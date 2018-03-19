package com.sps.service.order;

import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrderLog;

import java.util.List;
import java.util.Map;

public interface OrderLogService {

    /**
     * 新增或者修改日志
     */
    void saveOrUpdate(SpsOrderLog log);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsOrderLog findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsOrderLog> findList(Map<String, Object> map);


}
