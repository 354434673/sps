package com.sps.controller.account;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.sps.common.Result;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserService;
import com.sps.util.Md5Util;
import com.sps.util.ValidateImageCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
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
    @Resource

    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(WithdrawController.class);
    @RequestMapping("/findBankTradeList")
    @ResponseBody
     public HashMap<String, Object> findBankTradeList( Integer page,Integer limit,String applicationStartDate,String paymentDate,String tradeStatus) {
        String loginName = (String)SecurityUtils.getSubject().getPrincipal();
        HashMap<String, Object> list = bankTradereadService.getBankTradeList(page, limit, applicationStartDate, paymentDate, tradeStatus, loginName,"0");
		return list;
     }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> saveOrUpdate(BigDecimal withdrawAmt, String tradePwd) {
        Result<Boolean> result = new Result<Boolean>();
    	//比对交易密码是否正确
		String userName = (String) SecurityUtils.getSubject().getPrincipal();

        String pwd = bankReadService.findTradePassword(userName);
        String salt = bankReadService.findSalt(userName);

        String pass=Md5Util.getMd5(tradePwd,salt);
        if(pass.equals(pwd)){
            SpsUser user = userService.findByUserName(userName);
            //从当前登录用户中获取用户银行卡信息
            SpsChannelBank bankInfo = bankReadService.getBankInfoByUserName(userName);
            String tradeSerialNum = bankTradeWriteService.saveBankTradeInfo(bankInfo, withdrawAmt,"0",user.getUserId(),user.getUserMark());
            boolean flag = StringUtils.isNotEmpty(tradeSerialNum);
            result.setBody(flag);
            result.setMsg(flag ? "成功" : "保存失败");
            return result;
        }
        result.setBody(false);
        result.setMsg("密码输入有误");

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
        Result<Map> result = new Result<Map>();
        Map<String, Object> body = new HashMap<String,Object>();
        result.setBody(body);
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        String pwd = bankReadService.findTradePassword(userName);
        String salt = bankReadService.findSalt(userName);
        if(StringUtils.isNotEmpty(pwd) ){
            result.success();
            String pass=Md5Util.getMd5(psw+salt,Md5Util.getSalt(6));
            if(pass.equals(pwd)){
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
        logger.info("srcImgCode" + srcImgCode);

        String srcPhoneCode = (String) request.getSession().getAttribute("phoneCode");
        logger.info("srcPhoneCode"+ srcPhoneCode);
        if (imgCode.equals(srcImgCode) && phoneCode.equals(srcPhoneCode)) {
            //调用业务层进行更新账户中的交易密码
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            String salt = Md5Util.getSalt(6);
            String realPwd = Md5Util.getMd5(tradePwd, salt);
            Boolean flag = bankWriteService.modifyTradePsw(userName, realPwd,salt);
            result.setBody(flag);
            result.success();
            result.setMsg(flag ? "设置密码成功" : "设置密码失败");
            request.getSession().removeAttribute("imgCode");
            request.getSession().removeAttribute("phoneCode");
            return result;
        }else{
            result.setMsg("输入验证信息错误");
            return result;

        }

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
