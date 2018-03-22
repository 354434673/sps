package com.sps.dao.order;
import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.order.SpsBankTradeInfo;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsBankTradeInfoMapper extends ApiBaseDaoImpl<SpsBankTradeInfo, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsBankTradeInfo";
    }
}