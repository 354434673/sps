package org.sps.entity.account;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.sps.entity.merchant.SpsChannelBank;

public class AuthRequest  implements Serializable{
	    public interface UrlType{
	        public String auth = "https://open.yeepay.com/yop-center/rest/v1.0/paperorder/unified/auth/request";
	        public String confirm ="https://open.yeepay.com/yop-center/rest/v1.0/paperorder/auth/confirm";
	        public String resend = "https://open.yeepay.com/yop-center/rest/v1.0/paperorder/auth/resend";
	        public String query = "https://open.yeepay.com/yop-center/rest/v1.0/paperorder/auth/query";
	        public String lsit = "https://open.yeepay.com/yop-center/rest/v1.0/paperorder/auth/bindcard/list";
	    }
	    public static class CommonParam implements Serializable{
	        private String url ;
	        private String merchantno; //商户编号
	        private String requestno; //业务请求号
	        private String loginName;
	        private String userId;
	        private String yborderid;

	        public String getYborderid() {
	            return yborderid;
	        }

	        public void setYborderid(String yborderid) {
	            this.yborderid = yborderid;
	        }
	        public String getLoginName() {
				return loginName;
			}

			public void setLoginName(String loginName) {
				this.loginName = loginName;
			}

			public String getUserId() {
	            return userId;
	        }

	        public void setUserId(String userId) {
	            this.userId = userId;
	        }

	        public String getUrl() {
	            return url;
	        }

	        public void setUrl(String url) {
	            this.url = url;
	        }

	        public String getMerchantno() {
	            return merchantno;
	        }

	        public void setMerchantno(String merchantno) {
	            this.merchantno = merchantno;
	        }

	        public String getRequestno() {
	            return requestno;
	        }

	        public void setRequestno(String requestno) {
	            this.requestno = requestno;
	        }
	    }
	    public static  class AuthParam extends CommonParam implements Serializable{
	        private String identityid;//用户标识
	        private String identitytype;//用户标识类型
	        private String cardno;//卡号
	        private String idcardno;//证件号
	        private String idcardtype="ID";//证件类型
	        private String username;//用户真实姓名
	        private String phone;//手机号
	        private Boolean issms=true;//是否发短信
	        private String advicesmstype="MESSAGE";//建议短验发送类型
	        private String avaliabletime;//绑卡订单有效期
	        private String callbackurl;//回调地址
	        private String requesttime;//请求时间
	        private String authtype="COMMON_FOUR";//鉴权类型
	        private String bankName;//暂时无用

	        public AuthParam() {
	            super.url=UrlType.auth;
	        }

	        public AuthParam(SpsChannelBank bankInfo){
	            super.url=UrlType.auth;
	            this.username = bankInfo.getName();
	            this.phone = bankInfo.getPhone();
	            this.idcardno = bankInfo.getIdentity();
	            this.cardno = bankInfo.getAccounts();
	            this.identitytype = AuthEnums.IdentifyType.USER_ID.getValue();
	        }

	        public Map<String,String> params(){
	            Map<String,String> params = new HashMap<String,String>();
	            params.put("merchantno",super.merchantno);
	            params.put("requestno",super.requestno);
	            params.put("identityid",identityid);
	            params.put("identitytype",identitytype);
	            params.put("cardno",cardno);
	            params.put("idcardno",idcardno);
	            params.put("idcardtype",idcardtype);
	            params.put("username",username);
	            params.put("phone",phone);
	            params.put("issms",issms.toString());
	            params.put("advicesmstype",advicesmstype);
	            params.put("avaliabletime",avaliabletime);
	            params.put("callbackurl",callbackurl);
	            params.put("requesttime",requesttime);
	            params.put("authtype",authtype);
	            return params;
	        }

	        public String getBankName() {
	            return bankName;
	        }

	        public void setBankName(String bankName) {
	            this.bankName = bankName;
	        }

	        public String getIdentityid() {
	            return identityid;
	        }

