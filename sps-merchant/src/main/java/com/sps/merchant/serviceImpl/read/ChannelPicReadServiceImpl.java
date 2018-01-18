package com.sps.merchant.serviceImpl.read;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.merchant.SpsChannelPic;
import org.sps.entity.merchant.SpsChannelPicExample;
import org.sps.entity.merchant.SpsChannelPicExample.Criteria;
import org.sps.service.merchant.read.ChannelPicReadService;
import org.sps.service.merchant.write.ChannelPicUploadService;

import com.alibaba.dubbo.config.annotation.Service;
import com.sps.dao.merchant.read.SpsChannelPicReadMapper;
import com.sps.dao.merchant.write.SpsChannelPicWriteMapper;
@Service(timeout=12000)
@Transactional(readOnly = true)
public class ChannelPicReadServiceImpl implements ChannelPicReadService{
	@Resource
	private SpsChannelPicReadMapper picRead;

	@Override
	public List<SpsChannelPic> getPicList(String channelNum, Integer type) {
		
		SpsChannelPicExample example = new SpsChannelPicExample();
		
		Criteria createCriteria = example.createCriteria();
		
		createCriteria.andChannelNumEqualTo(channelNum);
		if(type != null){
			createCriteria.andPicTypeEqualTo(type);
		}
		List<SpsChannelPic> selectByExample = picRead.selectByExample(example );
		
		return selectByExample.size() == 0 ? null : selectByExample;
	}

}
