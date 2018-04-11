package com.sps.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.Result;
import com.sps.common.ReturnInfo;
import com.sps.service.user.UserService;
import com.sps.util.HttpClientUtils;
import com.sps.util.Md5Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.entity.merchant.SpsTradeLog;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;
import org.sps.service.merchant.write.ChannelBankWriteService;
import org.sps.service.merchant.write.SpsTradeLogWriteService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018-03-31.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping("/payRechange")
public class PayRechangeController {
    private  static  final Log Logger= LogFactory.getLog(PayRechangeController.class);

    private static String getMerchantAccount = "http://dev.app.chezhubaitiao.com/api/merchantAccount/getMerchantAccount";
    private static String pay = "http://dev.pay.juzifenqi.com/juzi-pay/payment/dianfu";
    private static String getCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/getCustomerAccount";
    private static String rechargeMoney = "http://dev.app.chezhubaitiao.com/api/customerAccount/recharge";


    @Reference(check=false,group="dianfu")
    private ChannelBankTradeWriteService bankTradeWriteService;
    @Reference(check=false,group="dianfu")
    private ChannelBankReadService bankReadService;
    @Reference(check=false,group="dianfu")
    private ChannelBankWriteService bankWriteService;
    @Reference(check=false,group="dianfu")
    private ChannelReadService readService;
    @Reference(check=false,group="dianfu")
    private ChannelBankTradeReadService bankTradereadService;
    @Reference(check=false,group="dianfu")
    private SpsTradeLogWriteService spsTradeLogWriteService;
    @Resource
    private UserService userService;

    /**
     * 支付接口
     *
     * @return
     */
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseBody
    public Result payment(String  withdrawAmt, String tradePwd) {
        Logger.info("保存充值方法"+"   payment"+"开始");
        Result<String> result = new Result<String>();
        //比对交易密码是否正确
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        Logger.info("根据用户名获取 密码"+"   findTradePassword"+"开始" +userName);
        String pwd = bankReadService.findTradePassword(userName);
        Logger.info("根据用户名获取 密码"+"   findTradePassword"+"结束" +pwd );
        Logger.info("根据用户名获取 盐"+"   findSalt"+"开始" + pwd);
        String salt = bankReadService.findSalt(userName);
        Logger.info("根据用户名获取 盐"+"   findSalt"+"开始" +salt);
        String pass = Md5Util.getMd5(tradePwd, salt);
        if (pass.equals(pwd)) {
            //  SpsUser user = userService.findByUserName(userName);
            //从当前登录用户中获取用户银行卡信息
            Logger.info("根据用户名获取银行卡信息"+"   getBankInfoByUserName"+"开始" +userName);
            SpsChannelBank bankInfo = bankReadService.getBankInfoByUserName(userName);
            Logger.info("根据用户名获取银行卡信息"+"   getBankInfoByUserName"+"结束" +bankInfo);
            Map resultMap = new HashMap<>();
            Logger.info("发送保护组装请求参数"+"   getBankInfoByUserName"+"开始");
            resultMap.put("amount", withdrawAmt);
            resultMap.put("application", "dianfu");
            resultMap.put("cardNo", bankInfo.getAccounts());
            resultMap.put("certNo", bankInfo.getIdentity());
            resultMap.put("customerId", "DF20180136191770");
            resultMap.put("customerName", bankInfo.getName());
            resultMap.put("mobile", bankInfo.getPhone());
            resultMap.put("notifyUrl", "http://123.56.24.208:8080/payRechange/payCallback");
            resultMap.put("orderId", "df2018328233");
            resultMap.put("payChannel", "baofu");
            resultMap.put("payGoal", "D");
            resultMap.put("payType", "pay");
            resultMap.put("tradeName", "店付充值");
            Logger.info("发送宝户请求开始 开始");
            String jsonResult = HttpClientUtils.post(pay, resultMap);
            Logger.info("发送宝户请求开始 结束" );
            if (jsonResult != null) {
                JSONObject object = JSONObject.parseObject(jsonResult);
                String code = object.getString("code");
                if ("000000".equals(code)) {
                    Logger.info("解析请求返回结果" );
                    String serialNumber = object.getJSONObject("data").getJSONObject("nomalReturn").getString("serialNumber");
                    String status = object.getJSONObject("data").getJSONObject("nomalReturn").getString("status");
                    if ("S".equals(status)) {
                        Logger.info("返回成功 组装业务逻辑开始" );
                        SpsChannelBankTrade bankTradeInfo = new SpsChannelBankTrade();
                        bankTradeInfo.setTradeNo(serialNumber);
                        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                        bankTradeInfo.setIdentity(bankInfo.getIdentity());
                        bankTradeInfo.setApplicationStartDate(new Date());
                        bankTradeInfo.setTradeSerialNum(uuid);
                        //0代表支出（提现），1代表收入（充值）
                        bankTradeInfo.setTradeType("1");
                        bankTradeInfo.setUserId(bankInfo.getUserId());
                        //交易状态 0 代表待审批，2 审批通过，1审批不通过
                        bankTradeInfo.setTradeStatus("2");
                        bankTradeInfo.setTradeName(bankInfo.getUserName());
                        bankTradeInfo.setTradeAmount(new BigDecimal(withdrawAmt));
                        bankTradeInfo.setAuditDate(new Date());
                        bankTradeInfo.setTradeBeforeBalanc(bankInfo.getAvailableBalance());
                        bankTradeInfo.setTradeName(bankInfo.getChannlNum());
                        bankTradeInfo.setStandby1("充值");

                        Logger.info("封装一条交易记录" );

                        /**根据身份证
                         * 去核心查询个人资金账户余额
                         */
                        Map map = new HashMap<>();
                        map.put("application", "dianfu");
                        map.put("businessId", bankInfo.getChannlNum());
                        Logger.info("根据身份证去核心查询个人资金账户余额 开始" );
                        //发送请求查询个人资金账户余额
                        String jsonRes = HttpClientUtils.post(getMerchantAccount, map);
                        Logger.info("根据身份证去核心查询个人资金账户余额 结束" );
                        bankTradeInfo.setRechargeStatus(2);
                        //银行卡充值
                        bankTradeInfo.setIncomeType("2");
                        String validAmount;
                        if (jsonRes != null) {
                            if ("000000".equals(code)) {
                                JSONObject obj = JSONObject.parseObject(jsonRes);
                                validAmount = obj.getJSONObject("result").getString("validAmount");
                                //更新交易前余额
                                bankTradeInfo.setTradeBeforeBalanc(new BigDecimal(validAmount));
                            }
                        }
                        //更新绑卡基本信息中的可用余额
                        Boolean flag = bankTradeWriteService.saveBankRechangeTradeInfo(userName,bankTradeInfo);
                        result.setCode(Message.SUCCESS_CODE);
                        result.setBody(serialNumber);
                        result.setMsg(flag ? "成功" : "保存失败");
                        return result;
                    }
                }
            }
            result.setBody(null);
            result.setMsg("支付接口调用异常");
            return result;
        }
        result.setBody(null);
        result.setMsg("密码输入有误");
        return result;
    }


