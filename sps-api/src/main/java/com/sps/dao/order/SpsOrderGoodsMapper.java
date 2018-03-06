package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.order.SpsOrderGoods;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsOrderGoodsMapper extends ApiBaseDaoImpl<SpsOrderGoods, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsOrderGoods";
    }
}