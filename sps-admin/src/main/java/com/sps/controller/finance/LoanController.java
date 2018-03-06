package com.sps.controller.finance;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.finance.LoanInfo;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import org.sps.service.order.OrderService;

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
    public HashMap<String, Object> findLoanList(Integer page, Integer limit, String loanStartTime, String loanEndTime,
                                                         String loanName, Integer loanStatus, String orderNo) {
     /*   HashMap<String, Object> result = orderService.queryOrderList(page, limit, loanStartTime, loanEndTime, loanName, loanStatus, orderNo);
        return result;*/
        List<LoanInfo> list = new ArrayList<LoanInfo>();
        LoanInfo loaninfo1 = new LoanInfo();
        LoanInfo loaninfo2=new LoanInfo();
        loaninfo1.setId(1);
        loaninfo1.setDaiXiaoFei(new BigDecimal(100.67));
        loaninfo1.setDaiXiaoFeilv(0.23);
        loaninfo1.setIncomeShouXuFei(new BigDecimal(1200));
        loaninfo1.setLoanAmount(new BigDecimal(12000));
        loaninfo1.setLoanBalancel(new BigDecimal(200));
        loaninfo1.setLoanEndDate(new Date());
        loaninfo1.setLoanNo("1111111111");
        loaninfo1.setLoanStartDate(new Date());
        loaninfo1.setLoanName("cailing");

        loaninfo2.setId(2);
        loaninfo2.setDaiXiaoFei(new BigDecimal(102.67));
        loaninfo2.setDaiXiaoFeilv(0.233);
        loaninfo2.setIncomeShouXuFei(new BigDecimal(2222));
        loaninfo2.setLoanAmount(new BigDecimal(120200));
        loaninfo2.setLoanBalancel(new BigDecimal(2200));
        loaninfo2.setLoanEndDate(new Date());
        loaninfo2.setLoanNo("222222");
        loaninfo2.setLoanStartDate(new Date());
        loaninfo2.setLoanName("cailing2");
        list.add(loaninfo1);
        list.add(loaninfo2);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        PageHelper.startPage(page, limit);
        PageInfo pageInfo = new PageInfo(list);
        hashMap.put("code", 0);
        hashMap.put("msg", "获取成功");
        hashMap.put("count", pageInfo.getTotal());
        hashMap.put("data", list.size() != 0 ? list : null);
        return hashMap;


    }
}
