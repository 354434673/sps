package com.sps.controller.account;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
import com.sps.common.Result;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;
import com.sps.util.UUIDFactory;
import com.yeepay.g3.sdk.yop.client.YopClient3;
import com.yeepay.g3.sdk.yop.client.YopRequest;
import com.yeepay.g3.sdk.yop.client.YopResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.utils.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.account.AuthRequest;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelBankTransReadService;
import org.sps.service.merchant.read.SpsBalanceReadService;
import org.sps.service.merchant.write.AuthBindCardWriteService;
import org.sps.service.merchant.write.ChannelBankTransWriteService;
import org.sps.service.merchant.write.ChannelBankWriteService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    private static final Log logger = LogFactory.getLog(BankCardController.class);
    private static final String YEEPAY_APP_KEY = "SQKK10015089427";

    private static final String YEEPAY_SERVER_ROOT = "https://open.yeepay.com/yop-center";

    private static final String YEEPAY_BIND_CARD_REQUEST_URL = "/rest/v1.0/paperorder/unified/auth/request";
    private static final String YEEPAY_BIND_CARD_SMS_COMFIRE_URL = "/rest/v1.0/paperorder/auth/confirm";

    private static final String YEEPAY_MERCHANT_NO = "10015089427";

    @Reference(check = false, group = "dianfu")
    private ChannelBankWriteService bankWriteService;
   /* @Reference(check = false, group = "dianfu")
    private SpsBankCardBindExceptionService  spsBankCardBindExceptionService;*/

    @Reference(check = false, group = "dianfu")
    private SpsBalanceReadService spsBalanceService;

    @Reference(check = false, group = "dianfu")
    private ChannelBankReadService bankReadService;
    @Reference(check = false, group = "dianfu")
    private ChannelBankTransReadService bankTransReadService;
    @Reference(check = false, group = "dianfu")
    private ChannelBankTransWriteService bankTransWriteService;
    @Reference(check = false, group = "dianfu")
    private AuthBindCardWriteService authBindCardWrite;


    @Reference(check = false, group = "member-center-dev1")
    private IMemberDianfuService memberDianfuService;


    @Reference(group = "member-center-dev1")
    private ISmsCommonService ismsCommonService;

    @Resource
    private UserService userService;
    @Resource
    private UserAndRoleService userAndRoleService;


    @RequestMapping("/getVerifyCode")
    @ResponseBody
    public ServiceResult<Boolean> getVerifyCode(String phone) {
        logger.info("getVerifyCode 方法 开始调用。。。。。。。");

        ServiceResult<Boolean> result = ismsCommonService.sendForgetPasswordSms(phone, 3);
		/*return sendRegisterSms;
		//去后台下校验手机号
		HashMap<String, Object> result=new HashMap<String, Object>();*/
		//转发第三方支付平台
        return result;

    }

    //调用绑卡接口
    @RequestMapping("/bindBankCard")
    @ResponseBody
    public Result bindBankCard(HttpServletRequest request, HttpServletResponse response, SpsChannelBank bankInfo) {
        JSONObject body = new JSONObject();
        Result<JSONObject> result = new Result<JSONObject>(body);
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        //根据用户名 和用户类型查询Balance中是否存在 该用户
        SpsChannelBank bankCard = bankReadService.getBankInfo(userName);
        if (bankCard == null) {
            SpsUser user = userService.findByUserName(userName);
            String userId = UUIDFactory.getUUIDStr();
            bankInfo.setUserId(userId);
            //保存绑卡记录表
            HashMap<String, Object> map = bankTransWriteService.saveBankTansInfos(bankInfo, userName, YEEPAY_MERCHANT_NO, userId);
            Boolean flag = (Boolean) map.get("flag");
            if (flag == true) {
                SpsChannelBankTrans spsChannelBankTrans = (SpsChannelBankTrans) map.get("spsChannelBankTrans1");
                /**
                 * 调用易宝进行鉴权绑卡
                 */
                YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
                yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
                yopRequest.addParam("requestno", spsChannelBankTrans.getSerialSh());
                yopRequest.addParam("identityid", spsChannelBankTrans.getUserId());
                yopRequest.addParam("identitytype", "ID_CARD");
                yopRequest.addParam("cardno", spsChannelBankTrans.getBankCode());
                yopRequest.addParam("idcardno", spsChannelBankTrans.getIdentity());
                yopRequest.addParam("idcardtype", "ID");
                yopRequest.addParam("username", spsChannelBankTrans.getName());
                yopRequest.addParam("phone", spsChannelBankTrans.getPhone());
                yopRequest.addParam("issms", "false");
                yopRequest.addParam("advicesmstype", "MESSAGE");
                yopRequest.addParam("requesttime", DateUtils.formatDate(new Date()));
                yopRequest.addParam("authtype", "COMMON_FOUR");
                //回调接口
               yopRequest.addParam("callbackurl", "");

                logger.info("易宝绑卡流水号：" + spsChannelBankTrans.getSerialSh() + ";请求参数：" + JSON.toJSONString(yopRequest));
                YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_REQUEST_URL, yopRequest);
                logger.info("易宝绑卡流水号：" + spsChannelBankTrans.getSerialSh() + ";返回参数：" + JSON.toJSONString(response));
                TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
                });
                Boolean aBoolean = bankTransWriteService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"));
                if("TO_VALIDATE".equals(yopResponse.getState())){
                    //调用短信验证接口
                    result.setMsg("待短验");
                    return result;
                }
                if("BIND_FAIL".equals(yopResponse.getState())){
                    //绑卡失败
                    result.setMsg("绑卡失败");
                    return result;
                }
                if("BIND_ERRORE".equals(yopResponse.getState())){

                    //绑卡异常
                    result.setMsg("绑卡异常");
                    return result;
                }
                if("TIME_OUT".equals(yopResponse.getState())){
                    //绑卡超时
                    result.setMsg("绑卡超时");
                    return result;
                }
                if("FAIL".equals(yopResponse.getState())){
                    //系统异常
                    result.setMsg("系统异常");
                    return result;
                }
                if("BIND_SUCCESS".equals(yopResponse.getState())){
                    Boolean saveBankInfo = bankWriteService.saveBankInfo(bankInfo, userName, user.getUserId(), user.getUserMark());
                    if (saveBankInfo) {
                        result.success();
                        result.setMsg("操作绑卡成功");
                        return result;
                    }
                    result.setMsg("后台操作绑卡失败");
                    return result;
                }
            }


        }
        result.setMsg("已绑过卡，请解绑卡之后再操作");
        return result;
    }
    //调用绑卡接口
   /* @RequestMapping("/bindBankCardOutTime")
    @ResponseBody
    public Result<Boolean> bindBankCardOutTime(HttpServletRequest request, HttpServletResponse response, YopResponse  yopResponse ) {
        Result<Boolean> result = new Result<>();
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
        SpsBankCardBingException spsBankCardBingException = new SpsBankCardBingException();
        spsBankCardBingException.setMerchantNo(responseParames.get("merchantno"));
        spsBankCardBingException.setRequestNo(responseParames.get("requestno"));
        spsBankCardBingException.setYborderId(responseParames.get("yborderid"));
        spsBankCardBingException.setState(responseParames.get("status"));
        spsBankCardBingException.setBankCode(responseParames.get("bankcode"));
        spsBankCardBingException.setCardLast(responseParames.get("cardlast"));
        spsBankCardBingException.setCardTop(responseParames.get("cardtop"));
        spsBankCardBingException.setErrorCode(responseParames.get("errorcode"));
        spsBankCardBingException.setErrorMsg(responseParames.get("errormsg"));
        try{
            //保存超时绑卡记录
            Boolean flag = spsBankCardBindExceptionService.saveBankCardBindException(spsBankCardBingException);
            result.setBody(true);
        }catch(Exception e){
           e.printStackTrace();
            result.setBody(false);

        }
        return  result;
    }*/


}