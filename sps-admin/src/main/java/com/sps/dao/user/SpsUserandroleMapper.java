package com.sps.dao.user;

import com.sps.entity.user.SpsUserandrole;
import com.sps.entity.user.SpsUserandroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpsUserandroleMapper {
    int countByExample(SpsUserandroleExample example);

    int deleteByExample(SpsUserandroleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpsUserandrole record);

    int insertSelective(SpsUserandrole record);

    List<SpsUserandrole> selectByExample(SpsUserandroleExample example);

    SpsUserandrole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpsUserandrole record, @Param("example") SpsUserandroleExample example);

    int updateByExample(@Param("record") SpsUserandrole record, @Param("example") SpsUserandroleExample example);

    int updateByPrimaryKeySelective(SpsUserandrole record);

    int updateByPrimaryKey(SpsUserandrole record);
}