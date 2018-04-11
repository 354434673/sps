package com.sps.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.order.OrderGoods;


public interface OrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    int insert(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    int insertSelective(OrderGoods record);

    /**
     * 根据orderid查询出商品列表信息
     * @param orderid
     * @return
     */
    List<OrderGoods> selectOrderGoods(@Param(value="orderid") String orderid,@Param(value="sku") String sku);
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sps_order_goods
     *
     * @mbggenerated
     */
    
    int updatePrice(@Param("orderGoods") OrderGoods orderGoods);
    
    int updatePriceBatch(OrderGoods orderGoods);
    
    int updateByPrimaryKey(OrderGoods record);


    List<OrderGoods> selectOrderGood(@Param(value="orderid")String orderid);
}