package com.sps.controller.setPwd;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.MemberInfo;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@RestController
@RequestMapping(value = "/api/setPaymentPwd")
public class SetPaymentPwdController {
    private static final Log logger = LogFactory.getLog(SetPaymentPwdController.class);

 /* @Reference(check=false,group="auth_dev1")
    private IDianfuPassportService idianPaswwService;*/

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
    public ReturnInfo queryVerfilyCode(@PathVariable("phone") String phone) {
        logger.info("queryVerfilyCode 方法开始执行。。。。。。");
        //  String userName = (String) SecurityUtils.getSubject().getPrincipal();
        // 调用短信验证码接口--获取短信验证码  category 3  ISmsCommonService.sendEditPasswordSms
        ReturnInfo returnInfo = new ReturnInfo();
        try{
            ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendForgetBalancePwdSms(phone,3);

            returnInfo.setResult(sendRegisterSms.getResult());
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;
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
    public ReturnInfo  modifyPaymentPwd(
            String mobile,
            String newPwd) {
        logger.info("editBalancePassword 方法开始执行。。。。。。。。。。。");
        ReturnInfo returnInfo = new ReturnInfo();
        try{
            ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.editBalancePassword(mobile, newPwd);
            returnInfo.setResult(memberInfoServiceResult.getResult());
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;

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
    public ReturnInfo forgetPaymentPwd(
            String code,
            String mobile,
            String newPwd) {
        logger.info("editBalancePassword 方法开始执行。。。。。。。。。。。");
        ReturnInfo returnInfo = new ReturnInfo();
        try{
            ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.forgetBalancePassword(mobile, newPwd,code);
            returnInfo.setResult(memberInfoServiceResult.getResult());
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }catch(Exception e){
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;
    }

}