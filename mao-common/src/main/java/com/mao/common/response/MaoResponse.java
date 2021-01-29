package com.mao.common.response;

/**
 * 统一数据返回体构建类
 * 根据相应类别返回不同格式数据
 * @see ResponseEnum 响应类别
 * create by mzx at 2021/1/29 22:27
 */
public abstract class MaoResponse {

    public <T> ResponseData<T> ok(T data) {
        return response(ResponseEnum.OK, data);
    }

    public ResponseData<String> badRequest(String message) {
        return response(ResponseEnum.BAD_REQUEST, message);
    }

    public ResponseData<String> unauthorized(String message) {
        return response(ResponseEnum.UNAUTHORIZED, message);
    }

    public ResponseData<String> forbidden(String message) {
        return response(ResponseEnum.FORBIDDEN, message);
    }

    public ResponseData<String> notFound(String message) {
        return response(ResponseEnum.NOT_FOUND, message);
    }

    public ResponseData<String> methodNotAllowed(String message) {
        return response(ResponseEnum.METHOD_NOT_ALLOWED, message);
    }

    public ResponseData<String> requestTimeout(String message) {
        return response(ResponseEnum.REQUEST_TIMEOUT, message);
    }

    public ResponseData<String> error(String message) {
        return response(ResponseEnum.ERROR, message);
    }

    public ResponseData<String> badGateway(String message) {
        return response(ResponseEnum.BAD_GATEWAY, message);
    }

    public ResponseData<String> paramError(String message) {
        return response(ResponseEnum.PARAM_ERROR, message);
    }

    public ResponseData<String> dataError(String message) {
        return response(ResponseEnum.DATA_ERROR, message);
    }

    public ResponseData<String> databaseError(String message) {
        return response(ResponseEnum.DATABASE_ERROR, message);
    }

    public <T> ResponseData<T> response(ResponseEnum type, T data) {
        return new ResponseData<>(type.getCode(), type.name(), data);
    }

}
