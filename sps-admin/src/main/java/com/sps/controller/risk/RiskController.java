package com.sps.controller.risk;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sps.entity.balance.Balance;
import org.sps.service.balance.write.BalanceWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
/**
 * 风控审核控制层
 * @ClassName:  RiskController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年4月8日 下午4:37:52
 */
@RestController
@RequestMapping("/risk")
public class RiskController {
	@Reference(group = "dianfu")
	private BalanceWriteService balanceWriteService;
	/**
	 * 额度审核
	 * @Title: insertBalance   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param balance
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月8日 下午4:38:02
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/insertBalance")
	private HashMap<String, Object> insertBalance(Balance balance){
		
		HashMap<String, Object> insertBalance = balanceWriteService.insertBalance(balance);
		
		return insertBalance;
	}
}
