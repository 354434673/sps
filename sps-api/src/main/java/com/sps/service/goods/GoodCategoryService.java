package com.sps.service.goods;

import com.sps.entity.goods.SpsGoodCategory;

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



    /**
     * 组装JSON
     * @param categoryList
     * @return
     */
    List<SpsGoodCategory> getJson(List<SpsGoodCategory> categoryList);

    /**
     * 添加页面使用  只显示2J分类
     * @param categoryList
     * @return
     */
    List<SpsGoodCategory> getTwoCategoryJson(List<SpsGoodCategory> categoryList);
    /**
     * 查询二级三级分类
     * @param ids
     * @return
     */
    List<SpsGoodCategory> findLastCategory(String ids);
}
