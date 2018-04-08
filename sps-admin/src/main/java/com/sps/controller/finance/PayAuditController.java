package com.sps.controller.finance;

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
import org.sps.service.finance.read.CashAuditReadService;
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
public class PayAuditController {
    private  static  final Log Logger= LogFactory.getLog(PayAuditController.class);

    private static String withdrawCashReturn = "http://dev.app.chezhubaitiao.com/api/merchantAccount/withdrawCashReturn";
    private static String withdrawCash = "http://dev.app.chezhubaitiao.com/api/merchantAccount/withdrawCash";

    @Reference(check = false, group = "dianfu")
    private CashAuditReadService cashAuditService;


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

    @RequestMapping("/saveAuditStatus")
    @ResponseBody
    public Result saveAuditStatus(int id, String type, String content) {
        Map<String, Object> map = bankTradeWriteService.modifyBankTradeByApplicateDate(id, type, content);
        //审核通过--调用别的接口进行体现
        Boolean flag = (Boolean) map.get("flag");
        SpsChannelBankTrade trade = (SpsChannelBankTrade) map.get("spsChannelBankTrade");
        if (flag && trade != null) {
            if ("2" .equals(trade.getTradeStatus())) {
                //调用核心进行金额的操作
                Map resultMap = new HashMap<>();
                resultMap.put("amount", trade.getTradeAmount());
                resultMap.put("application", "dianfu");
                resultMap.put("businessId", trade.getCahnnelBank().getChannlNum());
                //调用请求
                Logger.info("开始调用提现接口");
                String jsonResult = HttpClientUtils.post(withdrawCash, resultMap);
                Logger.info("发送提现接口 结束");
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
                            String uuid = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
                            Logger.info("封装一条交易记录" );

                            /**根据身份证
                             * 去核心查询个人资金账户余额
                             */
                           // Map map = new HashMap<>();
                            map.put("application", "dianfu");
                           // resultMap.put("businessId", bankInfo.getChannlNum());
                            Logger.info("根据身份证去核心查询个人资金账户余额 开始" );
                            //发送请求查询个人资金账户余额
                          //  String jsonRes = HttpClientUtils.post(getMerchantAccount, map);
                            Logger.info("根据身份证去核心查询个人资金账户余额 结束" );
                           /* System.out.println(jsonRes);
                            String validAmount;
                            if (jsonRes != null) {
                                if ("000000".equals(code)) {
                                    JSONObject obj = JSONObject.parseObject(jsonRes);
                                    validAmount = obj.getJSONObject("result").getString("validAmount");
                                    //更新交易前余额
                                    bankTradeInfo.setTradeBeforeBalanc(new BigDecimal(validAmount).subtract(new BigDecimal(withdrawAmt)));
                                }
                            }*/

                        }
                    }
                }
                return null;
            }
            //获取



        }
        return null;
    }
}
   /* *//**
 * 商户账户提现申请
 * 调这个接口  已经把钱冻结了
 * @return
 *//*
    @RequestMapping("/withdrawCash")
    @ResponseBody
    public void withdrawCash(String businessId, String amount) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", businessId);
            String jsonResult = HttpClientUtils.post(withdrawCash, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    *//**
 * 商户账户提现回调
 *
 * @return
 *//*
    @RequestMapping("/withdrawCashReturn")
    @ResponseBody
    public void withdrawCashReturn(String businessId, String amount, String pattern, String payOrder) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", businessId);
            resultMap.put("amount", amount);
            resultMap.put("pattern", pattern);
            resultMap.put("payOrder", payOrder);
            String jsonResult = HttpClientUtils.post(withdrawCashReturn, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
