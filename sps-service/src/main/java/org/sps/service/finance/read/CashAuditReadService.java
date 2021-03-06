package org.sps.service.finance.read;

import org.sps.entity.finance.BankDrawAudio;
import org.sps.entity.finance.OrderDetail;

import java.math.BigDecimal;
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
     * 根据用户名查询所有的交易记录
     * @param loginName
     * @param page
     * @param limit
     * @param startTime
     * @param endTime
     * @param minAmount
     * @param maxAmount
     * @param payType
     * @param companyName
     * @param reamrk
     * @return
     */
    HashMap<String, Object> getBankTradeIncomePayListByloginName( String loginName, Integer page, Integer  limit, String startTime, String endTime, BigDecimal  minAmount,BigDecimal maxAmount, String payType, String companyName, String reamrk);

    /**
     * 查看收支信息
     * @param id
     * @return
     */
   BankDrawAudio getBankTradeAuditInfo(int   id);

    /**
     * 查询收支信息
     * @param page
     * @param limit
     * @param startTime
     * @param endTime
     * @param minAmount
     * @param maxAmount
     * @param payType
     * @param companyName
     * @param reamrk
     * @return
     */
    HashMap<String, Object> getBankTradeIncomePayList(Integer page, Integer  limit, String startTime, String endTime, BigDecimal  minAmount,BigDecimal maxAmount, String payType, String companyName, String reamrk);

    /**
     * 查询收入信息
     * @param page
     * @param limit
     * @param startTime
     * @param endTime
     * @param minAmount
     * @param maxAmount
     * @param companyName
     * @param reamrk
     * @return
     */
    HashMap<String, Object> getBankTradeIncomeList(Integer page, Integer  limit, String startTime, String endTime, BigDecimal  minAmount,BigDecimal maxAmount, String payType,String companyName, String reamrk);

    /**
     * 查询支出信息
     * @param page
     * @param limit
     * @param startTime
     * @param endTime
     * @param minAmount
     * @param maxAmount
     * @param companyName
     * @param reamrk
     * @return
     */
    HashMap<String, Object> getBankTradePaymentList(Integer page, Integer  limit, String startTime, String endTime, BigDecimal  minAmount,BigDecimal maxAmount,String payType, String companyName, String reamrk);

    /**
     * 根据交易记录查询订单信息
     * @param tradeSeriNum
     * @return
     */
    OrderDetail getTradeOrderInfo(String  tradeSeriNum);
}
