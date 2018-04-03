package com.sps.service.help.help.impl;


import com.sps.common.Message;
import com.sps.dao.helpAndFeedBack.HelpDao;
import com.sps.entity.helpAndFeedback.Help;
import com.sps.service.help.help.HelpService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sps.util.StringUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    @Override
    public Boolean saveHelp(String title, String content) {
        Help help = new Help();
        help.setTitle(title);
        help.setContent(content);
        help.setCreateDate(new Date());
        help.setFlag(1);
        int m = helpDao.insertHelp(help);
        return m >0? true:false;
    }
}



