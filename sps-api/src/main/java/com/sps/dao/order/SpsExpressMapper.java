package com.sps.dao.order;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.express.SpsExpress;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsExpressMapper extends ApiBaseDaoImpl<SpsExpress, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsExpress";
    }
}