package com.sps.controller.finance;

import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.finance.LoanInfo;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.order.OrderRepayDetail;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import org.sps.service.order.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-03-02.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Controller
@RequestMapping("/loan")
public class LoanController {
    @Reference(check=false,group="dianfu")
    private ChannelBankTradeReadService bankTradereadService;
    @Reference(check=false,group="dianfu")
    private OrderService orderService;
    /**
     *
     * @param page
     * @param limit
     * @param loanStartTime
     * @param loanEndTime
     * @param loanName
     * @param loanStatus
     * @param orderNo
     * @return
     */

    @RequestMapping("/findLoanList")
    @ResponseBody
    public HashMap<String, Object> findLoanList(Integer page, Integer limit, String loanStartTime, String loanEndTime,String orderNo, String loanName, Integer loanStatus ) {
        LogFactory.getLog(LoanController.class).info("findLoanList");
         HashMap<String, Object> result = orderService.queryOrderList(page, limit, loanStartTime, loanEndTime, loanName, loanStatus, orderNo);
        return result;
    }

    @RequestMapping("/queryLoanDetail")
    @ResponseBody
    public HashMap<String, Object> queryLoanDetail(Integer page, Integer limit,String orderid){

        HashMap<String, Object> stringObjectHashMap = orderService.queryByOrderDetailByOrderNo(page, limit, orderid);
        return stringObjectHashMap;
    }
}
