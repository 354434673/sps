package com.sps.controller.shopkeeper;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.sps.entity.shopkeeper.SpsShopkeeperAccount;
import org.sps.entity.shopkeeper.SpsShopkeeperInvitation;
import org.sps.service.shopkeeper.read.ShopkeeperReadService;
import org.sps.service.shopkeeper.write.ShopkeeperWriteService;
import org.sps.util.FinalData;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.zxing.WriterException;
import com.sps.common.QRCodeFactory;
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
	
	/**
	 * 查询公司信息
	 * @Title: getShopkeeperCompany   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:22:42
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperCompany")
	public @ResponseBody HashMap<String, Object> getShopkeeperCompany(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperCompany(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 查询车产
	 * @Title: getShopkeeperCarProperty   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:22:50
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperCarProperty")
	public @ResponseBody HashMap<String, Object> getShopkeeperCarProperty(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperCarProperty(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 查找联系人信息
	 * @Title: getShopkeeperContact   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @param page
	 * @param: @param limit
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:23:03
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperContact")
	public @ResponseBody HashMap<String, Object> getShopkeeperContact(String shopkeeperCustomerid, Integer page,
			Integer limit) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperContact(shopkeeperCustomerid, page, limit);

		return shopkeeper;
	}
	/**
	 * 查找征信信息
	 * @Title: getShopkeeperCredit   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:23:24
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperCredit")
	public @ResponseBody HashMap<String, Object> getShopkeeperCredit(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperCredit(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 查询房产信息
	 * @Title: getShopkeeperHouseProperty   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:23:35
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperHouseProperty")
	public @ResponseBody HashMap<String, Object> getShopkeeperHouseProperty(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperHouseProperty(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 查找个人信息
	 * @Title: getShopkeeperPersonal   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:23:42
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperPersonal")
	public @ResponseBody HashMap<String, Object> getShopkeeperPersonal(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperPersonal(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 查找收人信息
	 * @Title: getShopkeeperRepayment   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:24:02
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperRepayment")
	public @ResponseBody HashMap<String, Object> getShopkeeperRepayment(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperRepayment(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 查找图片信息
	 * @Title: getShopkeeperPic   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:24:10
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperPic")
	public @ResponseBody HashMap<String, Object> getShopkeeperPic(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperPic(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 *  查询账户信息
	 * @Title: getShopkeeperAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:24:23
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/getShopkeeperAccount")
	public @ResponseBody HashMap<String, Object> getShopkeeperAccount(String shopkeeperCustomerid) {

		HashMap<String, Object> shopkeeper = readService.getShopkeeperAccount(shopkeeperCustomerid);

		return shopkeeper;
	}
	/**
	 * 更改账户信息
	 * @Title: updateAccount   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @param account
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:24:27
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/updateAccount")
	public @ResponseBody HashMap<String, Object> updateAccount(String shopkeeperCustomerid,
			SpsShopkeeperAccount account) {

		HashMap<String, Object> updateAccount = writeService.updateAccount(shopkeeperCustomerid, account);

		return updateAccount;
	}
	/**
	 * 修改店主状态
	 * @Title: updateState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param shopkeeperCustomerid
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:24:34
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping("/updateState")
	public @ResponseBody HashMap<String, Object> updateState(String shopkeeperCustomerid,
			Integer state) {
		
		HashMap<String, Object> updateState = writeService.updateState(shopkeeperCustomerid, state);
		
		return updateState;
	}
	//----------------------------------店主邀请------------------------------
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
	public HashMap<String, Object> exportExcel(HttpServletResponse response)
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
	public HashMap<String, Object> importExcel(@RequestParam(value = "file", required = false) MultipartFile file)
			throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		List<ArrayList<String>> importExcel = new ExcelUtil().importExcel(file);
		
		SpsShopkeeperInvitation spsShopkeeperInvitation = null;
		
		String channelNum = getChannelNum();
		try {
			for (ArrayList<String> arrayList : importExcel) {
					spsShopkeeperInvitation = new SpsShopkeeperInvitation();
					spsShopkeeperInvitation.setInvitationName(arrayList.get(0));
					spsShopkeeperInvitation.setInvitationPhone(arrayList.get(1));
					writeService.insertInvitation(spsShopkeeperInvitation, channelNum);
			}
			map.put("msg", "添加成功");
			map.put("state", FinalData.STATE_SUCCESS);
		} catch (Exception e) {
			map.put("msg", "添加失败");
			map.put("state", FinalData.STATE_ERROR);
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * @throws Exception 
	 * 店主邀请
	 * @Title: insertInvitation   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param invitation
	 * @param: @return
	 * @param: @throws IOException  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:22:07
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/insertInvitation")
	@ResponseBody
	public HashMap<String, Object> insertInvitation(SpsShopkeeperInvitation invitation){
		
		String channelNum = getChannelNum();
		
		HashMap<String, Object> insertInvitation = writeService.insertInvitation(invitation,channelNum);
		
		return insertInvitation;
	}
	/**
	 * 查询店主邀请列表
	 * @Title: queryInvitationList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param name
	 * @param: @param phone
	 * @param: @param state
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月2日 上午11:22:17
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	@RequestMapping(value = "/queryInvitationList.json")
	@ResponseBody
	public HashMap<String, Object> queryInvitationList(Integer page, Integer limit, String name, String phone, String state) {
		
		HashMap<String, Object> queryInvitationList = readService.queryInvitationList(page, limit, name, phone, state);
		
		return queryInvitationList;
	}

	@RequestMapping(value = "/getQRcode")
	public void getCode(HttpServletResponse response, HttpServletRequest request, String channelNum, String clientNum) {
		try {
			System.out.println(channelNum);
			
			String serverName = request.getServerName();
			
			int serverPort = request.getServerPort();
			
			String contextPath = request.getContextPath();
			
			response.setContentType("image/png");
			
/*			String content = serverName+":"+serverPort+"/"
					+ contextPath+"/page/main/register.html";*/
			String content = "http://123.56.24.208:8480/register.html?channelNum="+channelNum+"&clientNum="+clientNum;
			
			int[] size = new int[] { 430, 430 };
			
			OutputStream os = response.getOutputStream();
			
			BufferedImage creatQrImage = new QRCodeFactory().CreatQrImage(content, os, size);
			
			ImageIO.write(creatQrImage, "png", os);
			
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得当前登录商户的num
	 * @Title: getChannelNum   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月6日 下午2:40:31
	 * @return: String      
	 * @throws
	 */
	private String getChannelNum(){
		Subject subject = SecurityUtils.getSubject();
		//获取当前token中的用户
		String userName = (String) subject.getPrincipal();
		
		String channelNum = (String) subject.getSession().getAttribute(userName);
		
		return channelNum;
	}
}
