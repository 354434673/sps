package com.sps.controller.account;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.sps.common.Result;
import com.sps.entity.user.SpsUser;
import com.sps.service.user.UserService;
import com.sps.util.Md5Util;
import org.apache.shiro.SecurityUtils;
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
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/recharge")
public class ReChargeController {
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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> saveOrUpdate(BigDecimal withdrawAmt, String tradePwd) {
        Result<String> result = new Result<String>();
        //比对交易密码是否正确
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        String pwd = bankReadService.findTradePassword(userName);
        String salt = bankReadService.findSalt(userName);

        String pass=Md5Util.getMd5(tradePwd,salt);
        if(pass.equals(pwd)){
            SpsUser user = userService.findByUserName(userName);
            //从当前登录用户中获取用户银行卡信息
            SpsChannelBank bankInfo = bankReadService.getBankInfoByUserName(userName);
            if(bankInfo !=null){
                String tradeSerialNum = bankTradeWriteService.saveBankTradeInfo(bankInfo, withdrawAmt,"1",user.getUserId(),user.getUserMark());
                boolean flag = StringUtils.isNotEmpty(tradeSerialNum);
                result.setBody(tradeSerialNum);
                result.setMsg(flag ? "成功" : "保存失败");
                return result;
            }
        }
        result.setBody("");
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
        Result<Map> result = new Result<Map>();//
        Map<String, Object> body = new HashMap<String,Object>();
        result.setBody(body);
        String userName = (String)SecurityUtils.getSubject().getPrincipal();
        String pwd = bankReadService.findTradePassword(userName);
        if(StringUtils.isNotEmpty(pwd) ){
            result.success();
            if(Md5Util.getMd5(psw,Md5Util.getSalt(6)).equals(pwd)){
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
        if(StringUtils.isBlank(pwd) ){
              flag = false;
        }
        result.setBody(flag);
        return result;

    }
    /**
     * 获取交易详情
     * @return
     */
    @RequestMapping(value = "/rechargeDetail")
    @ResponseBody
    public SpsChannelBankTrade findTradeDetail(String  tradeSerialNum) {
        Map<String, String > resultMap = new HashMap<String,String>();
        SpsChannelBankTrade tradeDetail = bankTradereadService.getTradeInfo( tradeSerialNum);
        return tradeDetail;
    }

    @RequestMapping("/setTradePwd")
    @ResponseBody
    public Result<Boolean> setTradePwd(HttpServletRequest request,String tradePwd) {
        Result<Boolean> result = new Result<Boolean>();
            //调用业务层进行更新账户中的交易密码
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            String salt=Md5Util.getSalt(6);
            String realPwd = Md5Util.getMd5(tradePwd,salt);
            Boolean flag = bankWriteService.modifyTradePsw(userName, realPwd,salt);
            result.setBody(flag);
            result.success();
            result.setMsg(flag ? "设置密码成功" : "设置密码失败");
        return result;
    }


}
