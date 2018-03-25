package com.sps.controller.setPwd;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.juzifenqi.core.ServiceResult;
import com.juzifenqi.usercenter.entity.member.MemberInfo;
import com.juzifenqi.usercenter.service.ISmsCommonService;
import com.juzifenqi.usercenter.service.member.IMemberDianfuService;
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
@RequestMapping(value = "/api/setLoginPwd")
public class SetLoginPwdController {
    private static final Log logger = LogFactory.getLog(SetLoginPwdController.class);
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
    @RequestMapping(value = "/queryVerfilyCode", method = RequestMethod.GET)
    @ResponseBody
    public ServiceResult<Boolean> queryVerfilyCode(@RequestParam("phone") String phone) {
        logger.info("queryVerfilyCode 方法开始执行。。。。。。");
        // 调用短信验证码接口--获取短信验证码  category 3  ISmsCommonService.sendEditPasswordSms
        ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendForgetPasswordSms(phone,3);
        return sendRegisterSms;
    }


    /***
     * 修改登录密码（两种方式：按照手机号修改，方式二:按照原密码修改）
     * @param code
     * @param mobile
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/modifyLoaginPwd", method = RequestMethod.POST)
    @ResponseBody
    public  ServiceResult<MemberInfo> modifyLoaginPwd(@RequestParam("code") String code,
                                                      @RequestParam("mobile") String mobile,
                                                      @RequestParam("oldPwd") String oldPwd,
                                                      @RequestParam("newPwd") String newPwd) {
        //获取登录用户名---用户名就是手机号
        //  String userName = (String) SecurityUtils.getSubject().getPrincipal();
        ServiceResult<MemberInfo> memberInfoServiceResult=null;
        if (StringUtils.isNotEmpty(code)) {
            logger.info("editPasswordByMobile方法开始执行。。。。。。。。。。。");
            //根据手机号修改登录密码
            memberInfoServiceResult = memberDianfuService.editPasswordByMobile(code, mobile, newPwd);
            return memberInfoServiceResult;
        } else {
            //根据旧密码修改登录密码
            logger.info("editPasswordByOldPwd方法开始执行。。。。。。。。。。。");

            memberInfoServiceResult = memberDianfuService.editPasswordByOldPwd(oldPwd, newPwd, mobile);

            return memberInfoServiceResult;
        }
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
    public ServiceResult<MemberInfo>  forgetLoginPwd(@RequestParam("code") String code,
                                                     @RequestParam("mobile") String mobile,
                                                     @RequestParam("newPwd") String newPwd) {
        logger.info("forgetPassword方法开始执行。。。。。。。。。。。");
        ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.forgetPassword(code, mobile, newPwd);
        return memberInfoServiceResult;
    }


}