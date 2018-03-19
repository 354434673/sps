package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.goods.SpsBrand;
import com.sps.entity.order.SpsOrder;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsOrderMapper extends ApiBaseDaoImpl<SpsOrder, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsOrder";
    }
}