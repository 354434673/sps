package com.sps.service.impl;

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
import com.sps.common.StringUtil;
import com.sps.dao.BalanceDao;
import com.sps.entity.app.Balance;
import com.sps.service.base.BaseOperate;
import com.sps.service.base.BaseService;

@RestController
public class BalanceServiceImpl extends BaseOperate implements BaseService{

	@Autowired
	private BalanceDao dao;

	/**
	 * 根据id获取balance
	 */
	@Override
	@RequestMapping(value="/api/balance/get", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件获取balance对象
	 * balanceType
	 * balanceState
	 * balanceClientNum
	 */
	@Override
	@RequestMapping(value="/api/balance/find", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String find(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//入参检查
		String jsonIn = getReqContent(request);
		if (StringUtil.isEmpty(jsonIn)) 
			return Message.responseStr(Message.PARAM_NONE_CODE, Message.PARAM_NONE_MSG);

		JSONObject jsonObject = JSON.parseObject(jsonIn);
		String balanceType = jsonObject.getString("balanceType");
		String balanceClientNum = jsonObject.getString("balanceClientNum");
		Integer balanceState = jsonObject.getInteger("balanceState");

		int count = 0 ;
		if (StringUtil.isNotEmpty(balanceType))
			count++;
		if (StringUtil.isNotEmpty(balanceClientNum))
			count++;
		if (balanceState != null) 
			count++;

		if (count == 0) 
			return Message.responseStr(Message.PARAM_ILLEGAL_CODE, Message.PARAM_ILLEGAL_MSG);

		Balance obj = new Balance();
		obj.setBalanceType(balanceType);
		obj.setBalanceClientNum(balanceClientNum);
		obj.setBalanceState(balanceState);

		obj = dao.find(obj);
		return Message.responseStr(Message.SUCCESS_CODE, Message.SUCCESS_MSG, obj);
	}


	/**
	 * 根据条件获取balance对象列表
	 */
	@Override
	@RequestMapping(value="/api/balance/query", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String query(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件获取balance对象列表（分页）
	 * current: 当前页数-必须
	 * pagesize : 每页条数-必须
	 */
	@Override
	@RequestMapping(value="/api/balance/query/page", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String queryByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 获取balance总记录数
	 */
	@Override
	@RequestMapping(value="/api/balance/count", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String count(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件获取balance记录数
	 */
	@Override
	@RequestMapping(value="/api/balance/count/vo", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String countByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 添加balance
	 */
	@Override
	@RequestMapping(value="/api/balance/save", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象编辑balance
	 */
	@Override
	@RequestMapping(value="/api/balance/update", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件集合编辑balance
	 */
	@Override
	@RequestMapping(value="/api/balance/update/cond", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String updateByCond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象id删除balance
	 */
	@Override
	@RequestMapping(value="/api/balance/delete", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据实体对象删除balance
	 */
	@Override
	@RequestMapping(value="/api/balance/delete/vo", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String deleteByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


	/**
	 * 根据条件集合删除balance
	 */
	@Override
	@RequestMapping(value="/api/balance/delete/cond", method=RequestMethod.POST)
	@Transactional(readOnly=true, rollbackFor=java.lang.Exception.class)
	public String deleteByCond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//未实现
		return Message.responseStr(Message.FAILURE_CODE, Message.FAILURE_MSG);
	}


}
