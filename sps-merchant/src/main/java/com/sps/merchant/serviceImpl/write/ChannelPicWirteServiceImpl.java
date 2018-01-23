package com.sps.merchant.serviceImpl.write;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.sps.entity.merchant.SpsChannelPic;
import org.sps.entity.merchant.SpsChannelPicExample;
import org.sps.service.merchant.write.ChannelPicUploadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelPicReadMapper;
import com.sps.dao.merchant.write.SpsChannelPicWriteMapper;
@Service(timeout=2000,group="dianfu-dev")
public class ChannelPicWirteServiceImpl implements ChannelPicUploadService{
	@Resource
	private SpsChannelPicWriteMapper picWrite;
	@Resource
	private SpsChannelPicReadMapper picRead;
	@Override
	public HashMap<String, Object> uploadPic(String src, Integer type, String oldName, String newName, Integer state,
			String channelNum) {
		HashMap<String, Object> hashMap = null;
		
		SpsChannelPicExample example = new SpsChannelPicExample();
		
		example.createCriteria().andChannelNumEqualTo(channelNum)
								.andPicTypeEqualTo(type);
		List<SpsChannelPic> selectByExample = picRead.selectByExample(example);//检查数量
		try {
			hashMap = new HashMap<String, Object>();
			if(selectByExample.size()<5){
				SpsChannelPic record = new SpsChannelPic();
				record.setPicSrc(src);
				record.setPicType(type);
				record.setPicOldName(oldName);
				record.setPicNewName(newName);
				record.setPicState(state);
				record.setPicUploadTime(new Date());
				record.setChannelNum(channelNum);
				picWrite.insertSelective(record);
				hashMap.put("msg", "图片上传成功");
				hashMap.put("state", "success");
			}else{
				hashMap.put("msg", "该类型图片最多只可上传五张!");
				hashMap.put("state", "max");
			}
		} catch (Exception e) {
			hashMap.put("msg", "图片上传失败");
			hashMap.put("state", "error");
			e.printStackTrace();
		}
		return hashMap;
	}

}
