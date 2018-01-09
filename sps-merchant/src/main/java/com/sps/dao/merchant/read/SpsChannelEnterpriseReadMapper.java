package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelEnterpriseExample;

public interface SpsChannelEnterpriseReadMapper {
    int countByExample(SpsChannelEnterpriseExample example);

    List<SpsChannelEnterprise> selectByExample(SpsChannelEnterpriseExample example);

    SpsChannelEnterprise selectByPrimaryKey(Integer enterpriseId);
    
    List<SpsChannelEnterprise> selectChannel(SpsChannel channel);
}