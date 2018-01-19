package com.sps.controller.order;

import java.util.HashMap;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.service.order.OrderService;

import com.alibaba.dubbo.config.annotation.Reference;

@Controller
@RequestMapping("/rejected")
public class RejectedController {

	Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Reference
	OrderService orderService;
	
	
	@RequestMapping("/showOrder.json")
	@ResponseBody
	public  HashMap<String, Object> selectOrderByOrderId(String orderid){
		return orderService.selectOrderByOrderId(orderid);
	}
	@RequestMapping("/showSingle.json")
	@ResponseBody
	public HashMap<String, Object> selectByPrimaryKey(String orderid){
		return orderService.selectByPrimaryKey(orderid);
	}
	
	@RequestMapping("/showOrderGoods.json")
	@ResponseBody
	public HashMap<String,Object> selectOrderGoods(Integer page, Integer limit,String orderid,String sku){
		HashMap<String,Object> orderGoods=orderService.selectOrderGoods(page,limit,orderid,sku);
		return orderGoods;
	}
	@RequestMapping("/show.json")
	@ResponseBody
	public HashMap<String,Object> selectByParameters(Integer page, Integer limit,String name, String orderid, String startTime,String endTime, String flag){
		HashMap<String,Object> orders=orderService.selectByParameters(page,limit,name, orderid, startTime, endTime, flag);
		return orders;	
	}
	
	/**
	 * 修改待确认订单状态，修改好后返回到待确认订单页面
	 * @param orderid 订单id
	 * @return
	 */
	@RequestMapping("/updateConfirmOrderFlag")
	public String updateOrderFlag(String orderid,String flag,String remark){
		orderService.updateOrderFlag(orderid, flag, remark);
		return "/order/afterConfimed";
	}
	
	/**
	 * 修改待发货订单状态，修改好后返回到待发货页面
	 * @param orderid 订单id
	 * @return
	 */
	@RequestMapping("/updateDeliveryOrderFlag")
	public String updateDeliveryOrderFlag(String orderid,String flag){
		orderService.updateOrderFlag(orderid, flag,null);
		return "/order/orderToBeDelivery";
	}
	 
	 
}
