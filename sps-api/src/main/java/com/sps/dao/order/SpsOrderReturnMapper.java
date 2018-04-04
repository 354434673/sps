package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.order.SpsOrderReturn;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsOrderReturnMapper extends ApiBaseDaoImpl<SpsOrderReturn, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsOrderReturn";
    }

    public SpsOrderReturn findEntityByOrderNo(String orderNo) {
        return super.selectOne(getStatement("findEntityByOrderNo"), orderNo);
    }
}