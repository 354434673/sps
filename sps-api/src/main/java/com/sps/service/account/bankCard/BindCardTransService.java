package com.sps.service.account.bankCard;

import com.sps.entity.account.BankCardInfo;
import com.sps.entity.account.BindBankTrans;

import java.util.HashMap;

/**
 * Created by Administrator on 2018-03-21.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.// TODO: 2018/4/8  请求核心，发起提现申请
            //封装请求参数
            SpsBank bank = bankService.findEntityByNo(customerId);
            Map map = new HashMap<>();
            map.put("amount", amount);
            map.put("application", "dianfu");
            map.put("certNo", bank.getbIdentity());
            map.put("logType", "020");
            log.info("ing--请求核心提现接口，请求参数"+JSON.toJSONString(map));
            //请求核心发起提现操作
            String jsonResult = HttpClientUtils.post(freezeCustomerAccount, map);
            //核心返回参数
            log.info("ing--请求核心提现接口，返回参数"+ jsonResult);
            if (StringUtils.isBlank(jsonResult)){
                return returnFaild();
            }
            JSONObject job = JSON.parseObject(jsonResult);
            if (!"100000".equals(job.getString("code"))) {
                return returnFaild(job.getString("msg"));
            }
            // TODO: 2018/4/8  请求核心提现申请成功后，请求支付系统
            // 支付系统回调店付  true/调用核心 扣减金额接口，false/调用核心 按身份证号解冻账户金额 解冻用户金额
            //   待ing 开发


            // TODO: 2018/4/8  请求核心获取账户余额
            //获取用户核心余额
            BigDecimal big = new BigDecimal(0.00);
            map = new HashMap<>();
            map.put("application","dianfu");
            map.put("certNo",bank.getbIdentity());
            String userAmountJson = HttpClientUtils.post(getUserAmont, map);
            if (!StringUtils.isBlank(userAmountJson)){
                JSONObject jobs = JSON.parseObject(jsonResult);
                if ("100000".equals(job.getString("code"))) {
                    big = new BigDecimal(job.getJSONObject("result").getString("validAmount"));
                }
            }
            //插入数据库用户请求
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface BindCardTransService {

	/**
     * 删除交易记录信息
	 */
    void  removeBankInfo(String serialSh, String serialYop);

	/**
     * 根据页面绑卡记录 保存绑卡交易信息
	 *
     */
    HashMap<String,Object> saveBankTansInfos(BindBankTrans  bankCardInfo);

	/**
            * 根据请求号更新绑卡记录表
	 * @param seriNum
	 * @param yopSerNO
	 * @param status
	 * @return
     */
    Boolean  modifyBankTran(String seriNum, String yopSerNO, String status,String cardtop,String  cardlast, String authtype,String remark);

	/***
	 * 根据请求好与易宝号进行查询
	 * @param requestNo
	 * @param yborderid
	 * @return
     */
    BindBankTrans findBankState(String requestNo, String yborderid);
}
