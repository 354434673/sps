package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelEnterpriseExample;

public interface SpsChannelEnterpriseWriteMapper {

    int deleteByExample(SpsChannelEnterpriseExample example);

    int deleteByPrimaryKey(Integer enterpriseId);

    int insert(SpsChannelEnterprise record);

    int insertSelective(SpsChannelEnterprise record);

    int updateByExampleSelective(@Param("record") SpsChannelEnterprise record, @Param("example") SpsChannelEnterpriseExample example);

    int updateByExample(@Param("record") SpsChannelEnterprise record, @Param("example") SpsChannelEnterpriseExample example);

    int updateByPrimaryKeySelective(SpsChannelEnterprise record);

    int updateByPrimaryKey(SpsChannelEnterprise record);
}