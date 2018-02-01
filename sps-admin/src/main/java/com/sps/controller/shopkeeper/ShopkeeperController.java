package com.sps.controller.shopkeeper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
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
	@Reference(group = "dianfu-dev")
	private ShopkeeperReadService readService;
	@Reference(group = "dianfu-dev")
	private ShopkeeperWriteService writeService;

	/**
	 * 查询店主列表 @Title: getShopkeeperList @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param page @param: @param
	 * limit @param: @param account @param: @param shopkeeperName @param: @param
	 * shopkeeperState @param: @return @author YangNingSheng @date 2018年1月30日
	 * 下午5:37:00 @return: HashMap<String,Object> @throws
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
		String fileName ="店主邀请模板" + ".xls";
		// 填充projects数据
		String columnNames[] = { "店主名称*", "联系电话*" };
		String keys[] = { "name", "phone" };// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(fileName.getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	    out.close();  
		return null;
	}
}
