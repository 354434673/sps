package com.sps.controller.account;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.common.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.finance.OrderDetail;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.entity.order.Order;
import org.sps.entity.order.OrderGoods;
import org.sps.entity.order.SpsOrderLogistics;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import org.sps.service.order.OrderService;

import java.util.HashMap;
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
     * 获取交易号获取订一切信息
     * @param tradeSeriNum
     * @return
     */
    @RequestMapping("/queryTradeBasicInfo")
    @ResponseBody
    public Result<Order> queryTradeBasicInfo(String tradeSeriNum) {
        Result<Order> result = new Result<Order>();
//        根据交易序列号查询订单编号
        SpsChannelBankTrade tradeDetail = bankTradereadService.getTradeInfo( tradeSeriNum);
        Order orderDetail = orderService.queryByOrderId(tradeDetail.getOrderId());
        if(orderDetail!=null){
            result.setBody(orderDetail);
            result.setMsg("成功");
            return result;
        }
        result.setMsg("失败");
        return result;
    }
    /**
     * 个根据订单号获取所有订单项信息
     * @param tradeSeriNum
     * @return
     */
    @RequestMapping("/queryOrderGoods")
    @ResponseBody
    public HashMap<String, Object> queryOrderGoods(Integer page, Integer limit,String tradeSeriNum ) {
        SpsChannelBankTrade tradeDetail = bankTradereadService.getTradeInfo( tradeSeriNum);
        HashMap<String, Object> list = orderService.getGoodsByOrderId(page, limit,tradeDetail.getOrderId());
        return list;
    }

}
