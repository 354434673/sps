package com.sps.service.merchant.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.sps.common.EntityUtiles;
import com.sps.common.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.ChannelEnterpriseDao;
import com.sps.dao.goods.SpsCustomCategoryMapper;
import com.sps.dao.goods.SpsGoodShopMapper;
import com.sps.dao.goods.SpsGoodShopSkuMapper;
import com.sps.dao.goods.SpsGoodsAlbumMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.goods.SpsCustomCategory;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.service.base.BaseOperate;
import com.sps.service.goods.ApiGoodShopService;
import com.sps.service.goods.GoodCategoryService;
import com.sps.service.merchant.EnterpriseService;
import com.sps.service.shopkeeper.ShopkeeperService;
@Service
public class EnterpriseServiceImpl extends BaseOperate implements EnterpriseService {
	@Resource
	private ChannelEnterpriseDao enterpriseDao;
	@Resource
	private ShopkeeperService shopkeeperService;
	@Resource
	private ApiGoodShopService goodShopService;
	@Resource
	private SpsGoodShopMapper spsGoodShopMapper;
	@Resource
	private SpsGoodsMapper spsGoodsMapper;
	@Resource
	private SpsGoodsAlbumMapper spsGoodsAlbumMapper;
	@Resource
	private SpsGoodShopSkuMapper spsGoodShopSkuMapper;
	@Resource
	private SpsCustomCategoryMapper spsCustomCategoryMapper;
	@Resource
	private GoodCategoryService goodCategoryService;
	@Override
	@Transactional(readOnly = true)
	public HashMap<String, Object> queryMerchantList(String shopkeeperCustomerid) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		HashMap<String, Object> data = new HashMap<String, Object>();//封装对象
		
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();//存在封装对象的list
		
		SpsShopkeeper queryShopkeeperList = shopkeeperService.queryShopkeeperList(shopkeeperCustomerid);
			
			if(queryShopkeeperList != null){
				String shopkeeperDefaultChannelNum = queryShopkeeperList.getShopkeeperDefaultChannelNum();
				
				List<SpsChannelEnterprise> queryBusinessForApi = null;

				try {
					if(!StringUtil.isEmpty(shopkeeperCustomerid)){
						queryBusinessForApi = enterpriseDao.queryBusinessForApi(shopkeeperDefaultChannelNum, null , null);
					}else{
/*						//查询当前登录店主的主营业务
						String shopkeeperBusinessType = queryShopkeeperList.getShopkeeperBusinessType();
						
						String[] split = shopkeeperBusinessType.split(",");
						
						for (String string : split) {
							arrayList.add(string);
						}*/
						queryBusinessForApi = enterpriseDao.queryBusinessForApi(null, null, null);
					}
					for (SpsChannelEnterprise spsChannelEnterprise : queryBusinessForApi) {
						data = new HashMap<String, Object>();
						if(!"".equals(spsChannelEnterprise.getChannelNum())){
							Map<String, Object> map = new HashMap<>();
							map.put("shopNum", spsChannelEnterprise.getChannelNum());
							map.put("recommend", "1");
							map.put("orderType", "0");
							map.put("flowStatus", "2");
							//查询推荐中的商品
							List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
							String[] pro = new String[]{"gId","gPic","gSpuName","gMinPrice"};
							if(goodShopList!=null&&goodShopList.size()>0){
								spsChannelEnterprise.setGoodShops((List<SpsGoodShop>) EntityUtils.reloadListPropertyValue(goodShopList, pro));
							}
						}
						data.put("id", spsChannelEnterprise.getEnterpriseId());
						data.put("phone", spsChannelEnterprise.getGuarantee().getGuaranteeCorpPhone());
						data.put("businessProduct", goodCategoryService.findListByIds(spsChannelEnterprise.getBusiness().getBusinessProduct()));
						data.put("companyName", spsChannelEnterprise.getEnterpriseCompanyName());
						data.put("picSrc", spsChannelEnterprise.getPic().getPicSrc());
						data.put("goodsList", spsChannelEnterprise.getGoodShops());
						result.add(data);
					}
					super.logger.error(Message.SUCCESS_MSG);
					
					hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG, 
							Message.SUCCESS_MSG,queryBusinessForApi.size(), result);
				} catch (Exception e) {
					e.printStackTrace();
					super.logger.error(Message.SYSTEM_ERROR_MSG);
					
					hashMap = Message.resultMap( Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG, 
							Message.FAILURE_MSG,null, null);
				}
			}else{
				hashMap = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG, 
						Message.FAILURE_MSG,null, null);
			}
		return hashMap;
	}

	@Override
	@Transactional(readOnly = true)
	public HashMap<String, Object> queryMerchantDetail(Integer enterpriseId ,Integer categoryId, String orderType, String goodsName) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		ArrayList<String> arrayList = new ArrayList<String>();
		HashMap<String, Object> data = new HashMap<String, Object>();//封装对象

		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();//存在封装对象的list
			
			try {
				List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(null, 1, enterpriseId);
				//排序方式
				if(queryBusinessForApi!=null&&queryBusinessForApi.size()>0){
					for (SpsChannelEnterprise spsChannelEnterprise : queryBusinessForApi) {
						data = new HashMap<String, Object>();
						if(!"".equals(spsChannelEnterprise.getChannelNum())){
							Map<String, Object> map = new HashMap<>();
							map.put("shopNum", spsChannelEnterprise.getChannelNum());
							map.put("goodsName", goodsName);
							map.put("categorySelf", categoryId);
							map.put("orderType", orderType);
							map.put("flowStatus", "2");
							//查询推荐中的商品
							List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
							String[] pro1 = new String[]{"gId","gPic","gSpuName","gMinPrice"};
							if(goodShopList!=null&&goodShopList.size()>0){
								spsChannelEnterprise.setGoodShops((List<SpsGoodShop>) EntityUtils.reloadListPropertyValue(goodShopList, pro1));
							}
							/*Map<String, Object> categoryMap = new HashMap<>();
							categoryMap.put("customShopNum", spsChannelEnterprise.getChannelNum());
							List<SpsCustomCategory> categoryList = spsCustomCategoryMapper.findListAllWithMap(categoryMap);
							String[] pro = new String[]{"customName","customWide"};
							data.put("categoryList",EntityUtiles.reloadListPropertyValue(categoryList, pro));*/
						}
						data.put("id", spsChannelEnterprise.getEnterpriseId());
						data.put("phone", spsChannelEnterprise.getGuarantee().getGuaranteeCorpPhone());
						data.put("businessProduct", goodCategoryService.findListByIds(spsChannelEnterprise.getBusiness().getBusinessProduct()));
						data.put("companyName", spsChannelEnterprise.getEnterpriseCompanyName());
						data.put("picSrc", spsChannelEnterprise.getPic().getPicSrc());
						data.put("goodsList", spsChannelEnterprise.getGoodShops());
						result.add(data);
					}
				}
				super.logger.error(Message.SUCCESS_MSG);
				hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG,
						Message.SUCCESS_MSG,1, result.get(0));
			} catch (Exception e) {
				e.printStackTrace();
				super.logger.error(Message.SYSTEM_ERROR_MSG);

				hashMap = Message.resultMap( Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG,
						Message.FAILURE_MSG,null, null);
			}
		return hashMap;
	}
}
