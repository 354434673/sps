package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsBrand;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsBrandMapper extends ApiBaseDaoImpl<SpsBrand, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsBrand";
    }
}