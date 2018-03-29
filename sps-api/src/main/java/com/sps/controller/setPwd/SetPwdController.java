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
import com.sps.common.Message;
import com.sps.common.ReturnInfo;

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
@RequestMapping(value = "/api/setPwd")
public class SetPwdController {
    private static final Log logger= LogFactory.getLog(SetPwdController.class);

  @Reference(check=false,group="auth_dev1")
    private IDianfuPassportService idianPaswwService;

    @Reference(group="member-center-dev1")
    private IMemberDianfuService memberDianfuService;


    @Reference(group = "member-center-dev1")
    private ISmsCommonService ismsCommonService;

   @RequestMapping(value="/queryVerfilyCode/{phone}",method = RequestMethod.GET)
   @ResponseBody
    public ServiceResult<Boolean> queryVerfilyCode(@PathVariable("phone") String  phone){

        //  String userName = (String) SecurityUtils.getSubject().getPrincipal();
        // 调用短信验证码接口--获取短信验证码  category 3  ISmsCommonService.sendEditPasswordSms
       ServiceResult<Boolean> sendRegisterSms = ismsCommonService.sendEditPasswordSms(phone, 3);
       
        return  sendRegisterSms;
   }



    @RequestMapping(value="/modifyLoaginPwd",method = RequestMethod.POST)
    @ResponseBody
    public ServiceResult<MemberInfo> modifyLoaginPwd( String mobile,
                                      String oldPwd,
                                     String newPwd
                                    ) {
        //获取登录用户名---用户名就是手机号
        //  String userName = (String) SecurityUtils.getSubject().getPrincipal();
        ServiceResult<MemberInfo> result = memberDianfuService.editPasswordByOldPwd(oldPwd,newPwd, mobile);
        ReturnInfo returnInfo = new ReturnInfo();
        if(result.getSuccess()){
            logger.info("返回code " + result.getCode());
            logger.info("返回信息"+    result.getMessage());
            logger.info("返回数据"+  result.getResult());
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }else{
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return result;
    }
}
