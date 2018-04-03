package com.sps.controller.account;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.EntityUtiles;
import com.sps.common.JsonResult;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.controller.BaseApi;
import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.account.vo.BankTradeInfoVo;
import com.sps.entity.user.SpsUser;
import com.sps.enums.ReturnCode;
import com.sps.service.account.balance.AccountBalanceService;
import com.sps.service.account.bankCard.BankCardService;
import com.sps.service.account.bankTrade.BankTradeService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sps.service.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/api/accountTrade")
public class AccountTradeController extends BaseApi{

    private static  final Log log = LogFactory.getLog(AccountTradeController.class);

    @Autowired
    private BankTradeService bankTradeService;

    @RequestMapping(value = "/findTradeList")
    public JsonResult findTradeList( @RequestParam("customerId") String customerId) {
        //  根据登录用户名获取用户id
        try{
            if(StringUtils.isBlank(customerId)){
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            log.info("start--请求获取最近三个月交易明细，请求参数 "+customerId);
            List<BankTradeInfoVo> bankTrdeList = bankTradeService.findBankTrdeShowList(customerId);
            if(bankTrdeList==null){
                return returnFaild();
            }
            return returnSuccess(bankTrdeList);
        }catch (Exception e){
            log.info("end--请求获取最近三个月交易明细，异常 "+e.getMessage());
            return returnFaild();
        }
    }
    /**
     * 根据交易类型获取信息 0 标识支出 1标识收入 ,2标识全部
     */


    @RequestMapping(value = "/findTradeListByTradeType")
    public JsonResult findTradeListByTradeType(String customerId, Integer types,Integer currentPage, Integer pageSize) {

        log.info("start--根据类型获取交易列表，请求参数{customerId："+customerId+",types:"+types+",currentPage:"+currentPage+",pageSize:"+pageSize+"}");
        try{
            if(StringUtils.isBlank(customerId)|| types == null){
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            List<BankTradeInfoVo> bankTrdeList =  bankTradeService.findBankTrdeShowPageList(customerId,types,currentPage,pageSize);
            if(bankTrdeList==null){
                return returnFaild();
            }
            return returnSuccess(bankTrdeList);
        }catch (Exception e){
            log.info("end--根据类型获取交易列表，异常 "+ e.getMessage());
            return  returnFaild();
        }
    }

    /**
     * 查询交易详情
     * @param
     * @param
     * @param id
     * @return
     */
    @RequestMapping(value = "/findTradeDetail")
    public JsonResult findTradeDetail( @RequestParam("id") Integer id ) {
        log.info("start--根据ID获取用户交易明细，请求参数 " + id);
        try{
            if (id == null) {
                return returnFaild(ReturnCode.ERROR_PARAMS_NOT_NULL.getMsg());
            }
            BankTradeInfo bankTradeDetail = bankTradeService.findBankTradeDetail(id);
            if (bankTradeDetail == null) {
                return returnFaild(ReturnCode.ERROR_SELECT_IS_NULL.getMsg());
            }
            String[] pro = new String[]{"tradeAmount","tradeNo","tradeAfterBalanc","tradeStatus","tradeType","incomeType","expenditureType","paymentDate","standby1 ","standby2","rechargeStatus","bankCardName","bankCardNumber"};
           return returnSuccess(EntityUtiles.reloadEntityPropertyValue(bankTradeDetail, pro));
        }catch (Exception e){
            log.info("start--根据ID获取用户交易明细，异常 " + e.getMessage());
            return  returnFaild();
        }
    }

}

