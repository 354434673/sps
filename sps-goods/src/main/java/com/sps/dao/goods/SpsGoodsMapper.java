package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsGoods;

@SuppressWarnings("unchecked")
@Repository
public class SpsGoodsMapper extends BaseDaoImpl<SpsGoods, Integer> {
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