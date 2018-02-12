package com.sps.service.goods.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.sps.entity.goods.SpsBrand;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.service.goods.BrandService;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.dao.goods.SpsGoodsMapper;

@Service(timeout = 1200000,group="dianfu")
public class BrandServiceImpl implements BrandService {
    @Resource
    private SpsBrandMapper spsBrandMapper;
    @Resource
    private SpsGoodsMapper SpsGoodsMapper;
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;

    @Override
    public void saveOrUpdate(SpsBrand brand) {
        if (brand.getBrandId() != null) {

            brand.setBrandUpdateTime(new Date());
            spsBrandMapper.update(brand);
        } else {
            brand.setBrandDeleteFlag(0);
            brand.setBrandCreateTime(new Date());
            spsBrandMapper.insert(brand);
        }
    }

    @Override
    public SpsBrand findEntityById(Integer id) {
        return spsBrandMapper.findById(id);
    }

    @Override
    public List<SpsBrand> findList(Map<String, Object> map) {
        return spsBrandMapper.findListAllWithMap(map);
    }


    @Override
    public HashMap<String, Object> findBrandList(Integer page, Integer limit, String brandName, String brandEnglishName) {

        Map<String, Object> map = new HashMap<>();
        map.put("brandName", brandName);
        map.put("brandEnglishName", brandEnglishName);
        //分页
        PageHelper.startPage(page, limit);
        List<SpsBrand> brandList = spsBrandMapper.findListAllWithMap(map);
        if (brandList != null && brandList.size() > 0) {
            for (SpsBrand list : brandList) {
                String[] ids = list.getBrandCategoryIds().split(",");
                if (ids != null && ids.length > 0) {
                    String categoryNames = "";
                    for (String id : ids) {
                        SpsGoodCategory category = spsGoodCategoryMapper.findById(Integer.valueOf(id));
                        categoryNames += ">" + category.getCategoryName();
                    }
                    list.setBrandCategoryNames(categoryNames.substring(1));
                }
            }
        }
        PageInfo pageInfo = new PageInfo(brandList);
        //放入map
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", pageInfo.getTotal());
        hashMap.put("data", brandList.size() != 0 ? brandList : null);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findBrand(Map<String, Object> map) {
       /* Map<String, Object> map1 = new HashMap<>();
        List<SpsBrand> brandList = spsBrandMapper.findListAllWithMap(map);
        map1.put("brandList",brandList);
        return map1;*/
        return null;
    }

    @Override
    public void falseDeletion(Integer id) {
        SpsBrand brand = new SpsBrand();
        brand.setBrandId(id);
        brand.setBrandDeleteFlag(1);
        spsBrandMapper.update(brand);
    }


}
