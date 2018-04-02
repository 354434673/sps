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

import javax.annotation.Resource;

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
@RequestMapping(value = "/api/setLoginPwd")
public class SetLoginPwdController {
    private static final Log logger = LogFactory.getLog(SetLoginPwdController.class);

    @Reference(check = false, group = "member-center-dev1")
    private IMemberDianfuService   memberDianfuService;
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
        JSONObject json = new JSONObject ();
        logger.info("queryVerfilyCode 方法开始执行。。。。。。");
        ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendForgetPasswordSms(phone,3);
        if(sendRegisterSms.getSuccess()){
            json.put("success",sendRegisterSms.getSuccess());
            return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
        }
        json.put("success",sendRegisterSms.getSuccess());
        return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);

    }


    /***
     * 按照原密码修改修改登录密码
     * @param mobile
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/modifyLoaginPwdByOldPwd", method = RequestMethod.POST)
    @ResponseBody
    public  String modifyLoaginPwdByOldPwd(
                                                      @RequestParam("mobile") String mobile,
                                                      @RequestParam("oldPwd") String oldPwd,
                                                      @RequestParam("newPwd") String newPwd) {
        JSONObject json = new JSONObject ();
        //根据旧密码修改登录密码
        logger.info("editPasswordByOldPwd方法开始执行。。。。。。。。。。。");

        ServiceResult<MemberInfo> memberInfoServiceResult= memberDianfuService.editPasswordByOldPwd(oldPwd, newPwd, mobile);
        if(memberInfoServiceResult.getSuccess()){
            json.put("success",memberInfoServiceResult.getSuccess());
            return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
        }
        json.put("success",memberInfoServiceResult.getSuccess());
        return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);

    }

    /**
     * 按照手机号修改修改登录密码
     * @param mobile
     * @param code
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/modifyLoaginPwdByPhone", method = RequestMethod.POST)
    @ResponseBody
    public String  modifyLoaginPwdByPhone(
            @RequestParam("code") String code,
            @RequestParam("mobile") String mobile,
            @RequestParam("newPwd") String newPwd) {
        //按照手机号修改修改登录密码
        JSONObject json = new JSONObject ();
        ServiceResult<MemberInfo> memberInfoServiceResult= memberDianfuService.editPasswordByOldPwd(newPwd, mobile, code);
        if(memberInfoServiceResult.getSuccess()){
            json.put("success",memberInfoServiceResult.getSuccess());
            return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
        }
        json.put("success",memberInfoServiceResult.getSuccess());
        return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);

    }
    /**
     * 忘记登录密码
     *
     * @param code
     * @param mobile
     * @param
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/forgetLoginPwd", method = RequestMethod.POST)
    @ResponseBody
    public String   forgetLoginPwd(@RequestParam("code") String code,
                                                     @RequestParam("mobile") String mobile,
                                                     @RequestParam("newPwd") String newPwd) {
            //忘记登录密码
            JSONObject json = new JSONObject ();
        logger.info("forgetPassword方法开始执行。。。。。。。。。。。");
            ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.forgetPassword(code, mobile, newPwd);
            if(memberInfoServiceResult.getSuccess()){
                json.put("success",memberInfoServiceResult.getSuccess());
                return  Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG,json);
            }
            json.put("success",memberInfoServiceResult.getSuccess());
            return  Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, json);
    }
}