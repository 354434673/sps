package com.sps.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sps.common.HttpClientUtil;
import com.sps.common.Message;
import com.sps.common.ReturnInfo;
import com.sps.entity.app.FeedBack;
import com.sps.entity.app.FeedbackCategory;
import com.sps.entity.app.Help;
import com.sps.entity.shopkeeper.SpsShopkeeperPersonal;
import com.sps.service.app.help.HelpService;
import com.sps.service.app.help.feedBack.FeedBackService;
import com.sps.service.shopkeeper.ShopkeeperPersonService;
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
    @Autowired
    private ShopkeeperPersonService shopkeeperPersonService;

    /**
     * 查询所有反馈类型的方法
     * @return
     */
    @RequestMapping(value = "/findAllCatagory", method = RequestMethod.POST)
    @ResponseBody
    public String findAllCatagory(){
        JSONObject jsonO = new JSONObject();

        List<FeedbackCategory> catagorys = feedBackService.queryAllCtagory();
        if(catagorys.size()>0){
            jsonO.put("catagorys",catagorys);
            return Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG, jsonO);

        }
        jsonO.put("catagorys",null);
        return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG, jsonO);
    }

    /**
     * 根据类型id，保存反馈意见的方法
     * @return
     */
    @RequestMapping(value="/savaFeedBackInfo",method = RequestMethod.POST)
    @ResponseBody
    public String savaFeedBackInfo(@RequestParam("customerId") String customerId,@RequestParam("categoeyId") Integer categoeyId, @RequestParam("content") String content, @RequestParam("systype") String systype) {
        logger.info("savaFeedBackInfo ....................");
        SpsShopkeeperPersonal person = shopkeeperPersonService.findPerson(customerId);
        if(person !=null){
            FeedBack feedBack = new FeedBack();
            feedBack.setCategoeyId(categoeyId);
            feedBack.setContent(content);
            feedBack.setCreater(person.getPersonalId());
            feedBack.setSystype(systype);
            Date date = new Date();
            //设置要获取到什么样的时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //获取String类型的时间
            String createdate = sdf.format(date);
            feedBack.setCreatetime(createdate);
            Boolean flag= feedBackService.saveContent(feedBack);
            if(flag){
                return Message.responseStr(Message.SUCCESS_CODE,Message.SUCCESS_MSG);
            }
            return Message.responseStr(Message.FAILURE_CODE,Message.FAILURE_MSG);
        }
      return   Message.responseStr(Message.FAILURE_CODE,Message.PARAM_ILLEGAL_MSG);

    }


}
