package com.sps.dao.shopkeeper;

import com.sps.entity.app.SpsAppBanner;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.base.BaseDB;
import com.sps.service.base.ServiceBase;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * Created by cailing on 2018-02-27.
 * 涓汉淇℃伅鐨凞ao
 */
public interface SpsShopkeeperPersonalDao extends BaseDB<SpsShopkeeperPersonal> {
    /**
     * 鏍规嵁鐢ㄦ埛id鏌ヨ鏄电О涓庡ご鍍�
     * @param id
     * @returnid
     */
  SpsShopkeeperPersonal getByPersonId(@Param("id") Integer id);

    /**
     * 鏍规嵁鐢ㄦ埛id锛屼繚瀛樺浘鐗囦俊鎭�
     * @param id
     * @param src
     * @return
     */
    int  saveSrc(@Param("id") Integer id, @Param("src") String src);
    int updateNickName(@Param("id") Integer id, @Param("nickName") String nickName);
}
