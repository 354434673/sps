package com.sps.dao.order;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.order.Order;
import org.sps.entity.order.OrderRepayDetail;

import java.util.Date;
import java.util.List;

public interface OrderRepayDetailMapper {

    /**
     * 根据订单id查询信息
	 * @param orderNo
     * @return
     */
	OrderRepayDetail selectByOrderNo(String orderNo);
}