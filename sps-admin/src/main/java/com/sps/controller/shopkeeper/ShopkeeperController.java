package com.sps.controller.shopkeeper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.util.CommonUtil;
import com.sps.util.ExcelUtil;

/**
 * 店主相关控制层
 * 
 * @ClassName: ShopkeeperController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author YangNingSheng
 * @date 2018年1月30日 下午5:37:03
 */
@Controller
@RequestMapping("/shopkeeper")
public class ShopkeeperController{
	@Reference(group = "dianfu")
	private ShopkeeperReadService readService;
	@Reference(group = "dianfu")
	private ShopkeeperWriteService writeService;

	/**
	 * 查询店主列表
	 * @Title: getShopkeeperList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param account
	 * @param: @param shopkeeperName
	 * @param: @param shopkeeperState
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年2月2日 下午4:32:46
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperList.json")
	public @ResponseBody HashMap<String, Object> getShopkeeperList(Integer page, Integer limit, String account,
			String shopkeeperName, Integer shopkeeperState) {
		
		HashMap<String, Object> shopkeeperList = readService.getShopkeeperList(page, limit, account, shopkeeperName,
				shopkeeperState);
		return shopkeeperList;
	}

	/**
	 * 查找申请信息 @Title: getShopkeeper @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param
	 * shopkeeperCustomerid @param: @return @author YangNingSheng @date
	 * 2018年1月30日 下午8:26:39 @return: HashMap<String,Object> @throws
	 */
	@RequestMapping("/getShopkeeper")
	public @ResponseBody HashMap<String, Object> getShopkeeper(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeper(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperCompany")
	public @ResponseBody HashMap<String, Object> getShopkeeperCompany(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperCompany(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperCarProperty")
	public @ResponseBody HashMap<String, Object> getShopkeeperCarProperty(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperCarProperty(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperContact")
	public @ResponseBody HashMap<String, Object> getShopkeeperContact(String shopkeeperCustomerid, Integer page,
			Integer limit) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperContact(shopkeeperCustomerid, page, limit);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperCredit")
	public @ResponseBody HashMap<String, Object> getShopkeeperCredit(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperCredit(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperHouseProperty")
	public @ResponseBody HashMap<String, Object> getShopkeeperHouseProperty(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperHouseProperty(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperPersonal")
	public @ResponseBody HashMap<String, Object> getShopkeeperPersonal(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperPersonal(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperRepayment")
	public @ResponseBody HashMap<String, Object> getShopkeeperRepayment(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperRepayment(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperPic")
	public @ResponseBody HashMap<String, Object> getShopkeeperPic(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperPic(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/getShopkeeperAccount")
	public @ResponseBody HashMap<String, Object> getShopkeeperAccount(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperAccount(shopkeeperCustomerid);

		return shopkeeper;
	}

	@RequestMapping("/updateAccount")
	public @ResponseBody HashMap<String, Object> updateAccount(String shopkeeperCustomerid,
			SpsShopkeeperAccount account) {

		HashMap<String, Object> updateAccount = writeService.updateAccount(shopkeeperCustomerid, account);

		return updateAccount;
	}
	
	@RequestMapping("/updateState")
	public @ResponseBody HashMap<String, Object> updateState(String shopkeeperCustomerid,
			Integer state) {
		
		HashMap<String, Object> updateState = writeService.updateState(shopkeeperCustomerid, state);
		
		return updateState;
	}
	/**
	 * 导出模板
	 * @Title: exportExcel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param response
	 * @param: @return
	 * @param: @throws IOException  
	 * @author YangNingSheng    
	 * @date 2018年2月1日 下午3:36:36
	 * @return: Map<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> exportExcel(HttpServletResponse response)
			throws IOException {
		
		ExcelUtil.exportExcel(response);
		
		return null;
	}
	/**
	 * 
	 * @Title: importExcel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param file
	 * @param: @return
	 * @param: @throws IOException  
	 * @author YangNingSheng    
	 * @date 2018年2月2日 下午8:40:31
	 * @return: Map<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/importExcel")
	@ResponseBody
	public Map<String, Object> importExcel(@RequestParam(value = "file", required = false) MultipartFile file)
			throws IOException {
		
		List<ArrayList<String>> importExcel = new ExcelUtil().importExcel(file);
		
		return null;
	}
}
