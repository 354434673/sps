package org.sps.service.finance.read;

import org.sps.entity.finance.BankDrawAudio;

import java.util.HashMap;

/**
 * Created by Administrator on 2018-02-23.
 */
public interface CashAuditReadService {
    /**
     * 根据条件查询所有提现申请信息
     * @param page
     * @param limit
     * @param applicationStartDate
     * @param paymentDate
     * @param tradeStatus
     * @param name
     * @param account
     * @return
     */
    HashMap<String, Object> getBankTradeList(Integer page, Integer limit, String applicationStartDate, String paymentDate, String tradeStatus, String name, String account);

    /**
     * 根据客户名查询所以提现申请记录
     * @param page
     * @param limit
     * @return
     */
    HashMap<String, Object> getBankTradeAuditList(Integer page, Integer limit, String userName);

    /**
     * 根据申请日期查看交易信息
     * @param applicationDate
     * @return
     */
   BankDrawAudio getBankTradeAuditInfo(String  applicationDate);

}
