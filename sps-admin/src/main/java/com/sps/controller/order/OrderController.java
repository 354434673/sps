package com.sps.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.sps.entity.order.OrderGoods;
import org.sps.entity.order.SpsOrderLogistics;
import org.sps.service.order.OrderService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.service.user.ExpressService;
import com.sps.util.CommonUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	Logger logger=Logger.getLogger(this.getClass().getName());
	
	@Reference(group = "dianfu")
	OrderService orderService;
	@Resource
	private ExpressService expressService;
	
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
	public HashMap<String,Object> selectByParameters(Integer page, Integer limit,String name, 
			String channelName, String selfname, String orderid, 
			String startTime,String endTime, String flag){
		HashMap<String,Object> orders=orderService.selectByParameters(page, limit, name, channelName, 
				selfname, orderid, startTime, endTime, flag);
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
	@ResponseBody
	public HashMap<String, Object> updatePriceBeath(@RequestBody List<OrderGoods> orderGoods){
		HashMap<String, Object> updatePriceBatch = orderService.updatePriceBatch(orderGoods);
		
		return  updatePriceBatch;
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
	@ResponseBody
	public HashMap<String, Object> updateOrderFlag(String orderid,String flag,String remark){
		HashMap<String, Object> updateOrderFlag = orderService.updateOrderFlag(orderid, flag, remark);
		return updateOrderFlag;
	}
	@RequestMapping("/insertLogistics")
	@ResponseBody
	public HashMap<String, Object> insertLogistics(SpsOrderLogistics logistics, String flag){
		String otherName = logistics.getLogisticsOther();
		if(!(otherName.equals("")||otherName == null)){//物流配送中其他字段如果填了选项,则插入数据
			expressService.insertExpress(otherName);
		}
		HashMap<String, Object> insertLogistics = orderService.insertLogistics(flag, logistics);
		
		return insertLogistics;
	}
	@RequestMapping("/uploadLogistics")
	@ResponseBody
	public HashMap<String, Object> uploadLogistics(@RequestParam(value = "file", required = false) MultipartFile file,
			SpsOrderLogistics logistics, String orderid,String flag, HttpServletRequest request){
		
		if(file != null){//文件不为空则上传图片
			String realPath = request.getSession().getServletContext().getRealPath("upload/"); //项目路径
			
			String filePath ="order/"+logistics.getOrderId()+"/";
			
			CommonUtil.uploadPicture(file, realPath+filePath, file.getName());
		}
		HashMap<String, Object> insertLogistics = orderService.insertLogistics(flag, logistics);
		
		return insertLogistics;
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
