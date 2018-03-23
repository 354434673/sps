package com.sps.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.Page;
import com.sps.common.StringUtil;
import com.sps.dao.ChannelBusinessDao;
import com.sps.dao.GoodShopDao;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.merchant.SpsChannelBusiness;
import com.sps.service.base.BaseOperate;


/**
 * 商家
 */
@RestController
public class ChannelBusinessServiceImpl extends BaseOperate{

	@Autowired
	private ChannelBusinessDao dao;
	@Autowired
	private GoodShopDao goodShopDao;

	/**
	 * 根据条件获取商家列表（分页）
	 * businessProduct
	 * businessType
	 * businessBrand
	 * businessScope
	 * current: 当前页数-必须
	 * pagesize : 每页条数-必须
	 */
	@RequestMapping(value="/api/channel/business/query/page", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String queryByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String businessProduct = jsonObject.getString("businessProduct");
		String businessType = jsonObject.getString("businessType");
		String businessBrand = jsonObject.getString("businessBrand");
		String businessScope = jsonObject.getString("businessScope");
		
		Integer current = jsonObject.getInteger("current");
		Integer pagesize = jsonObject.getInteger("pagesize");
		if (current==null || current<1 || pagesize==null || pagesize<1) {
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);
		}

		SpsChannelBusiness obj = new SpsChannelBusiness();
		obj.setBusinessProduct(businessProduct);
		obj.setBusinessType(businessType);
		obj.setBusinessBrand(businessBrand);
		obj.setBusinessScope(businessScope);

		Page<SpsChannelBusiness> page = new Page<>(current, pagesize);
		int count = dao.countByEntity(obj);
		List<SpsChannelBusiness> list = dao.queryByPage(obj, page);
		if (StringUtil.isNotEmpty(list)) {
			//补充商品列表
			SpsGoodShop gs;
			for (SpsChannelBusiness temp : list) {
				try {
					if (StringUtil.isEmpty(temp.getChannelNum())) 
						continue;

					gs = new SpsGoodShop();
					gs.setgShopId(temp.getChannelNum());
					List<SpsGoodShop> gss = goodShopDao.query(gs);
					temp.setGoodShops(gss);
				} catch (Exception e) {
				}
			}
		}
		page.setToatl(count);
		page.setList(list);

		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, page);
	}




}
