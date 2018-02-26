package com.sps.serviceImpl.merchant.write;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import org.sps.entity.account.AuthEnums;

import org.sps.entity.account.AuthRequest.AuthParam;
import org.sps.entity.account.AuthRequest.ConfirmParam;
import org.sps.entity.account.AuthRequest.ResendParam;
import org.sps.entity.account.AuthResponse;
import org.sps.entity.account.AuthResponse.AuthResult;
import org.sps.entity.account.AuthResponse.ConfirmResult;
import org.sps.entity.account.AuthResponse.ResendResult;
import org.sps.entity.account.Converter;
import org.sps.entity.account.HttpsUtil;
import org.sps.entity.merchant.SpsChannelBankTrans;
import org.sps.service.merchant.write.AuthBindCardWriteService;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;

import com.sps.dao.merchant.read.SpsChannelBankReadMapper;
import com.sps.dao.merchant.read.SpsChannelBankTransReadMapper;
import com.sps.dao.merchant.write.SpsChannelBankTransWriteMapper;
import com.sps.dao.merchant.write.SpsChannelBankWriteMapper;


/***
 *  绑卡请求
 * @author cailing
 *
 */
@Service(timeout=2000,group="dianfu")
@Transactional
public class AuthBindCardWriteServiceImpl implements AuthBindCardWriteService{
	@Resource
	private SpsChannelBankWriteMapper bankWrite;
	@Resource
	private SpsChannelBankTransWriteMapper bankTransWrite;
	@Resource
	private SpsChannelBankTransReadMapper bankTransRead;
	@Resource
	private SpsChannelBankReadMapper bankRead;

	@Override
	public AuthResult request(AuthParam request) {
		try {

            //1.生成绑卡请求号，
            String requestNo = UUID.randomUUID().toString();
            request.setRequestno(requestNo);
            //2.生成一条鉴权交易流水
            SpsChannelBankTrans authDealRecord = Converter.toDealRecord(request);
            //保存流水帐号
            bankTransWrite.insertBankTrans(authDealRecord);
            //LogUtil.info("易宝鉴权请求参数："+request.params());
            String res = HttpsUtil.post(request.getUrl(), request.params());
            System.out.println("易宝鉴权响应结果数据："+res);//打印返回参数
           // LogUtil.info("易宝鉴权响应结果数据："+res);
            AuthResult authResult = JSONObject.parseObject(res, AuthResult.class);

            if(authResult != null){
                //更新流水
                authDealRecord.setState(authResult.getStatus());
                authDealRecord.setSerialYop(authResult.getYborderid());
                authDealRecord.setBankCode(authResult.getBankcode());
                bankTransWrite.updateBankTrans(authDealRecord);
                if( AuthEnums.AuthStatus.BIND_SUCCESS.name().equals(authResult.getStatus())){
                    //添加绑卡信息
               	 bankWrite.insertBank(Converter.toBankCard(authResult));
                }
            }

            return authResult;
       } catch (Exception e) {
           e.printStackTrace();
       }
       return null;
	}
	/**
	 * 短信确认的实现类
	 */
	@Override
	public ConfirmResult confirm(ConfirmParam confirmParam) {
		try {
            SpsChannelBankTrans authDealRecord = bankTransRead.selectOne(confirmParam.getRequestno(), confirmParam.getYborderid());
            confirmParam.setMerchantno(authDealRecord.getMerchantNo());
           // LogUtil.info("易宝短信确认请求参数："+confirmParam.params());
            String res = HttpsUtil.post(confirmParam.getUrl(), confirmParam.params());
           // LogUtil.info("易宝短信确认响应结果："+res);
            ConfirmResult confirmResult = JSONObject.parseObject(res, ConfirmResult.class);
            if(confirmResult != null){

                authDealRecord.setState(confirmResult.getStatus());
                authDealRecord.setSerialYop(confirmResult.getYborderid());
                authDealRecord.setBankCode(confirmResult.getBankcode());
                if(authDealRecord.getSerialYop().equals(confirmResult.getYborderid())){
                    //若易宝流水号相同，则更新流水
                	bankTransWrite.updateBankTrans(authDealRecord);
                }else{
                    //若易宝流水号不同，则插入一条新的流水
                	bankTransWrite.insertBankTrans(authDealRecord);
                }
                if( AuthEnums.AuthStatus.BIND_SUCCESS.name().equals(confirmResult.getStatus())){
                    //添加绑卡信息 需注意：银行卡号，身份证号应该为唯一标志 防止重复插入多条数据
                	bankWrite.insertBank(Converter.toBankCard(confirmResult));
                }
            }
            return confirmResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	/**再次发短信的方法
	 * 
	 */
	@Override
	public ResendResult resend(ResendParam resendParam) {
		  try {
	            SpsChannelBankTrans authDealRecord = bankTransRead.selectOne(resendParam.getRequestno(), resendParam.getYborderid());
	            resendParam.setMerchantno(authDealRecord.getMerchantNo());
	            //LogUtil.info("易宝短信确认请求参数："+resendParam.params());
	            String res = HttpsUtil.post(resendParam.getUrl(), resendParam.params());
	           // LogUtil.info("易宝短信确认响应结果："+res);
	            ResendResult resendResult = JSONObject.parseObject(res, ResendResult.class);
	            if(resendResult != null){
	                authDealRecord.setState(resendResult.getStatus());
	                authDealRecord.setSerialYop(resendResult.getYborderid());
	                if(authDealRecord.getSerialYop().equals(resendResult.getYborderid())){
	                    //若易宝流水号相同，则更新流水
	                	bankTransWrite.updateBankTrans(authDealRecord);
	                }else{
	                    //若易宝流水号不同，则插入一条新的流水
	                	bankTransWrite.insertBankTrans(authDealRecord);
	                }
	            }
	            return resendResult;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	
}
