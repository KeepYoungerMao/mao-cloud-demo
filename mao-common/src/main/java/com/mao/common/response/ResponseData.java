package com.mao.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 统一数据返回体
 * create by mzx at 2021/1/29 22:27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {

    private int code;               //响应码
    private String message;         //响应信息，与响应码对应
    private T data;                 //数据

}
