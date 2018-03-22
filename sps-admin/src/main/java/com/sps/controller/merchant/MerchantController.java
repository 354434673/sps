package com.sps.controller.merchant;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.entity.merchant.SpsChannelPic;
import org.sps.service.merchant.read.ChannelPicReadService;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelPicUploadService;
import org.sps.service.merchant.write.ChannelWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.dao.user.SpsRoleMapper;
import com.sps.entity.user.SpsRole;
import com.sps.entity.user.SpsRoleExample;
import com.sps.entity.user.SpsUser;
import com.sps.httpclient.merchant.MerchantService;
import com.sps.service.express.ExpressService;
import com.sps.service.user.UserAndRoleService;
import com.sps.service.user.UserService;
import com.sps.util.CommonUtil;
import com.sps.util.HttpClientUtil;

/**
 * 核心商户控制层
 * @ClassName:  MerchantController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author YangNingSheng
 * @date 2018年1月12日 下午4:15:29
 */
@RestController
@RequestMapping(value="/merchant")
public class MerchantController {
	@Reference(check=false,group="dianfu")
	private ChannelWriteService chanelWriteService;
	@Reference(check=false,group="dianfu")
	private ChannelReadService channelReadService;
	@Reference(check=false,group="dianfu")
	private ChannelPicUploadService uploadService;
	@Reference(check=false,group="dianfu")
	private ChannelPicReadService picReadService;
	@Resource
	private UserService userService;
	@Resource
	private ExpressService expressService;
	@Resource
	private MerchantService merchantService;
	@Resource 
	private UserAndRoleService userAndRoleService;
	@Resource
	private SpsRoleMapper roleMapper;
	/**
	 * 插入核心商户,将channelNum返回回来
	 * @Title: getChannel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param channel
	 * @param: @param enterprise
	 * @param: @param business
	 * @param: @param guarantee
	 * @param: @param financeTarget
	 * @param: @param logistics
	 * @param: @param openAccount
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年1月12日 下午4:15:40
	 * @return: HashMap<String,String>
	 * @throws
	 */
	@RequestMapping(value="/insertChannel")
	public HashMap<String, String> getChannel(
			SpsChannel channel, 
			SpsChannelEnterprise enterprise, 
			SpsChannelBusiness business, 
			SpsChannelGuarantee guarantee,
			SpsChannelFinanceTarget financeTarget,
			SpsChannelLogistics logistics , 
			SpsChannelOpenAccount openAccount){
		String otherName = logistics.getLogisticsOther();
		if(!(otherName.equals("")||otherName == null)){//物流配送中其他字段如果填了选项,则插入数据
			expressService.insertExpress(otherName);
		}
		HashMap<String, String> result = chanelWriteService.insertAll(channel, enterprise, 
				business, guarantee, financeTarget, 
				logistics, openAccount);
		//添加后增加到user表
		if(result.get("state").equals("success")){
			SpsUser spsUser = new SpsUser();
			spsUser.setUserUsername(openAccount.getOpenAdminNum());
			spsUser.setUserName(openAccount.getOpenAdminNum());
			spsUser.setUserPhone(openAccount.getOpenAdminPhone());
			spsUser.setUserMark(1);//1为商户
			userService.insertUser(spsUser);
			
			SpsRoleExample example = new SpsRoleExample();
			
			example.createCriteria().andRoleMarkEqualTo(1);
			List<SpsRole> selectByExample = roleMapper.selectByExample(example );
			int[] roleList = {selectByExample.get(0).getRoleId()};//获取标示为1的商户角色
			//添加用户角色
			userAndRoleService.insertUserAndRole(openAccount.getOpenAdminNum(), roleList);
		}
		return result;
	}
	/**
	 * 获得所有收款信息
	 * @Title: getGatherList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param page
	 * @param: @param limit
	 * @param: @param channelNum
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年1月12日 下午4:16:10
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping(value="/getGatherList.json")
	public HashMap<String, Object> getGatherList(Integer page, Integer limit, String channelNum){
		
		HashMap<String, Object> gatherList = channelReadService.getGatherList(page, limit, channelNum);
		
		return gatherList;
		
	}
	/**
	 * 核心账户初始化
	 * @Title: init   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param businessId
	 * @param: @param totalQuota
	 * @param: @param monthQuota
	 * @param: @param firstMonthQuota
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月21日 下午3:38:26
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value = "/init",method = RequestMethod.POST)
	public String init(String businessId, Double totalQuota, 
			Double monthQuota, Double firstMonthQuota){
		
		String result = merchantService.init(businessId, totalQuota, monthQuota, firstMonthQuota);
		
		return result;
	}
	/**
	 * 获得所有商户列表
	 * @Title: getChannelList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param channelNum
	 * @param: @param channelState
	 * @param: @param channelFlowState
	 * @param: @param page
	 * @param: @param limit
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年1月12日 下午4:16:22
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping(value="/getChannelList")
	public HashMap<String, Object> getChannelList(String channelNum, String name, Integer channelState,  
			Integer channelFlowState, Integer page, Integer limit){
		
		HashMap<String, Object> channelList = channelReadService.getChannelList(
				channelNum, name, channelState, channelFlowState, page, limit);
		
		return channelList;
		
	}
	/**
	 * 添加收款信息
	 * @Title: insertGather
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param gather
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年1月12日 下午4:16:38
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping(value="/insertGather")
	public HashMap<String, Object> insertGather(SpsChannelGather gather){
		
		HashMap<String, Object> insertGather = chanelWriteService.insertGather(gather);
		
		return insertGather;
	}
	@RequestMapping(value="/queryGather")
	public String getGather(String gatherBankId){
		
		SpsChannelGather g = channelReadService.queryGather(gatherBankId);
		
		if(g != null){
			return "exist";
		}else{
			return "success";
		}
	}
	/**
	 * 获得商户基本信息
	 * @Title: getChannel   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:11:35
	 * @return: SpsChannelEnterprise      
	 * @throws
	 */
	@RequestMapping(value="/getChannel")
	public SpsChannelEnterprise getChannel(String channelNum){
		
		SpsChannelEnterprise channelOne = channelReadService.getChannelOne(channelNum, null);
		
		return channelOne;
	}
	/**
	 * 获得该商户财务指标
	 * @Title: getFinanceTarget   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:12:29
	 * @return: SpsChannelFinanceTarget      
	 * @throws
	 */
	@RequestMapping(value="/getFinanceTarget")
	public SpsChannelFinanceTarget getFinanceTarget(String channelNum){
		
		SpsChannelFinanceTarget financeTarget = channelReadService.getFinanceTarget(channelNum);
		
		return financeTarget;
	}
	/**
	 * 获得该商户担保信息
	 * @Title: getGuarantee   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:13:04
	 * @return: SpsChannelGuarantee      
	 * @throws
	 */
	@RequestMapping(value="/getGuarantee")
	public SpsChannelGuarantee getGuarantee(String channelNum){
		
		SpsChannelGuarantee guarantee = channelReadService.getGuarantee(channelNum);
		
		return guarantee;
	}
	/**
	 * 获得该商户物流配送信息
	 * @Title: getLogistics   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月15日 下午6:13:38
	 * @return: SpsChannelFinanceTarget      
	 * @throws
	 */
	@RequestMapping(value="/getLogistics")
	public SpsChannelLogistics getLogistics(String channelNum){
		
		SpsChannelLogistics logistics = channelReadService.getLogistics(channelNum);
		
		return logistics;
	}
	@RequestMapping(value="/getOpenAccount")
	public SpsChannelOpenAccount getOpenAccount(String channelNum){
		
		SpsChannelOpenAccount openAccount = channelReadService.getOpenAccount(channelNum, null);
		
		return openAccount;
	}
	@RequestMapping(value="/getBusiness")
	public SpsChannelBusiness getBusiness(String channelNum){
		
		SpsChannelBusiness business = channelReadService.getBusiness(channelNum);
		
		return business;
	}
	@RequestMapping(value="/deleteChannel")
	public HashMap<String, String> deleteChannel(String channelNum, Integer state){
		
		HashMap<String, String> deleteChannel = chanelWriteService.deleteChannel(channelNum, state);
		
		return deleteChannel;
	}
	@RequestMapping("/getPicList")
	public List<SpsChannelPic> getPicList(String channelNum, Integer type){
		
		return picReadService.getPicList(channelNum, type);
	}
	/**
	 * 提交给风控审核
	 * @Title: toRisk   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channel
	 * @param: @param enterprise
	 * @param: @param business
	 * @param: @param guarantee
	 * @param: @param financeTarget
	 * @param: @param logistics
	 * @param: @param openAccount
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月21日 下午3:33:45
	 * @return: List<SpsChannelPic>      
	 * @throws
	 */
	@RequestMapping("/toRisk")
	public List<SpsChannelPic> toRisk(SpsChannel channel, 
			SpsChannelEnterprise enterprise, 
			SpsChannelBusiness business, 
			SpsChannelGuarantee guarantee,
			SpsChannelFinanceTarget financeTarget,
			SpsChannelLogistics logistics , 
			SpsChannelOpenAccount openAccount){
		
		final String  url = "";
		JSONObject CenterCompanyInfo = new JSONObject();
		
		CenterCompanyInfo.put("merchantId", "merchantType");
		CenterCompanyInfo.put("merchantType", "merchantType");
		CenterCompanyInfo.put("companyName", "merchantType");
		CenterCompanyInfo.put("bussinessType", "merchantType");
		CenterCompanyInfo.put("businessLicenseNumber", "merchantType");
		CenterCompanyInfo.put("corporateRepresent", "merchantType");
		CenterCompanyInfo.put("businessYears", "merchantType");
		CenterCompanyInfo.put("employeeNumber", "merchantType");
		CenterCompanyInfo.put("registerMoney", "merchantType");
		CenterCompanyInfo.put("registerProvinceCode", "merchantType");
		CenterCompanyInfo.put("registerProvince", "merchantType");
		CenterCompanyInfo.put("registerCityCode", "merchantType");
		CenterCompanyInfo.put("registerCity", "merchantType");
		CenterCompanyInfo.put("registerDistrictCode", "merchantType");
		CenterCompanyInfo.put("registerDistrict", "merchantType");
		CenterCompanyInfo.put("registerDetailAddress", "merchantType");
		CenterCompanyInfo.put("actualProvinceCode", "merchantType");
		CenterCompanyInfo.put("actualProvince", "merchantType");
		CenterCompanyInfo.put("actualCityCode", "merchantType");
		CenterCompanyInfo.put("actualCity", "merchantType");
		CenterCompanyInfo.put("actualDistrictCode", "merchantType");
		CenterCompanyInfo.put("actualDistrict", "merchantType");
		CenterCompanyInfo.put("actualDetailAddress", "merchantType");
		CenterCompanyInfo.put("mainBusiness", "merchantType");
		CenterCompanyInfo.put("mainCommodityType", "merchantType");
		CenterCompanyInfo.put("mainBrand", "merchantType");
		CenterCompanyInfo.put("businessArea", "merchantType");
		CenterCompanyInfo.put("guaranteeType", "merchantType");
		CenterCompanyInfo.put("marginAmount", "merchantType");
		CenterCompanyInfo.put("bankNo", "merchantType");
		CenterCompanyInfo.put("cardOwnerName", "merchantType");
		CenterCompanyInfo.put("certNo", "merchantType");
		CenterCompanyInfo.put("bindMobile", "merchantType");
		CenterCompanyInfo.put("depositBank", "merchantType");
		CenterCompanyInfo.put("bankSeparate", "merchantType");
		CenterCompanyInfo.put("bankBranch", "merchantType");
		CenterCompanyInfo.put("previousYearSales", "merchantType");
		
		JSONObject CenterContactInfo = new JSONObject();
		
		JSONObject CenterImageInfo = new JSONObject();
		
		JSONObject CenterMerchantInfo = new JSONObject();
		
		JSONObject data = new JSONObject();
		
		data.put("CenterCompanyInfo", CenterCompanyInfo);
		data.put("CenterContactInfo", CenterContactInfo);
		data.put("CenterImageInfo", CenterImageInfo);
		data.put("CenterMerchantInfo", CenterMerchantInfo);
		
		String jsonString = JSON.toJSONString(data);
		
		HttpClientUtil.doPostJson(url, jsonString);
		
		return null;
	}
	/**
	 * 上传图片
	 * @Title: uploadPic
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param: @param file
	 * @param: @param type 图片类型
	 * @param: @param accept 文件类型
	 * @param: @param status 身份(商户和店主)
	 * @param: @param types 数据库类型字段
	 * @param: @param channelNum 外键
	 * @param: @param request
	 * @param: @return
	 * @author YangNingSheng
	 * @date 2018年1月12日 下午4:16:47
	 * @return: HashMap<String,Object>
	 * @throws
	 */
	@RequestMapping(value="/uploadPic")
	public HashMap<String, Object> uploadPic(@RequestParam(value = "file", required = false) MultipartFile[] file,
		String type,String accept, String status, Integer types, String channelNum,  HttpServletRequest request){
		
		HashMap<String, Object> uploadPic = null;
        //String realPath = request.getSession().getServletContext().getRealPath("upload/"); //项目路径
		String realPath = System.getProperty("user.dir")+"/src/main/webapp/upload/";
        String filePath = status+"/"+type+"/"+channelNum+"/"+accept+"/";
        String path = "C:/development/sps/sps/sps-admin/src/main/webapp/upload/"+status+"/"+type+"/"+channelNum+"/"+accept+"/";
		
		for (MultipartFile multipartFile : file) {
			String newName = CommonUtil.getFileName(multipartFile);

			uploadPic = uploadService.uploadPic(filePath, types, multipartFile.getOriginalFilename(),
									newName, 0, channelNum);
			if(uploadPic.get("state").equals("success")){//插入成功后才上传
				CommonUtil.uploadPicture(multipartFile, realPath+filePath, newName);
			}
		}
		return uploadPic;
	}
}
