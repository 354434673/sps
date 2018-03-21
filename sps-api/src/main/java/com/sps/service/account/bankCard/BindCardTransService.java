package com.sps.service.account.bankCard;

import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BindBankTrans;

import java.util.HashMap;

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
public interface BindCardTransService {

	/**
     * 删除交易记录信息
	 */
    void  removeBankInfo(String serialSh, String serialYop);

	/**
     * 根据页面绑卡记录 保存绑卡交易信息
	 *
     */
    HashMap<String,Object> saveBankTansInfos(BankCardInfo bankCardInfo, String userName, String marchantNo, String UserId);

	/**
            * 根据请求号更新绑卡记录表
	 * @param seriNum
	 * @param yopSerNO
	 * @param status
	 * @return
     */
    Boolean  modifyBankTran(String seriNum, String yopSerNO, String status);
	/***
            * 根据请求好与易宝号进行查询
	 * @param requestNo
	 * @param yborderid
	 * @return
     */
    BindBankTrans findBankState(String requestNo, String yborderid);
}
