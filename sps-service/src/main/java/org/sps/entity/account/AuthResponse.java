package org.sps.entity.account;

public class AuthResponse {
	    public class Error{
	        private String code;
	        private String solution;
	        private String message;

	        public String getCode() {
	            return code;
	        }

	        public void setCode(String code) {
	            this.code = code;
	        }

	        public String getSolution() {
	            return solution;
	        }

	        public void setSolution(String solution) {
	            this.solution = solution;
	        }

	        public String getMessage() {
	            return message;
	        }

	        public void setMessage(String message) {
	            this.message = message;
	        }
	    }
	    public class AuthResult{
	        private String merchantno	;   //商户编号
	        private String requestno  ;    //业务请求号
	        private String yborderid  ;     //易宝流水号
	        private String status     ;     //订单状态
	        private String state      ;     //订单状态
	        private Boolean issms     ;     //是否发送短验
	        private String bankcode   ;     //银行编码
	        private String smscode    ;     //短验码
	        private String codesender ;     //短验发送方
	        private String smstype    ;     //实际短验发送类型
	        private String authtype   ;     //鉴权类型
	        private String cardtop    ;     //卡号前六位
	        private String cardlast   ;     //卡号后四位
	        private String remark     ;     //备注
	        private String errorcode  ;     //错误码
	        private String errormsg   ;     //错误信息
	        private Error  error;
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

	        public String getYborderid() {
	            return yborderid;
	        }

	        public void setYborderid(String yborderid) {
	            this.yborderid = yborderid;
	        }

	        public String getStatus() {
	            return status;
	        }

	        public void setStatus(String status) {
	            this.status = status;
	        }

	        public String getState() {
	            return state;
	        }

	        public void setState(String state) {
	            this.state = state;
	        }

	        public Boolean getIssms() {
	            return issms;
	        }

	        public void setIssms(Boolean issms) {
	            this.issms = issms;
	        }

	        public Error getError() {
	            return error;
	        }

	        public void setError(Error error) {
	            this.error = error;
	        }

	        public String getBankcode() {
	            return bankcode;
	        }

	        public void setBankcode(String bankcode) {
	            this.bankcode = bankcode;
	        }

	        public String getSmscode() {
	            return smscode;
	        }

	        public void setSmscode(String smscode) {
	            this.smscode = smscode;
	        }

	        public String getCodesender() {
	            return codesender;
	        }

	        public void setCodesender(String codesender) {
	            this.codesender = codesender;
	        }

	        public String getSmstype() {
	            return smstype;
	        }

	        public void setSmstype(String smstype) {
	            this.smstype = smstype;
	        }

	        public String getAuthtype() {
	            return authtype;
	        }

	        public void setAuthtype(String authtype) {
	            this.authtype = authtype;
	        }

	        public String getCardtop() {
	            return cardtop;
	        }

	        public void setCardtop(String cardtop) {
	            this.cardtop = cardtop;
	        }

	        public String getCardlast() {
	            return cardlast;
	        }

	        public void setCardlast(String cardlast) {
	            this.cardlast = cardlast;
	        }

	        public String getRemark() {
	            return remark;
	        }

	        public void setRemark(String remark) {
	            this.remark = remark;
	        }

	        public String getErrorcode() {
	            return errorcode;
	        }

	        public void setErrorcode(String errorcode) {
	            this.errorcode = errorcode;
	        }

	        public String getErrormsg() {
	            return errormsg;
	        }

	        public void setErrormsg(String errormsg) {
	            this.errormsg = errormsg;
	        }
	    }
	    public class ConfirmResult{
	        private String merchantno; //商户编号
	        private String requestno ; //绑卡请求号
	        private String yborderid ; //易宝流水号
	        private String bankcode  ; //银行编码
	        private String cardtop   ; //卡号前六位
	        private String cardlast  ; //卡号后四位
	        private String status    ; //订单状态
	        private String errorcode  ;     //错误码
	        private String errormsg   ;     //错误信息
	        private Error  error;

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

	        public String getYborderid() {
	            return yborderid;
	        }

	        public void setYborderid(String yborderid) {
	            this.yborderid = yborderid;
	        }

	        public String getBankcode() {
	            return bankcode;
	        }

	        public void setBankcode(String bankcode) {
	            this.bankcode = bankcode;
	        }

	        public String getCardtop() {
	            return cardtop;
	        }

	        public void setCardtop(String cardtop) {
	            this.cardtop = cardtop;
	        }

	        public String getCardlast() {
	            return cardlast;
	        }

	        public void setCardlast(String cardlast) {
	            this.cardlast = cardlast;
	        }

	        public String getStatus() {
	            return status;
	        }

	        public void setStatus(String status) {
	            this.status = status;
	        }

	        public String getErrorcode() {
	            return errorcode;
	        }

	        public void setErrorcode(String errorcode) {
	            this.errorcode = errorcode;
	        }

	        public String getErrormsg() {
	            return errormsg;
	        }

	        public void setErrormsg(String errormsg) {
	            this.errormsg = errormsg;
	        }

	        public Error getError() {
	            return error;
	        }

	        public void setError(Error error) {
	            this.error = error;
	        }
	    }
	    public class ResendResult{
	        private String merchantno ;// 商户编号
	        private String requestno  ;// 绑卡请求号
	        private String yborderid  ;// 易宝流水号
	        private String status     ;// 订单状态
	        private String smscode    ;// 短验码
	        private String codesender ;// 实际短验发送方
	        private String errorcode  ;// 错误码
	        private String errormsg   ;// 错误信息
	        private Error  error;

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

	        public String getYborderid() {
	            return yborderid;
	        }

	        public void setYborderid(String yborderid) {
	            this.yborderid = yborderid;
	        }

	        public String getStatus() {
	            return status;
	        }

	        public void setStatus(String status) {
	            this.status = status;
	        }

	        public String getSmscode() {
	            return smscode;
	        }

	        public void setSmscode(String smscode) {
	            this.smscode = smscode;
	        }

	        public String getCodesender() {
	            return codesender;
	        }

	        public void setCodesender(String codesender) {
	            this.codesender = codesender;
	        }

	        public String getErrorcode() {
	            return errorcode;
	        }

	        public void setErrorcode(String errorcode) {
	            this.errorcode = errorcode;
	        }

	        public String getErrormsg() {
	            return errormsg;
	        }

	        public void setErrormsg(String errormsg) {
	            this.errormsg = errormsg;
	        }

	        public Error getError() {
	            return error;
	        }

	        public void setError(Error error) {
	            this.error = error;
	        }
	    }
}


