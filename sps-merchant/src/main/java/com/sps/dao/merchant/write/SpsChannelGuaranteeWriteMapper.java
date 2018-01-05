package com.sps.dao.merchant.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelGuaranteeExample;

public interface SpsChannelGuaranteeWriteMapper {
    int countByExample(SpsChannelGuaranteeExample example);

    int deleteByExample(SpsChannelGuaranteeExample example);

    int deleteByPrimaryKey(Integer guaranteeId);

    int insert(SpsChannelGuarantee record);

    int insertSelective(SpsChannelGuarantee record);

    List<SpsChannelGuarantee> selectByExample(SpsChannelGuaranteeExample example);

    SpsChannelGuarantee selectByPrimaryKey(Integer guaranteeId);

    int updateByExampleSelective(@Param("record") SpsChannelGuarantee record, @Param("example") SpsChannelGuaranteeExample example);

    int updateByExample(@Param("record") SpsChannelGuarantee record, @Param("example") SpsChannelGuaranteeExample example);

    int updateByPrimaryKeySelective(SpsChannelGuarantee record);

    int updateByPrimaryKey(SpsChannelGuarantee record);
}