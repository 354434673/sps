package org.sps.service.merchant.read;

import java.util.List;

import org.sps.entity.merchant.SpsChannelPic;

public interface ChannelPicReadService {
	/**
	 * 查询该商户不同类型的图片
	 * @Title: getPicList   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param channelNum
	 * @param: @param type
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月16日 下午3:41:31
	 * @return: List<SpsChannelPic>      
	 * @throws
	 */
	List<SpsChannelPic> getPicList(String channelNum, Integer type);
}
