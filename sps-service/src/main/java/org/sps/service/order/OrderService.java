package org.sps.service.order;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.sps.entity.order.Order;
import org.sps.entity.order.OrderGoods;
import org.sps.entity.order.OrderGoodsVo;
import org.sps.entity.order.SpsOrderLogistics;

public interface OrderService extends Serializable{

	/**
	 * 根据oId查看订单，以及订单中的商品
	 *
	 * @param oId
	 * @return
	 */
	HashMap<String, Object> selectByPrimaryKey(String orderid);
	/*
	 * Order selectByPrimaryKey(String orderid);
	 */

	/**
	 * 根据商户名称，订单编号，申请订单的起止时间查询订单列表详情
	 *
	 * @param name
	 *            商户名称
	 * @param orderid
	 *            订单编号
	 * @param startTime
	 *            申请订单起始时间
	 * @param endTime
	 *            申请订单结束时间
	 * @param flag
	 *            订单状态
	 * @return
	 */
	HashMap<String, Object> selectByParameters(Integer page, Integer limit, String name, String channelNum, String channelName, String selfname, String orderid,
											   String startTime, String endTime, String flag);

	/**
	 *
	 * @param orderid
	 *            订单编号
	 * @return 返回订单对应的商品
	 */
	HashMap<String, Object> selectOrderGoods(Integer page, Integer limit, String orderid, String sku);

	/**
	 * 修改单价,只是在待确认订单中才有修改单价功能
	 *
	 * @param page
	 * @param limit
	 * @param orderid
	 *            订单id
	 * @param price
	 *            传入的价格
	 * @return
	 */
	// HashMap<String, Object> updatePriceBatch(Integer page, Integer limit,
	// String orderid,BigDecimal price);

	//修改单个
/*	int updatePrice(OrderGoods orderGoods);*/
	//批量修改
	/*HashMap<String, Object> updatePriceBatch(List<OrderGoods> orderGoodses);*/
	HashMap<String, Object> updatePriceBatch(List<OrderGoods> orderGoods);
	//只查询订单详情，不包含订单中的商品
	HashMap<String, Object> selectOrderByOrderId(String orderid);

	//待确认订单提交,需传入的参数为orderid
	/**
	 * @param order 订单的信息，包含订单的基本信息和该订单下的订单商品的信息
	 * @param flag 订单状态
	 * @param remark 说明
	 * @return
	 */
	HashMap<String, Object> updateOrderFlag(String orderid,String flag,String remark);
	/**
	 * 添加物流相关
	 * @Title: insertLogistics
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param logistics
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年2月2日 下午2:09:00
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	HashMap<String, Object> insertLogistics(String flag, SpsOrderLogistics logistics);

	/**
	 * 根据各种条件查询信息
	 * @param page
	 * @param limit
	 * @param loanStartTime
	 * @param loanEndTime
	 * @param loanName
	 * @param loanStatus
	 * @param orderNo
	 * @return
	 */
	HashMap<String, Object> queryOrderList(Integer page,
										   Integer limit,
										   String loanStartTime,
										   String loanEndTime,
										   String  loanName,
										   Integer loanStatus,
										   String orderNo);

	/**
	 * 根据订单id查询详情信息
	 * @param orderNo
	 * @return
	 */
	HashMap<String, Object> queryByOrderDetailByOrderNo(Integer page,
														Integer limit, String orderNo);

	/**
	 * 根据订单id，查询订单信息
	 * @param orderId
	 * @return
	 */
	Order queryByOrderId(String orderId);

	/**
	 *根据订单id查询所有的订单项
	 * @param page
	 * @param limit
	 * @param tradeSeriNum
	 * @return
	 */

	HashMap<String, Object> getGoodsByOrderId(Integer page,
											  Integer limit, String tradeSeriNum);

}
