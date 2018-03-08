package com.sps.service.goods;

import com.sps.entity.goods.SpsBrand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 新增或者修改品牌
     */
    void saveOrUpdate(SpsBrand brand);

    /**
     * 查看详情
     * @param id
     * @return
     */
    SpsBrand findEntityById(Integer id);
    /**
     * 查询集合
     * @param
     * @return
     */
    List<SpsBrand> findList(Map<String, Object> map);

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
    HashMap<String,Object> findBrandList(Integer page, Integer limit, String brandName, String brandEnglishName);

    HashMap<String,Object> findBrand(Map<String, Object> map);


}
