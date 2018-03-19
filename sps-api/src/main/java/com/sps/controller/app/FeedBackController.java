package com.sps.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sps.common.HttpClientUtil;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.app.FeedBack;
import com.sps.entity.app.FeedbackCategory;
import com.sps.entity.app.Help;
import com.sps.service.app.help.HelpService;
import com.sps.service.app.help.feedBack.FeedBackService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Controller
@RequestMapping(value = "/api/feedBack")
public class FeedBackController {
    private static final Log logger= LogFactory.getLog(FeedBackController.class);
    @Autowired
    private FeedBackService feedBackService;

    /**
     * 查询所有反馈类型的方法
     * @return
     */
    @RequestMapping(value = "/findAllCatagory", method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo findAllCatagory(){
        ReturnInfo returnInfo = new ReturnInfo();
        try {
            List<FeedbackCategory> catagorys = feedBackService.queryAllCtagory();
            if(catagorys.size()>0){
                returnInfo.setResult(catagorys);
                returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
                returnInfo.setCode(Message.API_SUCCESS_CODE);
                returnInfo.setMsg(Message.API_SUCCESS_MSG);
            }
        } catch (Exception e){
            e.printStackTrace();
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
        return returnInfo;
    }

    /**
     * 根据类型id，保存反馈意见的方法
     * @return
     */
    @RequestMapping(value="/savaFeedBackInfo/{categoeyId}/{content}/{systype}",method = RequestMethod.GET)
    @ResponseBody
    public ReturnInfo savaFeedBackInfo(@PathVariable("categoeyId") Integer categoeyId, @PathVariable("content") String content, @PathVariable("systype") String systype) {
        logger.info("savaFeedBackInfo ....................");
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        ReturnInfo returnInfo = new ReturnInfo();
        FeedBack feedBack = new FeedBack();
        feedBack.setCategoeyId(categoeyId);
        feedBack.setContent(content);
        feedBack.setCreater(userName);
        feedBack.setSystype(systype);
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        feedBack.setCreatetime(createdate);

            Boolean flag= feedBackService.saveContent(feedBack);
        if(flag){
            returnInfo.setSuccess(Message.API_SUCCESS_FLAG);
            returnInfo.setCode(Message.API_SUCCESS_CODE);
            returnInfo.setMsg(Message.API_SUCCESS_MSG);
        }else{
            returnInfo.setCode(Message.FAILURE_CODE);
            returnInfo.setMsg(Message.FAILURE_MSG);
            returnInfo.setSuccess(Message.API_ERROR_FLAG);
        }
      return returnInfo;
    }


}
