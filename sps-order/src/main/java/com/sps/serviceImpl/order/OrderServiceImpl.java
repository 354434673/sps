package com.sps.serviceImpl.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.sps.dao.order.OrderRepayDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.order.*;
import org.sps.service.order.OrderService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sps.dao.order.OrderGoodsMapper;
import com.sps.dao.order.OrderMapper;
import com.sps.dao.order.SpsOrderLogisticsMapper;

@Service(timeout = 2000, group = "dianfu")
@org.springframework.stereotype.Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderGoodsMapper orderGoodsMapper;

	@Autowired
	private SpsOrderLogisticsMapper mapper;

	@Autowired
	private OrderRepayDetailMapper orderDetailMapper;

	/**
	 * 根据orderid查询订单order,只返回order相关的信息，不包含关联的orderGoods相关信息
	 *
	 * @param orderid
	 * @return
	 */
	public HashMap<String, Object> selectOrderByOrderId(String orderid) {
		Order order = orderMapper.selectByPrimaryKey(orderid);
		List list = new ArrayList();
		list.add(order);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("data", list.size() > 0 ? list : null);
		hashMap.put("count", 1);
		return hashMap;
	}

	/**
	 * 根据orderid查询订单order,并将由orderid查询出来的orderGoods设置到order中；
	 *
	 * @param orderid
	 * @return
	 */
	public HashMap<String, Object> selectByPrimaryKey(String orderid) {
		Order order = orderMapper.selectByPrimaryKey(orderid);
		// 将获取到的orderGoods列表设置到order
		List<OrderGoods> orderGoods = orderGoodsMapper.selectOrderGoods(orderid, null);
		order.setOrderGoods(orderGoods);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("data", order == null ? null : order);
		hashMap.put("count", 1);
		return hashMap;
	}

	@Override
	public HashMap<String, Object> queryByOrderDetailByOrderNo( Integer page,
																Integer limit, String orderNo) {
		OrderRepayDetail orderRepayDetail = orderDetailMapper.selectByOrderNo(orderNo);
		List list = new ArrayList();
		list.add(orderRepayDetail);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("data", list.size() > 0 ? list : null);
		hashMap.put("count", 1);
		return hashMap;
	}


	/**
	 * 根据各种条件查询信息
	 * @param page
	 * @param limit
	 * @param orderId
	 * @return
	 */
	@Override
	public HashMap<String, Object> getGoodsByOrderId(Integer page, Integer limit, String orderId) {
//		根据订单号查询所有的订单项
		List<OrderGoods> orderGoodses = orderGoodsMapper.selectOrderGoods(orderId, null);
		for (OrderGoods good:orderGoodses) {
			double d = good.getPrice().doubleValue();
			good.setSummation(  d  * good.getAmount() );
		}
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		PageHelper.startPage(page, limit);
		PageInfo pageInfo = new PageInfo(orderGoodses);
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", orderGoodses.size() != 0 ? orderGoodses : null);
		return hashMap;
	}

	@Override
	public HashMap<String, Object> queryOrderList(Integer page, Integer limit, String loanStartTime, String loanEndTime, String loanName, Integer loanStatus, String orderNo) {
		PageHelper.startPage(page, limit);
		List<Order> orderList = orderMapper.selectByMoreCondition(loanStartTime, loanEndTime, loanName, loanStatus, orderNo);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		PageInfo pageInfo = new PageInfo(orderList);
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", orderList.size() != 0 ? orderList : null);
		return hashMap;
	}
	@Override
	public Order queryByOrderId(String orderId) {
		Order order = orderMapper.selectByTradeNO(orderId);
		return order;
	}

	/**
	 * 根据传入的参数查询所有的订单，如果参数为空则默认查询所有的订单
	 *
	 * @param page
	 *            页码
	 * @param limit
	 *            每页记录数
	 * @param name
	 *            店主名称
	 * @param orderid
	 *            订单编号
	 * @param startTime
	 *            订单申请开始日期
	 * @param endTime
	 *            订单申请结束日期
	 * @param flag
	 *            订单状态
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, Object> selectByParameters(Integer page, Integer limit, String name, String channelNum, String channelName,
													  String selfname, String orderid, String startTime, String endTime, String flag) {
		page = page == null ? 1 : page;

		limit = limit == null ? 10 : limit;

		// startTime = startTime == null ? null : startTime + " 00:00:00";

		if (startTime != null) {
			if(!startTime.equals("")){
				startTime = startTime + " 00:00:00";
			}
		}

		if (endTime != null) {
			if(!endTime.equals("")){
				endTime = endTime + " 23:59:59";
			}
		}

		// endTime = endTime == null ? null : endTime + " 23:59:59";

		List<String> flagList = null;

		if (flag == null || flag.equals("")) {
			flagList = new ArrayList<String>();
		} else {
			flagList = new ArrayList<String>();
			String[] split = flag.split(",");
			for (int i = 0; i < split.length; i++) {
				flagList.add(split[i]);
			}
		}
		PageHelper.startPage(page, limit);
		List<Order> orders = orderMapper.selectByParameters(name, channelNum, channelName, selfname, orderid, startTime, endTime,
				flagList);

		PageInfo pageInfo = new PageInfo(orders);

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("data", orders.size() != 0 ? orders : null);

		return hashMap;
	}

	/**
	 * 根据传入的参数查询订单商品，如果orderid为空则查询所有的商品，一个订单可以有多种商品；
	 * 如果传入sku则根据sku编号查询单种的商品，一个商品只有一个sku编号
	 *
	 * @param page
	 * @param limit
	 * @param orderid
	 * @param sku
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap<String, Object> selectOrderGoods(Integer page, Integer limit, String orderid, String sku) {

		if (page == null) {
			page = 1;
		}
		if (limit == null) {
			limit = 10;
		}
		// 分页
		PageHelper.startPage(page, limit);

		long amountTotl = 0;
		BigDecimal priceTotle = new BigDecimal(0);

		List<OrderGoods> orderGoods = this.getOrderGoods(orderid, sku);
		for (OrderGoods goods : orderGoods) {
			amountTotl += goods.getAmount();
			priceTotle = priceTotle.add(new BigDecimal(goods.getSummation()));
		}
		// 转为pageinfo
		PageInfo pageInfo = new PageInfo(orderGoods);

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", 0);
		hashMap.put("msg", "获取成功");
		hashMap.put("count", pageInfo.getTotal());
		hashMap.put("amountTotle", amountTotl);
		hashMap.put("priceTotle", priceTotle);
		hashMap.put("data", orderGoods.size() > 0 ? orderGoods : null);

		return hashMap;
	}

	public List<OrderGoods> getOrderGoods(String orderid, String sku) {

		List<OrderGoods> orderGoods = orderGoodsMapper.selectOrderGoods(orderid, sku);

		return orderGoods;
	}

	// 批量更新，需要加入事务
	/*
	 * @Transactional public Integer updatePriceBatch(List<OrderGoods> list){
	 * Integer result=orderGoodsMapper.updatePriceBatch(list); return
	 * result==0?0:result; }
	 */

	/**
	 * //单个修改价格
	 *
	 * @param orderGoods
	 *            传入的最新的OrderGoods对象
	 * @return
	 */

	/*
	 * public int updatePrice(OrderGoods orderGoods) { //获取sku编号 String
	 * sku=orderGoods.getSku();
	 *
	 * //根据sku编号值会查出来的只包含一个OrderGoods的List List<OrderGoods>
	 * myOrderGood=orderGoodsMapper.selectOrderGoods(null, sku);
	 *
	 * //将根据sku查出来的一个orderGood的List转换成OrderGoods对象，
	 * 此orderGood和最新的orderGoods的sku值是一样的，其他的可能不一样 OrderGoods
	 * orderGood=myOrderGood.get(0);
	 *
	 * //新创建一个对象，并将最新的数据设置进去 OrderGoods orderGoodss=new OrderGoods();
	 *
	 * //当前要设置的订货数量 Integer amount=orderGoods.getAmount(); //之前的价格 BigDecimal
	 * preprice=orderGood.getPrice(); //当前要设置的价格 BigDecimal
	 * price=orderGoods.getPrice();
	 *
	 * orderGoodss.setAmount(amount); orderGoodss.setModifytime(new Date());
	 * //设置修改前的订货量,将未修改前的订货量设置到新对象中
	 * orderGoodss.setPreAmount(orderGood.getAmount());
	 * orderGoodss.setPrice(price); //最新的价格和订货量对应的总金额 Double
	 * summation=amount.doubleValue()*price.doubleValue();
	 * orderGoodss.setSummation(summation); //设置修改前的价格，将从数据库中查询到的价格设置到新对象中
	 * orderGoodss.setPrePrice(preprice);
	 *
	 * int result=orderGoodsMapper.updatePrice(orderGoodss);
	 *
	 * return result; }
	 */

	/**
	 * 批量更新订单商品的价格与订货量，并将之前的价格与订货量写入到对应的字段中，然后同时更新当前商品订货的总价
	 *
	 * @param orderGoodses
	 *            前台页面传入的订单商品的列表
	 * @return
	 */
	// public HashMap<String, Object> updatePriceBatch(List<OrderGoods>
	// orderGoodses) {
	//
	// HashMap<String, Object> hashMap = new HashMap<String, Object>();
	// List<OrderGoods> orderGoodsList=new ArrayList<OrderGoods>();
	// for(OrderGoods orderGoods:orderGoodses){
	// String sku=orderGoods.getSku();
	// //根据sku编号值会查出来的只包含一个OrderGoods的List,一个sku只对应一种商品
	// List<OrderGoods> myOrderGood=orderGoodsMapper.selectOrderGoods(null,
	// sku);
	//
	// //从数据库中获取的之前的OrderGoods对象
	// OrderGoods orderGoo=myOrderGood.get(0);
	// //--------------------
	//
	// /*//新创建一个对象，并将最新的数据设置进去
	// OrderGoods orderGoodss=new OrderGoods();*/
	//
	// //orderGoods.getAmount()为当前传入的订货量
	// Integer amount=orderGoods.getAmount();
	// //orderGoo.getPrePrice()为从数据库查询的之前的价格
	// BigDecimal prePrice=orderGoo.getPrePrice();
	// //orderGoods.getPrice()为当前传入的价格
	// BigDecimal price=orderGoods.getPrice();
	// //orderGoo.getPrePrice()为从数据库查询的之前的订货量
	// Integer preAmount=orderGoo.getAmount();
	//
	//
	// orderGoods.setAmount(amount);
	// orderGoods.setModifytime(new Date());
	// //设置修改前的订货量,将未修改前的订货量设置到新对象中
	// orderGoods.setPreAmount(preAmount);
	// orderGoods.setPrice(price);
	// //最新的价格和订货量对应的总金额
	// Double summation=amount.doubleValue()*price.doubleValue();
	// orderGoods.setSummation(summation);
	// //设置修改前的价格，将从数据库中查询到的价格设置到新对象中
	// orderGoods.setPrePrice(prePrice);
	//
	// orderGoodsList.add(orderGoods);
	// }
	// List<OrderGoods>
	// orderGoodsListNew=orderGoodsMapper.updatePriceBatch(orderGoodsList);
	//
	// // 转为pageinfo
	// PageInfo pageInfo = new PageInfo(orderGoodsListNew);
	//
	// hashMap.put("code", 0);
	// hashMap.put("msg", "获取成功");
	// hashMap.put("count", pageInfo.getTotal());
	// hashMap.put("data", orderGoodsListNew.size() > 0 ? orderGoodsListNew :
	// null);
	/*
	 * // 分页 PageHelper.startPage(page, limit);
	 *
	 * // 根据orderid查出商品列表 List<OrderGoods> listOrderGoods=new
	 * ArrayList<OrderGoods>(); List<OrderGoods> orderGoods =
	 * this.getOrderGoods(orderid,null); for (OrderGoods orderGood : orderGoods)
	 * { OrderGoods newOrderGoods = new OrderGoods(); Integer
	 * amount=orderGood.getAmount();//订货量
	 * newOrderGoods.setPreAmount(orderGood.getAmount());
	 * newOrderGoods.setAmount(amount);//这里是新设定的订货量 Double
	 * summation=amount.doubleValue()*price.doubleValue();//合计
	 * newOrderGoods.setPrePrice(orderGood.getPrice());//将之前的价格设置为从数据库中查询出的价格，
	 * 也就是未更新的价格 newOrderGoods.setPrice(price);//将价格修改为传入的价格
	 * newOrderGoods.setAmount(amount);
	 * //newOrderGoods.setColor(orderGood.getColor());//规格
	 * //newOrderGoods.setMemory(orderGood.getMemory());//内存
	 * newOrderGoods.setModifytime(new Date());//更新日期
	 * //newOrderGoods.setSkuname(orderGood.getSkuname());//商品名称
	 * //newOrderGoods.setSku(orderGood.getSku());//sku编号
	 * newOrderGoods.setSummation(summation);//合计
	 * //newOrderGoods.setoId(orderGood.getoId());
	 * //newOrderGoods.setOrderid(orderGood.getOrderid());
	 * listOrderGoods.add(newOrderGoods); }
	 *
	 * List<OrderGoods> orderGoodses=
	 * orderGoodsMapper.updatePriceBatch(listOrderGoods); // 转为pageinfo PageInfo
	 * pageInfo = new PageInfo(orderGoodses);
	 *
	 * hashMap.put("code", 0); hashMap.put("msg", "获取成功"); hashMap.put("count",
	 * pageInfo.getTotal()); hashMap.put("data", orderGoodses.size() > 0 ?
	 * orderGoodses : null);
	 */
	// return hashMap;
	// }

	public HashMap<String, Object> updatePriceBatch(List<OrderGoods> goods) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>();
		for (OrderGoods orderGoods : goods) {
			String sku = orderGoods.getSku();
			// 根据sku编号值会查出来的只包含一个OrderGoods的List,一个sku只对应一种商品
			List<OrderGoods> myOrderGood = orderGoodsMapper.selectOrderGoods(null, sku);

			// 从数据库中获取的之前的OrderGoods对象
			OrderGoods orderGoo = myOrderGood.get(0);
			// --------------------

			/*
			 * //新创建一个对象，并将最新的数据设置进去 OrderGoods orderGoodss=new OrderGoods();
			 */

			// orderGoods.getAmount()为当前传入的订货量
			Integer amount = orderGoods.getAmount();
			// orderGoo.getPrePrice()为从数据库查询的之前的价格
			BigDecimal prePrice = orderGoo.getPrice();
			// orderGoods.getPrice()为当前传入的价格
			BigDecimal price = orderGoods.getPrice();
			// orderGoo.getPrePrice()为从数据库查询的之前的订货量
			Integer preAmount = orderGoo.getAmount();

			orderGoods.setAmount(amount);
			orderGoods.setModifytime(new Date());
			// 设置修改前的订货量,将未修改前的订货量设置到新对象中
			orderGoods.setPreAmount(preAmount);
			orderGoods.setPrice(price);
			orderGoods.setPrePrice(prePrice);
			// 最新的价格和订货量对应的总金额
			Double summation = amount.doubleValue() * price.doubleValue();
			orderGoods.setSummation(summation);
			// 设置修改前的价格，将从数据库中查询到的价格设置到新对象中
			orderGoods.setPrePrice(prePrice);

			// orderGoodsList.add(orderGoods);
			orderGoodsMapper.updatePriceBatch(orderGoods);
		}
		hashMap.put("msg", "修改成功");
		hashMap.put("state", "success");
		return hashMap;
	}

	/**
	 * 这里的flag 状态分为三个，2为已拒绝，6修改为待发货，拒绝的时候必须有message的说明原因,对于flag状态可以最后进行统一设定，
	 * 这里的状态并不作为最终状态码
	 */
	@Override
	public HashMap<String, Object> updateOrderFlag(String orderid, String flag, String remark) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int result = 0;
		switch (flag) {
			case "1":// 待确认
			case "2":// 已拒绝
			case "3":// 订单审核中
			case "4":// 订单审核不通过
			case "5":// 待签约
			case "6":// 待发货
			case "7":// 物流审核中
			case "8":// 物流审核不通过
				// case "9"://待还款
			case "9":// 已完成
			case "10":// 已退货
			case "11":// 已取消
			case "12":// 待确认退货
			case "13":// 待确认退货未通过
			case "14":// 已确认退货审核
			case "15":// 已确认退货审核未通过
			case "16":// 待收货退款
			case "17":// 待退款退货
			case "18":// 风控审核中
			case "19":// 风控审核不通过
				// 这里处理的逻辑，需要更新数据库的状态，如果有说明则将remark添加入说明中
				result = orderMapper.updateOrderFlag(orderid, flag, remark, new Date());
				hashMap.put("count", result);
				hashMap.put("state", "success");
				break;
		}
		return hashMap;
	}

	@Override
	public HashMap<String, Object> insertLogistics(String flag, SpsOrderLogistics logistics) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		try {
			logistics.setLogisticsCreatTime(new Date());
			logistics.setLogisticsUpdateTime(new Date());
			mapper.insertSelective(logistics);
			updateOrderFlag(logistics.getOrderId(), flag, null);
			hashMap.put("msg", "成功");
			hashMap.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			hashMap.put("msg", "失败");
			hashMap.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return hashMap;
	}
	/*
	 * @Override public HashMap<String,Object> selectByExpressPrimaryKey(Integer
	 * id) { HashMap<String, Object> hashMap = new HashMap<String, Object>();
	 * List<Express> list=new ArrayList<Express>(); Express
	 * express=expressMapper.selectByExpressPrimaryKey(id); list.add(express);
	 * hashMap.put("code", 0); hashMap.put("msg", "获取成功"); hashMap.put("data",
	 * list); hashMap.put("count", list.size()); return hashMap; }
	 */

	// @Override
	// public HashMap<String, Object> updatePriceBatch(Integer page, Integer
	// limit, String orderid, BigDecimal price) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	/*
	 * @Override public HashMap<String, Object> selectBySku(Integer page,
	 * Integer limit, String sku) { HashMap<String, Object> hashMap = new
	 * HashMap<String, Object>();
	 * 
	 * // 分页 PageHelper.startPage(page, limit);
	 * 
	 * List<OrderGoods> orderGoods = orderGoodsMapper.getOrderGoods(sku);
	 * 
	 * // 转为pageinfo PageInfo pageInfo = new PageInfo(orderGoods);
	 * 
	 * hashMap.put("code", 0); hashMap.put("msg", "获取成功"); hashMap.put("count",
	 * pageInfo.getTotal()); hashMap.put("data", orderGoods.size() > 0 ?
	 * orderGoods : null);
	 * 
	 * return hashMap; }
	 */

}
