package com.sps.entity.order;

import java.util.List;

public class OrderGoodsVo {
	
	private List<OrderGoods> orderGoodsList;

	public OrderGoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderGoodsVo(List<OrderGoods> orderGoodsList) {
		super();
		this.orderGoodsList = orderGoodsList;
	}

	public List<OrderGoods> getOrderGoodsList() {
		return orderGoodsList;
	}

	public void setOrderGoodsList(List<OrderGoods> orderGoodsList) {
		this.orderGoodsList = orderGoodsList;
	}

	
}
