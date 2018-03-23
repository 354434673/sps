package com.sps.controller.order;

import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderReturn;
import com.sps.service.goods.PurchaseOrderService;
import com.sps.service.order.OrderReturnService;
import com.sps.service.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/orderReturn")
public class OrderReturnController {
    @Resource
    private OrderReturnService orderReturnService;

    /**
     * 进货单数据校验
     *
     * @return
     */
    @RequestMapping(value = "/returnOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveOrUpdate(SpsOrderReturn order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            orderReturnService.saveOrUpdate(order);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
            ri.setSuccess(Message.API_SUCCESS_FLAG);
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


}
