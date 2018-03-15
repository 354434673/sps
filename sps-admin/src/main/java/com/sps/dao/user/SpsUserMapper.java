package com.sps.dao.user;

import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpsUserMapper {
    int countByExample(SpsUserExample example);

    int deleteByExample(SpsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SpsUser record);

    int insertSelective(SpsUser record);

    List<SpsUser> selectByExample(SpsUserExample example);

    SpsUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SpsUser record, @Param("example") SpsUserExample example);

    int updateByExample(@Param("record") SpsUser record, @Param("example") SpsUserExample example);

    int updateByPrimaryKeySelective(SpsUser record);

    int updateByPrimaryKey(SpsUser record);
//根据用户名获取用户
    SpsUser  selectByUserName(String userName);
}