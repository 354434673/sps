package com.sps.service.merchant.impl;

import java.util.*;

import javax.annotation.Resource;

import com.sps.common.EntityUtiles;
import com.sps.common.EntityUtils;
import com.sps.dao.shopkeeper.SpsChannelMapper;
import com.sps.entity.merchant.SpsChannel;
import com.sps.entity.merchant.SpsChannelExample;
import com.sps.entity.merchant.SpsChannelPic;
import com.sps.entity.merchant.SpsChannelPicExample;
import com.sps.entity.shopkeeper.SpsShopkeeperExample;
import com.sps.entity.shopkeeper.SpsShopkeeperPic;

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
import com.sps.dao.merchant.SpsChannelPicDao;
import com.sps.entity.goods.SpsCustomCategory;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.entity.shopkeeper.SpsShopkeeper;
import com.sps.service.base.BaseOperate;
import com.sps.service.goods.ApiGoodShopService;
import com.sps.service.goods.GoodCategoryService;
import com.sps.service.merchant.EnterpriseService;
import com.sps.service.shopkeeper.ShopkeeperPicService;
import com.sps.service.shopkeeper.ShopkeeperService;

@Service
public class EnterpriseServiceImpl extends BaseOperate implements EnterpriseService {
    @Resource
    private ChannelEnterpriseDao enterpriseDao;
    @Resource
    private SpsChannelMapper spsChannelMapper;
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
    @Resource
    private ShopkeeperPicService shopkeeperPicService;
    @Resource
    private SpsChannelPicDao spsChannelPicDao;

    @Override
    @Transactional(readOnly = true)
    public HashMap<String, Object> queryMerchantList(String shopkeeperCustomerid) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        HashMap<String, Object> data = new HashMap<String, Object>();//封装对象

        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();//存在封装对象的list

        SpsShopkeeper queryShopkeeperList = shopkeeperService.queryShopkeeperList(shopkeeperCustomerid);

