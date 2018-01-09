package org.sps.service.goods;
import org.sps.entity.goods.SpsGoodSku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodSkuService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsGoodSku goodSku);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsGoodSku findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsGoodSku> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    HashMap<String,Object> findGoodSkuList(Integer page, Integer limit, String goodsName, String spuNo, String size);
}
