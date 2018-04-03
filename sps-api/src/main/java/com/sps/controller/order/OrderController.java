package com.sps.controller.order;

import com.sps.common.Common;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsPurchaseOrder;
import com.sps.entity.order.SpsOrder;
import com.sps.entity.order.SpsOrderGoods;
import com.sps.entity.shopkeeper.SpsShopkeeperCompany;
import com.sps.service.goods.PurchaseOrderService;
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
@RequestMapping(value = "/api/order")
public class OrderController {

    @Resource
    private PurchaseOrderService purchaseOrderService;
    @Resource
    private OrderService orderService;


    /**
     * 根据ID订单详情
     *
     * @return
     */
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo cancelOrder(Integer id) {
        ReturnInfo ri = new ReturnInfo();
        if ("0".equals(ri.getCode())) return ri;
        try {
            orderService.cancelOrder(id);
            ri.setResult(id);
            ri.setSuccess(Message.SUCCESS_MSG);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

    /**
     * 根据ID订单详情
     *
     * @return
     */
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo deleteOrder(Integer id ) {
        ReturnInfo ri = new ReturnInfo();
        try {
            orderService.deleteOrder(id);
            ri.setResult(id);
            ri.setSuccess(Message.SUCCESS_MSG);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


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
            HashMap<String, Object> data = new HashMap<>();
            SpsOrder order = orderService.findById(id);
            if (order != null) {
                data.put("remark", order.getRemark());
                data.put("orderid", order.getOrderid());
                data.put("selfname", order.getSelfname());
                data.put("addTime", order.getCreatetime());
                data.put("phone", order.getPhone());
                data.put("address", order.getAddress());
                data.put("name", order.getName());
                data.put("scale", order.getScale());
                data.put("status", order.getFlag());
                data.put("shopPayMoney", order.getShopPayMoney());
                data.put("servicemoney", order.getServicemoney());
                data.put("orderGoodsList", order.getOrderGoodsList());
                ri.setResult(data);
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
     * 根据ID订单详情
     *
     * @return
     */
    @RequestMapping(value = "/findByOrderCode", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findByOrderCode(String orderCode) {
        ReturnInfo ri = new ReturnInfo();
        if ("0".equals(ri.getCode())) return ri;
        try {
            HashMap<String, Object> data = new HashMap<>();
            SpsOrder order = orderService.findByCode(orderCode);
            if (order != null) {
                data.put("orderid", order.getOrderid());
                data.put("selfname", order.getSelfname());
                data.put("remark", order.getRemark());
                data.put("addTime", order.getCreatetime());
                data.put("phone", order.getPhone());
                data.put("address", order.getAddress());
                data.put("name", order.getName());
                data.put("scale", order.getScale());
                data.put("status", order.getFlag());
                data.put("shopPayMoney", order.getShopPayMoney());
                data.put("servicemoney", order.getServicemoney());
                data.put("orderGoodsList", order.getOrderGoodsList());
                ri.setResult(data);
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
     * 根据登录手机号商家编号查询订单列表
     *
     * @return
     */
    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo orderList(String customerNum,String type ) {
        ReturnInfo ri = new ReturnInfo();
        Map<String, Object> map = new HashMap<>();
        HashMap<String, Object> data = new HashMap<>();
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();
        try {
            map.put("customerNum", customerNum);
            map.put("type", type);
            List<SpsOrder> orderList = orderService.findList(map);
            for (SpsOrder list : orderList) {
                data.put("sumCount", list.getSumCount());
                data.put("days", list.getDays());
                data.put("url", list.getUrl());
                data.put("id", list.getoId());
                data.put("repayDate", list.getRepayDate());
                data.put("orderid", list.getOrderid());
                data.put("orderType", list.getFlag());
                data.put("orderMoney", list.getMoney());
                data.put("selfname", list.getSelfname());
                data.put("scale", list.getScale());
                data.put("remark", list.getRemark());
                data.put("shopPayMoney", list.getShopPayMoney());
                data.put("servicemoney", list.getServicemoney());
                data.put("orderGoodsList", list.getOrderGoodsList());
                result.add(data);
            }
            if (orderList != null) {
                ri.setResult(result);
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
     * 下单
     *
     * @return
     */
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveOrUpdate(@RequestBody List<SpsPurchaseOrder> order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String, Object> map = purchaseOrderService.saveOrder(order);
            //成功返回当前用户地址个人信息
            if ((Integer) map.get("flag") == 0) {
                ri.setResult((String) map.get("orderCode"));
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
            } else {
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode("" + (Integer) map.get("flag"));
                ri.setMsg("" + (String) map.get("goodsName"));
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
     *
     * @return
     */
    @RequestMapping(value = "/verificationOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo verificationOrder(@RequestBody List<SpsPurchaseOrder> order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String, Object> map = purchaseOrderService.verificationOrder(order);
          
            //成功返回当前用户地址个人信息
            if ((Integer) map.get("flag") == 0) {
                ri.setResult(map.get("company"));
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
            } else {
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode("" + (Integer) map.get("flag"));
                ri.setMsg("" + (String) map.get("goodsName"));
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
     * 风控订单回调接口
     *
     * @return
     */
    @RequestMapping(value = "/orderCallback", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo orderCallback(@RequestBody Map<String,Object> map) {
        ReturnInfo ri =  Common.validate(map, "orderNum","orderStatus");
        if ("0".equals(ri.getCode())) return ri;
        try {
            orderService.updateStatus(map);
           /* orderService.cancelOrder(id);
            ri.setResult(id);*/
            ri.setSuccess(Message.SUCCESS_MSG);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }

}
