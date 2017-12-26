package com.sps.service.goods.impl;


import com.sps.dao.goods.SpsGoodCategoryMapper;
import com.sps.entity.goods.SpsGoodCategory;
import com.sps.service.goods.GoodCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class GoodCategoryServiceImpl  implements GoodCategoryService {
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
}
