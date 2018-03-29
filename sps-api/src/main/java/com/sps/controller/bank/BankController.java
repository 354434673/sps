package com.sps.controller.bank;

import com.sps.common.EntityUtiles;
import com.sps.common.EntityUtils;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.bank.SpsBank;
import com.sps.entity.goods.*;
import com.sps.service.bank.BankService;
import com.sps.service.goods.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/bank")
public class BankController {
    @Resource
    private BankService bankService;
    /**
     * 根据商户编号查询银行卡
     *
     * @return
     */
    @RequestMapping(value = "/findBankByCustomerId", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findEntity(String customerId ) {
        ReturnInfo ri = new ReturnInfo();
        try {
            HashMap<String, Object> data = new HashMap<>();//封装对象
            SpsBank bank = bankService.findEntityByNo(customerId);
            data.put("id", bank.getId());
            data.put("bankName",bank.getbBank());
            data.put("bankNum", bank.getbAccounts());
            data.put("userName", bank.getbName());
            data.put("userCardNum", bank.getbIdentity());
            data.put("phone", bank.getbPhone());
            if (data != null) {
                ri.setResult(data);
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }






}
