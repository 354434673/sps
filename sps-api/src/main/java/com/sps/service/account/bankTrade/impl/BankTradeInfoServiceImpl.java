package com.sps.service.account.bankTrade.impl;

import com.sps.dao.account.BankCardInfoDao;
import com.sps.dao.account.BankTradeInfoDao;
import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BankTradeInfo;
import com.sps.entity.account.vo.BankTradeInfoVo;
import com.sps.service.account.bankTrade.BankTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-03-09.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Service
public class BankTradeInfoServiceImpl implements BankTradeService {
    @Autowired
    private BankCardInfoDao bankCardInfoDao;
    @Autowired
    private BankTradeInfoDao bankTradeInfoDao;
    @Override
    public List<BankTradeInfo> findBankTrdeList(String constomeId) {
//        根据用户名查询userId
       String userId = bankCardInfoDao.selectByUserName(constomeId);
//        根据用户userId查询交易信息
        List<BankTradeInfo> bankTradeList = bankTradeInfoDao.selectListByUserName(userId);
        return bankTradeList;
    }
    @Override
    public List<BankTradeInfo> findBankTrdeListByTradeType(String constomId,  String tradeType) {
        String userId = bankCardInfoDao.selectByUserName(constomId);
//        根据用户userId查询交易信息
        List<BankTradeInfo> bankTradeList = bankTradeInfoDao.selectListByUserNameAndTradeType(userId,tradeType);
        return bankTradeList;
    }

    @Override
    public BankTradeInfo findBankTradeDetail( Integer id) {
        BankTradeInfo bankTradeInfo = bankTradeInfoDao.selectDetail(id);
        return bankTradeInfo;
    }

    @Override
    public List<BankTradeInfoVo> findBankTrdeShowList(String constomeId) {
        List<BankTradeInfoVo> bankTradeList = bankTradeInfoDao.selectListByConstomeId(constomeId);
        return bankTradeList;
    }

    @Override
    public BankTradeInfo findTradeDetailByOrderNo(String orderNo) {
        BankTradeInfo bankTradeInfo = bankTradeInfoDao.selectDetailByOrderNo(orderNo);
        return bankTradeInfo;
    }

    @Override
    public List<BankTradeInfoVo> findBankTrdeShowPageList(String constomeId, Integer types,Integer currentPage,Integer pageSize) {
        //暂时分页写死
        currentPage = currentPage * pageSize;
        return  bankTradeInfoDao.findBankTrdeShowPageList(constomeId,types,currentPage,pageSize);
    }

}
