package com.sps.dao.shopkeeper.read;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitationExample;

public interface SpsShopkeeperInvitationReadMapper {
    int countByExample(SpsShopkeeperInvitationExample example);

    List<SpsShopkeeperInvitation> selectByExample(SpsShopkeeperInvitationExample example);

    SpsShopkeeperInvitation selectByPrimaryKey(Integer invitationId);
}