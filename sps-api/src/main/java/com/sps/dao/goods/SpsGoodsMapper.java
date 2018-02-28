package com.sps.dao.goods;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsGoods;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodsMapper extends ApiBaseDaoImpl<SpsGoods, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsGoods";
    }

    public SpsGoods findLastId() {
        return super.selectOne(getStatement("findLastId"),null);
    }

    public Integer getEntityBySearchLimit(String gSpuNo) {
        return super.selectOne(getStatement("findSkuNoCount"),gSpuNo);
    }
}