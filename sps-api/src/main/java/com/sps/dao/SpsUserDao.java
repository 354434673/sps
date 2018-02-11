package com.sps.dao;

import com.sps.entity.user.SpsUser;
import com.sps.entity.user.SpsUserExample;
import com.sps.service.base.ServiceBase;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpsUserDao extends ServiceBase<SpsUserExample, SpsUser>{
	
}