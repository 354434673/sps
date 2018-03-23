package com.sps.controller.heart;

import com.sps.common.HttpClientUtils;
import com.sps.entity.order.SpsOrderLog;
import com.sps.service.order.OrderLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/heart")
public class heartController {

    private static String initCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/init";
    private static String initAccount = "http://dev.app.chezhubaitiao.com/api/account/init";
    private static String frozen = "http://dev.app.chezhubaitiao.com/api/accountSystem/freeze";
    private static String pay = "http://dev.pay.juzifenqi.com/juzi-pay/payment/assembleReqParam";
    private static String rechargeMoney = "http://dev.app.chezhubaitiao.com/api/customerAccount/recharge";

    @Resource
    private OrderLogService orderLogService;

    /**
     * 初始化个人资金账户
     *
     * @return
     */
    @RequestMapping(value = "/initCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void initCustomerAccount(String certNo) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", "142202199308070038");
            String jsonResult = HttpClientUtils.post(initCustomerAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化个人信用账户
     *
     * @return
     */
    @RequestMapping(value = "/initAccount", method = RequestMethod.POST)
    @ResponseBody
    public void initAccount(BigDecimal amount, String certNo) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("amount", "520.14");
            resultMap.put("certNo", "142202199308070038");
            String jsonResult = HttpClientUtils.post(initAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 冻结账户
     *
     * @return
     */
    @RequestMapping(value = "/frozen", method = RequestMethod.POST)
    @ResponseBody
    public void frozen(BigDecimal amount, String certNo, String businessId, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("amount", "50");
            resultMap.put("certNo", "142202199308070038");
            resultMap.put("businessId", "DF20183201115152");
            resultMap.put("orderId", "df10481047046932");
            String jsonResult = HttpClientUtils.post(frozen, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 支付接口
     *
     * @return
     */
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseBody
    public void payment(BigDecimal amount, String certNo, String businessId, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", "100");
            resultMap.put("application", "shangcheng");
            resultMap.put("callbackUrl", "http://www.baidu.com");
            resultMap.put("cardNo", "6214830180808999");
            resultMap.put("certNo", "142202199308070038");
            resultMap.put("customerId", "pay");
            resultMap.put("customerName", "张磊");
            resultMap.put("freeInterest ", "N");
            resultMap.put("loanAmount", "50");
            resultMap.put("mobile", "18910548021");
            resultMap.put("monthRate", "0.05");
            resultMap.put("notifyUrl", "http://www.baidu.com");
            resultMap.put("orderId", "df10481047046932");
            resultMap.put("payChannel", "baofu");
            resultMap.put("payGoal", "D");
            resultMap.put("payType", "pay");
            resultMap.put("principal", "10");
            resultMap.put("tradeName", "娃哈哈矿泉水");
            resultMap.put("sign", "232332");
            String jsonResult = HttpClientUtils.post(pay, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 支付接口
     *
     * @return
     */
    @RequestMapping(value = "/payCallback", method = RequestMethod.POST)
    @ResponseBody
    public void payCallback(String amount, String extParam, String failReason, String orderId, String payChannel, String payType, String period, String serialNumber, String sign, String status) {
        try {
            if ("000000".equals(status)) {
                Map resultMap = new HashMap<>();
                resultMap.put("amount", amount);
                resultMap.put("application", "shangcheng");
                resultMap.put("cardNo", "6214830180808999");
                resultMap.put("pattern", "易宝");
                resultMap.put("payOrder", serialNumber);
                String jsonResult = HttpClientUtils.post(rechargeMoney, resultMap);
                System.out.println(jsonResult);
                if (jsonResult != null) {
                  /*  JSONObject job = JSON.parseObject(jsonResult);
                    String code = job.getString("errcode");*/

                }
            } else {
                //插入日志
                SpsOrderLog log = new SpsOrderLog();
                log.setLogCreateTime(new Date());
                log.setLogType(2);
                log.setLogDes("订单编号为：" + orderId + "的订单支付失败,失败原因为：" + failReason);
                orderLogService.saveOrUpdate(log);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
