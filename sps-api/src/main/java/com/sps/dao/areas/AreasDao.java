package com.sps.dao.areas;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sps.entity.areas.Areas;
import com.sps.entity.areas.AreasExample;
import com.sps.service.base.BaseService;
import com.sps.service.base.ServiceBase;

public interface AreasDao extends ServiceBase<AreasExample, Areas>{
	
}