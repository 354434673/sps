package com.sps.common;


public class ReturnInfo {


    /**
     * 返回码 20:成功 30:程序异常 80:业务异常
     */
    String code;

    /**
     * 返回描述
     */
    String msg;

    /**
     * 详细信息，改对象可以是复杂的组合对象
     */
    Object result;

    String success;
    
	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }




}
