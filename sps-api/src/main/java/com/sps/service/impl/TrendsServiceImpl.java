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
import com.sps.dao.TrendsDao;
import com.sps.entity.app.SpsAppTrends;
import com.sps.service.base.BaseOperate;
import com.sps.service.base.BaseService;

@RestController
public class TrendsServiceImpl extends BaseOperate implements BaseService{

	@Autowired
	private TrendsDao dao;

	/**
	 * 根据id获取trends
	 */
	@Override
	@RequestMapping(value="/api/trends/get", method=RequestMethod.POST)
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

		SpsAppTrends obj = dao.get(id);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, obj);
	}


	/**
	 * 根据条件获取trends对象
	 * ttitle
	 * tisuse
	 */
	@Override
	@RequestMapping(value="/api/trends/find", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String find(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String ttitle = jsonObject.getString("ttitle");
		Integer tisuse = jsonObject.getInteger("tisuse");

		int count = 0 ;
		if (StringUtil.isNotEmpty(ttitle))
			count++;
		if (tisuse != null) 
			count++;

		if (count == 0) 
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);

		SpsAppTrends obj = new SpsAppTrends();
		obj.settTitle(ttitle);
		obj.settIsuse(tisuse);
		
		obj = dao.find(obj);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, obj);
	}


	/**
	 * 根据条件获取trends对象列表
	 * ttitle
	 * tisuse
	 */
	@Override
	@RequestMapping(value="/api/trends/query", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String ttitle = jsonObject.getString("ttitle");
		Integer tisuse = jsonObject.getInteger("tisuse");

		SpsAppTrends obj = new SpsAppTrends();
		obj.settTitle(ttitle);
		obj.settIsuse(tisuse);

		List<SpsAppTrends> list = dao.query(obj);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, list);
	}


	/**
	 * 根据条件获取trends对象列表（分页）
	 * ttitle
	 * tisuse
	 * current: 当前页数-必须
	 * pagesize : 每页条数-必须
	 */
	@Override
	@RequestMapping(value="/api/trends/query/page", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String queryByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String ttitle = jsonObject.getString("ttitle");
		Integer tisuse = jsonObject.getInteger("tisuse");
		Integer current = jsonObject.getInteger("current");
		Integer pagesize = jsonObject.getInteger("pagesize");
		
		if (current==null || current<1 || pagesize==null || pagesize<1) {
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);
		}
		
		SpsAppTrends obj = new SpsAppTrends();
		obj.settTitle(ttitle);
		obj.settIsuse(tisuse);

		Page<SpsAppTrends> page = new Page<>(current, pagesize);
		int count = dao.countByEntity(obj);
		List<SpsAppTrends> list = dao.queryByPage(obj, page);
		page.setToatl(count);
		page.setList(list);

		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, page);
	}


	/**
	 * 获取trends总记录数
	 */
	@Override
	@RequestMapping(value="/api/trends/count", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String count(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Integer t = dao.count();
		JSONObject jsonObject = new JSONObject();
		if(t != null)
			jsonObject.put("total", t);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonObject);
	}


	/**
	 * 根据条件获取trends记录数
	 * ttitle
	 * tisuse
	 */
	@Override
	@RequestMapping(value="/api/trends/count/vo", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String countByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String ttitle = jsonObject.getString("ttitle");
		Integer tisuse = jsonObject.getInteger("tisuse");

		SpsAppTrends obj = new SpsAppTrends();
		obj.settTitle(ttitle);
		obj.settIsuse(tisuse);

		jsonObject.clear();
		Integer t = dao.countByEntity(obj);
		if(t != null)
			jsonObject.put("total", t);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, jsonObject);
	}


	/**
	 * 添加trends
	 */
	@Override
	@RequestMapping(value="/api/trends/save", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象编辑trends
	 */
	@Override
	@RequestMapping(value="/api/trends/update", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件集合编辑trends
	 */
	@Override
	@RequestMapping(value="/api/trends/update/cond", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String updateByCond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象id删除trends
	 */
	@Override
	@RequestMapping(value="/api/trends/delete", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象删除trends
	 */
	@Override
	@RequestMapping(value="/api/trends/delete/vo", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String deleteByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件集合删除trends
	 */
	@Override
	@RequestMapping(value="/api/trends/delete/cond", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String deleteByCond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


}
