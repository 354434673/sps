package com.sps.controller.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sps.common.EntityUtiles;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderRepayDetail;
import com.sps.service.goods.PurchaseOrderService;
import com.sps.service.order.OrderRepayDetailService;

@Controller
@RequestMapping(value = "/api/orderRepayDetail")
public class OrderRepayDetailController {

    @Resource
    private PurchaseOrderService purchaseOrderService;

    @Resource
    private OrderRepayDetailService orderRepayDetailService;


    /**
     * 根据ID订单详情
     *
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findEntity(Integer id) {
        ReturnInfo ri = new ReturnInfo();
        if ("0".equals(ri.getCode())) return ri;
        try {
            SpsOrderRepayDetail order = orderRepayDetailService.findById(id);
            String[] pro = new String[]{"id","orderNo","repaydate","orderMoney","selfName","orderTime","payment","shopPayMoney","serviceMoney"};
            if (order != null) {
                ri.setResult(EntityUtiles.reloadEntityPropertyValue(order, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


    /**
     * 根据用户编号商家编号查询我的账单
     *
     * @return
     */
    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo orderList(String customerNum) {
        ReturnInfo ri = new ReturnInfo();
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("customerNum", customerNum);
            List<SpsOrderRepayDetail> orderRepayList = orderRepayDetailService.findList(map);
            String[] pro = new String[]{"id","orderStatus","repayAmount","orderNo","days"};
            if (orderRepayList != null) {
                ri.setResult(EntityUtiles.reloadListPropertyValue(orderRepayList, pro));
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

  

}
