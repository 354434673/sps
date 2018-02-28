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
    HashMap<String,Object> findGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus,Integer flowStatus,String endTime,String startTime,String shopNum);

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

    /**
     * 平台审核上架商品列表
     * @param page
     * @param limit
     * @param shopName
     * @param goodsName
     * @param shopNumber
     * @param shopStatus
     * @param endTime
     * @param startTime
     * @return
     */
    HashMap<String,Object> findAutidGoodsList(Integer page, Integer limit, String shopName, String goodsName, String shopNumber, Integer shopStatus, String endTime, String startTime);

    /**
     * 审核商品
     * @param goods
     */
    void auditShopGood(SpsGoodShop goods);

    /**
     * 平台端强制下架商品
     * @param page
     * @param limit
     * @param shopName
     * @param goodsName
     * @param shopNumber
     * @param shopStatus
     * @param endTime
     * @param startTime
     * @return
     */
    HashMap<String,Object> findForceGoodsList(Integer page, Integer limit, String shopName, String goodsName, String shopNumber, Integer shopStatus, String endTime, String startTime,String spuNo);

    /**
     * 强制下架
     * @param goods
     */
    void forceShopGood(SpsGoodShop goods,String forceOpinion);

    /**
     * 商户详情查看商户商品列表
     * @param page
     * @param limit
     * @param goodsName
     * @param shopStatus
     * @param flowStatus
     * @param endTime
     * @param startTime
     * @param shopNum
     * @param spuNo
     * @return
     */
    HashMap<String,Object> findShopGoodsList(Integer page, Integer limit, String goodsName, Integer shopStatus, Integer flowStatus, String endTime, String startTime, String shopNum, String spuNo);
}
