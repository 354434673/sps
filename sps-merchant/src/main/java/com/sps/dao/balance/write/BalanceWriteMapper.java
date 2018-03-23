package com.sps.dao.balance.write;

import com.sps.dao.BaseReadService;
import com.sps.dao.BaseWriteService;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.balance.Balance;
import org.sps.entity.balance.BalanceExample;

public interface BalanceWriteMapper extends BaseWriteService<BalanceExample, Balance>{
}