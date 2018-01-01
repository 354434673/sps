package com.sps.dao.user;

import com.sps.entity.user.SpsMenu;
import com.sps.entity.user.SpsMenuExample;
import com.sps.util.MenuUtil;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpsMenuMapper {
    int countByExample(SpsMenuExample example);

    int deleteByExample(SpsMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(SpsMenu record);

    int insertSelective(SpsMenu record);

    List<SpsMenu> selectByExample(SpsMenuExample example);

    SpsMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") SpsMenu record, @Param("example") SpsMenuExample example);

    int updateByExample(@Param("record") SpsMenu record, @Param("example") SpsMenuExample example);

    int updateByPrimaryKeySelective(SpsMenu record);

    int updateByPrimaryKey(SpsMenu record);
    
    List<MenuUtil> seletMenuList();
}