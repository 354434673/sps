package com.sps.common;

public class Result<T> {
    private final String ok="ok";
    private final String fail = "fail";
    private final String failMsg="系统异常";
    private String code;
    private String msg;
    private T body;

    public Result() {
        this.code = this.fail;
        this.msg = this.failMsg;
    }

    public Result(T body) {
        this.body = body;
        this.code = this.fail;
        this.msg = this.failMsg;
    }

    public String getCode() {
        return code;
    }
    public void success(){
        this.code = ok;
    }
    public void fail(){
        this.code = fail;
        this.msg = failMsg;
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

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getOk() {
        return ok;
    }

    public String getFail() {
        return fail;
    }
}

