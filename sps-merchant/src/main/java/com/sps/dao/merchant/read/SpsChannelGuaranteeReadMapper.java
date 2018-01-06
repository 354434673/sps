package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelGuaranteeExample;

public interface SpsChannelGuaranteeReadMapper {
    int countByExample(SpsChannelGuaranteeExample example);

    List<SpsChannelGuarantee> selectByExample(SpsChannelGuaranteeExample example);

    SpsChannelGuarantee selectByPrimaryKey(Integer guaranteeId);
}