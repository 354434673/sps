package com.sps.dao.shopkeeper.write;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitationExample;

public interface SpsShopkeeperInvitationWriteMapper {

    int deleteByExample(SpsShopkeeperInvitationExample example);

    int deleteByPrimaryKey(Integer invitationId);

    int insert(SpsShopkeeperInvitation record);

    int insertSelective(SpsShopkeeperInvitation record);

    int updateByExampleSelective(@Param("record") SpsShopkeeperInvitation record, @Param("example") SpsShopkeeperInvitationExample example);

    int updateByExample(@Param("record") SpsShopkeeperInvitation record, @Param("example") SpsShopkeeperInvitationExample example);

    int updateByPrimaryKeySelective(SpsShopkeeperInvitation record);

    int updateByPrimaryKey(SpsShopkeeperInvitation record);
}