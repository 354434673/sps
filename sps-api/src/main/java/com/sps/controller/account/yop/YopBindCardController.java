package com.sps.controller.account.yop;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.juzifenqi.capital.entity.BinCode;
import com.juzifenqi.capital.service.IBinCodeService;
import com.juzifenqi.core.ServiceResult;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.common.StringUtil;
import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BindBankTrans;
import com.sps.entity.bank.SpsBank;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.user.SpsUser;
import com.sps.service.account.bankCard.BankCardService;
import com.sps.service.account.bankCard.BindCardTransService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sps.service.user.UserService;
import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Administrator on 2018-03-21.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping("/api/yop")
public class YopBindCardController {
    private static final Log logger = LogFactory.getLog(YopBindCardController.class);
    private static final String YEEPAY_APP_KEY = "SQKK10015089427";

    private static final String YEEPAY_SERVER_ROOT = "https://open.yeepay.com/yop-center";

    private static final String YEEPAY_BIND_CARD_REQUEST_URL = "/rest/v1.0/paperorder/unified/auth/request";
    private static final String YEEPAY_BIND_CARD_SMS_COMFIRE_URL = "/rest/v1.0/paperorder/auth/confirm";
    private static final String YEEPAY_BIND_CARD_SMS_RESEND_URL = "/rest/v1.0/paperorder/auth/resend";
    private static final String YEEPAY_BIND_CARD_QUERY_URL = "/rest/v1.0/paperorder/auth/query";
    private static final String YEEPAY_BIND_CARD_QUERY_LIST_URL = "/rest/v1.0/paperorder/auth/bindcard/list";
    private static final String YEEPAY_MERCHANT_NO = "10015089427";
    @Autowired
    private ShopkeeperPersonService shopkeeperPersonService;
    @Autowired
    private ShopkeeperService shopkeeperService;
    @Autowired
    private BankCardService bankCardService;
    @Autowired
    private UserService userService;
    @Autowired
    BindCardTransService bindCardTransService;
    @Reference(group = "capital-service-dev1")
    private IBinCodeService iBinCodeService;

