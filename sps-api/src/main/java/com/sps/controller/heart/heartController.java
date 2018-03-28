package com.sps.controller.heart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.core.exception.BusinessException;
import com.sps.common.HttpClientUtil;
import com.sps.common.HttpClientUtils;
import com.sps.common.RSAUtil;
import com.sps.entity.order.SpsBankTradeInfo;
import com.sps.entity.order.SpsOrderLog;
import com.sps.service.order.OrderLogService;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/heart")
public class heartController {

    private static String initCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/init";
    private static String orderFirst = "http://dev.app.chezhubaitiao.com/api/accountSystem/freezeConsumption";
    private static String frozen = "http://dev.app.chezhubaitiao.com/api/accountSystem/freeze";
    //充值
    private static String pay = "http://dev.pay.juzifenqi.com/juzi-pay/payment/dianfu";
    private static String rechargeMoney = "http://dev.app.chezhubaitiao.com/api/customerAccount/recharge";
    private static String deductMoney = "http://dev.app.chezhubaitiao.com/api/customerAccount/deduct";
    private static String bindingCard = "http://test.cap.chezhubaitiao.com/route/bankCapital";
    private static String unFreezeCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/unFreezeCustomerAccount";
    private static String getCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/getCustomerAccount";
    private static String freezeCustomerAccount = "http://dev.app.chezhubaitiao.com/api/customerAccount/freezeCustomerAccount";
    private static String unFreezeAmount = "http://dev.app.chezhubaitiao.com/api/account/unFreezeAmount";
    private static String freezeAmount = "http://dev.app.chezhubaitiao.com/api/account/freezeAmount";
    private static String freezeConsumption = "http://dev.app.chezhubaitiao.com/api/account/freezeConsumption";
    private static String getAccountInfo = "http://dev.app.chezhubaitiao.com/api/account/getAccountInfo";
    private static String recoverByCertNo = "http://dev.app.chezhubaitiao.com/api/account/recoverByCertNo";
    private static String businessFreezeConsumption = "http://dev.app.chezhubaitiao.com/api/business/freezeConsumption";
    private static String businessFreezeAmount = "http://dev.app.chezhubaitiao.com/api/business/freezeAmount";
    private static String businessUnFreezeAmount = "http://dev.app.chezhubaitiao.com/api/business/unFreezeAmount";
    private static String businessGetAccount = "http://dev.app.chezhubaitiao.com/api/business/getAccount";
    private static String withdrawCash = "http://dev.app.chezhubaitiao.com/api/merchantAccount/withdrawCash";
    private static String withdrawCashReturn = "http://dev.app.chezhubaitiao.com/api/merchantAccount/withdrawCashReturn";
    private static String recharge = "http://dev.app.chezhubaitiao.com/api/merchantAccount/recharge";
    private static String main = "http://39.106.207.241:8080/m/assets/order/createOrder";

