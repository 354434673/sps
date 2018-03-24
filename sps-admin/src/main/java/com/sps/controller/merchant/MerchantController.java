package com.sps.controller.merchant;

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
		//HashMap<String, Object> CenterCompanyInfo = new HashMap<String,Object>();
		CenterCompanyInfo.put("merchantId", 30);
		CenterCompanyInfo.put("merchantType", 1);
		CenterCompanyInfo.put("companyName", enterprise.getEnterpriseCompanyName());
		CenterCompanyInfo.put("bussinessType", 1);//业务类型
		CenterCompanyInfo.put("businessLicenseNumber", enterprise.getEnterpriseBusinesslicenseNo());//营业执照编号
		CenterCompanyInfo.put("corporateRepresent", enterprise.getEnterpriseCorp());//公司法人代表
		CenterCompanyInfo.put("businessYears", enterprise.getEnterpriseOperatioTime());//经营年限
		CenterCompanyInfo.put("employeeNumber", enterprise.getEnterpriseEmployeeNum());//员工数量
		CenterCompanyInfo.put("registerMoney", new BigDecimal(18000000.00));//注册资金
/*		CenterCompanyInfo.put("registerProvinceCode", "28288192");//注册省份
		CenterCompanyInfo.put("registerProvince", "辽宁省");//注册省份名称
		CenterCompanyInfo.put("registerCityCode", "783728738");//注册城市
		CenterCompanyInfo.put("registerCity", "大连");//注册城市名称
		CenterCompanyInfo.put("registerDistrictCode", "783728738");//注册城市地区
		CenterCompanyInfo.put("registerDistrict", "不知道");//注册城市名称
*/		CenterCompanyInfo.put("registerDetailAddress", enterprise.getEnterpriseCompanyRealitAddr());//注册详细地址
/*		CenterCompanyInfo.put("actualProvinceCode", "783728738");//公司实际地址省份
		CenterCompanyInfo.put("actualProvince", "大连");//公司实际地址省份
		CenterCompanyInfo.put("actualCityCode", "783728738");
		CenterCompanyInfo.put("actualCity", "大连");
		CenterCompanyInfo.put("actualDistrictCode", "12");*/
		//CenterCompanyInfo.put("actualDistrict", "");
		CenterCompanyInfo.put("actualDetailAddress", enterprise.getEnterpriseCompanyRegisterAddr());//详细地址
		CenterCompanyInfo.put("mainBusiness", "手机");//主营业务
		CenterCompanyInfo.put("mainCommodityType", 1);//主营商品类型
		CenterCompanyInfo.put("mainBrand", "iphone");//主营品牌
		CenterCompanyInfo.put("businessArea", 1);//业务覆盖地域范围
		CenterCompanyInfo.put("guaranteeType", 1);//担保形式
		CenterCompanyInfo.put("marginAmount", new BigDecimal(18000000.45));//保证金金额
/*		CenterCompanyInfo.put("bankNo", "12345677");//收款银行卡账号
		CenterCompanyInfo.put("cardOwnerName", "杨XX");//银行卡所有人姓名
		CenterCompanyInfo.put("certNo", "630103199307091211");//身份证号
		CenterCompanyInfo.put("bindMobile", "18513967345");//银行卡绑定手机号
		CenterCompanyInfo.put("depositBank", "开户银行");//开户银行
		CenterCompanyInfo.put("bankSeparate", "开户行分行");//开户行分行
		CenterCompanyInfo.put("bankBranch", "支行");//开户银行支行
*/		CenterCompanyInfo.put("previousYearSales", financeTarget.getTargetLastSale());//上年销售额
		
		JSONObject CenterContactInfo = new JSONObject();
		
		CenterContactInfo.put("merchantId", guarantee.getGuaranteeId());//商户id
		CenterContactInfo.put("mobile", guarantee.getGuaranteeCorpPhone());//法人代表手机号
		CenterContactInfo.put("financeName", guarantee.getGuaranteeFinanceContactname());//财务联系人姓名
		CenterContactInfo.put("financeMobile", guarantee.getGuaranteeFinanceContactphone());//财务联系人手机号
		CenterContactInfo.put("businessName", guarantee.getGuaranteeBusinessLeadername());//业务负责人姓名
		CenterContactInfo.put("businessMobile", guarantee.getGuaranteeBusinessLeaderphone());//业务负责人手机号
		CenterContactInfo.put("businessMobilePassword", guarantee.getGuaranteeBusinessPhonePassword());//业务负责人手机号服务密码

		JSONObject CenterImageInfo = new JSONObject();
		
		CenterImageInfo.put("merchantId", 1234);
		CenterImageInfo.put("businessLicense", "123124124124");
		CenterImageInfo.put("accountFlow", "123123123");
		CenterImageInfo.put("certCard", "31312312");
		CenterImageInfo.put("companyPicture", "q123123123we");
		CenterImageInfo.put("cooperationContract", "123123");
		CenterImageInfo.put("groupPhoto", "qw1312312312e");
		CenterImageInfo.put("rentalAgreement", "qwe");
		CenterImageInfo.put("others", "qwe");
		
		JSONObject CenterMerchantInfo = new JSONObject();
		
		CenterMerchantInfo.put("merchantCode", "test030");//商户编号
		CenterMerchantInfo.put("merchantName", "商户名称");//商户名称
		CenterMerchantInfo.put("approveCode", "108876-01");//审批编号
		CenterMerchantInfo.put("approveType", 1);//审批类型
		CenterMerchantInfo.put("approveUser", "杨XX");//审批人
		CenterMerchantInfo.put("approveTime", new Date());//审批时间
		CenterMerchantInfo.put("status", 1);//商户状态
		CenterMerchantInfo.put("bussinessName", "XX");//店付业务员姓名
		CenterMerchantInfo.put("certNo", "210283199003027519");//店付业务员身份证
		CenterMerchantInfo.put("city", "北京");//所在城市
		CenterMerchantInfo.put("cityCode", "100862");//所在城市code
		CenterMerchantInfo.put("signBeginDate",  new Date());//签约开始日期
		CenterMerchantInfo.put("signEndDate",  new Date());//签约结束日期
		CenterMerchantInfo.put("createTime",  new Date());//创建时间
		CenterMerchantInfo.put("updateTime",  new Date());//更新时间
		CenterMerchantInfo.put("flag", 1);
		CenterMerchantInfo.put("delFlag", 0);
		
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
