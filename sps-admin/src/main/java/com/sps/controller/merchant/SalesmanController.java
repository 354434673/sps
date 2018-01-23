package com.sps.controller.merchant;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.service.merchant.read.ChannelSalesmanReadService;
import org.sps.service.merchant.write.ChannelSalesmanWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
/**
 * 业务员控制层
 * @ClassName:  SalesmanController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月12日 下午4:14:48
 */
@Controller
@RequestMapping("/salesman")
public class SalesmanController {
	@Reference(check=false,group="dianfu-dev")
	private ChannelSalesmanWriteService salesmanWrite;
	@Reference(check=false,group="dianfu-dev")
	private ChannelSalesmanReadService salesmanRead;
	/**
	 * 添加业务员
	 * @Title: insertSalesman   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salesman
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:15:01
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("insertSalesman")
	@ResponseBody
	public HashMap<String,Object>  insertSalesman(SpsChannelSalesman salesman){
		
		HashMap<String, Object> insertSalesman = salesmanWrite.insertSalesman(salesman);
		
		return insertSalesman;
	};
	/**
	 * 查询业务员列表
	 * @Title: getSalesmanList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param salesmanName
	 * @param: @param salesmanIdcard
	 * @param: @param salesmanPhone
	 * @param: @param salesmanEmail
	 * @param: @param bei1
	 * @param: @param page
	 * @param: @param limit
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 下午4:15:12
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getSalesmanList.json")
	@ResponseBody
	public HashMap<String,Object>  getSalesmanList(String salesmanName, String salesmanIdcard, 
			String salesmanPhone, String salesmanEmail, String bei1, Integer page, Integer limit){
		
		HashMap<String, Object> salesmanList = 
				salesmanRead.getSalesmanList(salesmanName, salesmanIdcard, salesmanPhone,
						salesmanEmail, bei1, page, limit);
		
		return salesmanList;
	};
}
