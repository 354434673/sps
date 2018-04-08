package com.sps.service.account.bankCard.impl;

import com.sps.common.StringUtil;
import com.sps.dao.account.AccountBalanceDao;
import com.sps.dao.account.BankCardInfoDao;
import com.sps.dao.account.BindBankTransDao;
import com.sps.dao.shopkeeper.SpsShopkeeperDao;
import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BindBankTrans;
import com.sps.service.account.bankCard.BindCardTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Administrator on 2018-03-21.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Service
public class BindCardTransServiceImpl implements BindCardTransService {
    @Autowired
    private BankCardInfoDao bankCardInfoDao;
    @Autowired
    private AccountBalanceDao accountBalanceDao;
    @Autowired
    private BindBankTransDao bindBankTransDao;
    @Autowired
    private SpsShopkeeperDao spsShopkeeperDao;


    @Override
    public void removeBankInfo(String serialSh, String serialYop) {

    }

    @Override
    public boolean saveBankTansInfos(BindBankTrans bankCardInfo) {

        int m = bindBankTransDao.insertBankTrans(bankCardInfo);
        return m>0;
    }

    @Override
    public Boolean modifyBankTran(String seriNum, String yopSerNO, String status,String cardtop,String  cardlast, String authtype,String remark) {
        int m=0;
        if(StringUtil.isNotEmpty(yopSerNO)){
            BindBankTrans bindBankTrans = bindBankTransDao.selectByRequestNo(seriNum);
           m= bindBankTransDao.updateBankTrans(bindBankTrans.getId(),status,yopSerNO,new Date(),cardtop,cardlast,authtype,remark);
        }else{
            BindBankTrans bindBankTrans = bindBankTransDao.selectByRequestNo(seriNum);
            m=  bindBankTransDao.updateBankTrans(bindBankTrans.getId(),status,null,new Date(),cardtop,cardlast,authtype,remark);
        }
        return m > 0 ? true : false;
    }

    @Override
    public BindBankTrans findBankState(String requestNo, String yborderid) {
        if(StringUtil.isEmpty(yborderid)){
            return  bindBankTransDao.selectByRequestNo(requestNo);
        }
        return bindBankTransDao.selectOne(requestNo, yborderid);

    }
}