    /**
     * 充值回调
     *
     * @return
     */
    @RequestMapping(value = "/payCallback", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo payCallback(String amount, String extParam, String failReason, String orderId, String payChannel, String payType, String period, String serialNumber, String sign, String status) {
        ReturnInfo ri = new ReturnInfo();
        try {
            if ("000000".equals(status)) {
                SpsChannelBankTrade spsBankTradeInfo = bankTradereadService.getTradeDetail(serialNumber);
                Map resultMap = new HashMap<>();
                resultMap.put("amount", amount);
                resultMap.put("application", "dianfu");
                resultMap.put("certNo", spsBankTradeInfo.getIdentity());
                resultMap.put("pattern", "5");
                resultMap.put("payOrder", serialNumber);
                String jsonResult = HttpClientUtils.post(rechargeMoney, resultMap);
                System.out.println(jsonResult);
                if (jsonResult != null) {
                    JSONObject job = JSON.parseObject(jsonResult);
                    String code = job.getString("code");
                    if ("100000".equals(code)) {
                        //去核心查询个人资金账户余额
                        // SpsChannelBankTrade bankTradeInfo = new SpsChannelBankTrade();
                        Map map = new HashMap<>();
                        map.put("application", "dianfu");
                        resultMap.put("businessId", spsBankTradeInfo.getChannel());
                        String jsonRes = HttpClientUtils.post(getMerchantAccount, map);
                        System.out.println(jsonRes);
                        if (jsonRes != null) {
                            if ("100000".equals(code)) {
                                JSONObject obj = JSONObject.parseObject(jsonRes);
                                SpsChannelBankTrade spsChannelBankTrade = new SpsChannelBankTrade();
                                String validAmount = obj.getJSONObject("result").getString("validAmount");
                                //设置充值状态、充值后交易金额、到账时间 ，交易序列号
                                spsChannelBankTrade.setTradeAfterBalanc(new BigDecimal(validAmount));
                                spsChannelBankTrade.setRechargeStatus(1);
                                spsChannelBankTrade.setPaymentDate(new Date());
                                spsChannelBankTrade.setTradeNo(serialNumber);
                                spsChannelBankTrade.setTradeSerialNum(spsBankTradeInfo.getTradeSerialNum());
                                Boolean flag = bankTradeWriteService.modifyRechangeStatus(spsChannelBankTrade);
                                if(flag) {
                                    ri.setCode(Message.SUCCESS_CODE);
                                    ri.setMsg(Message.API_SUCCESS_MSG);
                                    ri.setSuccess(Message.API_SUCCESS_FLAG);
                                    return  ri;
                                }
                                ri.setCode(Message.SUCCESS_CODE);
                                ri.setMsg("后台更新数据异常");
                                ri.setSuccess(Message.API_SUCCESS_FLAG);
                                return  ri;
                            }
                        }
                    }
                }
            } else {
                //插入日志
                SpsTradeLog log = new SpsTradeLog();
                log.setLogCreateTime(new Date());
                log.setLogType(2);
                log.setLogDes("订单编号为：" + orderId + "的订单支付失败,失败原因为：" + failReason);
                spsTradeLogWriteService.saveTradeLog(log);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

    /**
     * 商户资金账户查询
     *
     * @return
     */
    @RequestMapping(value = "/getMerchantAccount", method = RequestMethod.POST)
    @ResponseBody
    public Result  getMerchantAccount() {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        SpsChannelBank bankInfo = bankReadService.getBankInfoByUserName(userName);
        Result<BigDecimal> result = new Result<>();
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", bankInfo.getChannlNum());
            String jsonResult = HttpClientUtils.post(getMerchantAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
                JSONObject object = JSONObject.parseObject(jsonResult);
                String code = object.getString("code");
                if ("100000".equals(code)) {
                    String validAmount = object.getJSONObject("result").getString("validAmount");
                    result.setBody(new BigDecimal(validAmount));
                    result.setMsg("获取成功");
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setBody(null);
            result.setMsg("获取金额失败");

        }
        return result;
    }
}
