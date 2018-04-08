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
     * 获取所支持银行的方法
     */
   /* @RequestMapping(value = "/queryBankNameList", method = RequestMethod.POST)
    @ResponseBody
    public String queryBankNameList(@RequestParam("binNo") String binNo){
        JSONObject jsonO = new JSONObject();
        ServiceResult<BinCode> binCodeById = iBinCodeService.getBinCodeById(binNo);
        String shortName = binCodeById.getResult().getBankCode().getShortName();
        if(StringUtil.isNotEmpty(shortName)) {
            jsonO.put("shortName",shortName);
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
        jsonO.put("shortName",null);
        return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG, jsonO);
    }*/

    /**
     * 根据银行卡号获取银行名称的方法
     * @param binNo
     * @return
     */
   @RequestMapping(value = "/queryBankName", method = RequestMethod.POST)
    @ResponseBody
   public String queryBankName(@RequestParam("binNo") String binNo,@RequestParam("customerId") String customerId ){
       JSONObject jsonO = new JSONObject();
       ServiceResult<BinCode> binCodeById = iBinCodeService.getBinCodeById(binNo);
       if(binCodeById.getResult() !=null){
           //更新 银行编号，银行图片，一家银行简称
           String shortName = binCodeById.getResult().getBankCode().getShortName();
           BankCardInfo bankInfo = new BankCardInfo();
           bankInfo.setCardType(binCodeById.getResult().getCardType());
           bankInfo.setBankCode(binCodeById.getResult().getBankCode().getCode());
           bankInfo.setBankName(shortName);
           bankInfo.setBankPic(binCodeById.getResult().getBankCode().getPictrue());
           bankInfo.setChannlNum(customerId);
           //调用更新银行卡信息的方法
           Boolean flag = bankCardService.modifyBankInfo(bankInfo);
           if(StringUtil.isNotEmpty(shortName)) {
               jsonO.put("shortName",shortName);
               return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
           }
           jsonO.put("shortName",null);
           return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG, jsonO);
       }
       return Message.responseStr(Message.FAILURE_MSG,Message.ERROR_MSG);
    }

    /**
     * 查询绑卡信息
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/queryBindCardInfo", method = RequestMethod.POST)
    @ResponseBody
    public String queryBindCardInfo(@RequestParam("customerId") String customerId){
        JSONObject jsonO = new JSONObject();
        //获取绑卡的信息
        List<BankCardInfo> bindCardInfos = bankCardService.findBindCardInfo(customerId);
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        if(bindCardInfos.size()>0 && person!=null){
            BankCardInfo bankCardInfo = bindCardInfos.get(0);
            jsonO.put("cardNO",bankCardInfo.getAccounts());
            jsonO.put("bankName",bankCardInfo.getBank());
            jsonO.put("clientName",person.getPersonalClientName());
            jsonO.put("cardType",bankCardInfo.getCardType());
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
        jsonO.put("cardNO",null);
        jsonO.put("bankName",null);
        jsonO.put("clientName",person.getPersonalClientName());
        jsonO.put("cardType",null);
        return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
    }

    /**
     * 获取持卡人姓名的方法
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/getClientName" ,method =RequestMethod.POST)
    @ResponseBody
    public String getClientName(@RequestParam("customerId") String customerId){
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        JSONObject jsonO = new JSONObject();
        if(person !=null){
            jsonO.put("clientName",person.getPersonalClientName());
            return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonO);
        }
        jsonO.put("clientName",null);
        return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG, jsonO);
    }
    //调用绑卡接口
    @RequestMapping(value = "/bindBankCard", method = RequestMethod.POST)
    @ResponseBody
    public String bindBankCard(@RequestParam("customerId") String customerId,@RequestParam("personName") String personName,@RequestParam("cardNo") String cardNo,@RequestParam("phone") String phone,@RequestParam("bankName") String bankName) {
        JSONObject jsonO = new JSONObject();
        //根据customerId 获取登录用户名；
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        if(person!=null){
            String loginName=person.getPersonalUsername();
            if(person.getPersonalIdcard()!=null){
                /**
                 * 创建一条绑卡信息
                 */
                BindBankTrans bindBankTrades = new BindBankTrans();
                bindBankTrades.setBankName(bankName);
                bindBankTrades.setPhone(phone);
                bindBankTrades.setBankCode(cardNo);
                bindBankTrades.setLoginName(loginName);
                bindBankTrades.setName(personName);
                bindBankTrades.setMerchantNo(YEEPAY_MERCHANT_NO);
                bindBankTrades.setIdentity(person.getPersonalIdcard());
                bindBankTrades.setUserId(UUID.randomUUID().toString());
                bindBankTrades.setChannlNum(customerId);
                //根据登录用户查询是否绑卡
                String userId = bankCardService.findUserId(customerId);
                if ( StringUtil.isEmpty(userId)) {
                    /**
                     * 没有绑卡，保存一条绑卡交易记录
                     *
                     */
                    bindBankTrades.setUserId(UUID.randomUUID().toString());
                    HashMap<String, Object> map = bindCardTransService.saveBankTansInfos(bindBankTrades);
                    if (map != null) {
                        Boolean flag = (Boolean) map.get("flag");
                        if (flag) {
                            BindBankTrans bindBankTrans = (BindBankTrans) map.get("bindBankTransNew");
                            /**
                             * 调用易宝进行鉴权绑卡
                             * 57dc8546-0f55-4e30-b73c-85bc760dab89
                             */
                            String identityid1 = bindBankTrans.getUserId().replaceAll("-","");
                            YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
                            yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
                            yopRequest.addParam("requestno", bindBankTrans.getSerialSh());
                            yopRequest.addParam("identityid", identityid1);
                            yopRequest.addParam("identitytype", "ID_CARD");
                            yopRequest.addParam("cardno", cardNo);
                            yopRequest.addParam("idcardno",person.getPersonalIdcard());
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
                            logger.info("易宝绑卡流水号：" + ";请求参数：" + JSON.toJSONString(yopRequest));
                            YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_REQUEST_URL, yopRequest);
                            logger.info("易宝绑卡流水号：" + bindBankTrans.getSerialSh() + ";返回参数：" + JSON.toJSONString(yopResponse));
                            TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
                            });
                            Boolean aBoolean = bindCardTransService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"),responseParames.get("cardtop"),responseParames.get("cardlast"),responseParames.get("authtype"),responseParames.get("remark"));
                            if ("TO_VALIDATE".equals(responseParames.get("status"))) {
                                //调用短信验证接口
                                jsonO.put("requestno",responseParames.get("requestno"));
                                return Message.responseStr(Message.SUCCESS_CODE,"待短验", jsonO);
                            }
                            if ("BIND_FAIL".equals(responseParames.get("status"))) {
                                //绑卡失败
                                jsonO.put("requestno",responseParames.get("requestno"));
                                return Message.responseStr(Message.FAILURE_CODE,"绑卡失败", jsonO);
                            }
                            if ("BIND_ERRORE".equals(responseParames.get("status"))) {
                                //绑卡异常
                                jsonO.put("requestno",responseParames.get("requestno"));
                                return Message.responseStr(Message.FAILURE_CODE,"绑卡异常", jsonO);
                            }
                            if ("TIME_OUT".equals(responseParames.get("status"))) {
                                //绑卡超时
                                jsonO.put("requestno",responseParames.get("requestno"));
                                return Message.responseStr(Message.FAILURE_CODE,"绑卡超时", jsonO);
                            }
                            if ("FAIL".equals(responseParames.get("status"))) {
                                //系统异常
                                jsonO.put("requestno",responseParames.get("requestno"));
                                return Message.responseStr(Message.FAILURE_CODE,"易宝系统异常", jsonO);
                            }
                            if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
                                return Message.responseStr(Message.SUCCESS_CODE,"绑卡成功", jsonO);

                              /*  //根据请求号与易宝号获取信息
                                BindBankTrans bindBank = bindCardTransService.findBankState(responseParames.get("requestno"), responseParames.get("yborderid"));
                                BankCardInfo bankInfo = new BankCardInfo();
                                bankInfo.setUserId(bindBank.getUserId());
                                bankInfo.setAccounts(bindBank.getBankCode());
                                bankInfo.setBank(bindBank.getBankName());
                                bankInfo.setPhone(bindBank.getPhone());
                                bankInfo.setIdentity(bindBank.getIdentity());
                                bankInfo.setName(bindBank.getName());
                                bankInfo.setChannlNum(bindBank.getChannlNum());
                                bankInfo.setUserName(bindBank.getLoginName());
                                Boolean saveBankInfo = bankCardService.saveBankCardInfo(bankInfo);
                                //更新绑卡状态
                                if (saveBankInfo) {
                                    jsonO.put("requestno",responseParames.get("requestno"));
                                }
                                jsonO.put("requestno",responseParames.get("requestno"));
                                return Message.responseStr(Message.FAILURE_CODE,"内部服务异常", jsonO);*/
                            }
                        }

                    }
                }
                return Message.responseStr(Message.FAILURE_CODE,"已绑过卡，请解绑卡之后再操作");
            }
            return Message.responseStr(Message.FAILURE_CODE,"身份证不存在");

        }
        return Message.responseStr(Message.FAILURE_CODE,"不存在该编号");

    }
    //调用短信确认接口
    @RequestMapping(value = "/smsConfirm", method = RequestMethod.POST)
    @ResponseBody
    public String  smsConfirm(@RequestParam("validatecode") String validatecode,@RequestParam("requestNo") String requestNo) {
        //根据请求号与易宝交易号获取交易信息
        JSONObject jsonO = new JSONObject();
        /**
         * 调用易宝进行鉴权绑卡
         */
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno", requestNo);
        yopRequest.addParam("validatecode", validatecode);
        //回调接口
        logger.info("易宝绑卡流水号：" + ";请求参数：" + JSON.toJSONString(yopRequest));
        YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_SMS_COMFIRE_URL, yopRequest);
        logger.info("易宝绑卡流水号：" + requestNo + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
        Boolean aBoolean = bindCardTransService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"),responseParames.get("cardtop"),responseParames.get("cardlast"),responseParames.get("authtype"),responseParames.get("remark"));
        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
            //调用短信验证接口
            return  Message.responseStr(Message.SUCCESS_CODE, "待短验");
        }
        if ("BIND_FAIL".equals(responseParames.get("status"))) {
            //绑卡失败

            return  Message.responseStr(Message.FAILURE_CODE, "绑卡失败");
        }
        if ("BIND_ERRORE".equals(responseParames.get("status"))) {
            //绑卡异常

            return  Message.responseStr(Message.FAILURE_CODE, "绑卡异常");
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
            return Message.responseStr(Message.SUCCESS_CODE, "绑卡成功");

           /* //根据请求号与易宝号获取信息
            BindBankTrans bindBank = bindCardTransService.findBankState(requestNo,null);
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
            Boolean saveBankInfo = bankCardService.saveBankCardInfo(bankInfo);
            if(saveBankInfo){
                return Message.responseStr(Message.SUCCESS_CODE, "绑卡成功");
            }
            return Message.responseStr(Message.FAILURE_CODE, "后台服务异常");*/
        }
        return Message.responseStr(Message.PARAM_ILLEGAL_CODE,Message.PARAM_ILLEGAL_MSG);
    }
    //短信重发
    @RequestMapping(value = "/smsResend", method = RequestMethod.POST)
    @ResponseBody
    public String smsResend(@RequestParam("requestNo") String requestNo){
        //根据请求号与易宝交易号获取交易信息
      //  BindBankTrans bankState = bindCardTransService.findBankState(requestNo, null);
        JSONObject jsonO = new JSONObject();
        /**
         * 调用易宝进行鉴权绑卡
         */
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno", requestNo);
        logger.info("易宝绑卡流水号：" + ";请求参数：" + JSON.toJSONString(yopRequest));
        YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_SMS_RESEND_URL, yopRequest);

        logger.info("易宝绑卡流水号：" + requestNo + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
        bindCardTransService.modifyBankTran( responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"), responseParames.get("cardtop"),  responseParames.get("cardlast"),  responseParames.get("authtype"),  responseParames.get("remark"));
        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
            //调用短信验证接口
            return  Message.responseStr(Message.SUCCESS_CODE, "待短验");
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
            //系统异常
            return Message.responseStr(Message.SUCCESS_CODE, "绑卡成功");
        }
        return Message.responseStr(Message.PARAM_ILLEGAL_CODE,Message.PARAM_ILLEGAL_MSG);
    }
    //解绑银行卡
    @RequestMapping(value = "/deleteBankCard", method = RequestMethod.POST)
    @ResponseBody
    public String deleteBankCard(@RequestParam("customerId") String customerId){
        JSONObject jsonO = new JSONObject();
        //根据customerId 获取登录用户名；
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        String loginName=person.getPersonalUsername();
        //根据用户名获取userId,以及userMark
        SpsUser user = userService.findUserByUserName(loginName);
        //查询绑卡信息
        String userId = bankCardService.findUserId(customerId);
        if(StringUtil.isNotEmpty(userId)){
            //接触绑卡
            Boolean flag = bankCardService.removeBankCard(userId);
            if (flag){
                return Message.responseStr(Message.SUCCESS_CODE,"解除绑卡成功");
            }
            return Message.responseStr(Message.FAILURE_CODE,"解除绑卡失败");
        }
        return  Message.responseStr(Message.PARAM_ILLEGAL_CODE,Message.PARAM_ILLEGAL_MSG);
    }

    /**
     * 鉴权记录查询接口
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo query(@RequestParam("requestNo") String requestNo){
        //根据请求号与易宝交易号获取交易信息
        BindBankTrans bankState = bindCardTransService.findBankState(requestNo, null);
        ReturnInfo returnInfo = new ReturnInfo();
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno", requestNo);
        yopRequest.addParam("yborderid", bankState.getSerialYop());
        logger.info("易宝绑卡流水号：" +requestNo+ ";请求参数：" + JSON.toJSONString(yopRequest));
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
        if("BIND_SUCCESS".equals(responseParames.get("status"))){
            returnInfo.setMsg("绑卡成功");
        }

        return returnInfo;
    }
    /**
     * 鉴权列表查询接口
     */

    @RequestMapping(value = "/queryList", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo queryList(@RequestParam("userId") String userId){

        ReturnInfo returnInfo = new ReturnInfo();

        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("identityid", userId);
        yopRequest.addParam("identitytype","ID_CARD");
        logger.info("易宝绑卡流水号：" +userId+ ";请求参数：" + JSON.toJSONString(yopRequest));
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

