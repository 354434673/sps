package com.sps.controller.finance;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.finance.BankDrawAudio;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.finance.read.CashAuditReadService;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-02-26.
 */
@Controller
@RequestMapping("/incomePayment")
public class IncomePaymentController {
    @Reference(check=false,group="dianfu")
    private CashAuditReadService cashAuditService;
    @Reference(check=false,group="dianfu")
    private ChannelBankTradeWriteService bankTradeWriteService;

    /**
     * 查询交易详情
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

    @RequestMapping("/findIncomePaymentList")
    @ResponseBody
    public HashMap<String, Object> findIncomePaymentList(Integer page, Integer limit, String startTime, String endTime,
                                                       BigDecimal minAmount,BigDecimal maxAmount,String payType,String companyName,String reamrk) {
        HashMap<String, Object> list = cashAuditService.getBankTradeIncomePayList(page,limit,startTime,endTime,minAmount,maxAmount,payType,companyName,reamrk);
        return list;


    }

    /**
     * 查询所有收入类型
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
    @RequestMapping("/findIncomeList")
@ResponseBody
public HashMap<String, Object> findIncomeList(Integer page, Integer limit, String startTime, String endTime,
                                              BigDecimal minAmount,BigDecimal maxAmount, String companyName, String reamrk) {
    HashMap<String, Object> list =cashAuditService.getBankTradeIncomeList(page,limit,startTime,endTime,minAmount,maxAmount,"2",companyName,reamrk);
    return list;
}

    /**
     * 查询所有的支出类型
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
    @RequestMapping("/findPayment")
    @ResponseBody
    public HashMap<String, Object> findPayment(Integer page, Integer limit, String startTime, String endTime,
                                                  BigDecimal minAmount,BigDecimal maxAmount, String companyName, String reamrk) {
        HashMap<String, Object> list =cashAuditService.getBankTradePaymentList(page,limit,startTime,endTime,minAmount,maxAmount,"1",companyName,reamrk);
        return list;
    }
}
