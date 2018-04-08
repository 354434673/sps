package org.sps.service.balance.read;

import java.util.HashMap;
import java.util.List;

import org.sps.entity.balance.Balance;

public interface BalanceReadService {
	/**
	 * 根据客户编号获取额度信息
	 * @Title: queryBalanceList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param clientNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月1日 下午1:54:49
	 * @return: List<Balance>      
	 * @throws
	 */
	HashMap<String, Object> queryBalanceList(Integer page, Integer limit, String clientNum);
	/**
	 * 根据客户编号查询额度
	 * @Title: queryBalance   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月8日 下午3:38:40
	 * @return: Balance      
	 * @throws
	 */
	Balance queryBalance(String balanceClientNum, String balanceType);
}
