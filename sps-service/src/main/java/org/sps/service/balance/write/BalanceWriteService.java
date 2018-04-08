package org.sps.service.balance.write;

import java.util.HashMap;
import java.util.List;

import org.sps.entity.balance.Balance;

public interface BalanceWriteService {
	/**
	 * 添加账户额度
	 * @Title: insertBalance   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param balance
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月8日 下午4:05:04
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> insertBalance(Balance balance);
}