	        public void setIdentityid(String identityid) {
	            this.identityid = identityid;
	        }

	        public String getIdentitytype() {
	            return identitytype;
	        }

	        public void setIdentitytype(String identitytype) {
	            this.identitytype = identitytype;
	        }

	        public String getCardno() {
	            return cardno;
	        }

	        public void setCardno(String cardno) {
	            this.cardno = cardno;
	        }

	        public String getIdcardno() {
	            return idcardno;
	        }

	        public void setIdcardno(String idcardno) {
	            this.idcardno = idcardno;
	        }

	        public String getIdcardtype() {
	            return idcardtype;
	        }

	        public void setIdcardtype(String idcardtype) {
	            this.idcardtype = idcardtype;
	        }

	        public String getUsername() {
	            return username;
	        }

	        public void setUsername(String username) {
	            this.username = username;
	        }

	        public String getPhone() {
	            return phone;
	        }

	        public void setPhone(String phone) {
	            this.phone = phone;
	        }

	        public Boolean getIssms() {
	            return issms;
	        }

	        public void setIssms(Boolean issms) {
	            this.issms = issms;
	        }

	        public String getAdvicesmstype() {
	            return advicesmstype;
	        }

	        public void setAdvicesmstype(String advicesmstype) {
	            this.advicesmstype = advicesmstype;
	        }

	        public String getAvaliabletime() {
	            return avaliabletime;
	        }

	        public void setAvaliabletime(String avaliabletime) {
	            this.avaliabletime = avaliabletime;
	        }

	        public String getCallbackurl() {
	            return callbackurl;
	        }

	        public void setCallbackurl(String callbackurl) {
	            this.callbackurl = callbackurl;
	        }

	        public String getRequesttime() {
	            return requesttime;
	        }

	        public void setRequesttime(String requesttime) {
	            this.requesttime = requesttime;
	        }

	        public String getAuthtype() {
	            return authtype;
	        }

	        public void setAuthtype(String authtype) {
	            this.authtype = authtype;
	        }
	    }
	    public static class ConfirmParam extends CommonParam implements Serializable{
	        private String validatecode;

	        public ConfirmParam() {
	            super.url=UrlType.confirm;
	        }
	        public ConfirmParam(String validatecode) {
	            super.url=UrlType.confirm;
	            this.validatecode = validatecode;
	        }
	        public Map<String,String> params(){
	            Map<String, String> params = new HashMap<String,String>();
	            params.put("merchantno",super.merchantno);
	            params.put("requestno",super.requestno);
	            params.put("validatecode",this.validatecode);
	            return params;
	        }

	        public String getValidatecode() {
	            return validatecode;
	        }

	        public void setValidatecode(String validatecode) {
	            this.validatecode = validatecode;
	        }
	    }
	    public static class queryParam extends CommonParam implements Serializable{
	        private String yborderid;

	        public queryParam() {
	            super.url = UrlType.query;
	        }
	        public Map<String,String> params(){
	            Map<String, String> params = new HashMap<String,String>();
	            params.put("merchantno",super.merchantno);
	            params.put("requestno",super.requestno);
	            return params;
	        }
	    }
	    public static class ResendParam extends  CommonParam implements Serializable{
	        private String advicesmstype = "MESSAGE";

	        public ResendParam() {
	            super.url = UrlType.resend;

	        }

	        public ResendParam(String advicesmstype) {
	            super.url = UrlType.resend;
	            this.advicesmstype = advicesmstype;
	        }
	        public Map<String,String> params(){
	            Map<String, String> params = new HashMap<String,String>();
	            params.put("merchantno",super.merchantno);
	            params.put("requestno",super.requestno);
	            params.put("advicesmstype",this.advicesmstype);
	            return params;
	        }

	        public String getAdvicesmstype() {
	            return advicesmstype;
	        }

	        public void setAdvicesmstype(String advicesmstype) {
	            this.advicesmstype = advicesmstype;
	        }
	    }





	

}
