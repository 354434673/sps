package com.sps.controller.account;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
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
import org.sps.service.merchant.write.ChannelBankWriteService;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/withdraw")
public class WithdrawController {
	@Reference(check=false,group="dianfu")
    private ChannelBankTradeWriteService bankTradeWriteService;
	@Reference(check=false,group="dianfu")
	private ChannelBankReadService bankReadService;
    @Reference(check=false,group="dianfu")
    private ChannelBankWriteService bankWriteService;
	@Reference(check=false,group="dianfu")
	private ChannelReadService  readService;
	@Reference(check=false,group="dianfu")
	private ChannelBankTradeReadService  bankTradereadService;
   /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }*/
    @RequestMapping("/findBankTradeList")
    @ResponseBody
     public HashMap<String, Object> userList( Integer page,Integer limit,String applicationStartDate,String paymentDate,String tradeStatus) {
        String loginName = (String)SecurityUtils.getSubject().getPrincipal();
        HashMap<String, Object> list = bankTradereadService.getBankTradeList(page, limit, applicationStartDate, paymentDate, tradeStatus, loginName);
		return list;
     }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> saveOrUpdate(BigDecimal withdrawAmt,String type, Model model) {

    	//未完善的地方，type类型要从页面动态获取
		String userName = (String) SecurityUtils.getSubject().getPrincipal();
		//从当前登录用户中获取用户银行卡信息
		SpsChannelBank bankInfo = bankReadService.getBankInfoByUserName(userName);
		Result<Boolean> result = new Result<Boolean>();
		Boolean flag = bankTradeWriteService.saveBankTradeInfo(bankInfo, withdrawAmt);
		result.setBody(flag);
		result.success();
		result.setMsg(flag ? "成功" : "保存失败");
		return result;
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
        SpsChannelBank bankInfo = bankReadService.getBankInfoByUserName(userName);
        return bankInfo;
    }

    @RequestMapping("/queryTradePwd")
    @ResponseBody
    public Result findTradePwd(HttpServletRequest request,String psw) {
        Result<Map> result = new Result<Map>();//
        Map<String, Object> body = new HashMap<String,Object>();
        result.setBody(body);
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        String pwd = bankReadService.findTradePassword(userName);
        if(StringUtils.isNotEmpty(pwd) ){
            result.success();
            if(psw.equals(pwd)){
                result.setMsg("成功");
                body.put("flag",0);
            }else{
                result.setMsg("输入密码不正确");
                body.put("flag",1);
            }

        }else{
            result.fail();
            result.setMsg("未设置交易密码");
            body.put("flag",2);
        }
        return result;
    }

    @RequestMapping("/queryExistTradePwd")
    @ResponseBody
    public Result<Boolean> queryExistTradePwd(HttpServletRequest request) {
        Result<Boolean> result = new Result<Boolean>();

        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        String pwd = bankReadService.findTradePassword(userName);
        Boolean flag=true;
        if(StringUtils.isNotEmpty(pwd) ){
            result.setBody(flag);
            result.success();
            result.setMsg("ok");
            return result;

        }else{
            flag=false;
            result.fail();
            result.setMsg("未设置交易密码");
            result.setBody(flag);
            return result;
        }

    }
    /**
     * 获取交易详情
     * @return
     */
    @RequestMapping(value = "/withdrawDetail")
    @ResponseBody
    public SpsChannelBankTrade findTradeDetail(String  tradeSerialNum) {
        Map<String, String > resultMap = new HashMap<String,String>();
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        SpsChannelBankTrade tradeDetail = bankTradereadService.getTradeDetail(userName, tradeSerialNum);
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
    public Result<Boolean> setTradePwd(HttpServletRequest request, String phoneCode,String imgCode,String tradePwd) {
        Result<Boolean> result = new Result<Boolean>();
        String srcImgCode = (String) request.getSession().getAttribute("imgCode");
        String srcPhoneCode = (String) request.getSession().getAttribute("phoneCode");
        if (imgCode.equals(srcImgCode) && phoneCode.equals(srcPhoneCode)) {
            //调用业务层进行更新账户中的交易密码
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            Boolean flag = bankWriteService.modifyTradePsw(userName, tradePwd);
            result.setBody(flag);
            result.success();
            result.setMsg(flag ? "设置密码成功" : "设置密码失败");

            request.getSession().removeAttribute("imgCode");
            request.getSession().removeAttribute("phoneCode");
        }
        result.setMsg("输入验证信息错误");
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
