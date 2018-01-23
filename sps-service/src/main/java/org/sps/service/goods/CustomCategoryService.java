package org.sps.service.goods;
import org.sps.entity.goods.SpsCustomCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CustomCategoryService{

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsCustomCategory customCategory);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsCustomCategory findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsCustomCategory> findList(Map<String, Object> map);

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
    HashMap<String,Object> findCustomCategoryList(Integer page, Integer limit, String name);
}
