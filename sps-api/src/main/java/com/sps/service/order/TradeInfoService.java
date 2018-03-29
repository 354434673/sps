package com.sps.service.order;

import com.sps.entity.order.SpsBankTradeInfo;
import java.util.List;
import java.util.Map;

public interface TradeInfoService {

    /**
     * 新增或者修改
     */
    void saveOrUpdate(SpsBankTradeInfo order);

    /**
     * 根据交易流水查询交易明细
     * @param serialNumber
     * @return
     */
    SpsBankTradeInfo findBySerialNumber(String serialNumber);

    /**
     * 根据交易流水修改明细
     * @param bankTradeInfo
     * @return
     */
    int updateBySerialNumber(SpsBankTradeInfo bankTradeInfo);
}
