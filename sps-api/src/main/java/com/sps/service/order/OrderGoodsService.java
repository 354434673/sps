package com.sps.service.order;

import com.sps.entity.goods.SpsBrand;
import com.sps.entity.order.SpsOrderGoods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderGoodsService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsOrderGoods orderGoods);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsOrderGoods findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsOrderGoods> findList(Map<String, Object> map);

    /**
     * 逻辑删除
     * @param id
     */
    void falseDeletion(Integer id);

}
