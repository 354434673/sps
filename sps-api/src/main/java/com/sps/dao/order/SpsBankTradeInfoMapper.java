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

    public SpsBankTradeInfo findBySerialNumber(String serialNumber) {
        return super.selectOne(getStatement("findBySerialNumber"), serialNumber);
    }

    public int updateBySerialNumber(SpsBankTradeInfo bankTradeInfo) {
        return super.updateByValue(getStatement("updateBySerialNumber"), bankTradeInfo);
    }

    public int insert(SpsBankTradeInfo bankTradeInfo) {
        return super.insert(bankTradeInfo);
    }
}