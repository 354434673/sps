package com.sps.controller.merchant;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.sps.common.OssUtil;
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
	private static final String URL = "http://test1-spay.juzifenqi.com/sps/centerEnter";	
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
	 * 修改商户流程状态
	 * @Title: updateChannelState   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @param channelFlowState
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年4月8日 下午2:34:20
	 * @return: HashMap<String,String>      
	 * @throws
	 */
	@RequestMapping("/updateChannelState")
	public HashMap<String, Object> updateChannelState(String channelNum, Integer channelFlowState){
		
		return chanelWriteService.updateChannelState(channelNum, channelFlowState);
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
			SpsChannelOpenAccount openAccount,
			String channelNum){

		JSONObject centerCompanyInfo = new JSONObject();
		centerCompanyInfo.put("merchantType", 1);
		centerCompanyInfo.put("companyName", enterprise.getEnterpriseCompanyName());
		centerCompanyInfo.put("bussinessType", 1);//业务类型
		centerCompanyInfo.put("businessLicenseNumber", enterprise.getEnterpriseBusinesslicenseNo());//营业执照编号
		centerCompanyInfo.put("corporateRepresent", enterprise.getEnterpriseCorp());//公司法人代表
		centerCompanyInfo.put("businessYears", enterprise.getEnterpriseOperatioTime());//经营年限
		centerCompanyInfo.put("employeeNumber", enterprise.getEnterpriseEmployeeNum());//员工数量
		centerCompanyInfo.put("registerMoney", new BigDecimal(18000000.00));//注册资金
		centerCompanyInfo.put("registerDetailAddress", enterprise.getEnterpriseCompanyRealitAddr());//注册详细地址
		centerCompanyInfo.put("actualDetailAddress", enterprise.getEnterpriseCompanyRegisterAddr());//详细地址
		centerCompanyInfo.put("mainBusiness", business.getBusinessProduct());//主营业务
		centerCompanyInfo.put("mainCommodityType", business.getBusinessType());//主营商品类型
		centerCompanyInfo.put("mainBrand", business.getBusinessBrand());//主营品牌
		centerCompanyInfo.put("businessArea", business.getBusinessScope());//业务覆盖地域范围
		centerCompanyInfo.put("guaranteeType", guarantee.getGuaranteeSituation());//担保形式
		centerCompanyInfo.put("marginAmount", guarantee.getGuaranteeDeposit());//保证金金额
		centerCompanyInfo.put("previousYearSales", financeTarget.getTargetLastSale());//上年销售额
		
		JSONObject centerContactInfo = new JSONObject();
		
		centerContactInfo.put("merchantId", guarantee.getGuaranteeId());//商户id
		centerContactInfo.put("mobile", guarantee.getGuaranteeCorpPhone());//法人代表手机号
		centerContactInfo.put("financeName", guarantee.getGuaranteeFinanceContactname());//财务联系人姓名
		centerContactInfo.put("financeMobile", guarantee.getGuaranteeFinanceContactphone());//财务联系人手机号
		centerContactInfo.put("businessName", guarantee.getGuaranteeBusinessLeadername());//业务负责人姓名
		centerContactInfo.put("businessMobile", guarantee.getGuaranteeBusinessLeaderphone());//业务负责人手机号
		centerContactInfo.put("businessMobilePassword", guarantee.getGuaranteeBusinessPhonePassword());//业务负责人手机号服务密码

		JSONObject centerImageInfo = new JSONObject();
		
/*		centerImageInfo.put("merchantId", 1234);
		centerImageInfo.put("businessLicense", "123124124124");
		centerImageInfo.put("accountFlow", "123123123");
		centerImageInfo.put("certCard", "31312312");
		centerImageInfo.put("companyPicture", "q123123123we");
		centerImageInfo.put("cooperationContract", "123123");
		centerImageInfo.put("groupPhoto", "qw1312312312e");
		centerImageInfo.put("rentalAgreement", "qwe");
		centerImageInfo.put("others", "qwe");*/
		
		JSONObject centerMerchantInfo = new JSONObject();
		
		centerMerchantInfo.put("merchantCode", channelNum);//商户编号
		centerMerchantInfo.put("status", 0);//商户状态
		centerMerchantInfo.put("signBeginDate",  openAccount.getOpenStartTime());//签约开始日期
		centerMerchantInfo.put("signEndDate",  openAccount.getOpenEndTime());//签约结束日期
		centerMerchantInfo.put("createTime",  new Date());//创建时间
		centerMerchantInfo.put("updateTime",  new Date());//更新时间
		centerMerchantInfo.put("flag", 1);
		centerMerchantInfo.put("delFlag", 0);
		
		JSONObject data = new JSONObject();
		
		data.put("centerMerchantInfo", centerMerchantInfo);
		data.put("centerCompanyInfo", centerCompanyInfo);
		data.put("centerContactInfo", centerContactInfo);
		//data.put("centerImageInfo", centerImageInfo);
		
		String jsonString = JSON.toJSONString(data);
		
		
		HttpClientUtil.doPostJson(URL, jsonString);
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
	public HashMap<String, Object> uploadPic(@RequestParam(value = "file", required = false) MultipartFile file,
		String type,String accept, String status, Integer types, String channelNum,  HttpServletRequest request){
		
		HashMap<String, Object> uploadPic = null;
		
		try {
			OssUtil ossUtil = new OssUtil();
			
			String uploadImg2Oss = ossUtil.uploadImg2Oss(file);
			
			String imgUrl = ossUtil.getImgUrl(uploadImg2Oss); 
			
			String[] split = imgUrl.split("\\?");  
			
			uploadPic = uploadService.uploadPic(split[0], types, file.getOriginalFilename(),
					uploadImg2Oss, 0, channelNum);
/*			for (MultipartFile multipartFile : file) {
			}*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uploadPic;
	}
}
