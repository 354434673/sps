package com.sps.dao.express;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.express.SpsExpress;
import com.sps.entity.express.SpsExpressExample;

public interface SpsExpressMapper {
    int countByExample(SpsExpressExample example);

    int deleteByExample(SpsExpressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpsExpress record);

    int insertSelective(SpsExpress record);

    List<SpsExpress> selectByExample(SpsExpressExample example);

    SpsExpress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpsExpress record, @Param("example") SpsExpressExample example);

    int updateByExample(@Param("record") SpsExpress record, @Param("example") SpsExpressExample example);

    int updateByPrimaryKeySelective(SpsExpress record);

    int updateByPrimaryKey(SpsExpress record);
}