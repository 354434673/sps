package com.sps.controller.account;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.sps.common.JsonResult;
import com.sps.common.ReturnInfo;
import com.sps.controller.BaseApi;
import com.sps.enums.ReturnCode;
import com.sps.service.account.balance.AccountBalanceService;
import com.sps.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
/**
 * Created by Administrator on 2018-03-09.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping("/api/accountBalance")
public class AccountBalanceController extends BaseApi{

    private static  final Log log = LogFactory.getLog(AccountBalanceController.class);
    @Autowired
    private AccountBalanceService accountBalanceService;

    @Autowired
    private UserService userService;


    /**
     * 获取用户余额
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/findBalance")
    public JsonResult findBalance(String customerId){
        log.info("start--获取用户余额，请求参数 "+customerId);
       if (StringUtils.isBlank(customerId)){
           return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
       }
        try {
            BigDecimal balance = accountBalanceService.queryByCustomerId(customerId);
            log.info("end--获取用户余额，返回参数 "+balance.doubleValue());
            DecimalFormat df=new DecimalFormat("0.00");
         return  returnSuccess( df.format(balance.doubleValue()).toString());
        } catch (Exception e){
            log.info("end--获取用户余额，异常 "+e.getMessage());
            return  returnFaild();
        }
    }
}

