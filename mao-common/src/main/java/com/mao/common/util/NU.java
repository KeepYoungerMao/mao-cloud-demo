package com.mao.common.util;

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

}
