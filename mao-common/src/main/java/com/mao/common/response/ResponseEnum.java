package com.mao.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应类型
 * create by mzx at 2021/1/29 22:29
 */
@Getter
@AllArgsConstructor
public enum ResponseEnum {

    /**
     * 成功响应
     */
    OK(200),

    /**
     * 错误请求
     * 原HTTP状态为：语法错误，服务器未能理解请求
     * 此状态包含除401，403，404，405，408之外的所有客户端错误
     */
    BAD_REQUEST(400),

    /**
     * 禁止访问，客户端身份验证失败
     */
    UNAUTHORIZED(401),

    /**
     * 禁止访问，客户端授权失败
     */
    FORBIDDEN(403),

    /**
     * 客户端访问的资源不存在
     */
    NOT_FOUND(404),

    /**
     * 客户端的HTTP请求方法不被允许
     */
    METHOD_NOT_ALLOWED(405),

    /**
     * 请求超出了服务器的等待时间
     */
    REQUEST_TIMEOUT(408),

    /**
     * 服务器错误
     * 该状态包括了除502之外的所有服务器错误
     */
    ERROR(500),

    /**
     * 网关错误或网关超时
     * 网管代理服务器未能从上一个服务器得到响应
     */
    BAD_GATEWAY(502),

    /**
     * 自定义错误类型
     * 参数错误，指查询数据时传递的查询参数错误
     */
    PARAM_ERROR(5001),

    /**
     * 自定义错误类型
     * 数据错误，指数据更新、新增的请求数据错误
     */
    DATA_ERROR(5002),

    /**
     * 自定义错误类型
     * 数据库错误，指数据更新、新增至数据库时，数据库所发生的错误
     */
    DATABASE_ERROR(5003);

    /**
     * 响应码，响应码与每个枚举类是唯一对应关系，不可修改
     * 因此使用final修饰，禁止set
     */
    private final int code;

}
