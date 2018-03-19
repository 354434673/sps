package com.sps.dao.order;

import org.apache.ibatis.annotations.Param;
import org.sps.entity.order.SpsOrderLogistics;
import org.sps.entity.order.SpsOrderLogisticsExample;

import java.util.List;

public interface SpsOrderLogisticsMapper {
    int countByExample(SpsOrderLogisticsExample example);

    int deleteByExample(SpsOrderLogisticsExample example);

    int deleteByPrimaryKey(Integer logisticsId);

    int insert(SpsOrderLogistics record);

    int insertSelective(SpsOrderLogistics record);

    List<SpsOrderLogistics> selectByExample(SpsOrderLogisticsExample example);

    SpsOrderLogistics selectByPrimaryKey(Integer logisticsId);

    int updateByExampleSelective(@Param("record") SpsOrderLogistics record, @Param("example") SpsOrderLogisticsExample example);

    int updateByExample(@Param("record") SpsOrderLogistics record, @Param("example") SpsOrderLogisticsExample example);

    int updateByPrimaryKeySelective(SpsOrderLogistics record);

    int updateByPrimaryKey(SpsOrderLogistics record);

    /**
     * g根据订单号查询物流信息
     * @param orderNo
     * @return
     */
    SpsOrderLogistics  selectByOrderNo(String  orderNo);
}