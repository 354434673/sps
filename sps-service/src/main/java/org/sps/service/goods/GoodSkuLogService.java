package org.sps.service.goods;
import org.sps.entity.goods.SpsGoodSku;
import org.sps.entity.goods.SpsGoodSkuLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodSkuLogService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsGoodSkuLog log);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsGoodSkuLog findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsGoodSkuLog> findList(Map<String, Object> map);


}