    private  static  String  privateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCp-nKIvuXjzy3KKBLFUsis4xiqEwIQaaFxngLEAdSiLXaM6FEPdIuw3kGPP3t-VA4FB83Lcb7KUVfbQZXjJrMTUD-P68_vieFXrPoH-N5xoGAeBw_UEJw1yalBWhSyPhC5xvOuvKn_rKOUiQP7ftGs1TEiCG6AYyDKcj8_R60axL0DzDuVIEL9I33ZNT2KhnJGxxI21v_2XKhJBb2lqd3NVm9pMMrKSGnN1W16sQC76U-8jTw6JLSYs0CoktaaubQcjvQmVn7UyMyyEXXVp42TVqDzzwvuvY1GraK8f1GplJgUmX2mZrJwre0YgG00piPqsag9XM3exRTefn1MdHaTAgMBAAECggEASpMPxwEB-WW_MC9OtPXyBzAHdS6rvCmr5B4wFnC7KoAJwB542fAHDY0ldESk2LLmB7z5xCVeUINJqW9n5GXpMTMHAAy0iOKUVBQXCoJcjbuQD_yHLEIxVsPoFzz_UYg7bFZmOSaa6wqCJjvK3H8yXMKYMNdEK93R2CAxsYCv6Mrp9pSCgdRa-npPgM7LcfieeLzvYBXk3tMccOOqZJ10kn3_hW2j-rlk3GIiXzIst5mPxq2yFTawjhAXlPKFX_9f7Z3rzz-9TCJGuxKjivCLS8vJJlGdPc8HnVs9zwgLr2X5Ed-MzL6QtqX3Zin2_94XdvzVmqNHsYagemF7ujbRaQKBgQDpSH4wJRzPtGqxxMb7MxMvr7z3yOdV7jSmpcnn0xh22BJhj9UVQt3guLQpuUKrd2vcCHvf1kfThQiNY4BhSCRdp-HTN-WACiIsXezSQTelkDO1fpe8AKlr9aKRSCvfkbd_dQfnVRICwKiniLpWWfnOZaMV7sBWFxcPeYW1Cs9EzQKBgQC6h9R6A9aR5UATbkW_EBIqFakHO8WdHZG0lmKZJKrxxZCtQs8TcqixpgPr0o5psalJ_2U7tNmvWDMWBGxoGvT_KGbr39pKiLvYJmco69LLYn3FTkiUcmqooJZw2iNKI75tu4LRvtJhc4riiWC9ffhQGMwurrmCBUngGRIMl8Wo3wKBgEnC5DNw6KU8FKhU4d23jo97b7KhUZQ4F2nB7g9hDdE2DMnQYr2wQNu3SzAOJeh1gCM4g4KJDHjzDXs3RPZ9ixIZ7SuN9wD_M0L4B9OLT38IE3GFr5CAXRGHv3lUaprsRisE5BTfLyyzoiAm-VQoavY56NEchrAx6Na5w-80lcjZAoGAfFpPeaSTaKJIDGwojU6-fVYBYLQlczAiUh0r0GLUn-gRIqD2gkWfVweRd6bgkHADpzRfneVcdnw7WoNKbkECchTSQI_07FmpuVkozuwglLytkls1IdoBZzff845JloSr0GYAuaoYgSVRQuNJHisb3vIZNUoAnEDAVmkAUmrgOEsCgYEAkyMSy7AiFw2KCnMYC49ZitSg5Z0s0HNLScAB-Zh_g0Kr0YRvLbvRugHiIhFhTk7wj2FfYkSLNDbbVJEh19oW35o0oUutSdqPiZ_-sVxSJkgVs7Sd9Z79-LYk2v6Xsm8J0HEUffdpbhFmEPRH371cEM_YpCVMsGG1TiLfwaiq19U\",\"publicKey\":\"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqfpyiL7l488tyigSxVLIrOMYqhMCEGmhcZ4CxAHUoi12jOhRD3SLsN5Bjz97flQOBQfNy3G-ylFX20GV4yazE1A_j-vP74nhV6z6B_jecaBgHgcP1BCcNcmpQVoUsj4Qucbzrryp_6yjlIkD-37RrNUxIghugGMgynI_P0etGsS9A8w7lSBC_SN92TU9ioZyRscSNtb_9lyoSQW9pandzVZvaTDKykhpzdVterEAu-lPvI08OiS0mLNAqJLWmrm0HI70JlZ-1MjMshF11aeNk1ag888L7r2NRq2ivH9RqZSYFJl9pmaycK3tGIBtNKYj6rGoPVzN3sUU3n59THR2kwIDAQAB";





    @Resource
    private OrderLogService orderLogService;



