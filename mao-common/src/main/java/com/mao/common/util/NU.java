package com.mao.common.util;

import com.mao.common.ex.InvalidParamException;

/**
 * Number Utils
 * create by mzx at 2021/2/10 11:23
 */
public class NU {

    /**
     * 非正数
     */
    public static boolean isNotZs(Long n) {
        return null == n || n < 0;
    }

    /**
     * 字符串id转Long型id
     */
    public static Long parseId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 提取方法
     * 主键id校验
     */
    public static Long validId(String id) throws InvalidParamException {
        if (SU.isEmpty(id)) {
            throw new InvalidParamException("缺少主键标识");
        }
        Long tid = parseId(id);
        if (NU.isNotZs(tid)) {
            throw new InvalidParamException("非法主键标识");
        }
        return tid;
    }

}
