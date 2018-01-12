package com.sps.controller.merchant;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.sps.entity.merchant.SpsChannel;
import org.sps.entity.merchant.SpsChannelBusiness;
import org.sps.entity.merchant.SpsChannelEnterprise;
import org.sps.entity.merchant.SpsChannelFinanceTarget;
import org.sps.entity.merchant.SpsChannelGather;
import org.sps.entity.merchant.SpsChannelGuarantee;
import org.sps.entity.merchant.SpsChannelLogistics;
import org.sps.entity.merchant.SpsChannelOpenAccount;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelPicUploadService;
import org.sps.service.merchant.write.ChannelWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.controller.common.UploadController;
import com.sps.service.user.UserService;
import com.sps.util.CommonUtil;
import com.sps.util.ControllerLsit;

/**
 * 核心商户控制层
 * @ClassName:  MerchantController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年1月12日 下午4:15:29
 */
@Controller
@RequestMapping(value="/merchant")
public class MerchantController {
	@Reference
	private ChannelWriteService chanelWriteService;
	@Reference
	private ChannelReadService channelReadService;
	@Reference
	private ChannelPicUploadService uploadService;
	@Resource
	private UserService userService;
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
	@ResponseBody
	public HashMap<String, String> getChannel(
			SpsChannel channel, 
			SpsChannelEnterprise enterprise, 
			SpsChannelBusiness business, 
			SpsChannelGuarantee guarantee,
			SpsChannelFinanceTarget financeTarget,
			SpsChannelLogistics logistics , 
			SpsChannelOpenAccount openAccount){
		
		HashMap<String, String> result = chanelWriteService.insertAll(channel, enterprise, 
				business, guarantee, financeTarget, 
				logistics, openAccount);
		//添加后增加到user表
		if(result.get("state").equals("success")){
			userService.insertUser(openAccount.getOpenAdminNum(),"123456",openAccount.getOpenAdminNum(), 
					openAccount.getOpenAdminPhone(),null,"1");
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
	@ResponseBody
	public HashMap<String, Object> getGatherList(Integer page, Integer limit, String channelNum){
		
		HashMap<String, Object> gatherList = channelReadService.getGatherList(page, limit, channelNum);
		
		return gatherList;
		
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
	@ResponseBody
	public HashMap<String, Object> getChannelList(String channelNum, Integer channelState,  
			Integer channelFlowState, Integer page, Integer limit){
		
		HashMap<String, Object> channelList = channelReadService.getChannelList(
				channelNum, channelState, channelFlowState, page, limit);
		
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
	@ResponseBody
	public HashMap<String, Object> insertGather(SpsChannelGather gather){
		
		HashMap<String, Object> insertGather = chanelWriteService.insertGather(gather);
		
		return insertGather;
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
	@ResponseBody
	public HashMap<String, Object> uploadPic(@RequestParam(value = "file", required = false) MultipartFile[] file, 
		String type,String accept, String status, Integer types, String channelNum,  HttpServletRequest request){
		
		HashMap<String, Object> uploadPic = null;
        String realPath = request.getSession().getServletContext().getRealPath("upload/"); //项目路径
        String filePath = status+"/"+type+"/"+channelNum+"/"+accept+"/";
        String path = "c:/sps/sps/sps-admin/src/main/webapp/upload/"+status+"/"+type+"/"+channelNum+"/"+accept+"/";
		
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
