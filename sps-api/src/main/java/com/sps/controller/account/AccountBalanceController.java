package com.sps.controller.account;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.HttpClientUtils;
import com.sps.common.JsonResult;
import com.sps.controller.BaseApi;
import com.sps.entity.bank.SpsBank;
import com.sps.enums.ReturnCode;
import com.sps.service.bank.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


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
@RestController
@RequestMapping("/api/accountBalance")
public class AccountBalanceController extends BaseApi{

    private static  final Log log = LogFactory.getLog(AccountBalanceController.class);
    @Autowired
    private BankService bankService;

    //按身份证号查询账户余额
    private static String getUserAmont = "http://dev.app.chezhubaitiao.com/api/customerAccount/getCustomerAccount";
    /**
     * 获取用户余额
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/findBalance")
    public JsonResult findBalance(String customerId){
        log.info("start--获取用户余额，请求参数 "+customerId);
        try {
            if (StringUtils.isBlank(customerId)){
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            SpsBank bank = bankService.findEntityByNo(customerId);
            Map resultMap= new HashMap<>();
            resultMap.put("application","dianfu");
            resultMap.put("certNo",bank.getbIdentity());
            String jsonResult = HttpClientUtils.post(getUserAmont, resultMap);
            log.info("end--获取用户余额，返回参数 "+jsonResult);
            if(StringUtils.isBlank(jsonResult)){
                return  returnFaild();
            }
            JSONObject job = JSON.parseObject(jsonResult);
            if(!"100000".equals(job.getString("code"))){
                return  returnFaild(job.getString("msg"));
            }
            return returnSuccess(job.getString("result"));

        } catch (Exception e){
            log.info("end--获取用户余额，异常 "+e.getMessage());
            return  returnFaild();
        }
    }
}

