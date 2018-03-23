package com.sps.dao.merchant.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelBusinessExample;

public interface SpsChannelBusinessReadMapper {
    int countByExample(SpsChannelBusinessExample example);

    List<SpsChannelBusiness> selectByExample(SpsChannelBusinessExample example);

    SpsChannelBusiness selectByPrimaryKey(Integer businessId);
    /**
     * 根据登陆店主的主营业务,获得相对应的商户,提供api接口
     * @Title: queryBusinessForApi   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return  
     * @author YangNingSheng    
     * @date 2018年2月8日 上午10:47:16
     * @return: List<SpsChannelBusiness>      
     * @throws
     */
    List<SpsChannelBusiness> queryBusinessForApi(@Param("businessProduct") List<String> businessProduct, @Param("picType")Integer picType);
}