package com.sps.controller.finance;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.finance.BankDrawAudio;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.finance.read.CashAuditReadService;
import org.sps.service.finance.write.CashAuditWriteService;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;
import org.sps.service.merchant.write.ChannelBankWriteService;

import java.util.HashMap;

/**
 * Created by Administrator on 2018-02-23.
 */
@Controller
@RequestMapping("/cashAudit")
public class CashAuditController {
    @Reference(check=false,group="dianfu")
    private CashAuditReadService cashAuditService;
    @Reference(check=false,group="dianfu")
    private ChannelBankTradeWriteService bankTradeWriteService;
    //查询所有提现审核记录
    @RequestMapping("/findAudioList")
    @ResponseBody
    public HashMap<String, Object> findAudioList(Integer page, Integer limit, String applicationDate, String payDate, String status,String companyName,String userName) {
        HashMap<String, Object> list = cashAuditService.getBankTradeList(page, limit, applicationDate, payDate, status, companyName, userName);
        return list;
    }

    /**
     * 获取历史记录
     * @param userName
     * @return
     */
    @RequestMapping("/findAuditDetail")
    @ResponseBody
    public HashMap<String, Object> findAuditDetail(Integer page, Integer limit,String userName) {
        HashMap<String, Object> list = cashAuditService.getBankTradeAuditList(page, limit, userName);
        return list;
    }


    @RequestMapping("/findAuditDetailByApplicationDate")
    @ResponseBody
    public  BankDrawAudio findAuditDetailByApplicationDate(String  applicationDate){
        BankDrawAudio bankTradeAuditInfo = cashAuditService.getBankTradeAuditInfo(applicationDate);
        return bankTradeAuditInfo;
    }

//    @RequestMapping("/saveAuditStatus")
//    @ResponseBody
//    public Result saveAuditStatus(String  applicationDate){
//        Result<Boolean> result = new Result<Boolean>();
//        Boolean flag= true;
//        result.setBody(flag);
//        result.success();
//        result.setMsg(flag ? "成功" : "保存失败");
//        return result;
//    }
    @RequestMapping("/saveAuditStatus")
    @ResponseBody
    public Result saveAuditStatus(String  applicationDate,String type){

        Boolean flag = bankTradeWriteService.modifyBankTradeByApplicateDate(applicationDate,type);
        Result<Boolean> result = new Result<Boolean>();
        result.setBody(flag);
        result.setMsg(flag ? "成功" : "保存失败");
        return result;
    }
}
