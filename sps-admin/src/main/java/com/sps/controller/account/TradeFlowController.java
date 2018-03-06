package com.sps.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.entity.order.Order;
import org.sps.entity.order.OrderGoods;
import org.sps.entity.order.SpsOrderLogistics;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import org.sps.service.order.OrderService;

import java.util.List;

/**
 * Created by cailing on 2018/3/4.
 */

@Controller
@RequestMapping("/tradeFlow")
public class TradeFlowController {
    @Reference(check=false,group="dianfu")
    private ChannelBankTradeReadService bankTradereadService;
    @Reference(check=false,group="dianfu")
    private OrderService orderService;

    /**
     * 获取交易基本信息
     * @param tradeSeriNum
     * @return
     */
    @RequestMapping("/queryTradeInfo")
    @ResponseBody
    public Result<SpsChannelBankTrade> queryTradeInfo(String tradeSeriNum) {
        Result<SpsChannelBankTrade> result = new Result<SpsChannelBankTrade>();
        SpsChannelBankTrade tradeDetail = bankTradereadService.getTradeDetail(null, tradeSeriNum);
        if(tradeDetail!=null){
            result.setBody(tradeDetail);
            result.setMsg("成功");
            return result;
        }
        result.setMsg("失败");
        return result;
    }

    /**
     * 获取订单基本信息
     * @param orderNo
     * @return
     */
    @RequestMapping("/queryOrderBasic")
    @ResponseBody
    public Result<Order> queryOrderBasic(String orderNo) {
        Result<Order> result = new Result<Order>();
        Order order = orderService.queryByOrderId(orderNo);
        if(order!=null){
            result.setBody(order);
            result.setMsg("成功");
            return result;
        }
        result.setMsg("失败");
        return result;
    }

    /**
     * 获取物流信息
     * @param orderNo
     * @return
     */
    @RequestMapping("/queryOrderLogs")
    @ResponseBody
    public Result<SpsOrderLogistics> queryOrderLogs(String orderNo) {
        Result<SpsOrderLogistics> result = new Result<SpsOrderLogistics>();
        SpsOrderLogistics spsOrderLogistics = orderService.queryOrderLogistics(orderNo);
        if(spsOrderLogistics!=null){
            result.setBody(spsOrderLogistics);
            result.setMsg("成功");
            return result;
        }
        result.setMsg("失败");
        return result;
    }

    /**
     * 个根据订单号获取所有订单项信息
     * @param orderNo
     * @return
     */
    @RequestMapping("/queryOrderGoods")
    @ResponseBody
    public Result<List> queryOrderGoods(String orderNo) {
        Result<List> result = new Result<List>();
        return null;
      /*  List<OrderGoods> orderGoodss = orderService.queryGoods(orderNo);
        if(orderGoodss!=null){
            result.setBody(orderGoodss);
            result.setMsg("成功");
            return result;
        }
        result.setMsg("失败");
        return result;*/
    }

}
