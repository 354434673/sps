package com.sps.service.goods.impl;


import com.sps.dao.goods.SpsGoodCategoryMapper;
import org.springframework.stereotype.Service;
import org.sps.entity.goods.SpsGoodCategory;
import org.sps.service.goods.GoodCategoryService;

import javax.annotation.Resource;
import java.util.*;

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
        return null;
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
        return null;
    }
}
