package com.sps.dao.bank;
import com.sps.dao.base.ApiBaseDaoImpl;
import com.sps.entity.bank.SpsBank;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository
public class SpsBankMapper extends ApiBaseDaoImpl<SpsBank, Integer> {
    @Override
    public String getNameSpace() {
        return "sqlmap.SpsBank";
    }

    public SpsBank findByChannlNum(String channlNum) {
        return super.selectOne(getStatement("findByChannlNum"),channlNum);
    }
}