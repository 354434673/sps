package com.sps.controller.heart;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.core.exception.BusinessException;
import com.sps.common.*;
import com.sps.controller.BaseApi;
import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.bank.SpsBank;
import com.sps.entity.order.SpsBankTradeInfo;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderLog;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.entity.shopkeeper.SpsShopkeeperContact;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;
import com.sps.service.account.bankTrade.BankTradeService;
import com.sps.service.bank.BankService;
import com.sps.service.order.OrderLogService;
import com.sps.service.order.OrderService;
import com.sps.service.order.TradeInfoService;
import com.sps.service.shopkeeper.ShopkeeperCompanyService;
import com.sps.service.shopkeeper.ShopkeeperContactService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.shopkeeper.ShopkeeperPicService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.enterprise.inject.New;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/heart")
public class heartController extends BaseApi {

    @Resource
    private BankTradeService bankTradeService;
    @Resource
    private BankService bankService;
    @Resource
    private OrderService orderService;
    @Resource
    private ShopkeeperCompanyService shopkeeperCompanyService;
    @Resource
    private ShopkeeperContactService shopkeeperContactService;
    @Resource
    private ShopkeeperPicService shopkeeperPicService;
    @Resource
    private ShopkeeperPersonService shopkeeperPersonService;

    private static String getMerchantAccount = "http://dev.app.chezhubaitiao.com/api/merchantAccount/getMerchantAccount";
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

    private static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCp-nKIvuXjzy3KKBLFUsis4xiqEwIQaaFxngLEAdSiLXaM6FEPdIuw3kGPP3t-VA4FB83Lcb7KUVfbQZXjJrMTUD-P68_vieFXrPoH-N5xoGAeBw_UEJw1yalBWhSyPhC5xvOuvKn_rKOUiQP7ftGs1TEiCG6AYyDKcj8_R60axL0DzDuVIEL9I33ZNT2KhnJGxxI21v_2XKhJBb2lqd3NVm9pMMrKSGnN1W16sQC76U-8jTw6JLSYs0CoktaaubQcjvQmVn7UyMyyEXXVp42TVqDzzwvuvY1GraK8f1GplJgUmX2mZrJwre0YgG00piPqsag9XM3exRTefn1MdHaTAgMBAAECggEASpMPxwEB-WW_MC9OtPXyBzAHdS6rvCmr5B4wFnC7KoAJwB542fAHDY0ldESk2LLmB7z5xCVeUINJqW9n5GXpMTMHAAy0iOKUVBQXCoJcjbuQD_yHLEIxVsPoFzz_UYg7bFZmOSaa6wqCJjvK3H8yXMKYMNdEK93R2CAxsYCv6Mrp9pSCgdRa-npPgM7LcfieeLzvYBXk3tMccOOqZJ10kn3_hW2j-rlk3GIiXzIst5mPxq2yFTawjhAXlPKFX_9f7Z3rzz-9TCJGuxKjivCLS8vJJlGdPc8HnVs9zwgLr2X5Ed-MzL6QtqX3Zin2_94XdvzVmqNHsYagemF7ujbRaQKBgQDpSH4wJRzPtGqxxMb7MxMvr7z3yOdV7jSmpcnn0xh22BJhj9UVQt3guLQpuUKrd2vcCHvf1kfThQiNY4BhSCRdp-HTN-WACiIsXezSQTelkDO1fpe8AKlr9aKRSCvfkbd_dQfnVRICwKiniLpWWfnOZaMV7sBWFxcPeYW1Cs9EzQKBgQC6h9R6A9aR5UATbkW_EBIqFakHO8WdHZG0lmKZJKrxxZCtQs8TcqixpgPr0o5psalJ_2U7tNmvWDMWBGxoGvT_KGbr39pKiLvYJmco69LLYn3FTkiUcmqooJZw2iNKI75tu4LRvtJhc4riiWC9ffhQGMwurrmCBUngGRIMl8Wo3wKBgEnC5DNw6KU8FKhU4d23jo97b7KhUZQ4F2nB7g9hDdE2DMnQYr2wQNu3SzAOJeh1gCM4g4KJDHjzDXs3RPZ9ixIZ7SuN9wD_M0L4B9OLT38IE3GFr5CAXRGHv3lUaprsRisE5BTfLyyzoiAm-VQoavY56NEchrAx6Na5w-80lcjZAoGAfFpPeaSTaKJIDGwojU6-fVYBYLQlczAiUh0r0GLUn-gRIqD2gkWfVweRd6bgkHADpzRfneVcdnw7WoNKbkECchTSQI_07FmpuVkozuwglLytkls1IdoBZzff845JloSr0GYAuaoYgSVRQuNJHisb3vIZNUoAnEDAVmkAUmrgOEsCgYEAkyMSy7AiFw2KCnMYC49ZitSg5Z0s0HNLScAB-Zh_g0Kr0YRvLbvRugHiIhFhTk7wj2FfYkSLNDbbVJEh19oW35o0oUutSdqPiZ_-sVxSJkgVs7Sd9Z79-LYk2v6Xsm8J0HEUffdpbhFmEPRH371cEM_YpCVMsGG1TiLfwaiq19U\",\"publicKey\":\"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqfpyiL7l488tyigSxVLIrOMYqhMCEGmhcZ4CxAHUoi12jOhRD3SLsN5Bjz97flQOBQfNy3G-ylFX20GV4yazE1A_j-vP74nhV6z6B_jecaBgHgcP1BCcNcmpQVoUsj4Qucbzrryp_6yjlIkD-37RrNUxIghugGMgynI_P0etGsS9A8w7lSBC_SN92TU9ioZyRscSNtb_9lyoSQW9pandzVZvaTDKykhpzdVterEAu-lPvI08OiS0mLNAqJLWmrm0HI70JlZ-1MjMshF11aeNk1ag888L7r2NRq2ivH9RqZSYFJl9pmaycK3tGIBtNKYj6rGoPVzN3sUU3n59THR2kwIDAQAB";

