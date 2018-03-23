package com.sps.controller.account.yop;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sps.common.ReturnInfo;
import com.sps.common.StringUtil;
import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BindBankTrans;
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
@RequestMapping("/api/yopPay")
public class YopPayController {
   private static final Log logger = LogFactory.getLog(YopPayController.class);
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

 /**
  * 支付请求
  * @return
  */
 @RequestMapping(value = "/payRequest", method = RequestMethod.POST)
 @ResponseBody
 public ReturnInfo payRequest() {
  ReturnInfo returnInfo = new ReturnInfo();
  YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
  yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
  yopRequest.addParam("requestno", "true");
  yopRequest.addParam("issms", "true");
  yopRequest.addParam("identityid", "true");
  yopRequest.addParam("identitytype", "ID_CARD");
  yopRequest.addParam("cardtop", "true");
  yopRequest.addParam("cardlast", "true");
  yopRequest.addParam("amount", "true");
  yopRequest.addParam("productname", null);
  yopRequest.addParam("terminalno", "true");
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String dateString = sdf.format(new Date());
  yopRequest.addParam("requesttime", dateString);
  //回调接口
  logger.info("易宝绑卡流水号：" + ";请求参数：" + JSON.toJSONString(yopRequest));
  YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_REQUEST_URL, yopRequest);

  TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
  });
  String resre = responseParames.get("yborderid");
  return null;
 }


}

