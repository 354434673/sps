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
@RequestMapping(value = "/api/setLoginPwd")
public class SetLoginPwdController {
    private static final Log logger = LogFactory.getLog(SetLoginPwdController.class);

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
        ReturnInfo returnInfo = new ReturnInfo();
        ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendForgetPasswordSms(phone, 3);
        if(sendRegisterSms.getSuccess()){
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
            return  returnInfo;
        }else{
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
            return returnInfo;
        }
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
    public  ReturnInfo modifyLoaginPwd(String code,
                                      String mobile,
                                      String oldPwd,
                                      String newPwd) {
        //获取登录用户名---用户名就是手机号
        //  String userName = (String) SecurityUtils.getSubject().getPrincipal();
        ServiceResult<MemberInfo> memberInfoServiceResult=null;
        ReturnInfo returnInfo = new ReturnInfo();
        if (StringUtils.isNotEmpty(code)) {
                logger.info("editPasswordByMobile方法开始执行。。。。。。。。。。。");
                //根据手机号修改登录密码
            try{
                memberInfoServiceResult = memberDianfuService.editPasswordByMobile(code, mobile, newPwd);
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
             return  returnInfo;
        } else {
                //根据旧密码修改登录密码
            logger.info("editPasswordByOldPwd方法开始执行。。。。。。。。。。。");
            try{
                memberInfoServiceResult = memberDianfuService.editPasswordByOldPwd(oldPwd, newPwd, mobile);
                returnInfo.setResult(memberInfoServiceResult.getResult());
                returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
                returnInfo.setCode(Message.API_SUCCESS_CODE);
                returnInfo.setMsg(Message.API_SUCCESS_MSG);

            }catch(Exception e ){
                e.printStackTrace();
                returnInfo.setCode(Message.FAILURE_CODE);
                returnInfo.setMsg(Message.FAILURE_MSG);
                returnInfo.setSuccess(Message.API_ERROR_FLAG);
            }
            return  returnInfo;

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
    public ReturnInfo  forgetLoginPwd(String code,
                                   String mobile,
                                   String newPwd) {
        logger.info("forgetPassword方法开始执行。。。。。。。。。。。");
        ReturnInfo returnInfo = new ReturnInfo();
        try{
            ServiceResult<MemberInfo> memberInfoServiceResult = memberDianfuService.forgetPassword(code, mobile, newPwd);
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