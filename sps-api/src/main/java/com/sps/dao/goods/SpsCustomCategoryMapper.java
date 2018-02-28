package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsCustomCategory;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsCustomCategoryMapper extends ApiBaseDaoImpl<SpsCustomCategory, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsCustomCategory";
    }
}