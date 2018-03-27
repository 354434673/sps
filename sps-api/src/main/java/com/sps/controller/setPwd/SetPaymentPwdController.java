package com.sps.controller.setPwd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.MemberInfo;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.authorization.IDianfuPassportService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;

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
@RestController
@RequestMapping(value = "/api/setPaymentPwd")
public class SetPaymentPwdController {
    private static final Log logger = LogFactory.getLog(SetPaymentPwdController.class);

  @Reference(check=false,group="auth_dev1")
    private IDianfuPassportService idianPaswwService;

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
    @RequestMapping(value = "/queryVerfilyCode/{phone}", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<Boolean> queryVerfilyCode(@PathVariable("phone") String phone) {
        logger.info("queryVerfilyCode 方法开始执行。。。。。。");
        //  String userName = (String) SecurityUtils.getSubject().getPrincipal();
        // 调用短信验证码接口--获取短信验证码  category 3  ISmsCommonService.sendEditPasswordSms

        ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendForgetBalancePwdSms(phone,3);
        return sendRegisterSms;
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
    public ServiceResult<MemberInfo>  modifyPaymentPwd(
            String mobile,
            String newPwd) {
        logger.info("editBalancePassword 方法开始执行。。。。。。。。。。。");
        ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.editBalancePassword(mobile, newPwd);
        return memberInfoServiceResult;
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
    public ServiceResult<MemberInfo>  forgetPaymentPwd(
            String code,
            String mobile,
            String newPwd) {
        logger.info("editBalancePassword 方法开始执行。。。。。。。。。。。");
        ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.forgetBalancePassword(mobile, newPwd,code);
        return memberInfoServiceResult;
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
    @RequestMapping(value = "/editPaymentPwd", method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult<MemberInfo>  editPaymentPwd(
            String code,
            String mobile,
            String newPwd) {
        logger.info("editBalancePassword 方法开始执行。。。。。。。。。。。");
        ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.editBalancePassword(mobile, newPwd);
        return memberInfoServiceResult;
    }
}