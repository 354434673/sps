package com.sps.controller.account;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.user.SpsUser;
import com.sps.service.account.balance.AccountBalanceService;
import com.sps.service.account.bankCard.BankCardService;
import com.sps.service.account.bankTrade.BankTradeService;
import com.sps.service.user.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
@RequestMapping("/api/accountTrade")
public class AccountTradeController {
    private static  final Log logger= LogFactory.getLog(AccountTradeController.class);
    @Autowired
    private AccountBalanceService accountBalanceService;
   @Autowired
   private BankTradeService bankTradeService;
  @Autowired
    BankCardService bankCardService;



    @Autowired
    private UserService userService;
    @RequestMapping(value = "/findTradeList/{userMark}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findTradeList( @PathVariable("userMark") Integer userMark ) {
        ReturnInfo returnInfo = new ReturnInfo();
      String userName = (String) SecurityUtils.getSubject().getPrincipal();

        //  根据登录用户名获取用户id
     SpsUser user = userService.findUserByUserName(userName);
        try {
            List<BankTradeInfo> bankTrdeList = bankTradeService.findBankTrdeList(userName, userMark);
            returnInfo.setData(bankTrdeList);
            String userId = bankCardService.findUserId(userName);
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;
    }
}

