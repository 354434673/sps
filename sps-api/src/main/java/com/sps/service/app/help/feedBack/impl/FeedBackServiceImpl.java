package com.sps.service.app.help.feedBack.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Message;
import com.sps.common.StringUtil;
import com.sps.dao.app.FeedBackCatagoryDao;
import com.sps.dao.app.FeedBackDao;
import com.sps.entity.app.FeedBack;
import com.sps.entity.app.FeedbackCategory;
import com.sps.entity.app.Help;
import com.sps.service.app.help.feedBack.FeedBackService;
import com.sps.service.app.help.impl.HelpServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-03-07.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {
    private static final Log logger= LogFactory.getLog(HelpServiceImpl.class);


    @Autowired
    private FeedBackCatagoryDao feedBackCatagoryDao;
    @Autowired
    private FeedBackDao feedBackDao;

    @Override
    public List<FeedbackCategory> queryAllCtagory() {
        List<FeedbackCategory> list = feedBackCatagoryDao.selectList();
        return list;
    }

    @Override
    public Boolean saveContent(FeedBack feedBack) {
        Boolean flag=true;
        try{
            feedBackDao.insertFeedBack(feedBack);
        }catch(Exception e){
            e.printStackTrace();
            flag=false;
        }

        return flag ;
    }


}
