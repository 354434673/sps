package com.sps.controller.order;

import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.service.goods.PurchaseOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/order")
public class OrderController {

    @Resource
    private PurchaseOrderService purchaseOrderService;

    /**
     * 进货单数据校验
     * @return
     */
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveOrUpdate(@RequestBody List<SpsPurchaseOrder> order,@RequestBody SpsOrder spsOrder) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String,Object> map= purchaseOrderService.saveOrder(order,spsOrder);
            //成功返回当前用户地址个人信息
            if((Integer) map.get("flag")==0){
                ri.setData(map.get("company"));
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode(Message.API_SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }else {
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode((String) map.get("flag"));
                ri.setMsg((String) map.get("goodsName"));
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
     * 进货单数据校验
     * @return
     */
    @RequestMapping(value = "/verificationOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo verificationOrder(@RequestBody List<SpsPurchaseOrder> order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String,Object> map= purchaseOrderService.verificationOrder(order);
            //成功返回当前用户地址个人信息
            if((Integer) map.get("flag")==0){
                ri.setData(map.get("company"));
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode(Message.API_SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }else {
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode((String) map.get("flag"));
                ri.setMsg((String) map.get("goodsName"));
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
