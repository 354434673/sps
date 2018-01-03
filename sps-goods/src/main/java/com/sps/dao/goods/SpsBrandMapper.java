package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsBrand;

@SuppressWarnings("unchecked")
@Repository
public class SpsBrandMapper extends BaseDaoImpl<SpsBrand, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsBrand";
    }
}