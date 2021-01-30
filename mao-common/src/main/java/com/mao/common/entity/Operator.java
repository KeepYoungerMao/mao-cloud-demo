package com.mao.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 操作者
 * 记录一个操作数据的请求的客户端和账户
 * create by mzx at 2021/1/30 18:06
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Operator {

    private String client;      //客户端
    private String user;        //用户

}
