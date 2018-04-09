package com.sps.dao.merchant;


import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.merchant.SpsChannelOpenAccount;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class SpsChannelOpenAccountMapper extends ApiBaseDaoImpl<SpsChannelOpenAccount, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsChannelOpenAccount";
    }

    public SpsChannelOpenAccount findByNum(String channelNum) {
        return super.selectOne(getStatement("findByNum"),channelNum);
    }
}