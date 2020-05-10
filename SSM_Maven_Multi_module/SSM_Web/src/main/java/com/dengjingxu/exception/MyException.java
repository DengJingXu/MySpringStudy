package com.dengjingxu.exception;

/**
 * @author: dengjingxu
 * @date: 2020/5/9
 * @description: com.dengjingxu.exception
 * @version: 1.0
 */
public class MyException extends Exception{
    private String msg;

    public MyException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
