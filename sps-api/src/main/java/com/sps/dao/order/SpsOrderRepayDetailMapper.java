package com.sps.dao.order;


import org.springframework.stereotype.Repository;

import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.order.SpsOrderRepayDetail;

@SuppressWarnings("unchecked")
@Repository
public class SpsOrderRepayDetailMapper extends ApiBaseDaoImpl<SpsOrderRepayDetail, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsOrderRepayDetail";
    }
}