package com.sps.controller.account;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.HttpClientUtils;
import com.sps.common.JsonResult;
import com.sps.controller.BaseApi;
import com.sps.entity.bank.SpsBank;
import com.sps.entity.order.SpsBankTradeInfo;
import com.sps.enums.ReturnCode;
import com.sps.service.bank.BankService;
import com.sps.service.order.TradeInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther sunchao
 * @Descript 用户提现
 * @DATE 2018/4/8.
 */
@RestController
@RequestMapping("/api/userOperation")
public class AccountOperationController extends BaseApi{

    private static  final Log log = LogFactory.getLog(AccountOperationController.class);

    //核心提现申请接口
    private static String freezeCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/freezeCustomerAccount";
    //核心用户余额接口
    private static String getUserAmont = "http://dev.app.chezhubaitiao.com/api/customerAccount/getCustomerAccount";
    //获取连连银行编号
    private static String getNumberByName = "http://dev.pay.juzifenqi.com/juzi-pay/immediateRequest/getBankInfo";

    @Resource
    private BankService bankService;

    @Resource
    private TradeInfoService tradeInfoService;


    /**
     * 用户提现操作
     * @param amount
     * @param customerId
     * @return
     */
    @RequestMapping("/withdrawals")
    public JsonResult userWithdrawals(BigDecimal amount,String customerId){
        log.info("start--开始执行用户提现操作，请求参数 amount:"+amount+",customerId:"+customerId);
        try{
            if (StringUtils.isBlank(customerId)||amount.compareTo(BigDecimal.ZERO)==0){
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            // TODO: 2018/4/8  请求核心，发起提现申请
            //封装请求参数
            SpsBank bank = bankService.findEntityByNo(customerId);
            Map map = new HashMap<>();
            map.put("amount", amount);
            map.put("application", "dianfu");
            map.put("certNo", bank.getbIdentity());
            map.put("logType", "020");
            log.info("ing--请求核心提现接口，请求参数"+JSON.toJSONString(map));
            //请求核心发起提现操作
            String jsonResult = HttpClientUtils.post(freezeCustomerAccount, map);
            //核心返回参数
            log.info("ing--请求核心提现接口，返回参数"+ jsonResult);
            if (StringUtils.isBlank(jsonResult)){
                return returnFaild();
            }
            JSONObject job = JSON.parseObject(jsonResult);
            if (!"100000".equals(job.getString("code"))) {
                return returnFaild(job.getString("msg"));
            }
            // TODO: 2018/4/9 admin端审核通过后推送支付系统
            // 支付系统回调店付  true/调用核心 扣减金额接口，false/调用核心 按身份证号解冻账户金额 解冻用户金额
            // TODO: 2018/4/8  请求核心获取账户余额
            //获取用户核心余额
            BigDecimal big = new BigDecimal(0.00);
            map = new HashMap<>();
            map.put("application","dianfu");
            map.put("certNo",bank.getbIdentity());
            String userAmountJson = HttpClientUtils.post(getUserAmont, map);
            if (!StringUtils.isBlank(userAmountJson)){
                JSONObject jobs = JSON.parseObject(jsonResult);
                if ("100000".equals(jobs.getString("code"))) {
                    big = new BigDecimal(jobs.getJSONObject("result").getString("validAmount"));
                }
            }
            // TODO: 2018/4/8  插入交易记录
            //插入数据库用户请求
            SpsBankTradeInfo info = new SpsBankTradeInfo();
            //商户编号
            info.setBtTradeName(customerId);
            //身份证
            info.setBtIdentity(bank.getbIdentity());
            //交易类型 0支出，1收入
            info.setBtTradeType("0");
            //支出类型 0 体现，1支付订单首付，2 还款，3 平台减少
            info.setBtExpenditureType("0");
            //交易前金额
            info.setBtTradeBeforeBalanc(big);
            //交易后金额
            info.setBtTradeAfterBalanc(big.subtract(amount));
            //交易金额
            info.setBtTradeAmount(amount);
            //交易状态0为待审核，1审核不通过 2审核通过
            info.setBtTradeStatus("0");
            //备注信息：体现还是充值'
            info.setStandby1("提现");
            //银行code
            info.setBankCardType(bank.getbBankCode());
            //银行名称
            info.setBankCardName(bank.getbBankName());
            //银行卡号
            info.setBankCardNumber(bank.getbAccounts());

            tradeInfoService.insert(info);
            return returnSuccess();
        }catch (Exception e){
            log.info("end--用户提现操作，操作异常 "+e.getMessage());
            return returnFaild();
        }
    }

    /**
     * 提现支付系统回调
     * @param returnValue
     * @return
     */
    @RequestMapping("/backWithdrawals")
    public JsonResult backWithdrawals(String returnValue){
        log.info("start--用户提现支付回调参数"+returnValue);
        try{
            if(StringUtils.isBlank(returnValue)){
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            JSONObject json = JSON.parseObject(returnValue);
            //插入数据库用户请求
            SpsBankTradeInfo infos = new SpsBankTradeInfo();
            String[] backStr = json.getString("transNum").split("i");

            //state:1交易成功，2交易失败，3交易成功需退款
            if(!"1".equals(json.getString("state"))){
                //最后状态
                infos.setRechargeStatus(0);
                //交易号
                infos.setBtTradeNo(backStr[0]);
                //更新
                tradeInfoService.updateBySerialNumber(infos);
                return returnSuccess();
            }
            // TODO: 2018/4/8  根据返回参数获取请求流水表数据
            SpsBankTradeInfo info = tradeInfoService.findBySerialNumber(backStr[1]);
            if(info==null){
               return returnFaild(ReturnCode.SAFE_SYSTEM_MESSAGE.getMsg());
            }
            // TODO: 2018/4/8    数据库添加字段 已经处理当前回调  待开发
            //更新流水表
            // TODO: 2018/4/8  插入交易记录
            //最后状态
            infos.setRechargeStatus(0);
            //交易号
            infos.setBtTradeNo(backStr[0]);
            //更新
            tradeInfoService.updateBySerialNumber(infos);
            return  returnSuccess();
        }catch (Exception e){
            log.info("end--用户提现回调处理出现异常"+e.getMessage());
            return returnFaild();
        }
    }
}
