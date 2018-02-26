package com.sps.service.goods;

import com.sps.entity.goods.SpsGoods;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodsService extends Serializable{

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsGoods goods);

    /**
     * 查看详情
     * @return
     */
    SpsGoods findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsGoods> findList(Map<String, Object> map);

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
    HashMap<String,Object> findGoodsList(Integer page, Integer limit, String goodsName, String spuNo, String flowStatus);

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

    /**
     * 审核中的商品
     * @param map
     * @return
     */
    List<SpsGoods> findAuditList(Map<String, Object> map);
}
