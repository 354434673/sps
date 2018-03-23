package com.sps.service.log;

import java.util.List;

import com.sps.entity.log.SpsLog;

public interface LogService {
	/**
	 * 重要操作进行记录 @Title: insertLog @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param: @param log @author YangNingSheng @date
	 * 2018年2月5日 上午10:40:06 @return: void @throws
	 */
	void insertLog(SpsLog log);

	List<SpsLog> getLogByUser(String userName, String logType);
}
