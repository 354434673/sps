package com.sps.service.account.bankCard;

import com.sps.entity.account.BankCardInfo;

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
    String findUserId(String userName);
    //保存绑卡信息的方法
    Boolean saveBankCardInfo(BankCardInfo bankCardInfo, Integer userId, Integer userMark);
}