    /**
     * 支付
     * @return
     */
    @RequestMapping(value = "/paymentOrder", method = RequestMethod.POST)
    @ResponseBody
    public void frozen(SpsBankTradeInfo bankTrade, BigDecimal amount, Integer customerId, String certNo, String businessId, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("amount", bankTrade.getFirstMoney());
            resultMap.put("certNo", certNo);
            resultMap.put("businessId", businessId);
            resultMap.put("orderId", orderId);
            String jsonResult = HttpClientUtils.post(frozen, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
                  JSONObject job = JSON.parseObject(jsonResult);
                  String code = job.getString("code");
                  if("100000".equals(code)){
                      JSONArray array = new JSONArray();
                      array.add("1");
                      array.add("2");
                      array.add("3");
                      array.add("7");
                      array.add("9");
                      JSONObject json = new JSONObject();
                      json.put("application", "DF");
                      json.put("amount", bankTrade.getShopPayMoney());
                      json.put("authList", array);
                      json.put("certNo", certNo);
                      json.put("customerId", customerId);
                      json.put("orderId", orderId);
                      json.put("orderProvince", "北京");
                      json.put("period", 1);
                      json.put("periodType", 2);
                      json.put("productCode", "03");
                      String jsonRes = HttpClientUtil.doPostJson(bindingCard, json.toJSONString());
                      System.out.println(jsonRes);
                      if (jsonRes != null) {
                          JSONObject jobt = JSON.parseObject(jsonRes);
                          String bindingCardCode = jobt.getString("code");
                          if("100000".equals(bindingCardCode)){
                              SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                              JSONObject baseInfoJson = new JSONObject();
                              baseInfoJson.put("applDate", df.format(System.currentTimeMillis()));
                              baseInfoJson.put("applNosInst", "1");
                              baseInfoJson.put("applNosInstType", 2);
                              baseInfoJson.put("applyAmt", bankTrade.getShopPayMoney());
                              baseInfoJson.put("applyCurrency", "CNY");
                              baseInfoJson.put("capital", "0");
                              baseInfoJson.put("cardOpBankPhone", "13100000001");
                              baseInfoJson.put("policyNo", "DF20180316000001");
                              baseInfoJson.put("repayBankNum", "6228400000000000001");
                              baseInfoJson.put("custName", "北冰洋");
                              baseInfoJson.put("repayBankCd", "1");
                              baseInfoJson.put("repayBankName", "中国建设银行");
                              baseInfoJson.put("chnlTxNo", "1");
                           /*   baseInfoJson.put("commodityMoney", "198.00");
                              baseInfoJson.put("commodityName", "iphone手机壳");
                              baseInfoJson.put("commodityNumber", "1");*/
                              baseInfoJson.put("cooprProdCd", "CP20180313001");
                              baseInfoJson.put("coperCd", "QD20180313002");
                              baseInfoJson.put("downpayment", "99");
                              baseInfoJson.put("fixRateInd", "Y");
                              baseInfoJson.put("intAdjPct", "11");
                              baseInfoJson.put("intStartDt", "20180220");
                              baseInfoJson.put("isFree", "1");
                              baseInfoJson.put("isOverInterest", "1");
                              baseInfoJson.put("isSafe", "1");
                              baseInfoJson.put("loanInitState", "0");
                              baseInfoJson.put("loanPurpose", "购买IphoneX手机壳");
                              baseInfoJson.put("orderProvince", "北京");
                              baseInfoJson.put("rate", "2");
                              baseInfoJson.put("rateMode", "FX");
                              baseInfoJson.put("repayFristDate", "2018-03-30");
                              baseInfoJson.put("sysCode", "1");
                              baseInfoJson.put("txDt", "20180101");
                              baseInfoJson.put("txTm", "08:00:00");
                              baseInfoJson.put("userType", "1");

                              JSONArray loanContactList = new JSONArray();
                              JSONObject content = new JSONObject();
                              content.put("contactName", "哈哈哈");
                              content.put("contactPhone", "189105778885");
                              loanContactList.add(content);
                              baseInfoJson.put("loanContactList",loanContactList);
                              JSONObject loanMerchant = new JSONObject();
                              loanMerchant.put("areaStore", "1");
                              loanMerchant.put("areaStoreCd", "1");
                              loanMerchant.put("cityStore", "1");
                              loanMerchant.put("cityStoreCd", "1");
                              /*loanMerchant.put("employeeNo", "1");*/
                              loanMerchant.put("isLegalMan", "1");
                              loanMerchant.put("latitude", "1");
                              loanMerchant.put("legalMan", "1");
                              loanMerchant.put("legalManId", "1");
                              loanMerchant.put("legalManMatrlSts", "1");
                              loanMerchant.put("licenseNo", "1");
                             /* loanMerchant.put("licenseRegistTime", "1");*/
                              loanMerchant.put("longitude", "1");
                              loanMerchant.put("merchantAddr", "1");
                              loanMerchant.put("merchantId", "1");
                              loanMerchant.put("merchantName", "1");
                              loanMerchant.put("merchantType", "1");
                              loanMerchant.put("offSpace", "1");
                              loanMerchant.put("provinceStore", "1");
                              loanMerchant.put("provinceStoreCd", "1");
                              baseInfoJson.put("loanMerchant",loanMerchant);

                              //图片
                              JSONArray loanPhotoList = new JSONArray();
                              JSONObject photoContent = new JSONObject();
                              photoContent.put("photoType", "1");
                              photoContent.put("photoFormat", "图片");
                              photoContent.put("photoUrl", "/12121.jpg");
                              loanPhotoList.add(photoContent);
                              baseInfoJson.put("loanContactList",loanPhotoList);
                              //用户信息
                              JSONObject loanUser = new JSONObject();
                              loanUser.put("activePhoto", "1");
                              loanUser.put("areaZip", "图片");
                              loanUser.put("cityZip", "/12121.jpg");
                              loanUser.put("custId", "1");
                              loanUser.put("custName", "图片");
                              loanUser.put("dtOfBirth", "/12121.jpg");
                              loanUser.put("empr", "1");
                              loanUser.put("homeAddr", "图片");
                              loanUser.put("idNo", "/12121.jpg");
                              loanUser.put("idNoAddre", "1");
                              loanUser.put("idType", "图片");
                              loanUser.put("idValidEnd", "/12121.jpg");
                              loanUser.put("idValidStart", "1");
                              loanUser.put("sex", "1");
                              loanUser.put("provinceZip", "/12121.jpg");
                              baseInfoJson.put("loanUser",loanUser);
                               /*baseInfoJson.put("cooprProdType", "01");
                              baseInfoJson.put("coperName", "渠道商B-TEST进件01");
                              baseInfoJson.put("productName", "产品B-TEST进件01");
                              baseInfoJson.put("loanType", "桔子分期");
                              baseInfoJson.put("isFreeze", "0");
                              baseInfoJson.put("orderTime", "2017-12-30 12:00:00");
                              baseInfoJson.put("receiptProvinceCd", "130000");
                              baseInfoJson.put("receiptCityCd", "130300");
                              baseInfoJson.put("receiptAreaCd", "130321");
                              baseInfoJson.put("receiptAddr", "青龙街道1号");
                              baseInfoJson.put("receiptName", "爆冷门");
                              baseInfoJson.put("receiptPhone", "13100000002");
                              baseInfoJson.put("receiptZip", "066500");
                              baseInfoJson.put("seg1", " ");
                              baseInfoJson.put("paymentRatio", "50");
                              baseInfoJson.put("productRate", 14);*/





                              JSONObject res=encrytSignRSA2Json(privateKey, baseInfoJson.toString());
                              JSONObject jsonObject = new JSONObject();
                              jsonObject.put("appId", "6002");//总线分配的客户端id
                              jsonObject.put("data", res.get("data"));//密文
                              jsonObject.put("sign", res.get("sign"));//签名
                              String rest = postHttpJson(main,jsonObject);
                              System.out.println(rest);
                              if (rest != null) {

                              }




                          }else if ("100000".equals(bindingCardCode)){

                          }
                      }

                  }

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
    public void payment(String amount, String certNo, String cardNo, String phone,String name) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("cardNo", cardNo);
            resultMap.put("certNo", certNo);
            resultMap.put("customerId", "pay");
            resultMap.put("customerName", name);
            resultMap.put("mobile", phone);
            resultMap.put("notifyUrl", "http://123.56.24.208:8480/api/heart/payCallback");
            resultMap.put("orderId", "df2018328233");
            resultMap.put("payChannel", "baofu");
            resultMap.put("payGoal", "D");
            resultMap.put("payType", "pay");
            resultMap.put("tradeName", "店付充值");
            String jsonResult = HttpClientUtils.post(pay, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
                JSONObject object = JSONObject.parseObject(jsonResult);
                String code = object.getString("code");
                if("00000".equals(code)){
                    String serialNumber = object.getJSONObject("data").getJSONObject("nomalReturn").getString("serialNumber");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 充值金额
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
                resultMap.put("application", "dianfu");
               /* resultMap.put("cardNo", "6214830180808999");*/
                resultMap.put("certNo", "142202199308070038");
                resultMap.put("pattern", "5");
                resultMap.put("payOrder", serialNumber);
                String jsonResult = HttpClientUtils.post(rechargeMoney, resultMap);
                System.out.println(jsonResult);
                if (jsonResult != null) {
                    JSONObject job = JSON.parseObject(jsonResult);
                    String code = job.getString("code");

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
    /**
     * 扣减金额
     * @return
     */
    @RequestMapping(value = "/buckleMoney", method = RequestMethod.POST)
    @ResponseBody
    public void buckleMoney(String amount,String orderId, String certNo, String logType, String payOrder,String payType) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            resultMap.put("logType", logType);
            resultMap.put("payOrder", payOrder);
            resultMap.put("payType", payType);
            resultMap.put("orderId", orderId);
            String jsonResult = HttpClientUtils.post(deductMoney, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 按身份证号冻结账户金额
     * @return
     */
    @RequestMapping(value = "/freezeCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void freezeCustomerAccount(String orderId,String amount, String certNo) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("orderId", orderId);
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            String jsonResult = HttpClientUtils.post(freezeCustomerAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 按身份证号查询账户余额
     * @return
     */
    @RequestMapping(value = "/getCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void getCustomerAccount(String amount, String certNo, String logType, String payOrder,String payType) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            String jsonResult = HttpClientUtils.post(getCustomerAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 按身份证号解冻账户金额
     * @return
     */
    @RequestMapping(value = "/unFreezeCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void unFreezeCustomerAccount(String orderId,String amount, String certNo, String logType, String payOrder,String payType) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("orderId", orderId);
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            String jsonResult = HttpClientUtils.post(unFreezeCustomerAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 冻结后消费接口
     * @return
     */
    @RequestMapping(value = "/freezeConsumption", method = RequestMethod.POST)
    @ResponseBody
    public void freezeConsumption(String amount, String certNo, String orderId,String businessId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("businessId", businessId);
            resultMap.put("orderId", orderId);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            String jsonResult = HttpClientUtils.post(orderFirst, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * 下单冻结
     * @return
     */
    @RequestMapping(value = "/freeze", method = RequestMethod.POST)
    @ResponseBody
    public void freeze(String amount, String certNo, String orderId,String businessId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("amount", amount);
            resultMap.put("certNo", certNo);
            resultMap.put("businessId", businessId);
            resultMap.put("orderId", orderId);
            String jsonResult = HttpClientUtils.post(frozen, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 冻结个人信用
     * @return
     */
    @RequestMapping(value = "/freezeAmount", method = RequestMethod.POST)
    @ResponseBody
    public void freezeAmount(String amount, String certNo, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("orderId", orderId);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            String jsonResult = HttpClientUtils.post(freezeAmount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 解冻账户金额
     * @return
     */
    @RequestMapping(value = "/unFreezeAmount", method = RequestMethod.POST)
    @ResponseBody
    public void unFreezeAmount(String amount, String certNo, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            resultMap.put("orderId", orderId);
            String jsonResult = HttpClientUtils.post(unFreezeAmount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取账户额度信息
     * @return
     */
    @RequestMapping(value = "/getAccountInfo", method = RequestMethod.POST)
    @ResponseBody
    public void getAccountInfo(String amount, String certNo, String customerId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            resultMap.put("customerId", customerId);
            String jsonResult = HttpClientUtils.post(getAccountInfo, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 恢复额度
     * @return
     */
    @RequestMapping(value = "/recoverByCertNo", method = RequestMethod.POST)
    @ResponseBody
    public void recoverByCertNo(String amount, String certNo, String orderId,String mdType,String money) {
        try {
            Map resultMap = new HashMap<>();
           /* resultMap.put("amount", amount);*/
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            resultMap.put("orderId", orderId);
            resultMap.put("mdType", mdType);
            resultMap.put("money", money);
            String jsonResult = HttpClientUtils.post(recoverByCertNo, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }















    /**
     * 商户冻结后消费接口
     * @return
     */
    @RequestMapping(value = "/businessFreezeConsumption", method = RequestMethod.POST)
    @ResponseBody
    public void businessFreezeConsumption(String amount, String businessId, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", businessId);
            resultMap.put("orderId", orderId);
            String jsonResult = HttpClientUtils.post(businessFreezeConsumption, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 商户冻结商户账户额度
     * @return
     */
    @RequestMapping(value = "/businessFreezeAmount", method = RequestMethod.POST)
    @ResponseBody
    public void businessFreezeAmount(String amount, String businessId, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("orderId", orderId);
            resultMap.put("businessId", businessId);
            String jsonResult = HttpClientUtils.post(businessFreezeAmount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 商户解冻商户账户额度
     * @return
     */
    @RequestMapping(value = "/businessUnFreezeAmount", method = RequestMethod.POST)
    @ResponseBody
    public void businessUnFreezeAmount(String amount, String businessId, String orderId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("orderId", orderId);
            resultMap.put("businessId", businessId);
            String jsonResult = HttpClientUtils.post(businessUnFreezeAmount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询商户账户信息
     * @return
     */
    @RequestMapping(value = "/businessGetAccount", method = RequestMethod.POST)
    @ResponseBody
    public void businessGetAccount(String businessId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", businessId);
            String jsonResult = HttpClientUtils.post(businessGetAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 商户账户提现申请
     * @return
     */
    @RequestMapping(value = "/withdrawCash", method = RequestMethod.POST)
    @ResponseBody
    public void withdrawCash(String businessId,String amount) {
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
    /**
     * 商户账户提现回调
     * @return
     */
    @RequestMapping(value = "/withdrawCashReturn", method = RequestMethod.POST)
    @ResponseBody
    public void withdrawCashReturn(String businessId,String amount,String pattern,String payOrder) {
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
    }



    /**
     * 商户账户提现回调
     * @return
     */
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    @ResponseBody
    public void recharge(String businessId,String amount,String pattern,String payOrder) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", businessId);
            resultMap.put("amount", amount);
            resultMap.put("pattern", pattern);
            resultMap.put("payOrder", payOrder);
            String jsonResult = HttpClientUtils.post(recharge, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


// ------------------------------------分割线-------------------------------------------------------------------------------
    /**
     * 初始化
     * @return
     */
    @RequestMapping(value = "/initBusiness", method = RequestMethod.POST)
    @ResponseBody
    public void initBusiness(String businessId, String name) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            JSONObject baseInfoJson = new JSONObject();
            baseInfoJson.put("applDate", "2018-12-31 14:41:09");
            baseInfoJson.put("applNosInst", "12");
            baseInfoJson.put("applNosInstType", 2);
            baseInfoJson.put("applyAmt", 99.00);
            baseInfoJson.put("applyCurrency", "CNY");
            baseInfoJson.put("capital", "0");
            baseInfoJson.put("cardOpBankPhone", "13100000001");
            baseInfoJson.put("policyNo", "DF20180316000001");
            baseInfoJson.put("repayBankNum", "6228400000000000001");
            baseInfoJson.put("custName", "北冰洋");
            baseInfoJson.put("repayBankCd", "1");
            baseInfoJson.put("repayBankName", "中国建设银行");
            baseInfoJson.put("chnlTxNo", "1");
                           /*   baseInfoJson.put("commodityMoney", "198.00");
                              baseInfoJson.put("commodityName", "iphone手机壳");
                              baseInfoJson.put("commodityNumber", "1");*/
            baseInfoJson.put("cooprProdCd", "CP20180313001");
            baseInfoJson.put("coperCd", "QD20180313002");
            baseInfoJson.put("downpayment", "99");
            baseInfoJson.put("fixRateInd", "Y");
            baseInfoJson.put("intAdjPct", "11");
            baseInfoJson.put("intStartDt", "20180220");
            baseInfoJson.put("isFree", "1");
            baseInfoJson.put("isOverInterest", "1");
            baseInfoJson.put("isSafe", "1");
            baseInfoJson.put("loanInitState", "0");
            baseInfoJson.put("loanPurpose", "购买IphoneX手机壳");
            baseInfoJson.put("orderProvince", "北京");
            baseInfoJson.put("rate", "2");
            baseInfoJson.put("rateMode", "FX");
            baseInfoJson.put("repayFristDate", "2018-03-30");
            baseInfoJson.put("sysCode", "1");
            baseInfoJson.put("txDt", "20180101");
            baseInfoJson.put("txTm", "08:00:00");
            baseInfoJson.put("userType", "1");


            JSONArray loanContactList = new JSONArray();
            JSONObject content = new JSONObject();
            content.put("contactName", "哈哈哈");
            content.put("contactPhone", "189105778885");
            loanContactList.add(content);
            baseInfoJson.put("loanContactList",loanContactList);
            JSONObject loanMerchant = new JSONObject();
            loanMerchant.put("areaStore", "1");
            loanMerchant.put("areaStoreCd", "1");
            loanMerchant.put("cityStore", "1");
            loanMerchant.put("cityStoreCd", "1");
                              /*loanMerchant.put("employeeNo", "1");*/
            loanMerchant.put("isLegalMan", "1");
            loanMerchant.put("latitude", "1");
            loanMerchant.put("legalMan", "1");
            loanMerchant.put("legalManId", "1");
            loanMerchant.put("legalManMatrlSts", "1");
            loanMerchant.put("licenseNo", "1");
                             /* loanMerchant.put("licenseRegistTime", "1");*/
            loanMerchant.put("longitude", "1");
            loanMerchant.put("merchantAddr", "1");
            loanMerchant.put("merchantId", "1");
            loanMerchant.put("merchantName", "1");
            loanMerchant.put("merchantType", "1");
            loanMerchant.put("offSpace", "1");
            loanMerchant.put("provinceStore", "1");
            loanMerchant.put("provinceStoreCd", "1");
            baseInfoJson.put("loanMerchant",loanMerchant);


            JSONArray loanPhotoList = new JSONArray();
            JSONObject photoContent = new JSONObject();
            photoContent.put("photoType", "1");
            photoContent.put("photoFormat", "图片");
            photoContent.put("photoUrl", "/12121.jpg");
            loanPhotoList.add(photoContent);
            baseInfoJson.put("loanContactList",loanPhotoList);

            JSONObject loanUser = new JSONObject();
            loanUser.put("activePhoto", "1");
            loanUser.put("areaZip", "图片");
            loanUser.put("cityZip", "/12121.jpg");
            loanUser.put("custId", "1");
            loanUser.put("custName", "图片");
            loanUser.put("dtOfBirth", "/12121.jpg");
            loanUser.put("empr", "1");
            loanUser.put("homeAddr", "图片");
            loanUser.put("idNo", "/12121.jpg");
            loanUser.put("idNoAddre", "1");
            loanUser.put("idType", "图片");
            loanUser.put("idValidEnd", "/12121.jpg");
            loanUser.put("idValidStart", "1");
            loanUser.put("sex", "1");
            loanUser.put("provinceZip", "/12121.jpg");
            baseInfoJson.put("loanUser",loanUser);
            JSONObject res=encrytSignRSA2Json(privateKey, baseInfoJson.toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appId", "6002");//总线分配的客户端id
            jsonObject.put("data", res.get("data"));//密文
            jsonObject.put("sign", res.get("sign"));//签名
            String jsonResult = postHttpJson(main,jsonObject);
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
    }


    /**
     * 发送请求使用：加密加签，返回密文和签名 json
     */
    public JSONObject encrytSignRSA2Json(String privateKey, String data) {
        JSONObject result = new JSONObject();
        try {
            //加密加签
            String secretData = RSAUtil.buildRSAEncryptByPrivateKey(data, privateKey);
            String mysign = RSAUtil.buildRSASignByPrivateKey(data, privateKey);
            result.put("sign", mysign);
            result.put("data", secretData);
        } catch (Exception e) {
            /*logger.info("加密加签失败privateKey:{},DATA:{}", privateKey, data);*/
            throw new BusinessException("加密加签失败");
        }
        return result;
    }









    public String postHttpJson(String url, JSONObject json) {
        Map<String, String> header = new HashMap<>();
        //        header.put("accept", "*/*");
        //        header.put("connection", "Keep-Alive");
        //        header.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        HttpResponse response = doPost4fastjson(url, header, json);
        return getStringFromResponse(response);
    }

    public static HttpResponse doPost4fastjson(String url, Map<String, String> headers,
                                               JSONObject json) {
        HttpClient client = createHttpClient();
        HttpPost postMethod = new HttpPost(url);
        HttpResponse response = null;
        try {
            if (headers != null && headers.keySet().size() > 0) {
                for (String key : headers.keySet()) {
                    postMethod.addHeader(key, headers.get(key));
                    System.out.println(key + "\t" + headers.get(key));
                }
            }
            StringEntity entity = new StringEntity(json.toJSONString(), HTTP.PLAIN_TEXT_TYPE,
                    "UTF-8");
            postMethod.setEntity(entity);
            response = client.execute(postMethod);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
        return response;
    }

    private final static HttpClient createHttpClient() {
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        ThreadSafeClientConnManager clientmanager = new ThreadSafeClientConnManager();
        clientmanager.setMaxTotal(20);
        HttpClient client = new DefaultHttpClient(clientmanager, params);
        //设置socket链接超时时间
        client.getParams().setParameter("http.socket.timeout", new Integer(600000));
        client.getParams().setParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, true);
        HttpProtocolParams.setUseExpectContinue(client.getParams(), false);
        //      ConnManagerParams.setTimeout(params, 6000000);
        // 连接超时
        HttpConnectionParams.setConnectionTimeout(params, 600000);
        // 请求超时
        HttpConnectionParams.setSoTimeout(params, 600000);
        return client;
    }

    public static String getStringFromResponse(HttpResponse response) {
        if (response == null) {
            return null;
        }
        HttpEntity httpEntity = response.getEntity();
        Header[] headers = response.getHeaders("Content-Encoding");
        for (Header h : headers) {
            if (h.getValue().contains("gzip")) {
                httpEntity = new GzipDecompressingEntity(httpEntity);
                break;
            }
        }
        InputStream in = null;
        try {
            in = httpEntity.getContent();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String responseText = null;
        if (in != null) {
            responseText = getStringFromStreamUTF8(in);
        }
        return responseText;
    }

    //从流中得到字符串格式内容
    public static String getStringFromStreamUTF8(InputStream in) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        String str = null;
        try {
            while ((str = reader.readLine()) != null) {
                buffer.append(str + "\n");
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return buffer.toString();
    }
}
