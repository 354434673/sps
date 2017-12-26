package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.goods.SpsGoodCategory;

public class SpsBrandMapper extends BaseDaoImpl<SpsGoodCategory, Integer> {

    @Override
    public String getNameSpace() {
        return "sqlmap.SpsBrand";
    }
}