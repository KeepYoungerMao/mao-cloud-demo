package com.mao.common.util;

import java.util.*;

/**
 * String Utils
 * create by mzx at 2021/2/10 9:20
 */
public class SU {

    /**
     * Random随机类
     */
    private static final Random RANDOM = new Random();

    /**
     * 随机字符串生成使用的因子，包含数字和大小写字母
     * 只使用数字：10
     * 使用数字和字母：62
     * 使用全ASCII字符：94
     * 数字：0-9       10个
     * 字母：10-61     52个
     * 符号：62-93     32个
     */
    public static final char[] SEEDS = {
            '0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            '!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',
            ';','<','=','>','?','@','[','\\',']','^','_','`','{','|','}','~'
    };

    public static boolean isEmpty(String str) {
        return null == str || str.length() <= 0;
    }

    public static boolean isNotEmpty(String str) {
        return null != str && str.length() > 0;
    }

    /**
     * 判断是否全是数字
     */
    public static boolean isDigit(String str) {
        return str.matches("^[0-9]*$");
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成随机字符串
     * 随机因子为 数字和大小写字母 总数量：62
     * @param len 字符串长度
     * @return 随机字符串
     */
    public static String random(int len) {
        return random(len, 62, 0);
    }

    /**
     * 生成随机字符串
     * 随机因子为 数字 总数量：10
     * @param len 字符串长度
     * @return 随机字符串
     */
    public static String randomNumber(int len) {
        return random(len, 10, 0);
    }

    /**
     * 生成随机字符串
     * 随机因子为 大小写字母 总数量：52
     * @param len 字符串长度
     * @return 随机字符串
     */
    public static String randomChar(int len) {
        return random(len, 52, 10);
    }

    /**
     * 生成随机字符串
     * 随机因子为 数字、大小写字母、符号 总数量：94
     * @param len 字符串长度
     * @return 随机字符串
     */
    public static String randomAscii(int len) {
        return random(len, 94, 0);
    }

    /**
     * 生成随机字符串
     * 以本类中SEEDS字符数组为因子，根据起始点，取值范围来生成字符串。
     * @param len 字符串长度
     * @param bound 取值范围
     * @param start 起始位置
     * @return 随机字符串
     */
    private static String random(int len, int bound, int start) {
        if (len <= 0)
            return "";
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = SEEDS[RANDOM.nextInt(bound) + start];
        }
        return new String(chars);
    }

    /**
     * 字符拼接
     * 拼接迭代器类型
     * @param point 连接字符串
     * @param elements 拼接对象
     * @return 拼接后的字符串
     */
    public static String join(String point, Iterable<String> elements) {
        if (null == elements)
            return "";
        char[] pointChars = null == point ? new char[0] : point.toCharArray();
        char[] result = null;
        for (String element : elements) {
            result = joinChar(result, element, pointChars);
        }
        return null == result ? "" : new String(result);
    }

    /**
     * 字符拼接
     * 拼接字符串数组
     * @param point 连接字符串
     * @param elements 拼接对象
     * @return 拼接后的字符串
     */
    public static String join(String point, String[] elements) {
        if (null == elements)
            return "";
        char[] result = null;
        char[] pointChars = null == point ? new char[0] : point.toCharArray();
        for (String element : elements) {
            result = joinChar(result, element, pointChars);
        }
        return null == result ? "" : new String(result);
    }

    /**
     * 字符拼接
     * 提取方法
     * @param result 上一次拼接字符集
     * @param element 此次需要拼接的字符串
     * @param pointChars 连接字符集
     * @return 拼接后的字符集
     */
    private static char[] joinChar(char[] result, String element, char[] pointChars) {
        char[] elementChars = null == element ? new char[0] : element.toCharArray();
        char[] newValue;
        if (null == result) {
            //初次拼接，copy此次拼接字符串至新的字符集
            newValue = new char[elementChars.length];
            System.arraycopy(elementChars, 0, newValue, 0, elementChars.length);
        } else {
            //非初次拼接，依次copy 上一次拼接字符集、连接字符集、此次拼接字符串 至新的字符集
            newValue = new char[result.length + pointChars.length + elementChars.length];
            System.arraycopy(result, 0, newValue, 0, result.length);
            if (pointChars.length > 0) {
                System.arraycopy(pointChars, 0, newValue, result.length, pointChars.length);
            }
            if (elementChars.length > 0) {
                System.arraycopy(elementChars, 0, newValue,
                        result.length + pointChars.length, elementChars.length);
            }
        }
        return newValue;
    }

    /**
     * 字符拆分
     * @param data 需要拆分的字符
     * @param split 分割字符
     * @return Set集合
     */
    public static Set<String> unJoin(String data, String split) {
        Set<String> set = new HashSet<>();
        if (isEmpty(split) || isEmpty(data)) {
            return set;
        }
        if (data.contains(split)) {
            set.addAll(Arrays.asList(data.split(split)));
        } else {
            set.add(data);
        }
        return set;
    }

    /**
     * 打印成功标识
     */
    public static void pfSuccess(String service) {
        System.out.println(" ___ _   _  ___ ___ ___  ___ ___ \n" +
                "/ __| | | |/ __/ __/ _ \\/ __/ __|\n" +
                "\\__ \\ |_| | (_| (_|  __/\\__ \\__ \\\n" +
                "|___/\\__,_|\\___\\___\\___||___/___/\n" +
                "|-- " + service + " start success --|");
    }

    public static void main(String[] args) {
        pfSuccess("mao-data-api");
    }

}
