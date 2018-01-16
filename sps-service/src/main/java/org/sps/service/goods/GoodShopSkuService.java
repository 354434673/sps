package org.sps.service.goods;
import org.sps.entity.goods.SpsGoodShop;
import org.sps.entity.goods.SpsGoodShopSku;
import org.sps.entity.goods.SpsGoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodShopSkuService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsGoodShopSku goods);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsGoodShopSku findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsGoodShopSku> findList(Map<String, Object> map);

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
    HashMap<String,Object> findGoodsList(Integer page, Integer limit, String goodsName, String spuNo);

    /**
     * 获取最后的id
     * @return
     */
    SpsGoods findLastId();

    /**
     * 查询sku编号是否重复
     * @param gSpuNo
     * @return
     */
    Integer getEntityBySearchLimit(String gSpuNo);
}
