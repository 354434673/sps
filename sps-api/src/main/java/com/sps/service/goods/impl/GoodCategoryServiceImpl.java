package com.sps.service.goods.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.service.goods.GoodCategoryService;

@Service
public class GoodCategoryServiceImpl implements GoodCategoryService {
    @Resource
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
        return null;
    }

    @Override
    public List<SpsGoodCategory> getTwoCategoryJson(List<SpsGoodCategory> categoryList) {
        return null;
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

    @Override
    public String findListByIds(String ids) {
        String categoryNames = "";
        String[] idList = ids.split(",");
        for (String id : idList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", id);
            List<SpsGoodCategory> categoryList = spsGoodCategoryMapper.findListAllWithMap(map);
            if (categoryList!=null&&categoryList.size()>0){
                for (SpsGoodCategory list:categoryList) {
                    categoryNames += "," + list.getCategoryName();
                }
            }
        }
        return categoryNames.substring(1);
    }
}
