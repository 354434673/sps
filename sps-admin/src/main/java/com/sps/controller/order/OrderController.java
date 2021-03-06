package com.sps.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.logistics.tracking.api.IExpressService;
import org.logistics.tracking.api.IKdniaoTrackService;
import org.logistics.tracking.core.ServiceResult;
import org.logistics.tracking.vo.LogisticsTrackVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.sps.entity.order.Order;
import org.sps.entity.order.OrderGoods;
import org.sps.entity.order.SpsOrderLogistics;
import org.sps.service.order.OrderService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.common.OssUtil;
import com.sps.exception.ImgException;
import com.sps.service.express.ExpressService;
import com.sps.util.CommonUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	Logger logger=Logger.getLogger(this.getClass().getName());

	@Reference(timeout = 20000, group = "dianfu")
	OrderService orderService;
	@Resource
	private ExpressService expressService;
	@Resource
	private IKdniaoTrackService iKdniaoTrackService;

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
		 Subject subject = SecurityUtils.getSubject();
		//获取当前token中的用户
		String userName = (String) subject.getPrincipal();
		
		String channelNum = (String) subject.getSession().getAttribute(userName);
		
		HashMap<String,Object> orders=orderService.selectByParameters(page, limit, name, channelNum, channelName,
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
	/**
	 * 订阅物流信息
	 * @Title: insertLogistics   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param logistics
	 * @param: @param flag
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月11日 上午11:38:37
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/insertLogistics")
	@ResponseBody
	public HashMap<String, Object> insertLogistics(SpsOrderLogistics logistics, String flag){
		String otherName = logistics.getLogisticsOther();
		
		HashMap<String, Object> insertLogistics = null;
		if(!(otherName.equals("")||otherName == null)){//物流配送中其他字段如果填了选项,则插入数据
			expressService.insertExpress(otherName);
		}
		SpsOrderLogistics queryLogisticsByOrderId = orderService.queryLogisticsByOrderId(logistics.getOrderId());
		
		if(queryLogisticsByOrderId == null){
			insertLogistics = orderService.insertLogistics(flag, logistics);
		}else{
			insertLogistics = orderService.updateLogistics(logistics);
		}
		if(insertLogistics.get("state").equals(FinalData.STATE_SUCCESS)){
			//订阅物流
			ServiceResult<Boolean> subLogisticsTrack = iKdniaoTrackService.subLogisticsTrack(
					null, logistics.getLogisticsCode(), logistics.getLogisticsNum(), logistics.getLogisticsName());
		}
		return insertLogistics;
	}
	/**
	 * 查看物流轨迹
	 * @Title: getLogisticsTrack   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param orderId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月11日 上午11:38:02
	 * @return: ServiceResult<LogisticsTrackVo>      
	 * @throws
	 */
	@RequestMapping("/getLogisticsTrack")
	@ResponseBody
	public ServiceResult<LogisticsTrackVo> getLogisticsTrack(String orderId){
		
		SpsOrderLogistics data = orderService.queryLogisticsByOrderId(orderId);
		
		ServiceResult<LogisticsTrackVo> logisticsTrack = null;
		if(data != null){
			logisticsTrack = iKdniaoTrackService.getLogisticsTrack(null, data.getLogisticsCode(), data.getLogisticsNum());
		}else{
			logisticsTrack = iKdniaoTrackService.getLogisticsTrack(null, null, null);
		}
		//ServiceResult<LogisticsTrackVo> logisticsTrack = iKdniaoTrackService.getLogisticsTrack(null, "YD", "3934460804760");

		return logisticsTrack;
	}
	@RequestMapping("/uploadLogistics")
	@ResponseBody
	public HashMap<String, Object> uploadLogistics(@RequestParam(value = "file", required = false) MultipartFile file,
												   SpsOrderLogistics logistics, String orderid,String flag, HttpServletRequest request){

			HashMap<String, Object> insertLogistics = null;
			try {
				OssUtil ossUtil = new OssUtil();
				
				String uploadImg2Oss = ossUtil.uploadImg2Oss(file);
				
				String imgUrl = ossUtil.getImgUrl(uploadImg2Oss); 
				
				String[] split = imgUrl.split("\\?");  
				
				logistics.setLogisticsVoucher(split[0]);
				
				SpsOrderLogistics queryLogisticsByOrderId = orderService.queryLogisticsByOrderId(logistics.getOrderId());
				
				if(queryLogisticsByOrderId == null){
					insertLogistics = orderService.insertLogistics(flag, logistics);
				}else{
					insertLogistics = orderService.updateLogistics(logistics);
				}
			} catch (ImgException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
