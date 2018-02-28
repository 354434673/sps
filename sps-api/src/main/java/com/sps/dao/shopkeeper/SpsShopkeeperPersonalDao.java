package com.sps.dao.shopkeeper;

import com.sps.entity.app.SpsAppBanner;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.base.BaseDB;
import com.sps.service.base.ServiceBase;
import com.sun.jdi.connect.Connector;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * Created by cailing on 2018-02-27.
 * 个人信息的Dao
 */
public interface SpsShopkeeperPersonalDao extends BaseDB<SpsShopkeeperPersonal> {
    /**
     * 根据用户id查询昵称与头像
     * @param id
     * @returnid
     */
  SpsShopkeeperPersonal getByPersonId(@Param("id") Integer id);

    /**
     * 根据用户id，保存图片信息
     * @param id
     * @param src
     * @return
     */
    int  saveSrc(@Param("id") Integer id, @Param("src") String src);
    int updateNickName(@Param("id") Integer id, @Param("nickName") String nickName);
}
