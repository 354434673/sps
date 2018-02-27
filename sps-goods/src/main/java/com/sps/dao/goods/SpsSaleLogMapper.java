package com.sps.dao.goods;


import com.sps.dao.goods.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import org.sps.entity.goods.SpsSaleLog;

@SuppressWarnings("unchecked")
@Repository
public class SpsSaleLogMapper extends BaseDaoImpl<SpsSaleLog, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsSaleLog";
    }
}