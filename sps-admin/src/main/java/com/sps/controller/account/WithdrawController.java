package com.sps.controller.account;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sps.common.Result;
import com.sps.util.ValidateImageCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrade;
import org.sps.service.merchant.read.ChannelBankReadService;
import org.sps.service.merchant.read.ChannelBankTradeReadService;
import org.sps.service.merchant.read.ChannelReadService;
import org.sps.service.merchant.write.ChannelBankTradeWriteService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sps.common.Account;
import com.sps.common.Withdraw;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {
	@Reference(check=false,group="dianfu")
    private ChannelBankTradeWriteService bankTradeWriteService;
	@Reference(check=false,group="dianfu")
	private ChannelBankReadService bankReadService;
	@Reference(check=false,group="dianfu")
	private ChannelReadService  readService;
	@Reference(check=false,group="dianfu")
	private ChannelBankTradeReadService  bankTradereadService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }
    @RequestMapping("/findBankTradeList")
    @ResponseBody
     public HashMap<String, Object> userList( Integer page,Integer limit,String applicationStartDate,String paymentDate,String tradeStatus) {
        String loginName = (String)SecurityUtils.getSubject().getPrincipal();
        HashMap<String, Object> list = bankTradereadService.getBankTradeList(page, limit, applicationStartDate, paymentDate, tradeStatus, loginName);
		return list;
     }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(SpsChannelBankTrade bankTrade, Model model) {
  		String userName = (String)SecurityUtils.getSubject().getPrincipal();
		
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
        	bankTradeWriteService.saveBankTradeInfo(bankTrade,userName);
            resultMap.put("flag", 1);
            resultMap.put("msg", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", 0);
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }

    /**
     * 获取账户的方法
     * @param request
     * @return
     */
    @RequestMapping("/getAccount")
    @ResponseBody
    public SpsChannelBank getAccount(HttpServletRequest request){
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        SpsChannelBank bankInfo = bankReadService.getBankInfo(userName);
        return bankInfo;
    }

    /**
     * 查询是否存在交易密码
     * @return
     */
    @RequestMapping(value = "/findTradePwd")
    public Map<String, String> findTradePwd() {
        Map<String, String > resultMap = new HashMap<String,String>();
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        Boolean flag = bankReadService.findTradePassword(userName);
        if(flag==true){
            resultMap.put("flag", "ok");
            return resultMap;
        }else{
            resultMap.put("flag", "no");
            return resultMap;
        }
    }
    /**
     * 获取交易详情
     * @return
     */
    @RequestMapping(value = "/findTradeDetail")
    @ResponseBody
    public SpsChannelBankTrade findTradeDetail() {
        Map<String, String > resultMap = new HashMap<String,String>();
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        SpsChannelBankTrade tradeDetail = bankTradereadService.getTradeDetail(userName);
        return tradeDetail;
    }





    @RequestMapping("/getVerifyCode")
    @ResponseBody
    public Result<String> getVerifyCode(HttpServletRequest request, String phone){
        String numricCode = ValidateImageCodeUtils.getRandNum();
        request.getSession().setAttribute("phoneCode",numricCode);
        Result<String> result = new Result<String>();
        result.setBody(numricCode);
        result.success();
        result.setMsg("成功");
        return result;
    }
    @RequestMapping("/getPhone")
    @ResponseBody
    public Result<JSONObject> getPhoneAndImgCode(){
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        String phone= bankReadService.findMobileByUserName(userName);
        JSONObject body = new JSONObject();
        Result<JSONObject> result = new Result<JSONObject>(body);
        body.put("phone",phone);
        result.success();
        result.setMsg("成功");
        return result;
    }
    @RequestMapping("/setTradePwd")
    @ResponseBody
    public Result<Boolean> setTradePwd(HttpServletRequest request, String phoneCode,String imgCode,String tradePwd){
        Result<Boolean> result = new Result<Boolean>();
        String srcImgCode  = (String) request.getSession().getAttribute("imgCode");
        String srcPhoneCode = (String) request.getSession().getAttribute("phoneCode");
        if(imgCode.equals(srcImgCode) && phoneCode.equals(srcPhoneCode)){
            //调用业务层进行更新账户中的交易密码
            result.setBody(true);
            result.success();
            result.setMsg("成功");
            request.getSession().removeAttribute("imgCode");
            request.getSession().removeAttribute("phoneCode");
        }
        return result;
    }
    @RequestMapping(value = "/imageCode")
    public String imageCode(HttpServletRequest request, HttpServletResponse response){
        try {
            //禁止图片缓存
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            //生成验证码
            String code = ValidateImageCodeUtils.getSecurityCode();
            //存到session或redis中
            request.getSession().setAttribute("imgCode",code);
            //输出图片流到img标签
            BufferedImage bi = ValidateImageCodeUtils.createImage(code);
            ServletOutputStream os = response.getOutputStream();
            ImageIO.write(bi, "png", os);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
