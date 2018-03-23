package com.sps.controller.option;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juzifenqi.capital.entity.BinCode;
import com.juzifenqi.capital.service.IBinCodeService;
import com.juzifenqi.core.ServiceResult;
import com.sps.service.area.AreasService;


/**
 * 查询各类选项的接口
 * @ClassName:  OptionController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月19日 下午2:40:25
 */
@RestController
@RequestMapping("/option")
public class OptionController {
	@Resource
	private IBinCodeService iBinCodeService;
	@Resource
	private AreasService areasService;
	/**
	 * @return 
	 * 根据银行卡查询所属银行
	 * @Title: queryBankForId   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param bankId  
	 * @author YangNingSheng    
	 * @date 2018年3月19日 下午2:41:35
	 * @return: void      
	 * @throws
	 */
	@RequestMapping("/queryBankForId")
	public ServiceResult<BinCode> queryBankForId(String bankId){
		
		ServiceResult<BinCode> binCodeById = iBinCodeService.getBinCodeById(bankId);
		
		return binCodeById;
	}
	/**
	 * 省市县三级
	 * @Title: getAreas   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param parentId
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年3月19日 下午2:53:03
	 * @return: List<Areas>      
	 * @throws
	 */
	@RequestMapping("/getAreasList")
	public HashMap<String, Object> getAreas(String parentId){
		
		HashMap<String, Object> areasList = areasService.getAreasList(parentId);
		
		return areasList;
	}
}
