package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrderLog;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsOrderLogMapper extends ApiBaseDaoImpl<SpsOrderLog, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsOrderLog";
    }
}