    //调用用户还款计划
    private static String userPayPlan = "http://dev.app.chezhubaitiao.com/api/plan/list/repayments";
    @Resource
    private OrderLogService orderLogService;
    @Resource
    private TradeInfoService tradeInfoService;
    private static  final Log log = LogFactory.getLog(heartController.class);

    /**
     * 订单支付
     *
     * @param firstMoney    首付
     * @param shopPayMoney  店付金额
     * @param amount        全款金额
     * @param customerId    客户id
     * @param shopkeeperNum 客户编号
     * @param businessId    商户编号
     * @param orderId       订单编号
     * @return
     */
    @RequestMapping(value = "/paymentOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo paymentOrder(BigDecimal firstMoney, BigDecimal shopPayMoney, BigDecimal amount, Integer customerId, String shopkeeperNum, String businessId, String orderId) {
        ReturnInfo ri = new ReturnInfo();
        try {
            SpsOrder order = orderService.findByCode(orderId);
            SpsBank bank = bankService.findEntityByNo(shopkeeperNum);
            SpsShopkeeperPersonal personInfo = shopkeeperPersonService.findByCustomerNum(shopkeeperNum);
            SpsShopkeeperCompany company = shopkeeperCompanyService.findByCustomerNum(shopkeeperNum);
            if (order != null) {
                //如果全额直接走扣减金额接口 首付走 资金匹配 走总线进件 再走核心冻结后扣款
                if (order.getScale() == 100) {
                    Map resultMap = new HashMap<>();
                    resultMap.put("amount", amount);
                    resultMap.put("application", "dianfu");
                    resultMap.put("certNo", bank.getbIdentity());
                    resultMap.put("logType", "015");
                    //提现需要传
                   /* resultMap.put("payOrder", payOrder);*/
                    resultMap.put("payType", "5");
                    resultMap.put("orderId", orderId);
                    String jsonResult = HttpClientUtils.post(deductMoney, resultMap);
                    if (jsonResult != null) {
                        JSONObject job = JSON.parseObject(jsonResult);
                        String code = job.getString("code");
                        if ("100000".equals(code)) {
                            ri.setCode(Message.SUCCESS_CODE);
                            ri.setMsg(Message.API_SUCCESS_MSG);
                            ri.setSuccess(Message.API_SUCCESS_FLAG);
                        }
                    }
                } else {
                    //冻结个人 商户信用额度   个人资金额度   这块放在平台商户确认订单
                    //直接走资金匹配
                    JSONArray array = new JSONArray();
                    array.add("1");
                    array.add("2");
                    array.add("3");
                    array.add("7");
                    array.add("9");
                    JSONObject json = new JSONObject();
                    json.put("application", "DF");
                    json.put("amount", shopPayMoney);
                    json.put("authList", array);
                    json.put("certNo", bank.getbIdentity());
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
                        //最优资金方
                        String goodCapital = jobt.getJSONObject("result").getString("capital");
                        if ("100000".equals(bindingCardCode)) {
                            //资匹走完 走总线
                            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
                            JSONObject baseInfoJson = new JSONObject();
                            baseInfoJson.put("applDate", df.format(System.currentTimeMillis()));
                            baseInfoJson.put("serviceFee", order.getServicemoney());
                            baseInfoJson.put("applNosInst", "1");
                            baseInfoJson.put("applNosInstType", 2);
                            baseInfoJson.put("applyAmt", shopPayMoney);
                            baseInfoJson.put("applyCurrency", "CNY");
                            baseInfoJson.put("capital", goodCapital);
                            baseInfoJson.put("cardOpBankPhone", bank.getbPhone());
                            baseInfoJson.put("policyNo", orderId);
                            baseInfoJson.put("repayBankNum", bank.getbAccounts());
                            baseInfoJson.put("custName", bank.getbName());
                            //银行卡开户行编码（暂时没有）
                            baseInfoJson.put("repayBankCd", "1");
                            baseInfoJson.put("repayBankName", bank.getbBank());
                            baseInfoJson.put("chnlTxNo", "1");
                            baseInfoJson.put("cooprProdCd", "010207");
                            //渠道方代码                            baseInfoJson.put("coperCd", "DF");

                            baseInfoJson.put("downpayment", firstMoney);
                            baseInfoJson.put("fixRateInd", "Y");
                            baseInfoJson.put("intAdjPct", "0");
                            //起息日
                            baseInfoJson.put("intStartDt", DateUtil.dateGapDays(DateUtil.getNowDD(), 1));
                            baseInfoJson.put("isFree", "0");
                            baseInfoJson.put("isOverInterest", "0");
                            baseInfoJson.put("isSafe", "1");
                            baseInfoJson.put("loanInitState", "0");
                            //申请用途
                            baseInfoJson.put("loanPurpose", "进货贷款");
                            //下单区域省 待定
                            baseInfoJson.put("orderProvince", "北京");
                            //费率 待定
                            baseInfoJson.put("rate", "2");
                            baseInfoJson.put("rateMode", "FX");
                            baseInfoJson.put("repayFristDate", DateUtil.dateGapDays(DateUtil.getNowDD(), 8));
                            //系统编码 待定
                            baseInfoJson.put("sysCode", "0");

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                            baseInfoJson.put("txDt", simpleDateFormat.format(order.getCreatetime()));
                            baseInfoJson.put("txTm", sdf.format(order.getCreatetime()));
                            baseInfoJson.put("userType", "0");
                            //联系人
                            JSONArray loanContactList = new JSONArray();
                            JSONObject content = new JSONObject();
                            List<SpsShopkeeperContact> shopkeeperContactList = shopkeeperContactService.findList(shopkeeperNum);
                            if (shopkeeperContactList != null && shopkeeperContactList.size() > 0) {
                                for (SpsShopkeeperContact contactList : shopkeeperContactList) {
                                    content.put("contactName", contactList.getContactName());
                                    content.put("contactPhone", contactList.getContactPhone());
                                    loanContactList.add(content);
                                }
                            }
                            baseInfoJson.put("loanContactList", loanContactList);
                            //小B基本信息
                            JSONObject loanMerchant = new JSONObject();
                            loanMerchant.put("areaStore", company.getCompanyBusinessAreaName());
                            //区域编码
                            loanMerchant.put("areaStoreCd", company.getCompanyBusinessAreaCode());
                            loanMerchant.put("cityStore", company.getCompanyBusinessCityName());
                            //市编码
                            loanMerchant.put("cityStoreCd", company.getCompanyBusinessCityCode());
                            //是否法人代表待定
                            loanMerchant.put("isLegalMan", "1");
                            //经纬度
                            loanMerchant.put("latitude", company.getCompanyBusinessLat());
                            //法人代表关联公司表查
                            loanMerchant.put("legalMan", company.getCompanyCorpName());
                            loanMerchant.put("legalManId", bank.getbIdentity());
                            if ("1".equals(personInfo.getPersonalMaritalStatus())) {
                                loanMerchant.put("legalManMatrlSts", "已婚");
                            } else if ("2".equals(personInfo.getPersonalMaritalStatus())) {
                                loanMerchant.put("legalManMatrlSts", "未婚");

                            } else if ("3".equals(personInfo.getPersonalMaritalStatus())) {
                                loanMerchant.put("legalManMatrlSts", "离异");
                            }
                            //营业执照
                            loanMerchant.put("licenseNo", "1");
                            //经度
                            loanMerchant.put("longitude", company.getCompanyBusinessLng());
                            loanMerchant.put("merchantAddr", company.getCompanyBusinessAddr());
                            loanMerchant.put("merchantId", company.getCompanyId());
                            loanMerchant.put("merchantName", company.getCompanyName());
                            //店铺类型
                            loanMerchant.put("merchantType", "1");
                            loanMerchant.put("offSpace", company.getCompanyBusinessArea());
                            loanMerchant.put("provinceStore", company.getCompanyBusinessCityName());
                            loanMerchant.put("provinceStoreCd", company.getCompanyBusinessCityCode());
                            baseInfoJson.put("loanMerchant", loanMerchant);
                            //图片
                            JSONArray loanPhotoList = new JSONArray();
                            JSONObject photoContent = new JSONObject();
                            List<SpsShopkeeperPic> spsShopkeeperPicList = shopkeeperPicService.findList(shopkeeperNum);
                            if (spsShopkeeperPicList != null && spsShopkeeperPicList.size() > 0) {
                                for (SpsShopkeeperPic picList : spsShopkeeperPicList) {
                                    photoContent.put("photoType", picList.getPicType());
                                    photoContent.put("photoFormat", "jpg");
                                    photoContent.put("photoUrl", picList.getPicSrc());
                                    loanPhotoList.add(photoContent);
                                }
                            }
                            baseInfoJson.put("loanContactList", loanPhotoList);
                            //用户信息
                            JSONObject loanUser = new JSONObject();
                            loanUser.put("activePhoto", "1");
                            loanUser.put("areaZip", personInfo.getPersonalLivingAreaCode());
                            loanUser.put("cityZip", personInfo.getPersonalLivingCityCode());
                            loanUser.put("custId", personInfo.getPersonalId());
                            loanUser.put("custName", personInfo.getPersonalClientName());
                            loanUser.put("dtOfBirth", CutId(personInfo.getPersonalIdcard()));
                            //小B工作地址待定
                            loanUser.put("empr", company.getCompanyBusinessAddr());
                            loanUser.put("homeAddr", personInfo.getPersonalLivingAddress());
                            loanUser.put("idNo", personInfo.getPersonalIdcard());
                            loanUser.put("idNoAddre", personInfo.getPersonalPlaceofdomicile());
                            loanUser.put("idType", "身份证");
                            loanUser.put("idValidEnd", personInfo.getPersonalIdcardValidityEnd());
                            loanUser.put("idValidStart", personInfo.getPersonalIdcardValidityStart());
                            loanUser.put("sex", personInfo.getPersonalSex());
                            loanUser.put("provinceZip", personInfo.getPersonalLivingProvinceCode());
                            baseInfoJson.put("loanUser", loanUser);

                            JSONObject res = encrytSignRSA2Json(privateKey, baseInfoJson.toString());
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("appId", "6002");//总线分配的客户端id
                            jsonObject.put("data", res.get("data"));//密文
                            jsonObject.put("sign", res.get("sign"));//签名
                            String rest = postHttpJson(main, jsonObject);
                            System.out.println(rest);
                            if (rest != null) {
                                JSONObject jsonRest = JSON.parseObject(rest);
                                String resCode = jsonRest.getString("code");
                                if ("0000".equals(resCode)) {
                                    Map resMap = new HashMap<>();
                                    resMap.put("amount", shopPayMoney);
                                    resMap.put("businessId", businessId);
                                    resMap.put("orderId", orderId);
                                    resMap.put("firstPayAmount", firstMoney);
                                    resMap.put("application", "dianfu");
                                    resMap.put("certNo", bank.getbIdentity());
                                    String restParam = HttpClientUtils.post(orderFirst, resMap);
                                    System.out.println(restParam);
                                    if (restParam != null) {
                                        JSONObject lastRest = JSON.parseObject(restParam);
                                        String lastRestCode = lastRest.getString("code");
                                        if ("0000".equals(lastRestCode)) {
                                            ri.setCode(Message.SUCCESS_CODE);
                                            ri.setMsg(Message.API_SUCCESS_MSG);
                                            ri.setSuccess(Message.API_SUCCESS_FLAG);
                                        }
                                    }
                                }
                            }
                        } else if ("100000".equals(bindingCardCode)) {
                        }
                    }
                }
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
     * 充值接口
     *
     * @return
     */
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo payment(String amount, String certNo, String cardNo, String phone, String name, String customerId) {
        ReturnInfo ri = new ReturnInfo();
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
                if ("000000".equals(code)) {
                    String serialNumber = object.getJSONObject("data").getJSONObject("nomalReturn").getString("serialNumber");
                    String status = object.getJSONObject("data").getJSONObject("nomalReturn").getString("status");
                    if ("S".equals(status)) {
                        SpsBankTradeInfo bankTradeInfo = new SpsBankTradeInfo();
                        bankTradeInfo.setBtIdentity(certNo);
                        bankTradeInfo.setBtApplicationStartDate(new Date());
                        bankTradeInfo.setBtTradeName(customerId);
                        //充值代表收入
                        bankTradeInfo.setBtTradeType("1");
                        bankTradeInfo.setBtIncomeType("充值");
                        bankTradeInfo.setRechargeStatus(2);
                        bankTradeInfo.setBtTradeAmount(new BigDecimal(amount));
                        //去核心查询个人资金账户余额
                        Map map = new HashMap<>();
                        map.put("application", "dianfu");
                        map.put("certNo", certNo);
                        String jsonRes = HttpClientUtils.post(getCustomerAccount, map);
                        System.out.println(jsonRes);
                        if (jsonRes != null) {
                            if ("000000".equals(code)) {
                                JSONObject obj = JSONObject.parseObject(jsonRes);
                                String validAmount = obj.getJSONObject("result").getString("validAmount");
                                bankTradeInfo.setBtTradeBeforeBalanc(new BigDecimal(validAmount));
                            }
                        }
                        bankTradeInfo.setBtUserId(customerId);
                        bankTradeInfo.setBtTradeNo(serialNumber);
                        tradeInfoService.saveOrUpdate(bankTradeInfo);
                        ri.setCode(Message.SUCCESS_CODE);
                        ri.setMsg(Message.API_SUCCESS_MSG);
                        ri.setSuccess(Message.API_SUCCESS_FLAG);
                    }
                }
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
                SpsBankTradeInfo spsBankTradeInfo = tradeInfoService.findBySerialNumber(serialNumber);
                Map resultMap = new HashMap<>();
                resultMap.put("amount", amount);
                resultMap.put("application", "dianfu");
                resultMap.put("certNo", spsBankTradeInfo.getBtIdentity());
                resultMap.put("pattern", "5");
                resultMap.put("payOrder", serialNumber);
                String jsonResult = HttpClientUtils.post(rechargeMoney, resultMap);
                System.out.println(jsonResult);
                if (jsonResult != null) {
                    JSONObject job = JSON.parseObject(jsonResult);
                    String code = job.getString("code");
                    if ("100000".equals(code)) {
                        //去核心查询个人资金账户余额
                        SpsBankTradeInfo bankTradeInfo = new SpsBankTradeInfo();
                        Map map = new HashMap<>();
                        map.put("application", "dianfu");
                        map.put("certNo", spsBankTradeInfo.getBtIdentity());
                        String jsonRes = HttpClientUtils.post(getCustomerAccount, map);
                        System.out.println(jsonRes);
                        if (jsonRes != null) {
                            if ("100000".equals(code)) {
                                JSONObject obj = JSONObject.parseObject(jsonRes);
                                String validAmount = obj.getJSONObject("result").getString("validAmount");
                                bankTradeInfo.setBtTradeAfterBalanc(new BigDecimal(validAmount));
                                bankTradeInfo.setRechargeStatus(1);
                                bankTradeInfo.setBtPaymentDate(new Date());
                                bankTradeInfo.setBtAuditDate(new Date());
                                bankTradeInfo.setBtTradeNo(serialNumber);
                                tradeInfoService.updateBySerialNumber(bankTradeInfo);
                                ri.setCode(Message.SUCCESS_CODE);
                                ri.setMsg(Message.API_SUCCESS_MSG);
                                ri.setSuccess(Message.API_SUCCESS_FLAG);
                            }
                        }
                    }
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
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


   /* *//**
     * 个人提现
     *
     * @return
     *//*
    @RequestMapping(value = "/userWithdrawals", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo userWithdrawals(String period, String serialNumber, String sign, String status) {
        ReturnInfo ri = new ReturnInfo();
        try {
            SpsBankTradeInfo spsBankTradeInfo = tradeInfoService.findBySerialNumber(serialNumber);
            Map resultMap = new HashMap<>();
            resultMap.put("amount", amount);
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", spsBankTradeInfo.getBtIdentity());
            resultMap.put("pattern", "5");
            resultMap.put("payOrder", serialNumber);
            String jsonResult = HttpClientUtils.post(rechargeMoney, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
                JSONObject job = JSON.parseObject(jsonResult);
                String code = job.getString("code");
                if ("100000".equals(code)) {
                    //去核心查询个人资金账户余额
                    SpsBankTradeInfo bankTradeInfo = new SpsBankTradeInfo();
                    Map map = new HashMap<>();
                    map.put("application", "dianfu");
                    map.put("certNo", spsBankTradeInfo.getBtIdentity());
                    String jsonRes = HttpClientUtils.post(getCustomerAccount, map);
                    System.out.println(jsonRes);
                    if (jsonRes != null) {
                        if ("100000".equals(code)) {
                            JSONObject obj = JSONObject.parseObject(jsonRes);
                            String validAmount = obj.getJSONObject("result").getString("validAmount");
                            bankTradeInfo.setBtTradeAfterBalanc(new BigDecimal(validAmount));
                            bankTradeInfo.setRechargeStatus(1);
                            bankTradeInfo.setBtPaymentDate(new Date());
                            bankTradeInfo.setBtAuditDate(new Date());
                            bankTradeInfo.setBtTradeNo(serialNumber);
                            tradeInfoService.updateBySerialNumber(bankTradeInfo);
                            ri.setCode(Message.SUCCESS_CODE);
                            ri.setMsg(Message.API_SUCCESS_MSG);
                            ri.setSuccess(Message.API_SUCCESS_FLAG);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }*/


    /**
     * 扣减金额
     * 本地测试用
     *
     * @return
     */
    @RequestMapping(value = "/buckleMoney", method = RequestMethod.POST)
    @ResponseBody
    public void buckleMoney(String amount, String orderId, String certNo, String logType, String payOrder, String payType) {
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
     * 本地测试用
     *
     * @return
     */
    @RequestMapping(value = "/freezeCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void freezeCustomerAccount(String orderId, String amount, String certNo) {
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
     * 本地测试用
     *
     * @return
     */
    @RequestMapping(value = "/getCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void getCustomerAccount(String amount, String certNo, String logType, String payOrder, String payType) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("certNo", certNo);
            String jsonResult = HttpClientUtils.post(getCustomerAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
                JSONObject object = JSONObject.parseObject(jsonResult);
                String validAmount = object.getJSONObject("result").getString("validAmount");
                System.out.println(validAmount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 按身份证号解冻账户金额
     * 本地测试用
     *
     * @return
     */
    @RequestMapping(value = "/unFreezeCustomerAccount", method = RequestMethod.POST)
    @ResponseBody
    public void unFreezeCustomerAccount(String orderId, String amount, String certNo, String logType, String payOrder, String payType) {
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
     * 本地测试用
     *
     * @return
     */
    @RequestMapping(value = "/freezeConsumption", method = RequestMethod.POST)
    @ResponseBody
    public void freezeConsumption(String amount, String certNo, String orderId, String businessId) {
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
     *
     * @return
     */
    @RequestMapping(value = "/freeze", method = RequestMethod.POST)
    @ResponseBody
    public void freeze(String amount, String certNo, String orderId, String businessId) {
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
     *
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
     *
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
     *
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
     *
     * @return
     */
    @RequestMapping(value = "/recoverByCertNo", method = RequestMethod.POST)
    @ResponseBody
    public void recoverByCertNo(String amount, String certNo, String orderId, String mdType, String money) {
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
     *
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
     *
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
     *
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
     *
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
     * 调这个接口  已经把钱冻结了
     *
     * @return
     */
    @RequestMapping(value = "/withdrawCash", method = RequestMethod.POST)
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

    /**
     * 商户账户提现回调
     *
     * @return
     */
    @RequestMapping(value = "/withdrawCashReturn", method = RequestMethod.POST)
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
    }


    /**
     * 商户账户提现回调
     *
     * @return
     */
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    @ResponseBody
    public void recharge(String businessId, String amount, String pattern, String payOrder) {
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


    /**
     * 商户资金账户查询
     *
     * @return
     */
    @RequestMapping(value = "/getMerchantAccount", method = RequestMethod.POST)
    @ResponseBody
    public void getMerchantAccount(String businessId) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", businessId);
            String jsonResult = HttpClientUtils.post(getMerchantAccount, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
                JSONObject object = JSONObject.parseObject(jsonResult);
                String code = object.getString("code");
                if ("100000".equals(code)) {
                    String validAmount = object.getJSONObject("result").getString("validAmount");
                    System.out.println(validAmount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 退货接口
     *
     * @return
     */
    @RequestMapping(value = "/returnGoods", method = RequestMethod.POST)
    @ResponseBody
    public void returnGoods(String businessId) {
        try {
            Map map = new HashMap<>();
            map.put("amount", "0");
            map.put("application", "dianfu");
            map.put("certNo", "142202199308070038");
            map.put("businessId", "DF20183201115152");
            map.put("orderId", "df10489728549887");
            String jsonRes = HttpClientUtils.post("http://dev.app.chezhubaitiao.com/api/customerAccount/returnGoods", map);
            if (jsonRes != null) {
                JSONObject object = JSONObject.parseObject(jsonRes);
                String code = object.getString("code");
                if ("100000".equals(code)) {
                  /*  Map resMap = new HashMap<>();
                    resMap.put("amount","0.1");
                    resMap.put("application", "dianfu");
                    resMap.put("certNo", "142202199308070038");
                    resMap.put("businessId", "DF20183201115152");
                    resMap.put("orderId", "DF201803270000035");
                    String json = HttpClientUtils.post("http://dev.app.chezhubaitiao.com/api/customerAccount/userRepayment", resMap);*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 还款接口
     *
     * @return
     */
    @RequestMapping(value = "/userRepayment", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo userRepayment(String orderId, BigDecimal amount) {
        ReturnInfo ri = new ReturnInfo();
        try {
            BankTradeInfo bankTradeInfo = bankTradeService.findTradeDetailByOrderNo(orderId);
           /* Map resMap = new HashMap<>();
            resMap.put("amount", amount);
            resMap.put("application", "dianfu");
            resMap.put("certNo", bankTradeInfo.getIdentity());
            resMap.put("orderId", orderId);
            resMap.put("pattern", "5");
            resMap.put("payOrder", bankTradeInfo.getTradeNo());*/
            Map resMap = new HashMap<>();
            resMap.put("amount", "0.1");
            resMap.put("application", "dianfu");
            resMap.put("certNo", "142202199308070038");
            resMap.put("orderId", "df10489728549887");
            resMap.put("pattern", "5");
            resMap.put("payOrder", "144556555");
            String json = HttpClientUtils.post("http://dev.app.chezhubaitiao.com/api/customerAccount/userRepayment", resMap);
            if (json != null) {
                JSONObject object = JSONObject.parseObject(json);
                String code = object.getString("code");
                if ("100000".equals(code)) {
                    Map map = new HashMap<>();
                    map.put("status", 20);
                    map.put("orderNo", orderId);
                    orderService.updateStatusByOrderNo(map);
                    ri.setCode(Message.SUCCESS_CODE);
                    ri.setMsg(Message.API_SUCCESS_MSG);
                    ri.setSuccess(Message.API_SUCCESS_FLAG);
                } else {
                    ri.setCode(Message.FAILURE_CODE);
                    ri.setMsg(Message.FAILURE_MSG);
                    ri.setSuccess(Message.API_ERROR_FLAG);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


// ------------------------------------分割线-------------------------------------------------------------------------------

      /* loanMerchant.put("licenseRegistTime", "1");*/
                               /*loanMerchant.put("employeeNo", "1");*/
                              /*   baseInfoJson.put("commodityMoney", "198.00");
                              baseInfoJson.put("commodityName", "iphone手机壳");
                              baseInfoJson.put("commodityNumber", "1");*/
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


    public String CutId(String id) {
        String rest = "";
        String year = id.substring(6, 10);// 截取年
        String month = id.substring(10, 12);// 截取月份
        String day = id.substring(12, 14);// 截取天
        rest = year + month + day;
        return rest;
    }

    /**
     * 初始化
     *
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
            baseInfoJson.put("intAdjPct", "0");
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
            baseInfoJson.put("loanContactList", loanContactList);
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
            //营业执照号
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
            baseInfoJson.put("loanMerchant", loanMerchant);


            JSONArray loanPhotoList = new JSONArray();
            JSONObject photoContent = new JSONObject();
            photoContent.put("photoType", "1");
            photoContent.put("photoFormat", "图片");
            photoContent.put("photoUrl", "/12121.jpg");
            loanPhotoList.add(photoContent);
            baseInfoJson.put("loanContactList", loanPhotoList);

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
            baseInfoJson.put("loanUser", loanUser);
            JSONObject res = encrytSignRSA2Json(privateKey, baseInfoJson.toString());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appId", "6002");//总线分配的客户端id
            jsonObject.put("data", res.get("data"));//密文
            jsonObject.put("sign", res.get("sign"));//签名
            String jsonResult = postHttpJson(main, jsonObject);
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

    /**
     * 用户还款计划
     *
     * @return
     */
    @RequestMapping(value = "/userPayPlan", method = RequestMethod.POST)
    public JsonResult  getUserPayPlan(String appChannel, String certNo, String currentPage, String indays,String pageSize ,String state) {
        log.info("start--获取用户还款计划 ，身份证号码"+certNo);
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("appChannel", appChannel);
            resultMap.put("certNo", certNo);
            resultMap.put("currentPage", currentPage);
            if(indays!=null){
                resultMap.put("indays", indays);
            }
            resultMap.put("pageSize", pageSize);
            resultMap.put("state", state);
            String  jsonResult = HttpClientUtils.post(userPayPlan, resultMap);
            JSONObject job = JSON.parseObject(jsonResult);
            JSONArray json =job.getJSONObject("result").getJSONArray("data");
           /*if(json.size()>0){
                for(int i=0;i<json.size();i++){
                    JSONObject gardenJson = (JSONObject) json.get(i);
                    for (int j=0;j<gardenJson.size();j++){
                        if (!"orderId".equals(gardenJson.get(j))  || !"overDueDay".equals(gardenJson.get(j))  || !"repayMoney".equals(gardenJson.get(j)) || !"state".equals(gardenJson.get(j))){
                            gardenJson.remove(j);
                        }
                    }
                }
            }*/
            log.info("end--获取用户还款计划 ，身份证号码"+certNo);
            if(!"100000".equals(job.getString("code"))){
                return  returnFaild(job.getString("msg"));
            }
            return returnSuccess(job.getJSONObject("result").getJSONArray("data"));
        } catch (Exception e) {
            log.info("end--获取用户还款计划异常 "+e);
            return  returnFaild();
        }
    }

}
