package com.sps.dao.account;

import com.sps.entity.account.BankCardInfo;
import org.apache.ibatis.annotations.Param;

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
public interface BankCardInfoDao {
//   根据登录用户获取绑卡信息
    String  selectByUserName(@Param("userName") String userName,@Param("userMark") Integer userMark);
    //保存绑卡记录
    int insertBankCardInfo(BankCardInfo bankCardInfo);
    //删除绑卡记录
    int deleteBankCard(String userId);
}
