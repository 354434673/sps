package com.sps.controller.setPwd;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.MemberInfo;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
import com.sps.common.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018-03-12.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping(value = "/api/setPaymentPwd")
public class SetPaymentPwdController {
    private static final Log logger = LogFactory.getLog(SetPaymentPwdController.class);

    @Reference(check = false, group = "member-center-dev1")
    private IMemberDianfuService memberDianfuService;

    @Reference(group = "member-center-dev1")
    private ISmsCommonService ismsCommonService;
    /**
     * 获取手机验证码
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/queryVerfilyCode", method = RequestMethod.POST)
    @ResponseBody
    public String  queryVerfilyCode(@RequestParam("phone") String phone) {
        logger.info("queryVerfilyCode 方法开始执行。。。。。。");
        JSONObject json = new JSONObject ();
        logger.info("queryVerfilyCode 方法开始执行。。。。。。");
        ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendForgetBalancePwdSms(phone,3);
        if(sendRegisterSms.getSuccess()){
            json.put("success",sendRegisterSms.getSuccess());
            return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
        }
        json.put("success",sendRegisterSms.getSuccess());
        return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);
    }

    /**
     * 修改交易密码
     *
     * @param
     * @param mobile
     * @param
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/modifyPaymentPwd", method = RequestMethod.POST)
    @ResponseBody
    public String  modifyPaymentPwd(
            @RequestParam("mobile") String mobile,
            @RequestParam("newPwd") String newPwd) {
        logger.info("editBalancePassword 方法开始执行。。。。。。。。。。。");
        JSONObject json = new JSONObject ();
        ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.editBalancePassword(mobile, newPwd);
        if(memberInfoServiceResult.getSuccess()){
            json.put("success",memberInfoServiceResult.getSuccess());
            return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
        }
        json.put("success",memberInfoServiceResult.getSuccess());
        return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);
    }

    /**
     * 忘记交易密码
     *
     * @param
     * @param mobile
     * @param
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/forgetPaymentPwd", method = RequestMethod.POST)
    @ResponseBody
    public String  forgetPaymentPwd(@RequestParam("code") String code, @RequestParam("mobile") String mobile, @RequestParam("newPwd") String newPwd) {
        JSONObject json = new JSONObject ();
        logger.info("forgetPassword方法开始执行。。。。。。。。。。。");
        ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.forgetBalancePassword(mobile, newPwd,code);
        if(memberInfoServiceResult.getSuccess()){
            json.put("success",memberInfoServiceResult.getSuccess());
            return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
        }
        json.put("success",memberInfoServiceResult.getSuccess());
        return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);

    }

}