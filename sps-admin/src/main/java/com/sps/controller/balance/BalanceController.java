/*package com.sps.controller.balance;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sps.service.balance.read.BalanceReadService;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/balance")
public class BalanceController {
	@Reference(group = "dianfu")
	private BalanceReadService balanceReadService;
	
	@RequestMapping("/queryBalanceList.json")
	public HashMap<String, Object>  queryBalanceList(Integer page, Integer limit, String clientNum){
		
		HashMap<String, Object> queryBalanceList = balanceReadService.queryBalanceList(page, limit, clientNum);
		
		return queryBalanceList;
	}
}
*/