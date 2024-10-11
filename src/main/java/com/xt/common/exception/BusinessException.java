package com.xt.common.exception;

/**
 * @author hongxuanchai
 */
public class BusinessException extends RuntimeException {
    private int code;
    private String msg;

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = getMsg();
    }
    public BusinessException(Integer code,String msg) {
        super(msg);
        this.code = code;
        this.msg = getMsg();
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }

}