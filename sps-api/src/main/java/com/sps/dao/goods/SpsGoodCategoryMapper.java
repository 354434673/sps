package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsGoodCategory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodCategoryMapper extends ApiBaseDaoImpl<SpsGoodCategory, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoodCategory";
    }


}