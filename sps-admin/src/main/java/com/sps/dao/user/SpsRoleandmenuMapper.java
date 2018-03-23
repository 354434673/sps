package com.sps.dao.user;

import com.sps.entity.user.SpsRoleandmenu;
import com.sps.entity.user.SpsRoleandmenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpsRoleandmenuMapper {
    int countByExample(SpsRoleandmenuExample example);

    int deleteByExample(SpsRoleandmenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpsRoleandmenu record);

    int insertSelective(SpsRoleandmenu record);

    List<SpsRoleandmenu> selectByExample(SpsRoleandmenuExample example);

    SpsRoleandmenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpsRoleandmenu record, @Param("example") SpsRoleandmenuExample example);

    int updateByExample(@Param("record") SpsRoleandmenu record, @Param("example") SpsRoleandmenuExample example);

    int updateByPrimaryKeySelective(SpsRoleandmenu record);

    int updateByPrimaryKey(SpsRoleandmenu record);
}