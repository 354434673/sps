package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.entity.merchant.SpsChannelSalesmanExample;

public interface SpsChannelSalesmanReadMapper {
    int countByExample(SpsChannelSalesmanExample example);

    List<SpsChannelSalesman> selectByExample(SpsChannelSalesmanExample example);

    SpsChannelSalesman selectByPrimaryKey(Integer salesmanId);

}