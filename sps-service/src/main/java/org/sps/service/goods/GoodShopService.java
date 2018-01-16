package org.sps.service.goods;
import org.sps.entity.goods.SpsGoodShop;
import org.sps.entity.goods.SpsGoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodShopService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsGoodShop goods);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsGoodShop findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsGoodShop> findList(Map<String, Object> map);

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
    HashMap<String,Object> findGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus,Integer flowStatus);

    /**
     * 获取最后的id
     * @return
     */
    SpsGoodShop findLastId();

    /**
     * 查询sku编号是否重复
     * @param gSpuNo
     * @return
     */
    Integer getEntityBySearchLimit(String gSpuNo,String spuName);

    void setSale(Integer id, String state);

    void setRecommend(Integer id, String state);
}
