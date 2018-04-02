package com.sps.controller.account;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.JsonResult;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.controller.BaseApi;
import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.account.vo.BankTradeInfoVo;
import com.sps.entity.user.SpsUser;
import com.sps.enums.ReturnCode;
import com.sps.service.account.balance.AccountBalanceService;
import com.sps.service.account.bankCard.BankCardService;
import com.sps.service.account.bankTrade.BankTradeService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sps.service.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2018-03-09.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@RestController
@RequestMapping("/api/accountTrade")
public class AccountTradeController extends BaseApi{
    private static  final Log log = LogFactory.getLog(AccountTradeController.class);
    @Autowired
    private AccountBalanceService accountBalanceService;
    @Autowired
    private BankTradeService bankTradeService;
    @Autowired
    private BankCardService bankCardService;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopkeeperPersonService shopkeeperPersonService;
    @Autowired
    private ShopkeeperService shopkeeperService;


    @RequestMapping(value = "/findTradeList")
    public JsonResult findTradeList( @RequestParam("customerId") String customerId) {
        //  根据登录用户名获取用户id
        try{
            if(StringUtils.isBlank(customerId)){
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            log.info("start--请求获取最近三个月交易明细，请求参数 "+customerId);
            List<BankTradeInfoVo> bankTrdeList = bankTradeService.findBankTrdeShowList(customerId);
            if(bankTrdeList==null){
                return returnFaild();
            }
            return returnSuccess(bankTrdeList);
        }catch (Exception e){
            log.info("end--请求获取最近三个月交易明细，异常 "+e.getMessage());
            return returnFaild();
        }
    }
    /**
     * 根据交易类型获取信息 0 标识支出 1标识收入 ,2标识全部
     */


    @RequestMapping(value = "/findTradeListByTradeType")
    public String findTradeListByTradeType(  @RequestParam("customerId") String customerId, @RequestParam("tradeType") Integer tradeType ) {
        ReturnInfo returnInfo = new ReturnInfo();
        JSONObject jsonO = new JSONObject();
        List<BankTradeInfo> bankTrdeList=null;
        try {
            if (tradeType!=2){
                bankTrdeList= bankTradeService.findBankTrdeListByTradeType(customerId,String.valueOf(tradeType));
            }else{
                bankTrdeList = bankTradeService.findBankTrdeList(customerId);
            }
            jsonO.put("bankTrdeList",bankTrdeList);
           return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,jsonO);
        } catch (Exception e) {
            e.printStackTrace();
            jsonO.put("bankTrdeList",null);
            return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG,jsonO);
        }
    }

    /**
     * 查询交易详情
     * @param
     * @param
     * @param id
     * @return
     */
    @RequestMapping(value = "/findTradeDetail")
    public String findTradeDetail( @RequestParam("id") Integer id ) {
        JSONObject jsonO = new JSONObject();
        BankTradeInfo bankTradeDetail = bankTradeService.findBankTradeDetail(id);
        if(bankTradeDetail != null){
            jsonO.put("bankTradeDetail",bankTradeDetail);
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
        jsonO.put("bankTradeDetail",null);
        return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG, jsonO);
    }



    public JsonResult getTreeMonthDetial(String customerNum){


        return returnFaild();
    }

}

