package com.sps.dao.user;

import com.sps.entity.user.SpsRole;
import com.sps.entity.user.SpsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpsRoleMapper {
    int countByExample(SpsRoleExample example);

    int deleteByExample(SpsRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(SpsRole record);

    int insertSelective(SpsRole record);

    List<SpsRole> selectByExample(SpsRoleExample example);
    
    List<SpsRole> selectRoleForUserId(@Param("id")Integer id);

    SpsRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") SpsRole record, @Param("example") SpsRoleExample example);

    int updateByExample(@Param("record") SpsRole record, @Param("example") SpsRoleExample example);

    int updateByPrimaryKeySelective(SpsRole record);

    int updateByPrimaryKey(SpsRole record);
}