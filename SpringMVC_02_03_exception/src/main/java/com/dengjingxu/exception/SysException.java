package com.dengjingxu.exception;

/**
 * @author: dengjingxu
 * @date: 2020/5/5
 * @description: com.dengjingxu.exception
 * @version: 1.0
 */
public class SysException extends Exception {

    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
