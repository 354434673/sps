package org.sps.service.goods;
import org.sps.entity.goods.SpsBrand;
import org.sps.entity.goods.SpsSaleLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SaleLogService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsSaleLog log);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsBrand findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsBrand> findList(Map<String, Object> map);


}
