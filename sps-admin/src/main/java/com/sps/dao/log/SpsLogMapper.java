package com.sps.dao.log;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.log.SpsLog;
import com.sps.entity.log.SpsLogExample;

public interface SpsLogMapper {
    int countByExample(SpsLogExample example);

    int deleteByExample(SpsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(SpsLog record);

    int insertSelective(SpsLog record);

    List<SpsLog> selectByExample(SpsLogExample example);

    SpsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") SpsLog record, @Param("example") SpsLogExample example);

    int updateByExample(@Param("record") SpsLog record, @Param("example") SpsLogExample example);

    int updateByPrimaryKeySelective(SpsLog record);

    int updateByPrimaryKey(SpsLog record);
}