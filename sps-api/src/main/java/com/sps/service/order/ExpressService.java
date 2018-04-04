package com.sps.service.order;

import com.sps.entity.express.SpsExpress;
import com.sps.entity.order.SpsOrderLogistics;

import java.util.List;
import java.util.Map;

public interface ExpressService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsExpress express);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsExpress findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsExpress> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

}
