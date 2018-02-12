package com.sps.dao.merchant.write;

import org.sps.entity.merchant.SpsChannelBank;

public interface SpsChannelBankWriteMapper {

	int deleteByPrimaryKey(String userId);

    int insertBank(SpsChannelBank bank);

    int updateBank(SpsChannelBank bank);
}