package com.sps.controller.app;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sps.common.ReturnInfo;
import com.sps.common.UUIDFactory;

import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2018-03-15.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping("/yopBingCard")
public class YopBingCardController {

    private static final Log logger = LogFactory.getLog(YopBingCardController.class);
    private static final String YEEPAY_APP_KEY = "SQKK10015089427";

    private static final String YEEPAY_SERVER_ROOT = "https://open.yeepay.com/yop-center";

    private static final String YEEPAY_BIND_CARD_REQUEST_URL = " https://open.yeepay.com/yop-center/rest/v1.0/paperorder/unified/auth/request";
    private static final String YEEPAY_BIND_CARD_SMS_COMFIRE_URL = "https://open.yeepay.com/yop-center/rest/v1.0/paperorder/auth/confirm";

    private static final String YEEPAY_MERCHANT_NO = "10015089427";

    //调用绑卡接口
    @RequestMapping(value = "/bindBankCard", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo bindBankCard() throws  Exception {
        //保存绑卡记录表
        /**
         * 调用易宝进行鉴权绑卡
         */
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY,"", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno",UUIDFactory.getUUIDStr());
        yopRequest.addParam("identityid",UUIDFactory.getUUIDStr());
        yopRequest.addParam("identitytype", "ID_CARD");
        yopRequest.addParam("cardno", "6217211107001880725");
        yopRequest.addParam("idcardno","410801197909035685");
        yopRequest.addParam("idcardtype","ID");
        yopRequest.addParam("username", "hhh");
        yopRequest.addParam("phone", "13456713602");
        yopRequest.addParam("issms", "false");
        yopRequest.addParam("advicesmstype", "MESSAGE");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(new Date());
        yopRequest.addParam("requesttime",dateString);
        yopRequest.addParam("authtype", "COMMON_FOUR");
        //回调接口

        logger.info("易宝绑卡流水号：" + ";请求参数：" + JSON.toJSONString(yopRequest));
        YopResponse yopResponse = YopClient3.postRsa("https://open.yeepay.com/yop-center/rest/v1.0/paperorder/unified/auth/request", yopRequest);
        logger.info(yopRequest);
        logger.info("易宝绑卡流水号：" + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
        ReturnInfo returnInfo = new ReturnInfo();
        if ("TO_VALIDATE".equals(yopResponse.getState())) {
            //调用短信验证接口
            returnInfo.setMsg("待短验");
            return returnInfo;
        }
        if ("BIND_FAIL".equals(yopResponse.getState())) {
            //绑卡失败
            returnInfo.setMsg("绑卡失败");
            return returnInfo;
        }
        if ("BIND_ERRORE".equals(yopResponse.getState())) {

            //绑卡异常
            returnInfo.setMsg("绑卡异常");
            return returnInfo;
        }
        if ("TIME_OUT".equals(yopResponse.getState())) {
            //绑卡超时
            returnInfo.setMsg("绑卡超时");
            return returnInfo;
        }
        if ("FAIL".equals(yopResponse.getState())) {
            //系统异常
            returnInfo.setMsg("系统异常");
            return returnInfo;
        }
        if ("SUCCESS".equals(yopResponse.getState())) {

            returnInfo.setMsg("后台操作绑卡失败");
            return returnInfo;
        }
        returnInfo.setMsg("已绑过卡，请解绑卡之后再操作");
        return returnInfo;
    }

    @RequestMapping(value = "/sendMsm", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo sendMsm() throws Exception {
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY,"",YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno",YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno","A12345678");
        yopRequest.addParam("validatecode","345678");
        logger.info("易宝绑卡流水号：" + ";请求参数：" + JSON.toJSONString(yopRequest));
        YopResponse yopResponse = YopClient3.postRsa("https://open.yeepay.com/yop-center/rest/v1.0/paperorder/auth/confirm", yopRequest);
        logger.info("易宝绑卡流水号：" + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
       return null;
    }
    public static String getRandom(int length) {
        Random random = new Random();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
            if (isChar) { // 字符串
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                ret.append((char) (choice + random.nextInt(26)));
            } else { // 数字
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }
        return ret.toString();
    }

}

