package org.sps.service.merchant.write;

import java.io.Serializable;
import java.util.HashMap;

public interface ChannelPicUploadService extends Serializable{
	/**
	 * 上传图片
	 * @Title: uploadPic   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param src
	 * @param: @param type
	 * @param: @param oldName
	 * @param: @param newName
	 * @param: @param state
	 * @param: @param channelNum
	 * @param: @return  
	 * @author YangNingSheng    
	 * @date 2018年1月12日 上午10:39:17
	 * @return: HashMap<String,Object>      
	 * @throws
	 */
	HashMap<String, Object> uploadPic(String src, Integer type, String oldName, String newName
			, Integer state, String channelNum);
}
