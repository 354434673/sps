package com.sps.service.base;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceBase<T,K extends Serializable>{
    int countByExample(T example);

    int deleteByExample(T example);

    int deleteByPrimaryKey(Integer userId);

    int insert(K record);

    int insertSelective(K record);

    List<K> selectByExample(T example);

    K selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") K record, @Param("example") T example);

    int updateByExample(@Param("record") K record, @Param("example") T example);

    int updateByPrimaryKeySelective(K record);

    int updateByPrimaryKey(K record);
}