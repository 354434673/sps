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
import com.sps.dao.BannerDao;
import com.sps.entity.app.SpsAppBanner;
import com.sps.service.base.BaseOperate;
import com.sps.service.base.BaseService;

@RestController
public class BannerServiceImpl extends BaseOperate implements BaseService{

	@Autowired
	private BannerDao dao;

	/**
	 * 根据id获取banner
	 */
	@Override
	@RequestMapping(value="/api/banner/get", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		Integer id = jsonObject.getInteger("id");
		if (id == null)
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);

		SpsAppBanner obj = dao.get(id);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, obj);
	}


	/**
	 * 根据条件获取banner对象
	 * bname
	 */
	@Override
	@RequestMapping(value="/api/banner/find", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String find(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String bname = jsonObject.getString("bname");
		if (StringUtil.isEmpty(bname))
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);

		SpsAppBanner obj = new SpsAppBanner();
		obj.setbName(bname);
		
		obj = dao.find(obj);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, obj);
	}


	/**
	 * 根据条件获取banner对象列表
	 * bname
	 */
	@Override
	@RequestMapping(value="/api/banner/query", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String bname = jsonObject.getString("bname");

		SpsAppBanner obj = new SpsAppBanner();
		obj.setbName(bname);

		List<SpsAppBanner> list = dao.query(obj);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, list);
	}


	/**
	 * 根据条件获取banner对象列表（分页）
	 * bname
	 * current: 当前页数-必须
	 * pagesize : 每页条数-必须
	 */
	@Override
	@RequestMapping(value="/api/banner/query/page", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String queryByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String bname = jsonObject.getString("bname");
		Integer current = jsonObject.getInteger("current");
		Integer pagesize = jsonObject.getInteger("pagesize");
		if (current==null || current<1 || pagesize==null || pagesize<1) {
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);
		}

		SpsAppBanner obj = new SpsAppBanner();
		obj.setbName(bname);

		Page<SpsAppBanner> page = new Page<>(current, pagesize);
		int count = dao.countByEntity(obj);
		List<SpsAppBanner> list = dao.queryByPage(obj, page);
		page.setToatl(count);
		page.setList(list);

		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, page);
	}


	/**
	 * 获取banner总记录数
	 */
	@Override
	@RequestMapping(value="/api/banner/count", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String count(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer t = dao.count();
		JSONObject jsonObject = new JSONObject();
		if(t != null)
			jsonObject.put("total", t);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonObject);
	}


	/**
	 * 根据条件获取banner记录数
	 * bname
	 */
	@Override
	@RequestMapping(value="/api/banner/count/vo", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String countByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String bname = jsonObject.getString("bname");

		SpsAppBanner obj = new SpsAppBanner();
		obj.setbName(bname);

		jsonObject.clear();
		Integer t = dao.countByEntity(obj);
		if(t != null)
			jsonObject.put("total", t);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonObject);
	}


	/**
	 * 添加banner
	 */
	@Override
	@RequestMapping(value="/api/banner/save", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象编辑banner
	 */
	@Override
	@RequestMapping(value="/api/banner/update", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件集合编辑banner
	 */
	@Override
	@RequestMapping(value="/api/banner/update/cond", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String updateByCond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象id删除banner
	 */
	@Override
	@RequestMapping(value="/api/banner/delete", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象删除banner
	 */
	@Override
	@RequestMapping(value="/api/banner/delete/vo", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String deleteByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件集合删除banner
	 */
	@Override
	@RequestMapping(value="/api/banner/delete/cond", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String deleteByCond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


}
