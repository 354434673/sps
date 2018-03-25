package com.sps.controller.merchant;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sps.entity.merchant.SpsChannelSalesman;
import org.sps.service.merchant.read.ChannelSalesmanReadService;
import org.sps.service.merchant.write.ChannelSalesmanWriteService;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * 业务员控制层
 *
 * @ClassName: SalesmanController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author YangNingSheng
 * @date 2018年1月12日 下午4:14:48
 */
@RestController
@RequestMapping("/salesman")
public class SalesmanController {
	private final String REQUEST_URL = "http://123.56.24.208:8480";
	@Reference(check = false, group = "dianfu")
	private ChannelSalesmanWriteService salesmanWrite;
	@Reference(check = false, group = "dianfu")
	private ChannelSalesmanReadService salesmanRead;
/*	@Resource
	private ISmsCommonService iSmsCommonService;*/

	/**
	 * 添加业务员 @Title: insertSalesman @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param salesman @param: @return @author
	 * YangNingSheng @date 2018年1月12日 下午4:15:01 @return:
	 * HashMap<String,Object> @throws
	 */
	@RequestMapping("insertSalesman")
	public HashMap<String, Object> insertSalesman(SpsChannelSalesman salesman) {
		
		final String URL = REQUEST_URL +"/invitation.html?salemanPhone="+salesman.getSalesmanPhone();
		
		final String CONTENT = "【店付】业务员您好，以下为店主邀请链接，请妥善保存此链接:"+URL;
		
		Subject subject = SecurityUtils.getSubject();
		
		String channelNum = (String)subject.getSession().getAttribute(subject.getPrincipal());

		salesman.setSalesmaneChannelNum(channelNum);
		
		HashMap<String, Object> insertSalesman = salesmanWrite.insertSalesman(salesman);
		
/*		if(insertSalesman.get("state").equals("success")){
			//业务员添加成功后调用短信接口给业务员发送短信
			ServiceResult<Boolean> sendCommonSms = iSmsCommonService.sendCommonSms(salesman.getSalesmanPhone(), CONTENT, 3);
		}*/
		return insertSalesman;
	};

	@RequestMapping("updateSalesman")
	public HashMap<String, Object> updateSalesman(SpsChannelSalesman salesman) {
		HashMap<String, Object> updateSalesman = salesmanWrite.updateSalesman(salesman);

		return updateSalesman;
	}

	/**
	 * 查询业务员列表 @Title: getSalesmanList @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param salesmanName @param: @param
	 * salesmanIdcard @param: @param salesmanPhone @param: @param
	 * salesmanEmail @param: @param bei1 @param: @param page @param: @param
	 * limit @param: @return @author YangNingSheng @date 2018年1月12日
	 * 下午4:15:12 @return: HashMap<String,Object> @throws
	 */
	@RequestMapping("/getSalesmanList.json")
	public HashMap<String, Object> getSalesmanList(String salesmanName, String salesmanIdcard, String salesmanPhone,
			String salesmanEmail, String bei1, Integer page, Integer limit) {

		HashMap<String, Object> salesmanList = salesmanRead.getSalesmanList(salesmanName, salesmanIdcard, salesmanPhone,
				salesmanEmail, bei1, page, limit);

		return salesmanList;
	}
}