    /**
     * 根据银行卡号获取银行名称的方法
     *
     * @param binNo
     * @return
     */
    @RequestMapping(value = "/queryBankName", method = RequestMethod.POST)
    @ResponseBody
    public String queryBankName(@RequestParam("binNo") String binNo, @RequestParam("customerId") String customerId) {
        JSONObject jsonO = new JSONObject();
        ServiceResult<BinCode> binCodeById = iBinCodeService.getBinCodeById(binNo);
        if (binCodeById.getResult() != null) {
            //更新 银行编号，银行图片，银行简称
            String shortName = binCodeById.getResult().getBankCode().getShortName();
            BankCardInfo bankInfo = new BankCardInfo();
            bankInfo.setCardType(binCodeById.getResult().getCardType());
            bankInfo.setBankCode(binCodeById.getResult().getBankCode().getCode());
            bankInfo.setBankName(shortName);
            bankInfo.setBankPic(binCodeById.getResult().getBankCode().getPictrue());
            bankInfo.setChannlNum(customerId);
            //调用更新银行卡信息的方法
            Boolean flag = bankCardService.modifyBankInfo(bankInfo);
            if (StringUtil.isNotEmpty(shortName)) {
                jsonO.put("shortName", shortName);
                return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
            }
            jsonO.put("shortName", null);
            return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG, jsonO);
        }
        return Message.responseStr(Message.FAILURE_MSG, Message.ERROR_MSG);
    }

    /**
     * 查询绑卡信息
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/queryBindCardInfo", method = RequestMethod.POST)
    @ResponseBody
    public String queryBindCardInfo(@RequestParam("customerId") String customerId) {
        JSONObject jsonO = new JSONObject();
        //获取绑卡的信息
        List<BankCardInfo> bindCardInfos = bankCardService.findBindCardInfo(customerId);
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        if (bindCardInfos.size() > 0 && person != null) {
            BankCardInfo bankCardInfo = bindCardInfos.get(0);
            jsonO.put("cardNO", bankCardInfo.getAccounts());
            jsonO.put("bankName", bankCardInfo.getBank());
            jsonO.put("clientName", person.getPersonalClientName());
            jsonO.put("cardType", bankCardInfo.getCardType());
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
        jsonO.put("cardNO", null);
        jsonO.put("bankName", null);
        jsonO.put("clientName", person.getPersonalClientName());
        jsonO.put("cardType", null);
        return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
    }

    /**
     * 获取持卡人姓名的方法
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/getClientName", method = RequestMethod.POST)
    @ResponseBody
    public String getClientName(@RequestParam("customerId") String customerId) {
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        JSONObject jsonO = new JSONObject();
        if (person != null) {
            jsonO.put("clientName", person.getPersonalClientName());
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
        jsonO.put("clientName", null);
        return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG, jsonO);
    }

    //调用绑卡接口
    @RequestMapping(value = "/bindBankCard", method = RequestMethod.POST)
    @ResponseBody
    public String bindBankCard(@RequestParam("customerId") String customerId, @RequestParam("personName") String personName, @RequestParam("cardNo") String cardNo, @RequestParam("phone") String phone, @RequestParam("bankName") String bankName) {
     logger.info("bindBankCard 接口 入参参数"+ customerId );
        try {
            JSONObject jsonO = new JSONObject();
            //根据customerId 获取登录用户名；
            SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
            if (person == null) {
                logger.info("【绑卡接口[bindBankCard]】- 调用shopkeeperPersonService.findPerson（customerId） 查询用户信息，返回空" + customerId );

                return Message.responseStr(Message.FAILURE_CODE, "用户不存在");
            }
            if (StringUtil.isEmpty(person.getPersonalIdcard())) {
                logger.info("【绑卡接口[bindBankCard]】- 调用shopkeeperPersonService.findPerson（customerId） 查询用户信息，返回身份证为空" + customerId );
                return Message.responseStr(Message.FAILURE_CODE, "身份证不存在");
            }
            String loginName = person.getPersonalUsername();
            //根据登录用户查询是否绑卡
            String userId = bankCardService.findUserId(customerId);
            if (StringUtil.isNotEmpty(userId)) {
                logger.info("【绑卡接口[bindBankCard]】- 调用bankCardService.findUserId(customerId) 查询绑卡记录信息，返回已经绑卡" + customerId );
                return Message.responseStr(Message.FAILURE_CODE, "已绑过卡");
            }
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            BindBankTrans bindBankTrades = new BindBankTrans();
            bindBankTrades.setBankName(bankName);
            bindBankTrades.setPhone(phone);
            bindBankTrades.setBankCode(cardNo);
            bindBankTrades.setLoginName(loginName);
            bindBankTrades.setName(personName);
            bindBankTrades.setMerchantNo(YEEPAY_MERCHANT_NO);
            bindBankTrades.setIdentity(person.getPersonalIdcard());
            bindBankTrades.setUserId(uuid);
            bindBankTrades.setChannlNum(customerId);
            bindBankTrades.setStartTime(new Date());
            bindBankTrades.setSerialSh(uuid);
            boolean saveOk = bindCardTransService.saveBankTansInfos(bindBankTrades);
            if (!saveOk) {
                logger.info("【绑卡接口[bindBankCard]】- 调用bindCardTransService.saveBankTansInfos(bindBankTrades)，保存绑卡记录失败" + bindBankTrades );
                return Message.responseStr(Message.FAILURE_CODE, "保存交易记录失败");
            }
            YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
            yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
            yopRequest.addParam("requestno", uuid);
            yopRequest.addParam("identityid", customerId);
            yopRequest.addParam("identitytype", "ID_CARD");
            yopRequest.addParam("cardno", cardNo);
            yopRequest.addParam("idcardno", person.getPersonalIdcard());
            yopRequest.addParam("idcardtype", "ID");
            yopRequest.addParam("username", personName);
            yopRequest.addParam("phone", phone);
            yopRequest.addParam("issms", "true");
            yopRequest.addParam("advicesmstype", "MESSAGE");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = sdf.format(new Date());
            yopRequest.addParam("requesttime", dateString);
            yopRequest.addParam("authtype", "COMMON_FOUR");
            //回调接口
            logger.info("绑卡接口[bindBankCard]】- 调用【易宝绑卡接口[%s]】时【请求参数为【YopRequest】" +YEEPAY_BIND_CARD_REQUEST_URL+"   " +yopRequest);

            YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_REQUEST_URL, yopRequest);
            TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {});
            logger.info("【绑卡接口[bindBankCard]】- 调用【易宝绑卡接口】，响应结果为【YopResponse】" +YEEPAY_BIND_CARD_REQUEST_URL+"   " +yopRequest +"responseParames");

            bindCardTransService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"), responseParames.get("cardtop"), responseParames.get("cardlast"), responseParames.get("authtype"), responseParames.get("remark"));
            jsonO.put("requestno", responseParames.get("requestno"));
            if ("TO_VALIDATE".equals(responseParames.get("status"))) {
                //调用短信验证接口
                return Message.responseStr(Message.SUCCESS_CODE, "待短验", jsonO);
            }

            if ("BIND_FAIL".equals(responseParames.get("status"))) {
                //绑卡失败
                return Message.responseStr(Message.FAILURE_CODE, "绑卡失败", jsonO);
            }
            if ("BIND_ERRORE".equals(responseParames.get("status"))) {
                //绑卡异常
                return Message.responseStr(Message.FAILURE_CODE, "绑卡异常", jsonO);
            }
            if ("TIME_OUT".equals(responseParames.get("status"))) {
                //绑卡超时
                return Message.responseStr(Message.FAILURE_CODE, "绑卡超时", jsonO);
            }
            if ("FAIL".equals(responseParames.get("status"))) {
                //系统异常
                return Message.responseStr(Message.FAILURE_CODE, "易宝系统异常", jsonO);
            }
            if ( "BIND_SUCCESS".equals(responseParames.get("status"))) {
                //根据请求号与易宝号获取信息
                BankCardInfo bankInfo = new BankCardInfo();
                bankInfo.setUserId(bindBankTrades.getUserId());
                bankInfo.setAccounts(bindBankTrades.getBankCode());
                bankInfo.setBank(bindBankTrades.getBankName());
                bankInfo.setPhone(bindBankTrades.getPhone());
                bankInfo.setIdentity(bindBankTrades.getIdentity());
                bankInfo.setName(bindBankTrades.getName());
                bankInfo.setChannlNum(bindBankTrades.getChannlNum());
                bankInfo.setUserName(bindBankTrades.getLoginName());
                bankInfo.setState(1);
                bankInfo.setFlag(0);
                bankInfo.setCreatetime(new Date());
                bankCardService.saveBankCardInfo(bankInfo);
                //更新绑卡状态
                return Message.responseStr(Message.SUCCESS_CODE, "绑卡成功", jsonO);
            }
            return Message.responseStr(Message.FAILURE_CODE, "易宝返回错误码不存在");
        } catch (Exception e) {
           logger.error("【绑卡接口[bindBankCard]】，抛异常，入参"+customerId+""+personName+"  "+cardNo +" "+phone +" "+bankName, e);
            return Message.responseStr(Message.FAILURE_CODE, "系统异常");
        }

    }

   //调用短信确认接口
    @RequestMapping(value = "/smsConfirm", method = RequestMethod.POST)
    @ResponseBody
    public String smsConfirm(@RequestParam("validatecode") String validatecode, @RequestParam("requestNo") String requestNo) {
      logger.info("【短信确认接口[smsConfirm]】-请求参数【validatecode,requestNo】"+validatecode+"-"+requestNo);

        try {
            //调用易宝进行鉴权绑卡
            YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
            yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
            yopRequest.addParam("requestno", requestNo);
            yopRequest.addParam("validatecode", validatecode);
            //回调接口
            logger.info("【短信确认接口[smsConfirm]】-调用【易宝短信确认接口】时，请求参数【YopRequest】" +YEEPAY_BIND_CARD_SMS_COMFIRE_URL+"-"+JSON.toJSONString(yopRequest));

            YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_SMS_COMFIRE_URL, yopRequest);
            logger.info("【短信确认接口[smsConfirm]】-调用【易宝短信确认接口】，响应结果【YopResponse[%s]】"+JSON.toJSONString(yopResponse));
            TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
            });
            bindCardTransService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"), responseParames.get("cardtop"), responseParames.get("cardlast"), responseParames.get("authtype"), responseParames.get("remark"));
            if ("TO_VALIDATE".equals(responseParames.get("status"))) {
                //调用短信验证接口
                return Message.responseStr(Message.SUCCESS_CODE, "待短验");
            }
            if ("BIND_FAIL".equals(responseParames.get("status"))) {
                //绑卡失败
                return Message.responseStr(Message.FAILURE_CODE, "绑卡失败");
            }
            if ("BIND_ERRORE".equals(responseParames.get("status"))) {
                //绑卡异常
                return Message.responseStr(Message.FAILURE_CODE, "绑卡异常");
            }
            if ("TIME_OUT".equals(responseParames.get("status"))) {
                //绑卡超时
                return Message.responseStr(Message.FAILURE_CODE, "绑卡超时");
            }
            if ("FAIL".equals(responseParames.get("status"))) {
                //系统异常
                return Message.responseStr(Message.FAILURE_CODE, "系统异常");
            }
            if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
                //根据请求号与易宝号获取信息
                BindBankTrans bindBank = bindCardTransService.findBankState(responseParames.get("requestno"), responseParames.get("yborderid"));
                //保存绑卡记录
                if (bindBank != null) {
                    BankCardInfo bankInfo = new BankCardInfo();
                    bankInfo.setUserId(bindBank.getUserId());
                    bankInfo.setAccounts(bindBank.getBankCode());
                    bankInfo.setBank(bindBank.getBankName());
                    bankInfo.setPhone(bindBank.getPhone());
                    bankInfo.setIdentity(bindBank.getIdentity());
                    bankInfo.setName(bindBank.getName());
                    bankInfo.setChannlNum(bindBank.getChannlNum());
                    bankInfo.setUserName(bindBank.getLoginName());
                    bankInfo.setState(1);
                    bankInfo.setFlag(0);
                    Boolean saveBankInfo = bankCardService.saveBankCardInfo(bankInfo);
                    if (saveBankInfo) {
                        return Message.responseStr(Message.SUCCESS_CODE, "绑卡成功");
                    }
                    return Message.responseStr(Message.SUCCESS_CODE, "后台服务异常");
                }
            }
            return Message.responseStr(Message.FAILURE_CODE, "易宝返回api文档中不存在的错误码");
        } catch (Exception e) {
            logger.error("【短信确认接口[smsConfirm]】抛出异常"+ e);
            return Message.responseStr(Message.FAILURE_CODE, "系统异常");

        }
    }

   //短信重发
    @RequestMapping(value = "/smsResend", method = RequestMethod.POST)
    @ResponseBody
    public String smsResend(@RequestParam("requestNo") String requestNo) {
        logger.info("【短信重发接口[smsResend]】-请求参数【requestNo】"+requestNo);
        try {
            YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
            yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
            yopRequest.addParam("requestno", requestNo);
            logger.info("【短信重发接口[smsResend]】-调用【易宝短信重发接口】时，请求参数【YopRequest】"+ JSON.toJSONString(yopRequest));
            YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_SMS_RESEND_URL, yopRequest);
            logger.info("【短信重发接口[smsResend]】-调用【易宝短信确认接口】，响应结果【YopResponse】"+ JSON.toJSONString(yopResponse));
            TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
            });
            bindCardTransService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"), responseParames.get("cardtop"), responseParames.get("cardlast"), responseParames.get("authtype"), responseParames.get("remark"));
            if ("TO_VALIDATE".equals(responseParames.get("status"))) {
                //调用短信验证接口
                return Message.responseStr(Message.SUCCESS_CODE, "待短验");
            }
            if ("TIME_OUT".equals(responseParames.get("status"))) {
                //绑卡超时
                return Message.responseStr(Message.FAILURE_CODE, "绑卡超时");
            }
            if ("FAIL".equals(responseParames.get("status"))) {
                //系统异常
                return Message.responseSystemError();
            }
            if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
                //根据请求号与易宝号获取信息
                BindBankTrans bindBank = bindCardTransService.findBankState(responseParames.get("requestno"), responseParames.get("yborderid"));
                if (bindBank != null) {
                    //保存绑卡记录
                    BankCardInfo bankInfo = new BankCardInfo();
                    bankInfo.setUserId(bindBank.getUserId());
                    bankInfo.setAccounts(bindBank.getBankCode());
                    bankInfo.setBank(bindBank.getBankName());
                    bankInfo.setPhone(bindBank.getPhone());
                    bankInfo.setIdentity(bindBank.getIdentity());
                    bankInfo.setName(bindBank.getName());
                    bankInfo.setChannlNum(bindBank.getChannlNum());
                    bankInfo.setUserName(bindBank.getLoginName());
                    bankInfo.setState(1);
                    bankInfo.setFlag(0);
                    Boolean saveBankInfo = bankCardService.saveBankCardInfo(bankInfo);
                    if (saveBankInfo) {
                        return Message.responseStr(Message.SUCCESS_CODE, "绑卡成功");
                    }
                    return Message.responseStr(Message.FAILURE_CODE, "易宝绑卡成功，后台保存数据异常");
                }
                return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);

            }
            return Message.responseStr(Message.FAILURE_CODE, "易宝返回api文档中不存在的错误码");

        } catch (Exception e) {
            logger.error("【短信重发接口[smsResend]】抛出异常"+ e);
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE, "系统异常");

        }
    }

    //解绑银行卡
    @RequestMapping(value = "/deleteBankCard", method = RequestMethod.POST)
    @ResponseBody
    public String deleteBankCard(@RequestParam("customerId") String customerId) {
        //查询绑卡信息
        try {
            String userId = bankCardService.findUserId(customerId);
            if (StringUtil.isNotEmpty(userId)) {
                //接触绑卡
                Boolean flag = bankCardService.removeBankCard(userId);
                if (flag) {
                    return Message.responseStr(Message.SUCCESS_CODE, "解除绑卡成功");
                }
                return Message.responseStr(Message.FAILURE_CODE, "解除绑卡失败");
            }
            return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return Message.responseStr(Message.FAILURE_CODE, "系统异常");
        }
    }

    /**
     * 鉴权记录查询接口
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo query(@RequestParam("requestNo") String requestNo) {
        //根据请求号与易宝交易号获取交易信息
        BindBankTrans bankState = bindCardTransService.findBankState(requestNo, null);
        ReturnInfo returnInfo = new ReturnInfo();
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno", requestNo);
        yopRequest.addParam("yborderid", bankState.getSerialYop());
        logger.info("易宝绑卡流水号：" + requestNo + ";请求参数：" + JSON.toJSONString(yopRequest));
        YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_QUERY_URL, yopRequest);

        logger.info("易宝绑卡流水号：" + requestNo + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });

        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
            //调用短信验证接口
            returnInfo.setMsg("待短验");
        }
        if ("BIND_FAIL".equals(responseParames.get("status"))) {
            //绑卡失败

            returnInfo.setMsg("绑卡失败");
        }
        if ("BIND_ERRORE".equals(responseParames.get("status"))) {

            //绑卡异常
            returnInfo.setMsg("绑卡异常");
        }
        if ("TIME_OUT".equals(responseParames.get("status"))) {
            //绑卡超时
            returnInfo.setMsg("绑卡超时");
        }
        if ("FAIL".equals(responseParames.get("status"))) {
            //系统异常
            returnInfo.setMsg("系统异常");
        }
        if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
            returnInfo.setMsg("绑卡成功");
        }

        return returnInfo;
    }

    /**
     * 鉴权列表查询接口
     */

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo queryList(@RequestParam("userId") String userId) {

        ReturnInfo returnInfo = new ReturnInfo();

        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("identityid", userId);
        yopRequest.addParam("identitytype", "ID_CARD");
        logger.info("易宝绑卡流水号：" + userId + ";请求参数：" + JSON.toJSONString(yopRequest));
        YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_QUERY_LIST_URL, yopRequest);

        logger.info("易宝绑卡流水号：" + userId + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
        String cardlist = responseParames.get("cardlist");
        //将字符串转换成集合
        returnInfo.setResult(cardlist);

        return returnInfo;
    }
}

