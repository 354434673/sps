package com.sps.service;


import com.sps.enums.ReturnCode;

/**
 * Service层公用的Exception.
 * 继承自RuntimeException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 */
public class ApiServiceException extends RuntimeException {

    private static final long serialVersionUID = 3583566093089790852L;

    private ReturnCode code;

    private String key;

    private String msg;

    public ApiServiceException(String key, String msg){
        this.key=key;
        this.msg=msg;
    }

    public ApiServiceException() {
        super();
    }

    public ApiServiceException(ReturnCode code) {
        super();
        this.code = code;
    }

    public ApiServiceException(String message) {
        super(message);
    }

    public ApiServiceException(Throwable cause) {
        super(cause);
    }

    public ApiServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReturnCode getCode() {
        return code;
    }

    public void setCode(ReturnCode code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
