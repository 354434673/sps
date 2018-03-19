package com.sps.service.app.help.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.app.HelpDao;
import com.sps.entity.app.Help;
import com.sps.entity.goods.SpsCustomCategory;
import com.sps.entity.goods.SpsGoodShop;
import com.sps.entity.merchant.SpsChannelEnterprise;
import com.sps.service.app.help.HelpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-03-06.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Service
public class HelpServiceImpl implements HelpService {
    private static final Log logger= LogFactory.getLog(HelpServiceImpl.class);
    @Autowired
    private HelpDao helpDao;

    @Override
    public List<Help> queryAllTittle() {
        List<Help> list = helpDao.selectAllTittle();
        return list;
    }

    @Override
    public HashMap<String, Object> queryContent(String date) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if(!StringUtil.isEmpty(date)){
            try {
                Help help = helpDao.selectContent(Integer.valueOf(date));

                hashMap.put("help",help);
                Message.resultMap(Message.SUCCESS_CODE, Message.SUCCESS_MSG, Message.SUCCESS_MSG,1,hashMap);
            } catch(Exception e){
                e.printStackTrace();
               logger.info(Message.SYSTEM_ERROR_MSG);

                hashMap = Message.resultMap( Message.SYSTEM_ERROR_CODE, Message.SYSTEM_ERROR_MSG,
                        Message.FAILURE_MSG,null, null);
            }
        }
        return hashMap;
    }
}



