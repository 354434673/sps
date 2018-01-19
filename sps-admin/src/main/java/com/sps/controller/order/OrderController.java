package com.sps.controller.order;

import java.util.HashMap;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.order.OrderGoodsVo;
import org.sps.service.order.OrderService;

import com.alibaba.dubbo.config.annotation.Reference;

@Controller
@RequestMapping("/order")
public class OrderController {

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
/*	@RequestMapping("/showSingle.json")
//	@ResponseBody
	public String selectByPrimaryKey(String orderid,Model model){
		HashMap<String, Object> data=orderService.selectByPrimaryKey(orderid);
		model.addAttribute("orderid", orderid);
		model.addAttribute("data", data);
		return "order/confimed";
	}*/
	
	/*@RequestMapping("/showOrderGoods")
	@ResponseBody
	public Order selectOrderGoods(String orderid){
		return orderService.selectOrderGoods(orderid);
	}*/
	
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
		
/*	@RequestMapping("/toConfirm")
	public String toConfirm(String orderid,Integer page,Integer limit,String sku, Model model ){
		if(orderid != null){
			HashMap<String,Object> data=orderService.selectOrderGoods(page, limit, orderid, sku);
			model.addAttribute("orderid", orderid);
			model.addAttribute("data", data);
		}
		return "order/confimedOrder";
	}*/
	
	
	/*@RequestMapping("/updatePrice")
	@ResponseBody
	public int updateBatch(OrderGoods orderGoods){
		int result=0;
			try{
				result=orderService.updatePrice(orderGoods);
			}catch(Exception e){
				logger.info("更新失败，进行回滚操作");
				//出现异常进行回滚操作
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		return result;
	}*/
	
	/*@RequestMapping(value="/updatePriceBeath",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> updatePriceBeath(List<OrderGoods> orderGoods){
		HashMap<String, Object> result=new HashMap<String, Object>();
			try{
				result=orderService.updatePriceBatch(orderGoods);
			}catch(Exception e){
				logger.info("更新失败，进行回滚操作");
				//出现异常进行回滚操作
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		return result;
	}*/
	
	
	/**
	 * 修改订单的价格以及订货量，修改后页面刷新返回到修改后的详情页面
	 * @param orderGoods
	 * @return
	 */
	@RequestMapping(value="/updatePriceBeath",method=RequestMethod.POST)
	public String updatePriceBeath(OrderGoodsVo orderGoods){
		orderService.updatePriceBatch(orderGoods);
		return  "/order/confimed";
	}
	/*@RequestMapping(value="/updatePriceBeath",method=RequestMethod.POST)
	public String updatePriceBeath(OrderGoods[] orderGoods){
		orderService.updatePriceBatch(Arrays.asList(orderGoods));
		return  "/order/confimed";
	}*/
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
