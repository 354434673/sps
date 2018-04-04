package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.order.SpsOrderLogistics;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsOrderLogisticsMapper extends ApiBaseDaoImpl<SpsOrderLogistics, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsOrderLogistics";
    }
}