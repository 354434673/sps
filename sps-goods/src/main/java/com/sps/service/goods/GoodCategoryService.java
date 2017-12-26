package com.sps.service.goods;

import com.sps.entity.goods.SpsGoodCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GoodCategoryService {
    /**
     * 新增或者修改商品分类
     * @param category
     */
    void saveOrUpdate(SpsGoodCategory category);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsGoodCategory findEntityById(Integer id);
    /**
     * 查看详情
     * @param
     * @return
     */
    List<SpsGoodCategory> findList(Map<String, Object> map);
}
