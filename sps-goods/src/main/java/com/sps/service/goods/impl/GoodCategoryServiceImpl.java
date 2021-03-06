package com.sps.service.goods.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.goods.SpsBrandMapper;
import com.sps.dao.goods.SpsGoodCategoryMapper;

import org.sps.entity.goods.SpsBrand;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.service.goods.GoodCategoryService;

import javax.annotation.Resource;
import java.util.*;

@Service(timeout = 1200000,group="dianfu")
public class GoodCategoryServiceImpl implements GoodCategoryService {
    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;
    @Resource
    private SpsBrandMapper spsBrandMapper;

    @Override
    public void saveOrUpdate(org.sps.entity.goods.SpsGoodCategory category) {
        if (category.getCategoryId() != null) {
            category.setCategoryUpdateTime(new Date());
            spsGoodCategoryMapper.update(category);
        } else {
            if (category.getCategoryParentId() == null) {
                category.setCategoryParentId(0);
            }
            category.setCategoryDeleteFlag(0);
            category.setCategoryCreateTime(new Date());
            spsGoodCategoryMapper.insert(category);
        }
    }

    @Override
    public org.sps.entity.goods.SpsGoodCategory findEntityById(Integer id) {
        return spsGoodCategoryMapper.findById(id);
    }

    @Override
    public List<org.sps.entity.goods.SpsGoodCategory> findList(Map<String, Object> map) {
        return spsGoodCategoryMapper.findListAllWithMap(map);
    }

    @Override
    public List<org.sps.entity.goods.SpsGoodCategory> getJson(List<org.sps.entity.goods.SpsGoodCategory> categoryList) {
        List<SpsGoodCategory> list = new ArrayList<>();
        SpsGoodCategory spsCategory = null;
        for (SpsGoodCategory category : categoryList) {
            spsCategory = new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setName(category.getCategoryName());
            //查找子类
            List<SpsGoodCategory> getChildren = getChildren(category.getCategoryId());
            if (getChildren.size() != 0) {
                spsCategory.setChildren(getChildren);
            }
            list.add(spsCategory);
        }
        return list;
    }

    @Override
    public List<SpsGoodCategory> getTwoCategoryJson(List<SpsGoodCategory> categoryList) {
        List<SpsGoodCategory> list = new ArrayList<>();
        SpsGoodCategory spsCategory = null;
        for (SpsGoodCategory category : categoryList) {
            spsCategory = new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setName(category.getCategoryName());
            //查找子类
            List<SpsGoodCategory> getChildren = getTowChildren(category.getCategoryId());
            if (getChildren.size() != 0) {
                spsCategory.setChildren(getChildren);
            }
            list.add(spsCategory);
        }
        return list;
    }

    @Override
    public List<SpsGoodCategory> findLastCategory(String ids) {
        List list = new ArrayList<>();
        if (ids != null && !"".equals(ids)) {
            String[] id = ids.split(",");
            for (String ides : id) {
                Map<String, Object> map = new HashMap<>();
                map.put("categoryId", ides);
                List<SpsGoodCategory> selectChildern = this.findList(map);
                SpsGoodCategory spsCategory;
                List<SpsGoodCategory> childernList = new ArrayList<>();
                for (SpsGoodCategory category : selectChildern) {
                    spsCategory = new SpsGoodCategory();
                    spsCategory.setId(category.getCategoryId());
                    spsCategory.setTitle(category.getCategoryName());
                    childernList.add(spsCategory);
                    List<SpsGoodCategory> getGrandson = getGrand(category.getCategoryId());
                    spsCategory.setChildren(getGrandson);
                    list.add(spsCategory);
                }
            }
        }
        return list;
    }

    @Override
    public void falseDeletion(Integer id) {
        if(id != null) {
            //判断是否有下级
            Map<String, Object> map = new HashMap<>();
            map.put("categoryId", id);
            List<SpsGoodCategory> selectChildern = this.findList(map);
            if (selectChildern!=null&&selectChildern.size()>0){
                for ( SpsGoodCategory list:selectChildern) {
                    list.setCategoryId(id);
                    list.setCategoryDeleteFlag(1);
                    spsGoodCategoryMapper.update(list);
                }
            }else {
                SpsGoodCategory category = new SpsGoodCategory();
                category.setCategoryId(id);
                category.setCategoryDeleteFlag(1);
                spsGoodCategoryMapper.update(category);
            }
            //品牌中包含分类的全至为空
            Map<String, Object> brandMap = new HashMap<>();
            brandMap.put("categoryId", id);
            List<SpsBrand> brandList = spsBrandMapper.findListAllWithMap(brandMap);
            if (brandList != null && brandList.size() > 0) {
                for(SpsBrand list:brandList){
                    if(list.getBrandCategoryIds()!=null){
                        list.setBrandCategoryIds("");
                        spsBrandMapper.update(list);
                    }
                }
            }
        }
    }

