package com.sps.dao.balance.read;

import com.sps.dao.BaseReadService;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.sps.entity.balance.Balance;
import org.sps.entity.balance.BalanceExample;

public interface BalanceReadMapper extends BaseReadService<BalanceExample, Balance>{
}