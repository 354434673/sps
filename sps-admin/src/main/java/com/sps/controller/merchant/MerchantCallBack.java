package com.sps.controller.merchant;
import com.alibaba.fastjson.JSONObject;
import com.sps.util.HttpClientUtil;
import com.sps.util.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(value="/merchantCallBack")
public class MerchantCallBack {
    private static String init = "http://dev.app.chezhubaitiao.com/api/merchantAccount/init";
    private static String initBusiness = "http://dev.app.chezhubaitiao.com/api/business/init";



    /**
     * 初始化
     * @return
     */
    @RequestMapping(value = "/initBusiness", method = RequestMethod.POST)
    @ResponseBody
    public void initBusiness(String businessId, String name) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            JSONObject json = new JSONObject();
            json.put("application", "dianfu");
            json.put("approvedDate", df.format(System.currentTimeMillis()));
            json.put("businessId", "DF20183201115152");
            json.put("firstMonthQuota", "20000");
            json.put("monthQuota", "20000");
            json.put("signDateStart", df.format(System.currentTimeMillis()));
            json.put("totalQuota", "20000");
            String jsonResult = HttpClientUtil.doPostJson(initBusiness, json.toJSONString());
            System.out.println(jsonResult);
            if (jsonResult != null) {

            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
    }
    /**
     * 初始化
     *
     * @return
     */
    @RequestMapping(value = "/initMerchantAccount", method = RequestMethod.POST)
    @ResponseBody
    public void initMerchantAccount(String businessId, String name) {
        try {
            Map resultMap = new HashMap<>();
            resultMap.put("application", "dianfu");
            resultMap.put("businessId", "DF20180136191770");
            resultMap.put("name", "公司");
            String jsonResult = HttpClientUtils.post(init, resultMap);
            System.out.println(jsonResult);
            if (jsonResult != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
