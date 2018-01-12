package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsCustomCategory;

@SuppressWarnings("unchecked")
@Repository
public class SpsCustomCategoryMapper extends BaseDaoImpl<SpsCustomCategory, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsCustomCategory";
    }
}