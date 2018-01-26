package com.sps.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.order.Order;

public interface OrderMapper {

	/**
	 * 根据oId查看订单
	 * @param oId
	 * @return
	 */
    Order selectByPrimaryKey(
    		@Param(value="orderid") String orderid
    		);
    
    /**
     * 根据商户名称，订单编号，申请订单的起止时间查询订单列表详情
     * @param name 商户名称
     * @param orderid 订单编号
     * @param startTime 申请订单起始时间
     * @param endTime 申请订单结束时间
     * @return
     */
    List<Order> selectByParameters(
    		@Param(value="name") String name,
    		@Param(value="channelName") String channelName,
    		@Param(value="selfname") String selfname,
    		@Param(value="orderid") String orderid,
    		@Param(value="startTime") String startTime, 
    		@Param(value="endTime") String endTime,
    		@Param(value="flag") String flag
    		);

    /**
     * 根据前台传入的status更新orderid对应的订单的数据库状态码
     * @param status
     * @return
     */
	int updateOrderFlag(
			@Param(value="orderid") String orderid,
			@Param(value="flag") String flag,
			@Param(value="remark") String remark
			);
    
   
}