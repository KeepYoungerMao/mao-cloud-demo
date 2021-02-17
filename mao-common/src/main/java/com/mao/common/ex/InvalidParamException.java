package com.mao.common.ex;

/**
 * 参数错误异常
 * 用于参数校验错误时抛出异常
 * create by mzx at 2021/2/17 15:00
 */
public class InvalidParamException extends Exception {

    public InvalidParamException(String message) {
        super(message);
    }

}