    private List<SpsGoodCategory> getTowChildren(Integer categoryId) {
        List<SpsGoodCategory> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        List<SpsGoodCategory> selectChildern = this.findList(map);
        SpsGoodCategory spsCategory;
        List<SpsGoodCategory> childernList = new ArrayList<>();
        for (SpsGoodCategory category : selectChildern) {
            spsCategory = new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setName(category.getCategoryName());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            childernList.add(spsCategory);
            list.add(spsCategory);

        }
        return childernList;
    }

    private List<SpsGoodCategory> getChildren(Integer categoryId) {
        List<SpsGoodCategory> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        List<SpsGoodCategory> selectChildern = this.findList(map);
        SpsGoodCategory spsCategory;
        List<SpsGoodCategory> childernList = new ArrayList<>();
        for (SpsGoodCategory category : selectChildern) {
            spsCategory = new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setName(category.getCategoryName());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            childernList.add(spsCategory);
            List<SpsGoodCategory> getGrandson = getGrandson(category.getCategoryId());
            if (getGrandson.size() != 0) {
                spsCategory.setChildren(getGrandson);
            }
            list.add(spsCategory);
        }
        return childernList;
    }

    private List<SpsGoodCategory> getGrandson(Integer categoryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        List<SpsGoodCategory> selectChildern = this.findList(map);
        SpsGoodCategory spsCategory;
        List<SpsGoodCategory> childernList = new ArrayList<>();
        for (SpsGoodCategory category : selectChildern) {
            spsCategory = new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setName(category.getCategoryName());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            childernList.add(spsCategory);
        }
        return childernList;
    }

    private List<SpsGoodCategory> getGrand(Integer categoryId) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        List<SpsGoodCategory> selectChildern = this.findList(map);
        SpsGoodCategory spsCategory;
        List<SpsGoodCategory> childernList = new ArrayList<>();
        List<SpsGoodCategory> list = new ArrayList<>();
        for (SpsGoodCategory category : selectChildern) {
            spsCategory = new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setTitle(category.getCategoryName());
            spsCategory.setChildren(list);
            childernList.add(spsCategory);
        }
        return childernList;
    }

/*    @Resource
    private SpsGoodCategoryMapper spsGoodCategoryMapper;
    @Override
    public void saveOrUpdate(SpsGoodCategory category) {

    }

    @Override
    public SpsGoodCategory findEntityById(Integer id) {
        return null;
    }


    @Override
    public List<SpsGoodCategory> findList(Map<String, Object> map) {
        return spsGoodCategoryMapper.findListAllWithMap(map);
    }

    @Override
    public List<SpsGoodCategory> getJson(List<SpsGoodCategory> categoryList) {
        List<SpsGoodCategory> list = new ArrayList<>();
        SpsGoodCategory spsCategory= null;
        for (SpsGoodCategory category : categoryList) {
            spsCategory=new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setName(category.getCategoryName());
            //查找子类
            List<SpsGoodCategory> getChildren = getChildren(category.getCategoryId());
            if(getChildren.size()!= 0){
                spsCategory.setChildren(getChildren);
            }
            list.add(spsCategory);
        }
        return list;
    }

    private List<SpsGoodCategory> getChildren(Integer categoryId) {
        Map<String,Object> map=new HashMap<>();
        map.put("categoryId",categoryId);
        List<SpsGoodCategory> selectChildern = this.findList(map);
        SpsGoodCategory spsCategory;
        List<SpsGoodCategory> childernList = new ArrayList<>();
        for (SpsGoodCategory category : selectChildern) {
            spsCategory=new SpsGoodCategory();
            spsCategory.setId(category.getCategoryId());
            spsCategory.setName(category.getCategoryName());
            spsCategory.setCategoryWeight(category.getCategoryWeight());
            spsCategory.setCategoryDes(category.getCategoryDes());
            spsCategory.setCategoryUrl(category.getCategoryUrl());
            childernList.add(spsCategory);
        }
        return childernList;
    }*/


}
