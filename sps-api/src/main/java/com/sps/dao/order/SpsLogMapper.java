package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.order.SpsLog;
import com.sps.entity.order.SpsOrder;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsLogMapper extends ApiBaseDaoImpl<SpsLog, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsLog";
    }
}