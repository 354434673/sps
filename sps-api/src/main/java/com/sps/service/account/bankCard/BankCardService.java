package com.sps.service.account.bankCard;

import com.sps.entity.account.BankCardInfo;

import java.util.List;

/**
 * Created by Administrator on 2018-03-10.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface BankCardService {
    String findUserId(String customerId);
    //保存绑卡信息的方法
    Boolean saveBankCardInfo(BankCardInfo bankCardInfo);
    //删除绑卡记录
    Boolean  removeBankCard(String userId);
    //根据客户编号查询绑卡信息
    List<BankCardInfo> findBindCardInfo(String customerId);
    //更新银行卡信息
    Boolean modifyBankInfo(BankCardInfo bankCardInfo);
}
