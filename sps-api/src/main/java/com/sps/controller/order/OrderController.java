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
     * @param map  id
     * @return
     */
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo cancelOrder(@RequestBody Map<String,Object> map){
        ReturnInfo ri = Common.validate(map, "id");
        if("0".equals(ri.getCode())) return ri;
        try {
            Integer id = (Integer) map.get("id");
           orderService.cancelOrder(id);
                ri.setResult(id);
            ri.setSuccess(Message.SUCCESS_MSG);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e){
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }
    /**
     * 根据ID订单详情
     * @param map  id
     * @return
     */
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo deleteOrder(@RequestBody Map<String,Object> map){
        ReturnInfo ri = Common.validate(map, "id");
        if("0".equals(ri.getCode())) return ri;
        try {
            Integer id = (Integer) map.get("id");
            orderService.deleteOrder(id);
            ri.setResult(id);
            ri.setSuccess(Message.SUCCESS_MSG);
            ri.setCode(Message.SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
        } catch (Exception e){
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


    /**
     * 根据ID订单详情
     * @param map  id
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findEntity(@RequestBody Map<String,Object> map){
        ReturnInfo ri = Common.validate(map, "id");
        if("0".equals(ri.getCode())) return ri;
        try {
            Integer id = (Integer) map.get("id");
            SpsOrder order = orderService.findById(id);
            if(order != null){
                ri.setResult(order);
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e){
            e.printStackTrace();
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.FAILURE_MSG);
            ri.setSuccess(Message.API_ERROR_FLAG);
        }
        return ri;
    }


    /**
     * 根据用户编号商家编号查询订单列表
     * @param map  id
     * @return
     */
    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo orderList(@RequestBody Map<String,Object> map){
        ReturnInfo ri = Common.validate(map,"customerNum","shopkeeperNum");
        if("0".equals(ri.getCode())) return ri;
        try {
            List<SpsOrder> orderList = orderService.findList(map);
            if(orderList != null){
                ri.setResult(orderList);
                ri.setSuccess(Message.SUCCESS_MSG);
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e){
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
    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo saveOrUpdate(@RequestBody List<SpsPurchaseOrder> order) {
        ReturnInfo ri = new ReturnInfo();
        try {
            Map<String,Object> map= purchaseOrderService.saveOrder(order);
            //成功返回当前用户地址个人信息
                if((Integer) map.get("flag")==0){
                    ri.setCode(Message.SUCCESS_CODE);
                    ri.setMsg(Message.API_SUCCESS_MSG);
                    ri.setSuccess(Message.API_SUCCESS_FLAG);
            }else {
                    ri.setCode(Message.FAILURE_CODE);
                    ri.setMsg(Message.FAILURE_MSG);
                    ri.setSuccess(Message.API_ERROR_FLAG);

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
                ri.setResult(map.get("company"));
                ri.setCode(Message.SUCCESS_CODE);
                ri.setMsg(Message.API_SUCCESS_MSG);
                ri.setSuccess(Message.API_SUCCESS_FLAG);
            }else {
                ri.setSuccess(Message.API_SUCCESS_FLAG);
                ri.setCode(""+(Integer) map.get("flag"));
                ri.setMsg(""+(String) map.get("goodsName"));
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
