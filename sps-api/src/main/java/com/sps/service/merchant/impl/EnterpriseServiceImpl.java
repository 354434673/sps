package com.sps.service.merchant.impl;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;

import com.sps.dao.goods.SpsGoodShopMapper;
import com.sps.dao.goods.SpsGoodShopSkuMapper;
import com.sps.dao.goods.SpsGoodsAlbumMapper;
import com.sps.dao.goods.SpsGoodsMapper;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.goods.SpsGoodShopSku;
import com.sps.entity.goods.SpsGoodsAlbum;
import com.sps.service.goods.ApiGoodShopService;
import com.sps.service.goods.GoodShopSkuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.ChannelEnterpriseDao;
import com.sps.dao.SpsShopkeeperDao;
import com.sps.entity.merchant.SpsChannelBusiness;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.service.base.BaseOperate;
import com.sps.service.merchant.EnterpriseService;
import com.sps.service.shopkeeper.ShopkeeperService;
import com.sun.mail.util.SharedByteArrayOutputStream;
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
	@Override
	@Transactional(readOnly = true)
	public HashMap<String, Object> queryMerchantList(String data) {
		
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		ArrayList<String> arrayList = null;
		if(!StringUtil.isEmpty(data)){
			JSONObject parseObject = JSON.parseObject(data);
			
			String shopkeeperCustomerid = parseObject.getString("shopkeeperCustomerid");
			
			SpsShopkeeper queryShopkeeperList = shopkeeperService.queryShopkeeperList(shopkeeperCustomerid);
			
			String shopkeeperBusinessType = queryShopkeeperList.getShopkeeperBusinessType();
			
			String[] split = shopkeeperBusinessType.split(",");
			
			arrayList = new ArrayList<String>();
			for (String string : split) {
				
				arrayList.add(string);
			}
			try {
				List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(arrayList, 1);
			/*	List<SpsChannelBusiness> queryBusinessForApi = enterpriseDao.queryBusinessForApi(arrayList, 1);*/
				if(queryBusinessForApi!=null&&queryBusinessForApi.size()>0){
					List<SpsGoodShop> goodShop = new  ArrayList();
					//查询商户下的商品
					for (SpsChannelEnterprise channel : queryBusinessForApi) {
						if(!"".equals(channel.getChannelNum())){
							Map<String, Object> map = new HashMap<>();
							map.put("shopNum", channel.getChannelNum());
							map.put("recommend", "1");
							//查询推荐中的商品
							List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
							if(goodShopList!=null&&goodShopList.size()>0){

								for(SpsGoodShop list: goodShopList){
									//查询图片
									Map<String, Object> albumMap = new HashMap<>();
									map.put("goodsId", list.getgId());
									List<SpsGoodsAlbum> albumList = spsGoodsAlbumMapper.findListAllWithMap(albumMap);
									if(albumList!=null&&albumList.size()>0){
										//主图
										List<SpsGoodsAlbum> mainPic = new ArrayList<>();
										for (SpsGoodsAlbum pic : albumList) {
											if (pic.getAlbumType()==0) {
												mainPic.add(pic);
											}
										}
										list.setAlbumList(mainPic);
									}

									Map<String, Object> skuMap = new HashMap<>();
									map.put("goodsId", list.getgId());
									List<SpsGoodShopSku> skuList = spsGoodShopSkuMapper.findListAllWithMap(skuMap);
									//获取SKU中最小的价格
									if (skuList != null && skuList.size() > 0) {
										if (skuList.size() != 1) {
											List<BigDecimal> price = new ArrayList<>();
											for (SpsGoodShopSku sku : skuList) {
												price.add(sku.getgPrice());
											}
											list.setMinPrice(Collections.min(price));
										} else {
											list.setMinPrice(skuList.get(0).getgPrice());
										}
									}
									goodShop.add(list);
								}
							}
						}
						channel.setGoodShops(goodShop);
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
}
