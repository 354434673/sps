package com.sps.controller.account;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
import com.sps.common.Message;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.account.AuthRequest;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelBankTransReadService;
import org.sps.service.merchant.read.SpsBalanceReadService;
import org.sps.service.merchant.read.SpsChannelOpenAccountReadService;
import org.sps.service.merchant.write.AuthBindCardWriteService;
import org.sps.service.merchant.write.ChannelBankTransWriteService;
import org.sps.service.merchant.write.ChannelBankWriteService;
import org.sps.util.StringUtil;

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

    @Reference(check = false, group = "dianfu")
    private ChannelBankWriteService bankWriteService;

    @Reference(check = false, group = "dianfu")
    private SpsBalanceReadService spsBalanceService;

    @Reference(check = false, group = "dianfu")
    private SpsChannelOpenAccountReadService spsChannelOpenAccountReadService;

    @Reference(check = false, group = "dianfu")
    private ChannelBankReadService bankReadService;

    @Reference(check = false, group = "dianfu")
    private ChannelBankTransReadService bankTransReadService;

    @Reference(check = false, group = "dianfu")
    private ChannelBankTransWriteService bankTransWriteService;

    @Reference(check = false,group = "member-center-dev1")
    private ISmsCommonService ismsCommonService;

    @Resource
    private UserService userService;
    @Resource
    private UserAndRoleService userAndRoleService;
    //调用绑卡接口
    @RequestMapping("/bindBankCard")
    @ResponseBody
    public Result bindBankCard( SpsChannelBank bankInfo) {
        logger.info("【绑卡接口[bindBankCard]】，入参：【bankInfo】"+bankInfo);
        Result<String> result = new Result<String>();
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        //根据用户名 和用户类型查询Balance中是否存在 该用户
        SpsChannelBank bankCard = bankReadService.getBankInfo(userName);
        if(bankCard !=null){
            logger.info("【绑卡接口[bindBankCard]】- bankReadService.getBankInfo(userName)查询用户信息，返回空" +(String) SecurityUtils.getSubject().getPrincipal());
            result.setCode("7");
            result.setMsg("已绑过卡，请解绑卡之后再操作");
            return result;
        }
        SpsUser user = userService.findByUserName(userName);
        if(user ==null){
            result.setCode("10");
            result.setMsg("该商户的不存在");
            return result;
        }
        String channelNum = spsChannelOpenAccountReadService.selectByOpenAdminNum(userName);
        if(StringUtil.isEmpty(channelNum)){
            result.setCode("11");
            result.setMsg("该商户的渠道编号不存在");
            return result;
        }
        //保存一条交易交易记录
        SpsChannelBankTrans spsChannelBankTrans = new SpsChannelBankTrans();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        spsChannelBankTrans.setUserId(uuid);
        spsChannelBankTrans.setName(bankInfo.getName());
        spsChannelBankTrans.setBankName(bankInfo.getBank());
        spsChannelBankTrans.setIdentity(bankInfo.getIdentity());
        spsChannelBankTrans.setPhone(bankInfo.getPhone());
        spsChannelBankTrans.setMerchantNo(YEEPAY_MERCHANT_NO);
        spsChannelBankTrans.setLoginName(userName);
        spsChannelBankTrans.setSerialSh(uuid);
        spsChannelBankTrans.setBankCode(bankInfo.getAccounts());
        spsChannelBankTrans.setChannlNum(channelNum);
        //保存绑卡记录表
        Boolean flag = bankTransWriteService.saveBankTansInfos(spsChannelBankTrans);
       /* Boolean flag =(Boolean) map.get("flag");

        String num = (String) map.get("num");*/
        if(! flag){
            logger.info("【绑卡接口[bindBankCard]】- 调用bankTransWriteService.saveBankTansInfos(spsChannelBankTrans,userName)查询用户信息，返回空"+ spsChannelBankTrans+"-"+userName);
            result.setCode("9");
            result.setMsg("保存交易记录失败");
            return result;
        }
        YopRequest yopRequest = new YopRequest(YEEPAY_APP_KEY, "", YEEPAY_SERVER_ROOT);
        yopRequest.addParam("merchantno", YEEPAY_MERCHANT_NO);
        yopRequest.addParam("requestno", spsChannelBankTrans.getSerialSh());
        yopRequest.addParam("identityid", channelNum);
        yopRequest.addParam("identitytype", "ID_CARD");
        yopRequest.addParam("cardno", bankInfo.getAccounts());
        yopRequest.addParam("idcardno",bankInfo.getIdentity() );
        yopRequest.addParam("idcardtype", "ID");
        yopRequest.addParam("username", bankInfo.getName());
        yopRequest.addParam("phone",bankInfo.getPhone() );
        yopRequest.addParam("issms", "true");
        yopRequest.addParam("advicesmstype", "MESSAGE");
        yopRequest.addParam("requesttime", DateUtils.formatDate(new Date()));
        yopRequest.addParam("authtype", "COMMON_FOUR");
            //回调接口
       yopRequest.addParam("callbackurl", "");
        logger.info("易宝绑卡流水号：" + spsChannelBankTrans.getSerialSh() + ";请求参数：" + JSON.toJSONString(yopRequest));
         YopResponse yopResponse = YopClient3.postRsa(YEEPAY_BIND_CARD_REQUEST_URL, yopRequest);
        logger.info("易宝绑卡流水号：" + spsChannelBankTrans.getSerialSh() + ";返回参数：" + JSON.toJSONString(yopResponse));
        TreeMap<String, String> responseParames = JSON.parseObject(yopResponse.getStringResult(), new TypeReference<TreeMap<String, String>>() {
        });
        Boolean aBoolean = bankTransWriteService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"),responseParames.get("cardtop"),responseParames.get("cardlast"),responseParames.get("authtype"),responseParames.get("remark"));
        result.setBody(responseParames.get("requestno"));
        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
            //调用短信验证接口
            result.setMsg(responseParames.get("message"));
            result.setCode("0");
            return result;
        }
        if("BIND_FAIL".equals(responseParames.get("status"))){
                //绑卡失败
                result.setMsg(responseParames.get("errormsg"));
                result.setCode("1");
                return result;
            }
        if("BIND_ERRORE".equals(responseParames.get("status"))){
            //绑卡异常
            result.setMsg(responseParames.get("errormsg"));
            result.setCode("2");
            return result;
        }
        if("TIME_OUT".equals(responseParames.get("status"))){
            //绑卡超时
            result.setMsg(responseParames.get("errormsg"));
            result.setCode("3");
            return result;
        }
        if("FAIL".equals(responseParames.get("status"))){
            //系统异常
            result.setMsg(responseParames.get("errormsg"));
            result.setCode("4");
            return result;
        }
        if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
            //保存绑卡记录
            SpsChannelBank bindCardInfo = new SpsChannelBank();
            bindCardInfo.setUserId(spsChannelBankTrans.getUserId());
            bindCardInfo.setAccounts(spsChannelBankTrans.getBankCode());
            bindCardInfo.setBank(spsChannelBankTrans.getBankName());
            bindCardInfo.setPhone(spsChannelBankTrans.getPhone());
            bindCardInfo.setIdentity(spsChannelBankTrans.getIdentity());
            bindCardInfo.setName(spsChannelBankTrans.getName());
            bindCardInfo.setChannlNum(spsChannelBankTrans.getChannlNum());
            bindCardInfo.setUserName(spsChannelBankTrans.getLoginName());
            bindCardInfo.setState(1);
            bindCardInfo.setFlag(0);
            bindCardInfo.setCreatetime(new Date());
            bindCardInfo.setUserMark(user.getUserMark());
            Boolean saveBankInfo = bankWriteService.saveBankInfo(bindCardInfo,  user.getUserMark());
            if (saveBankInfo) {
                result.setCode("5");
                result.success();
                result.setMsg("操作绑卡成功");
                return result;
            }
            result.setCode("6");
            result.setBody(responseParames.get("requestno"));
            result.setMsg(responseParames.get("errormsg"));
            return result;
        }
        result.setCode("8");
        result.setBody(responseParames.get("requestno"));
        result.setMsg("超过同一卡绑定用户数");
        return result;
        }
    //调用短信确认接口
    @RequestMapping("/smsConfirm")
    @ResponseBody
    public Result  smsConfirm( String validatecode, String requestNo) {
        //根据请求号与易宝交易号获取交易信息
        Result<String> result = new Result<String>();
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
        Boolean aBoolean = bankTransWriteService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"),responseParames.get("cardtop"),responseParames.get("cardlast"),responseParames.get("authtype"),responseParames.get("remark"));
        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
            //调用短信验证接口
            result.setCode("0");
            result.setMsg("待短验");
            return result;
        }
        if ("BIND_FAIL".equals(responseParames.get("status"))) {
            //绑卡失败
            result.setCode("1");
            result.setMsg(responseParames.get("errormsg"));
            return result;
        }
        if ("BIND_ERRORE".equals(responseParames.get("status"))) {
            //绑卡异常
            result.setCode("2");
            result.setMsg(responseParames.get("errormsg"));
            return result;
        }
        if ("TIME_OUT".equals(responseParames.get("status"))) {
            //绑卡超时
            result.setCode("3");
            result.setMsg(responseParames.get("errormsg"));
            return result;
        }
        if ("FAIL".equals(responseParames.get("status"))) {
            //系统异常
            result.setCode("4");
            result.setMsg(responseParames.get("errormsg"));
            return result;
        }
        if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
            //根据请求号与易宝号获取信息
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            SpsChannelBankTrans bindBank = bankTransReadService.findBankState(responseParames.get("requestno"), responseParames.get("yborderid"));
            SpsUser user = userService.findByUserName(userName);
            //保存绑卡记录
            SpsChannelBank bindCardInfo = new SpsChannelBank();
            bindCardInfo.setUserId(bindBank.getUserId());
            bindCardInfo.setAccounts(bindBank.getBankCode());
            bindCardInfo.setBank(bindBank.getBankName());
            bindCardInfo.setPhone(bindBank.getPhone());
            bindCardInfo.setIdentity(bindBank.getIdentity());
            bindCardInfo.setName(bindBank.getName());
            bindCardInfo.setChannlNum(bindBank.getChannlNum());
            bindCardInfo.setUserName(bindBank.getLoginName());
            bindCardInfo.setState(1);
            bindCardInfo.setFlag(0);
            bindCardInfo.setCreatetime(new Date());
            bindCardInfo.setUserMark(user.getUserMark());
            Boolean saveBankInfo = bankWriteService.saveBankInfo(bindCardInfo, user.getUserMark());
            if (saveBankInfo) {
                result.setCode("5");
                result.setMsg("操作绑卡成功");
                return result;
            }
            result.setCode("6");
            result.setMsg("后台操作绑卡失败");
            return result;
        }
        result.setCode("8");
        result.setMsg("请求参数异常");
        return result;
    }
    //短信重发
    @RequestMapping(value = "/smsResend", method = RequestMethod.POST)
    @ResponseBody
    public Result smsResend(@RequestParam("requestNo") String requestNo){
        //根据请求号与易宝交易号获取交易信息
        Result<String> result = new Result<String>();
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
        Boolean aBoolean = bankTransWriteService.modifyBankTran(responseParames.get("requestno"), responseParames.get("yborderid"), responseParames.get("status"),responseParames.get("cardtop"),responseParames.get("cardlast"),responseParames.get("authtype"),responseParames.get("remark"));
        if ("TO_VALIDATE".equals(responseParames.get("status"))) {
            //调用短信验证接口
            result.setCode("0");
            result.setMsg("待短验");
            return result;
        }
        if ("TIME_OUT".equals(responseParames.get("status"))) {
            //绑卡超时
            result.setCode("3");
            result.setMsg("绑卡超时");
            return result;
        }
        if ("FAIL".equals(responseParames.get("status"))) {
            //系统异常
            result.setCode("4");
            result.setMsg("系统异常");
            return result;
        }
        if ("BIND_SUCCESS".equals(responseParames.get("status"))) {
            //根据请求号与易宝号获取信息
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            SpsChannelBankTrans bindBank = bankTransReadService.findBankState(responseParames.get("requestno"), responseParames.get("yborderid"));
            SpsUser user = userService.findByUserName(userName);
            //保存绑卡记录
            SpsChannelBank bindCardInfo = new SpsChannelBank();
            bindCardInfo.setUserId(bindBank.getUserId());
            bindCardInfo.setAccounts(bindBank.getBankCode());
            bindCardInfo.setBank(bindBank.getBankName());
            bindCardInfo.setPhone(bindBank.getPhone());
            bindCardInfo.setIdentity(bindBank.getIdentity());
            bindCardInfo.setName(bindBank.getName());
            bindCardInfo.setChannlNum(bindBank.getChannlNum());
            bindCardInfo.setUserName(bindBank.getLoginName());
            bindCardInfo.setState(1);
            bindCardInfo.setFlag(0);
            bindCardInfo.setCreatetime(new Date());
            bindCardInfo.setUserMark(user.getUserMark());
            Boolean saveBankInfo = bankWriteService.saveBankInfo(bindCardInfo, user.getUserMark());
            if (saveBankInfo) {
                result.setCode("5");
                result.setMsg("操作绑卡成功");
                return result;
            }
            result.setCode("6");
            result.setMsg("后台操作绑卡失败");
            return result;
        }
        result.setCode("8");
        result.setMsg("请求参数异常");
        return result;
    }
    @RequestMapping("/bankCardDetail")
    @ResponseBody
    public JSONObject bankCardDetail(HttpServletRequest request){
        JSONObject result = new JSONObject();
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        SpsChannelBank bankCard = bankReadService.getBankInfoByUserName(userName);
        result.put("bankCard", bankCard);
        result.put("isDEL",bankCard == null?"1":"0");
        return result;
    }
    @RequestMapping("/unbindBackCard")
    @ResponseBody
    public Result unbindBackCard(HttpServletRequest request,String isDEL){
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        Result result = new Result<Boolean>();
        String msg = "解绑成功";
        Boolean delete = bankWriteService.removeBankInfo(userName);
        msg = delete?"解绑成功":"解绑失败";
        result.setBody(delete);
        result.setMsg(msg);
        return result;
    }
}