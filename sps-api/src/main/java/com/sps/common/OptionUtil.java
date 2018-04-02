package com.sps.common;
/**
 * 规定
 * @ClassName:  OptionUtil   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年3月23日 下午3:31:23
 */
public class OptionUtil {
	/**
	 * 婚姻状况
	 */
	public static final String MARITAL_STATUS_MARRIED= "1";//已婚
	
	public static final String MARITAL_STATUS_SPINSTERHOOD = "2";//未婚
	
	public static final String MARITAL_STATUS_DIVORCED = "3";//
	/**
	 * 居住情况
	 */
	public static final String LIVE_OWN = "1";//自有
	
	public static final String LIVE_FAMILY = "2";//父母同住
	
	public static final String LIVE_LEASE = "3";//租赁
	
	public static final String LIVE_OTHER = "4";//其他
	/**
	 * 双方关系
	 */
	public static final String RELATIONLIVE_PARENT = "1";//父母
	
	public static final String RELATIONLIVE_MATE = "2";//配偶
	
	public static final String RELATIONLIVE_CHILDREN = "3";//子女
	
	public static final String RELATIONLIVE_CALLEAGUE = "4";//同事
	
	public static final String RELATIONLIVE_FRIEND = "5";//朋友
	/**
	 * 经营地所有权 business_addr
	 */
	public static final String BUSINESS_OWN = "1";//自有
	
	public static final String BUSINESS_LEASE = "2";//租赁
	/**
	 * 经营模式 business
	 */
	public static final String BUSINESS_MONOPOLY  = "1";//专卖
	
	public static final String BUSINESS_BLEND = "2";//混合经营
	/**
	 * 号牌种类 car_brand
	 */
	public static final String CAR_BRAND_SMAIL = "1";//小型车
	
	public static final String CAR_BRAND_BIG = "2";//大型车
	
	/*
	 * 状态(
		1邀请中：核心商户或业务员录入店主信息，发送请至店主
		2待激活：店主已注册未提交认证信息
		3运营审核中：店主提交认证信息后，运营审核中
		4运营审核不通过：店主提交认证信息后，运营审不通
		5风控审核中：运营审核通过后，风控审核中
		6风控审核不通过：风控审核不通过
		7已激活：风控审核通过
		8冻结：运营修改店主状态
		)
	 */
}
