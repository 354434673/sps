package com.sps.dao.shopkeeper;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonalExample;
import com.sps.service.base.BaseDB;

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
   * 获取身份证信息
   * @param personId
   * @return
   */
  String  selectByPersonId(@Param("personId") String personId);

    /**
     * 鏍规嵁鐢ㄦ埛id锛屼繚瀛樺浘鐗囦俊鎭�
     * @param id
     * @param src
     * @return
     */
    int  saveSrc(@Param("id") Integer id, @Param("src") String src);
    int updateNickName(@Param("id") Integer id, @Param("nickName") String nickName);
    
    int insertSelective(SpsShopkeeperPersonal personal);
    
    int updateByExampleSelective(@Param("record") SpsShopkeeperPersonal record, @Param("example") SpsShopkeeperPersonalExample example);

    SpsShopkeeperPersonal selectById(@Param("id") Integer id);
}
