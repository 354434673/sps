package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.sps.entity.goods.SpsGoodCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodCategoryMapper extends BaseDaoImpl<SpsGoodCategory, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodCategory";
    }


}