package com.sps.service.merchant.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	@Override
	@Transactional(readOnly = true)
	public HashMap<String, Object> queryMerchantList(String data) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<String> arrayList = null;
		if(!StringUtil.isEmpty(data)){
			JSONObject parseObject = JSON.parseObject(data);
			
			String shopkeeperCustomerid = parseObject.getString("shopkeeperCustomerid");
			
			SpsShopkeeper queryShopkeeperList = shopkeeperService.queryShopkeeperList(shopkeeperCustomerid);
			//查询当前登录店主的主营业务
			String shopkeeperBusinessType = queryShopkeeperList.getShopkeeperBusinessType();
			
			String[] split = shopkeeperBusinessType.split(",");
			
			arrayList = new ArrayList<String>();
			for (String string : split) {
				
				arrayList.add(string);
			}
			try {
				//根据店主主营业务,获取相同主营业务的商户列表
				List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(arrayList, 1, null);
				if(queryBusinessForApi!=null&&queryBusinessForApi.size()>0){
					//查询商户下的商品
					for (SpsChannelEnterprise channel : queryBusinessForApi) {
						if(!"".equals(channel.getChannelNum())){
							Map<String, Object> map = new HashMap<>();
							map.put("shopNum", channel.getChannelNum());
							map.put("recommend", "1");
							map.put("orderType", "0");
							//查询推荐中的商品
							List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
							if(goodShopList!=null&&goodShopList.size()>0){
								channel.setGoodShops(goodShopList);
							}
						}
					}
				}
				super.logger.error(Message.SUCCESS_MSG);
				
				hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG, 
						Message.SUCCESS_MSG,queryBusinessForApi.size(), queryBusinessForApi);
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
	public HashMap<String, Object> queryMerchantDetail(String data) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		ArrayList<String> arrayList = new ArrayList<String>();
		if(!StringUtil.isEmpty(data)){
			JSONObject parseObject = JSON.parseObject(data);
			
			Integer enterpriseId = parseObject.getInteger("enterpriseId");
			try {
				List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(arrayList, 1, enterpriseId);
				//排序方式
				String orderType = parseObject.getString("orderType");
				String goodsName = parseObject.getString("goodsName");
				Integer categoryId = parseObject.getInteger("categoryId");
				if(queryBusinessForApi!=null&&queryBusinessForApi.size()>0){
					//查询商户下的商品
					for (SpsChannelEnterprise channel : queryBusinessForApi) {
						if(!"".equals(channel.getChannelNum())){
							Map<String, Object> map = new HashMap<>();
							map.put("shopNum", channel.getChannelNum());
							map.put("goodsName", goodsName);
							map.put("categorySelf", categoryId);
							map.put("orderType", orderType);
							//查询推荐中的商品
							List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
							if(goodShopList!=null&&goodShopList.size()>0){
								channel.setGoodShops(goodShopList);
							}
							Map<String, Object> categoryMap = new HashMap<>();
							categoryMap.put("customShopNum", channel.getChannelNum());
							List<SpsCustomCategory> categoryList = spsCustomCategoryMapper.findListAllWithMap(categoryMap);
							if(categoryList!=null&&categoryList.size()>0){
								channel.setCustomCategoryList(categoryList);
							}
						}
					}
				}
				super.logger.error(Message.SUCCESS_MSG);
				hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG,
						Message.SUCCESS_MSG,1, queryBusinessForApi.get(0));
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
}