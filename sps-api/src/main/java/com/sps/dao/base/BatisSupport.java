package com.sps.dao.base;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BatisSupport {

	@Autowired
    private SqlSessionTemplate sqlSessionTemplate;

	protected SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}

}
