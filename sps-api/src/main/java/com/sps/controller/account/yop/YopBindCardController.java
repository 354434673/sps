package com.sps.controller.account.yop;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.juzifenqi.capital.entity.BinCode;
import com.juzifenqi.capital.service.IBankCodeService;
import com.juzifenqi.capital.service.IBinCodeService;
import com.juzifenqi.core.ServiceResult;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.common.StringUtil;
import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BindBankTrans;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.user.SpsUser;
import com.sps.service.account.bankCard.BankCardService;
import com.sps.service.account.bankCard.BindCardTransService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.user.UserService;
import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;


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
@RestController
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
    private BankCardService bankCardService;
    @Autowired
    private UserService userService;
     @Autowired
    BindCardTransService bindCardTransService;
  @Reference(group = "capital-dev1")
    private IBinCodeService iBinCodeService;
    //根据银行卡号获取银行名称的方法
    @RequestMapping(value = "/queryBankName/{binNo}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo queryBankName(String binNo){
        ServiceResult<BinCode> binCodeById = iBinCodeService.getBinCodeById(binNo);
        ReturnInfo returnInfo = new ReturnInfo();
        String shortName = binCodeById.getResult().getBankCode().getShortName();
        if(StringUtil.isNotEmpty(shortName)){
            returnInfo.setResult(shortName);
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }else {
            returnInfo.setResult(binCodeById.getMessage());
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;
    }

   //调用绑卡接口
    @RequestMapping(value = "/bindBankCard/{userName}/{personName}/{cardNo}/{phone}/{bankName}/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo bindBankCard(@PathVariable("userName") String userName,@PathVariable("personName") String personName,@PathVariable("cardNo") String cardNo,@PathVariable("phone") String phone,@PathVariable("bankName") String bankName,@PathVariable("id") Integer id) {
        ReturnInfo returnInfo = new ReturnInfo();
        //根据personId获取----以后身份证为 idCard
       String idcardno = shopkeeperPersonService.findPerson(id);
         //根据登录用户查询是否绑卡
        String userId = bankCardService.findUserId(userName);
        //根据用户名获取userId
         SpsUser user = userService.findUserByUserName(userName);
        ReturnInfo retrunInfo = new ReturnInfo();
        BindBankTrans bindBankTrades = new BindBankTrans();
        bindBankTrades.setBankName(bankName);
        bindBankTrades.setPhone(phone);
        bindBankTrades.setBankCode(cardNo);
        bindBankTrades.setLoginName(userName);
        bindBankTrades.setName(personName);
        bindBankTrades.setMerchantNo(YEEPAY_MERCHANT_NO);
        bindBankTrades.setIdentity(idcardno);
        bindBankTrades.setUserId(UUID.randomUUID().toString());
        //保存绑卡记录
     if (StringUtil.isNotEmpty(idcardno) && StringUtil.isNotEmpty(userId)) {
      HashMap<String, Object> map = bindCardTransService.saveBankTansInfos(bindBankTrades, userName, userId);
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
        yopRequest.addParam("idcardno",idcardno);
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
       String resre =responseParames.get("yborderid");
        Boolean aBoolean = bindCardTransService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"),responseParames.get("cardtop"),responseParames.get("cardlast"),responseParames.get("authtype"),responseParames.get("remark"));
        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
         //调用短信验证接口
            retrunInfo.setResult(responseParames.get("requestno"));
            retrunInfo.setMsg("待短验");

         return retrunInfo;
        }
        if ("BIND_FAIL".equals(responseParames.get("status"))) {
         //绑卡失败
            retrunInfo.setResult(responseParames.get("requestno"));

            retrunInfo.setMsg("绑卡失败");
         return retrunInfo;
        }
        if ("BIND_ERRORE".equals(responseParames.get("status"))) {

         //绑卡异常
            retrunInfo.setResult(responseParames.get("requestno"));
            retrunInfo.setMsg("绑卡异常");
         return retrunInfo;
        }
        if ("TIME_OUT".equals(responseParames.get("status"))) {

         //绑卡超时
         retrunInfo.setMsg("绑卡超时");
         return retrunInfo;
        }
        if ("FAIL".equals(responseParames.get("status"))) {

         //系统异常
            retrunInfo.setResult(responseParames.get("requestno"));
            retrunInfo.setMsg("系统异常");
         return retrunInfo;
        }
        if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
            //根据请求号与易宝号获取信息
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
            bankCardService.saveBankCardInfo(bankInfo,user.getUserId(),user.getUserMark());
           Boolean saveBankInfo = bankCardService.saveBankCardInfo(bankInfo, user.getUserId(), user.getUserMark());
         //跟新绑卡状态
         if (saveBankInfo) {
          retrunInfo.setMsg("操作绑卡成功");
          return retrunInfo;
         }
         retrunInfo.setMsg("后台操作绑卡失败");
         return retrunInfo;
        }
       }

      }
     }
     retrunInfo.setMsg("已绑过卡，请解绑卡之后再操作");
     return retrunInfo;
    }
 //调用短信确认接口
 @RequestMapping(value = "/smsConfirm/{userName}/{validatecode}/{requestNo}", method = RequestMethod.POST)
 @ResponseBody
 public ReturnInfo smsConfirm(@PathVariable("userName") String userName,@PathVariable("validatecode") String validatecode,@PathVariable("requestNo") String requestNo) {
  //根据请求号与易宝交易号获取交易信息
  BindBankTrans bankState = bindCardTransService.findBankState(requestNo, null);

  ReturnInfo returnInfo = new ReturnInfo();
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
  bindCardTransService.modifyBankTran((String) responseParames.get("requestno"), (String) responseParames.get("yborderid"), (String) responseParames.get("status"), (String) responseParames.get("cardtop"), (String) responseParames.get("cardlast"), (String) responseParames.get("authtype"), (String) responseParames.get("remark"));

  if ("TO_VALIDATE".equals(responseParames.get("status"))) {
   //调用短信验证接口
   returnInfo.setMsg("待短验");
   return returnInfo;
  }
  if ("BIND_FAIL".equals(responseParames.get("status"))) {
   //绑卡失败
   returnInfo.setMsg("绑卡失败");
   return returnInfo;
  }
  if ("BIND_ERRORE".equals(responseParames.get("status"))) {
   //绑卡异常
   returnInfo.setMsg("绑卡异常");
   return returnInfo;
  }
  if ("TIME_OUT".equals(responseParames.get("status"))) {
   //绑卡超时
   returnInfo.setMsg("绑卡超时");
   return returnInfo;
  }
  if ("FAIL".equals(responseParames.get("status"))) {
   //系统异常
   returnInfo.setMsg("系统异常");
   return returnInfo;
  }
  if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
      //根据登录用户查询是否绑卡
      String userId = bankCardService.findUserId(userName);
      //根据用户名获取userId
      SpsUser user = userService.findUserByUserName(userName);
      //根据请求号与易宝号获取信息
      BindBankTrans bindBank = bindCardTransService.findBankState(responseParames.get("requestno"), responseParames.get("yborderid"));
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
      Boolean flag = bankCardService.saveBankCardInfo(bankInfo, user.getUserId(), user.getUserMark());
      if(flag){
          returnInfo.setMsg("操作绑卡成功");
      }

   return returnInfo;
  }
  return returnInfo;
 }
 //短信重发
 @RequestMapping(value = "/smsResend/{requestNo}", method = RequestMethod.POST)
 @ResponseBody
 public ReturnInfo smsResend(@PathVariable("requestNo") String requestNo){
     //根据请求号与易宝交易号获取交易信息
     BindBankTrans bankState = bindCardTransService.findBankState(requestNo, null);

     ReturnInfo returnInfo = new ReturnInfo();
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
     bindCardTransService.modifyBankTran((String) responseParames.get("requestno"), (String) responseParames.get("yborderid"), (String) responseParames.get("status"), (String) responseParames.get("cardtop"), (String) responseParames.get("cardlast"), (String) responseParames.get("authtype"), (String) responseParames.get("remark"));
     if ("TO_VALIDATE".equals(responseParames.get("status"))) {
         //调用短信验证接口
         returnInfo.setMsg("待短验");
         return returnInfo;
     }
     if ("TIME_OUT".equals(responseParames.get("status"))) {
         //绑卡超时
         returnInfo.setMsg("绑卡超时");
         return returnInfo;
     }
     if ("FAIL".equals(responseParames.get("status"))) {
         //系统异常
         returnInfo.setMsg("系统异常");
         return returnInfo;
     }

     return returnInfo;
 }

/**
 * 鉴权记录查询接口
 * @return
 */
    @RequestMapping(value = "/query/{requestNo}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo query(@PathVariable("requestNo") String requestNo){
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

 @RequestMapping(value = "/queryList/{userId}", method = RequestMethod.POST)
 @ResponseBody
 public ReturnInfo queryList(@PathVariable("userId") String userId){

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

