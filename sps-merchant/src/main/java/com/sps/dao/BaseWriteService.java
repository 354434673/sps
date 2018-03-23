package com.sps.dao;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

public interface BaseWriteService <T, K extends Serializable>{

    int deleteByExample(T example);

    int deleteByPrimaryKey(Integer id);

    int insert(K record);

    int insertSelective(K record);

    int updateByExampleSelective(@Param("record") K record, @Param("example") T example);

    int updateByExample(@Param("record") K record, @Param("example") T example);

    int updateByPrimaryKeySelective(K record);

    int updateByPrimaryKey(K record);
}