        if (queryShopkeeperList != null) {
            String shopkeeperDefaultChannelNum = queryShopkeeperList.getShopkeeperDefaultChannelNum();

            List<SpsChannelEnterprise> queryBusinessForApi = null;

            try {
                if (!StringUtil.isEmpty(shopkeeperCustomerid)) {
                    queryBusinessForApi = enterpriseDao.queryBusinessForApi(shopkeeperDefaultChannelNum, null, null,null);
                } else {
/*						//查询当前登录店主的主营业务
                        String shopkeeperBusinessType = queryShopkeeperList.getShopkeeperBusinessType();

						String[] split = shopkeeperBusinessType.split(",");

						for (String string : split) {
							arrayList.add(string);
						}*/
                    queryBusinessForApi = enterpriseDao.queryBusinessForApi(null, null, null,null);
                }
                List<SpsChannelPic> queryChannelPic = queryChannelPic(shopkeeperDefaultChannelNum, 7);
                for (SpsChannelEnterprise spsChannelEnterprise : queryBusinessForApi) {
                    data = new HashMap<String, Object>();
                 /*   if (!"".equals(spsChannelEnterprise.getChannelNum())) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("shopNum", spsChannelEnterprise.getChannelNum());
                        map.put("recommend", "1");
                        map.put("orderType", "0");
                        map.put("flowStatus", "2");
                        //查询推荐中的商品
                        List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
                        List<SpsGoodShop> shopList = new ArrayList<>();
                        //过滤主营业务
                        if (!"".equals(queryShopkeeperList.getShopkeeperBusinessType())) {
                            if (goodShopList != null && goodShopList.size() > 0) {
                                for (SpsGoodShop goods : goodShopList) {
                                    String[] idList = queryShopkeeperList.getShopkeeperBusinessType().split(",");
                                    //判断数组是否包含id
                                    if (useLoop(idList, goods.getgCategoryIds().split(",")[0])) {
                                        shopList.add(goods);
                                    }
                                }
                            }
                        }
                        String[] pro = new String[]{"gId", "gPic", "gSpuName", "gMinPrice"};
                        if (goodShopList != null && goodShopList.size() > 0) {
                            spsChannelEnterprise.setGoodShops((List<SpsGoodShop>) EntityUtils.reloadListPropertyValue(shopList, pro));
                        }
                    }*/
                    data.put("id", spsChannelEnterprise.getEnterpriseId());
                    if( !"".equals(spsChannelEnterprise.getGuarantee().getGuaranteeCorpPhone())){
                        data.put("phone", spsChannelEnterprise.getGuarantee().getGuaranteeCorpPhone());
                    }else {
                        data.put("phone", "");
                    }

                    data.put("businessProduct", goodCategoryService.findListByIds(spsChannelEnterprise.getBusiness().getBusinessProduct()));
                    data.put("companyName", spsChannelEnterprise.getEnterpriseCompanyName());
                    String picUrl = queryChannelPic == null ? null :queryChannelPic.get(0).getPicSrc();
                    data.put("picSrc",picUrl);
                  /*  data.put("goodsList", spsChannelEnterprise.getGoodShops());*/
                    result.add(data);
                }
                super.logger.error(Message.SUCCESS_MSG);

                hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG,
                        Message.SUCCESS_MSG, queryBusinessForApi.size(), result);
            } catch (Exception e) {
                e.printStackTrace();
                super.logger.error(Message.SYSTEM_ERROR_MSG);

                hashMap = Message.resultMap(Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG,
                        Message.FAILURE_MSG, null, null);
            }
        } else {
            hashMap = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG,
                    Message.FAILURE_MSG, null, null);
        }
        return hashMap;
    }


    @Override
    @Transactional(readOnly = true)
    public HashMap<String, Object> queryMerchantDetail(Integer enterpriseId, Integer categoryId, String orderType, String goodsName, String shopkeeperCustomerId) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<String, Object> data = new HashMap<String, Object>();//封装对象

        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();//存在封装对象的list
        try {
            List<SpsChannelEnterprise> queryBusinessForApi = enterpriseDao.queryBusinessForApi(null, 1, enterpriseId,null);

            //排序方式
            if (queryBusinessForApi != null && queryBusinessForApi.size() > 0) {
                List<SpsChannelPic> queryChannelPic = queryChannelPic(queryBusinessForApi.get(0).getChannelNum(), 7);
                for (SpsChannelEnterprise spsChannelEnterprise : queryBusinessForApi) {
                    data = new HashMap<String, Object>();
                    if (!"".equals(spsChannelEnterprise.getChannelNum())) {
                        SpsShopkeeper queryShopkeeper = shopkeeperService.queryShopkeeperList(shopkeeperCustomerId);
                        //查询当前登录店主的主营业务
                        String shopkeeperBusinessType = queryShopkeeper.getShopkeeperBusinessType();
                        Map<String, Object> map = new HashMap<>();
                        map.put("shopNum", spsChannelEnterprise.getChannelNum());
                        map.put("goodsName", goodsName);
                        map.put("categorySelf", categoryId);
                        map.put("orderType", orderType);
                        map.put("flowStatus", "2");
                        //查询推荐中的商品
                        List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
                        List<SpsGoodShop> shopList = new ArrayList<>();
                        if("SP20180302711645".equals(shopkeeperCustomerId)){
                            String[] pro1 = new String[]{"gId", "gPic", "gSpuName", "gMinPrice"};
                            if (goodShopList != null && goodShopList.size() > 0) {
                                spsChannelEnterprise.setGoodShops((List<SpsGoodShop>) EntityUtils.reloadListPropertyValue(goodShopList, pro1));
                            }
                        }else {
                            //过滤主营业务
                            if (goodShopList != null && goodShopList.size() > 0) {
                                for (SpsGoodShop goods : goodShopList) {
                                    String[] idList = shopkeeperBusinessType.split(",");
                                    //判断数组是否包含id
                                    if (useLoop(idList, goods.getgCategoryIds().split(",")[0])) {
                                        shopList.add(goods);
                                    }
                                }
                            }
                            String[] pro1 = new String[]{"gId", "gPic", "gSpuName", "gMinPrice"};
                            if (goodShopList != null && goodShopList.size() > 0) {
                                spsChannelEnterprise.setGoodShops((List<SpsGoodShop>) EntityUtils.reloadListPropertyValue(shopList, pro1));
                            }
                        }
                    }
                    data.put("id", spsChannelEnterprise.getEnterpriseId());
                    data.put("phone", spsChannelEnterprise.getGuarantee().getGuaranteeCorpPhone());
                    data.put("businessProduct", goodCategoryService.findListByIds(spsChannelEnterprise.getBusiness().getBusinessProduct()));
                    data.put("companyName", spsChannelEnterprise.getEnterpriseCompanyName());
                    String picUrl = queryChannelPic == null ? null :queryChannelPic.get(0).getPicSrc();
                    data.put("picSrc",picUrl);
                    data.put("goodsList", spsChannelEnterprise.getGoodShops());
                    result.add(data);
                }
            }
            super.logger.error(Message.SUCCESS_MSG);
            hashMap = Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG,
                    Message.SUCCESS_MSG, 1, result.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            super.logger.error(Message.SYSTEM_ERROR_MSG);

            hashMap = Message.resultMap(Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG,
                    Message.FAILURE_MSG, null, null);
        }
        return hashMap;
    }

    @Override
    public int updateStatus(Map<String, Object> map) {
        Integer status = (Integer) map.get("status");
        String customerId = (String) map.get("customerId");
        SpsChannel channel = new SpsChannel();
        if (status == 1) {
            channel.setChannelState(1);
            channel.setChannelFlowState(2);
        } else if (status == 0) {
            channel.setChannelFlowState(3);
            channel.setChannelState(2);
        }
        channel.setChannelNum(customerId);
        channel.setChannelUpTime(new Date());
        SpsChannelExample example = new SpsChannelExample();
        example.createCriteria().andChannelNumEqualTo(channel.getChannelNum());
        return spsChannelMapper.updateByExampleSelective(channel, example);
    }

    @Override
    public HashMap<String, Object> homeSearch(String shopkeeperCustomerid, String keyWord) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        HashMap<String, Object> data = new HashMap<String, Object>();//封装对象
        ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();//存在封装对象的list
        SpsShopkeeper queryShopkeeperList = shopkeeperService.queryShopkeeperList(shopkeeperCustomerid);
        if (queryShopkeeperList != null) {
            String shopkeeperDefaultChannelNum = queryShopkeeperList.getShopkeeperDefaultChannelNum();
            List<SpsChannelEnterprise> queryBusinessForApi = null;
            try {
                if (!StringUtil.isEmpty(shopkeeperCustomerid)) {
                    queryBusinessForApi = enterpriseDao.queryBusinessForApi(shopkeeperDefaultChannelNum, null, null,keyWord);
                } else {
/*						//查询当前登录店主的主营业务
                    String shopkeeperBusinessType = queryShopkeeperList.getShopkeeperBusinessType();

                    String[] split = shopkeeperBusinessType.split(",");

                    for (String string : split) {
                        arrayList.add(string);
                    }*/
                    queryBusinessForApi = enterpriseDao.queryBusinessForApi(null, null, null,keyWord);
                }
                for (SpsChannelEnterprise spsChannelEnterprise : queryBusinessForApi) {
                    data = new HashMap<String, Object>();
                    if (!"".equals(spsChannelEnterprise.getChannelNum())) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("shopNum", spsChannelEnterprise.getChannelNum());
                        map.put("recommend", "1");
                        map.put("orderType", "0");
                        map.put("flowStatus", "2");
                        //查询推荐中的商品
                        List<SpsGoodShop> goodShopList = spsGoodShopMapper.findListAllWithMap(map);
                        List<SpsGoodShop> shopList = new ArrayList<>();
                        //过滤主营业务
                        if (!"".equals(queryShopkeeperList.getShopkeeperBusinessType())) {
                            if (goodShopList != null && goodShopList.size() > 0) {
                                for (SpsGoodShop goods : goodShopList) {
                                    String[] idList = queryShopkeeperList.getShopkeeperBusinessType().split(",");
                                    //判断数组是否包含id
                                    if (useLoop(idList, goods.getgCategoryIds().split(",")[0])) {
                                        shopList.add(goods);
                                    }
                                }
                            }
                        }
                        String[] pro = new String[]{"gId", "gPic", "gSpuName", "gMinPrice"};
                        if (goodShopList != null && goodShopList.size() > 0) {
                            spsChannelEnterprise.setGoodShops((List<SpsGoodShop>) EntityUtils.reloadListPropertyValue(shopList, pro));
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
                        Message.SUCCESS_MSG, queryBusinessForApi.size(), result);
            } catch (Exception e) {
                e.printStackTrace();
                super.logger.error(Message.SYSTEM_ERROR_MSG);

                hashMap = Message.resultMap(Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG,
                        Message.FAILURE_MSG, null, null);
            }
        } else {
            hashMap = Message.resultMap(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG,
                    Message.FAILURE_MSG, null, null);
        }
        return hashMap;
    }


    /**
     * 判断数组中是否包含某一元素
     *
     * @param arr
     * @param targetValue
     * @return
     */
    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }


	@Override
	public List<SpsChannelPic> queryChannelPic(String channelNum, Integer type) {
		SpsChannelPicExample example = new SpsChannelPicExample();
		
		example.createCriteria().andPicStateEqualTo(0)
								.andChannelNumEqualTo(channelNum)
								.andPicTypeEqualTo(type);
		List<SpsChannelPic> selectByExample = spsChannelPicDao.selectByExample(example );
		return selectByExample.size() == 0 ? null : selectByExample;
	}
}
