package com.mao.common.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Time Utils
 * create by mzx at 2021/2/17 15:45
 */
public class TU {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String MINUTE_FORMAT = "HH:mm";
    private static final String WEEK_FORMAT = "E";

    /**
     * 返回当前时间字符串
     * 返回格式参照 DATETIME_FORMAT
     * @return 时间字符串
     */
    public static String show() {
        return show(LocalDateTime.now(), DATETIME_FORMAT);
    }

    /**
     * 时间戳转化为时间字符串
     * 返回格式参照 DATETIME_FORMAT
     * 传递错误的时间戳发生的异常自行解决
     * 本方法使用的是LocalDateTime转化时间戳，
     * 如果传递负数值，则将按照0计算，返回起始时间戳计数点：1970-01-01 00:00:00
     * @param timestamp 时间戳
     * @return 时间字符串
     */
    public static String show(long timestamp) {
        return show(localDateTime(timestamp), DATETIME_FORMAT);
    }

    /**
     * 时间戳转化为时间字符串
     * 自定义返回格式
     * 传递错误的时间戳发生的异常自行解决
     * 本方法使用的是LocalDateTime转化时间戳，
     * 如果传递负数值，则将按照0计算，返回起始时间戳计数点：1970-01-01 00:00:00
     * 传递不规范的时间模板发生的异常自行解决
     * @param timestamp 时间戳
     * @param format 时间格式模板
     * @return 时间字符串
     */
    public static String show(long timestamp, String format) {
        return show(localDateTime(timestamp), format);
    }

    /**
     * 日期类型转化为时间字符串
     * 本方法使用内置时间模板 DATETIME_FORMAT 进行转化
     * @param date 时间
     * @return 时间字符串
     */
    public static String show(Date date) {
        return show(date, DATETIME_FORMAT);
    }

    /**
     * 时间类型转化为时间字符串
     * 自定义时间模板
     * 传递不规范的时间模板发生的异常自行解决
     * @param date 时间
     * @param format 时间模板
     * @return 时间字符串
     */
    public static String show(Date date, String format) {
        if (null == date)
            return null;
        return show(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(), format);
    }

    /**
     * LocalDateTime类型转化为时间字符串
     * 本方法使用内置时间模板 DATETIME_FORMAT 进行转化
     * @param localDateTime LocalDateTime时间类
     * @return 时间字符串
     */
    public static String show(LocalDateTime localDateTime) {
        return show(localDateTime, DATETIME_FORMAT);
    }

    /**
     * LocalDateTime类型转化为时间字符串
     * 自定义时间模板
     * 如果LocalDateTime参数为null，则返回null值
     * 如果时间模板参数为空，则使用内置时间模板 DATETIME_FORMAT
     * 传递不规范的时间模板发生的异常自行解决
     * @param localDateTime LocalDateTime时间类
     * @param format 时间模板
     * @return 时间字符串
     */
    public static String show(LocalDateTime localDateTime, String format) {
        if (null == localDateTime)
            return null;
        if (empty(format))
            format = DATETIME_FORMAT;
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * LocalDate类型转化为日期字符串
     * 本方法使用内置时间模板 DATE_FORMAT 进行转化
     * @param localDate LocalDate日期类
     * @return 日期字符串
     */
    public static String show(LocalDate localDate) {
        return show(localDate, DATE_FORMAT);
    }

    /**
     * LocalDate类型转化为日期字符串
     * 自定义日期模板
     * 如果LocalDate日期类为null，则返回null值
     * 如果日期模板参数为空，则使用内置日期模板
     * 传递不规范的时间模板发生的异常自行解决
     * @param localDate LocalDate日期类
     * @param format 日期模板
     * @return 日期字符串
     */
    public static String show(LocalDate localDate, String format) {
        if (null == localDate)
            return null;
        if (empty(format))
            format = DATE_FORMAT;
        return localDate.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * LocalTime类型转化为时间字符串
     * 使用内置时间模板 TIME_FORMAT 进行转化
     * @param localTime LocalTime时间类
     * @return 时间字符串
     */
    public static String show(LocalTime localTime) {
        return show(localTime, TIME_FORMAT);
    }

    /**
     * LocalTime类型转化为时间字符串
     * 自定义日期模板
     * 如果LocateTime时间类参数为null，则返回null值。
     * 如果时间模板参数为空，则使用内置时间模板
     * 传递不规范的时间模板发生的异常自行解决
     * @param localTime LocateTime时间类
     * @param format 时间模板
     * @return 时间字符串
     */
    public static String show(LocalTime localTime, String format) {
        if (null == localTime)
            return null;
        if (empty(format))
            format = TIME_FORMAT;
        return localTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 返回当前时间Date类
     * @return Date
     */
    public static Date date() {
        return new Date();
    }

    /**
     * 时间戳转化为时间Date类
     * @param timestamp 时间戳
     * @return Date
     */
    public static Date date(long timestamp) {
        return new Date(timestamp);
    }

    /**
     * 时间字符串转化为Date时间类
     * 使用内置时间模板 DATETIME_FORMAT
     * 时间字符串不正确会转化失败，异常自行解决
     * @param date 时间字符串
     * @return Date
     */
    public static Date date(String date) {
        return date(date, DATETIME_FORMAT);
    }

    /**
     * 时间字符串转化为Date时间类
     * 自定义时间模板
     * @param date 时间字符串
     * @param format 时间模板
     * @return Date
     */
    public static Date date(String date, String format) {
        return date(localDateTime(date, format));
    }

    /**
     * LocalDateTime时间类转化为Date时间类
     * @param localDateTime LocalDateTime
     * @return Date
     */
    public static Date date(LocalDateTime localDateTime) {
        if (null == localDateTime)
            return null;
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate日期类转化为Date时间类
     * 先转化为LocalDateTime时间类，在时间部分上取零点，再转化为Date时间类
     * @param localDate LocalDateTime
     * @return Date
     */
    public static Date date(LocalDate localDate) {
        return date(localDateTime(localDate));
    }

    /**
     * 获取时间戳
     * 返回当前时间
     * @return 时间戳
     */
    public static long timestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Date时间类转化为时间戳
     * @param date Date时间类
     * @return 时间戳
     */
    public static long timestamp(Date date) {
        return date.getTime();
    }

    /**
     * 时间字符串转化为时间戳
     * 此方法接收标准日期时间模板字符串
     * 参照DATETIME_FORMAT
     * @param date 时间字符串
     * @return 时间戳
     */
    public static long timestamp(String date) {
        return timestamp(localDateTime(date));
    }

    /**
     * 时间字符串转化为时间戳
     * 时间字符串依照传递的时间日期模板
     * 必须含有日期，否则会转化失败
     * @param date 时间字符串
     * @param format 日期时间模板
     * @return 时间戳
     */
    public static long timestamp(String date, String format) {
        return timestamp(localDateTime(date, format));
    }

    /**
     * LocalDate日期类转化为时间戳
     * 设定时间为0时0分0秒
     * @param localDate LocalDate日期类
     * @return 时间戳
     */
    public static long timestamp(LocalDate localDate) {
        return timestamp(localDateTime(localDate));
    }

    /**
     * LocalDateTime日期时间类转化为时间戳
     * @param localDateTime LocalDateTime日期时间类
     * @return 时间戳
     */
    public static long timestamp(LocalDateTime localDateTime) {
        if (null == localDateTime)
            return -1;
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * 返回LocalDateTime时间类。当前时间
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 时间字符串转化为LocalDateTime时间类
     * 使用内置时间模板 DATETIME_FORMAT
     * @param date 时间字符串
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTime(String date) {
        return localDateTime(date, DATETIME_FORMAT);
    }

    /**
     * 时间字符串转化为LocalDateTime时间类
     * 使用自定义模板
     * 如果时间模板参数为空，则使用内置时间模板
     * @param date 时间字符串
     * @param format 时间模板
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTime(String date, String format) {
        if (empty(date))
            return null;
        if (empty(format))
            format = DATETIME_FORMAT;
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * 时间戳转化为LocalDateTime时间类
     * 毫秒级时间戳
     * @param timestamp 时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTime(long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp/1000, 0, ZoneOffset.ofHours(8));
    }

    /**
     * Date时间类转化为LocalDateTime时间类
     * 与时间戳转化一样
     * @param date Date时间类
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTime(Date date) {
        if (null == date)
            return null;
        return localDateTime(date.getTime());
    }

    /**
     * LocalDate日期类转化为LocalDateTime时间类
     * @param localDate LocalDate日期类
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTime(LocalDate localDate) {
        if (null == localDate)
            return null;
        return localDate.atTime(0, 0, 0);
    }

    /**
     * 返回当前日期的LocalDate日期类
     * @return LocalDate
     */
    public static LocalDate localDate() {
        return LocalDate.now();
    }

    /**
     * 日期字符串转化为LocalDate日期类
     * 使用内置 DATE_FORMAT 日期模板
     * @param date 日期字符串
     * @return LocalDate
     */
    public static LocalDate localDate(String date) {
        return localDate(date, DATE_FORMAT);
    }

    /**
     * 日期字符串转化为LocalDate日期类
     * @param date 日期字符串
     * @param format 日期模板
     * @return LocalDate
     */
    public static LocalDate localDate(String date, String format) {
        if (empty(date))
            return null;
        if (empty(format))
            format = DATE_FORMAT;
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * Date时间类转化为LocalDate日期类
     * 使用LocalDateTime转化后再转化为LocalDate日期类
     * @param date Date时间类
     * @return LocalDate
     */
    public static LocalDate localDate(Date date) {
        return localDateTime(date).toLocalDate();
    }

    /**
     * 时间戳转化为LocalDate日期类
     * 先转化为LocalDateTime再转化为LocalDate日期类
     * @param timestamp 时间戳
     * @return LocalDate
     */
    public static LocalDate localDate(long timestamp) {
        return localDateTime(timestamp).toLocalDate();
    }

    /**
     * LocalDateTime时间类转化为LocalDate日期类
     * 使用原方法
     * @param localDateTime LocalDateTime
     * @return LocalDate
     */
    public static LocalDate localDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    /**
     * 返回现在时间的LocalTime时间类
     * @return LocalTime
     */
    public static LocalTime localTime() {
        return LocalTime.now();
    }

    /**
     * Date时间类转化为LocalTime时间类
     * 先转化为LocalDateTime再转化为LocalTime时间类
     * @param date Date时间类
     * @return LocalTime
     */
    public static LocalTime localTime(Date date) {
        return localDateTime(date).toLocalTime();
    }

    /**
     * 时间戳转化为LocalTime时间类
     * 先转化为LocalDateTime再转化为LocalTime时间类
     * @param timestamp 时间戳
     * @return LocalTime
     */
    public static LocalTime localTime(long timestamp) {
        return localDateTime(timestamp).toLocalTime();
    }

    /**
     * 时间字符串转化为LocalTime时间类
     * 使用内置时间模板 TIME_FORMAT
     * @param time 时间字符串
     * @return LocalTime
     */
    public static LocalTime localTime(String time) {
        return localTime(time, TIME_FORMAT);
    }

    /**
     * 时间字符串转化为LocalTime时间类
     * 自定义时间模板
     * @param time 时间字符串
     * @param format 时间模板
     * @return LocalTime
     */
    public static LocalTime localTime(String time, String format) {
        if (empty(time))
            return null;
        if (empty(format))
            format = TIME_FORMAT;
        return LocalTime.parse(time, DateTimeFormatter.ofPattern(format));
    }

    /**
     * LocalDateTime时间类转化为LocalTime时间类
     * 使用原方法
     * @param localDateTime LocalDateTime
     * @return LocalTime
     */
    public static LocalTime localTime(LocalDateTime localDateTime) {
        if (null == localDateTime)
            return null;
        return localDateTime.toLocalTime();
    }

    /**
     * 将时间字符串转化为时间移位值，用作储存
     * 与 intToMinute 方法对应
     * 时间精确到分
     * 示例： 08:21  --->   2069
     * @param minute 时间字符串
     * @return 时间移位值
     */
    public static Integer minuteToInt(String minute) {
        if (empty(minute))
            return null;
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(minute, DateTimeFormatter.ofPattern(MINUTE_FORMAT));
        } catch (Exception e) {
            return null;
        }
        return (localTime.getHour() << 8) + localTime.getMinute();
    }

    /**
     * 将时间移位值转化为时间字符串
     * 与 minuteToInt 方法对应
     * 时间精确到分
     * 示例： 2069  --->   08:21
     * @param time 时间移位值
     * @return 时间字符串
     */
    public static String intToMinute(Integer time) {
        if (null == time)
            return null;
        return add0((time & 0x0000ffff) >> 8) + ":" + add0(time & 0x000000ff);
    }

    /**
     * 将时间字符串转化为时间移位值，用作储存
     * 与 intToSecond 方法对应
     * 时间精确到秒
     * 示例 01:59:59  ---> 80699
     * @param second 时间字符串
     * @return 时间移位值
     */
    public static Integer secondToInt(String second) {
        if (empty(second))
            return null;
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(second, DateTimeFormatter.ofPattern(TIME_FORMAT));
        } catch (Exception e) {
            return null;
        }
        return (localTime.getHour() << 16) + (localTime.getMinute() << 8) + localTime.getSecond();
    }

    /**
     * 将时间移位值转化为时间字符串
     * 与 secondToInt 方法对应
     * 时间精确到秒
     * 示例 80699  --->  01:59:59
     * @param time 时间移位值
     * @return 时间字符串
     */
    public static String intToSecond(Integer time) {
        if (null == time)
            return null;
        return add0((time & 0x00ffffff) >> 16) + ":"
                + add0((time & 0x0000ffff) >> 8) + ":"
                + add0(time & 0x000000ff);
    }

    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return boolean
     */
    private static boolean empty(String str) {
        return null == str || str.length() <= 0;
    }

    /**
     * 补0操作
     * 可对时、分、秒、日、月 进行补零
     * @param anInt 值
     * @return 补0后的字符串
     */
    public static String add0(int anInt) {
        return anInt < 10 ? "0" + anInt : "" + anInt;
    }

    /**
     * 返回当前日期字符串
     * 返回格式参见DATE_FORMAT
     * @return 当前日期字符串
     */
    public static String showDate() {
        return show(localDate(), DATE_FORMAT);
    }

    /**
     * 返回当前时间字符串
     * 返回格式参见TIME_FORMAT
     * @return 当前时间字符串
     */
    public static String showTime() {
        return show(localTime(), TIME_FORMAT);
    }

    /**
     * 返回当前时间为星期几
     * 如返回：星期一
     * @return 星期
     */
    public static String showWeek() {
        return show(localDate(), WEEK_FORMAT);
    }

    /**
     * 根据Date时间类返回当前时间星期几
     * 如返回：星期一
     * @param date Date时间类
     * @return 星期
     */
    public static String showWeek(Date date) {
        return show(localDate(date), WEEK_FORMAT);
    }

    /**
     * 根据时间戳返回当前时间星期几
     * 如返回：星期一
     * @param timestamp 13位时间戳
     * @return 星期
     */
    public static String showWeek(long timestamp) {
        return show(localDate(timestamp), WEEK_FORMAT);
    }

    /**
     * 根据LocalDate日期类返回当前时间星期几
     * 如返回：星期一
     * @param localDate LocalDate日期类
     * @return 星期
     */
    public static String showWeek(LocalDate localDate) {
        return show(localDate, WEEK_FORMAT);
    }

    /**
     * 根据LocalDateTime日期时间类返回当前时间星期几
     * 如返回：星期一
     * @param localDateTime LocalDateTime日期时间类
     * @return 星期
     */
    public static String showWeek(LocalDateTime localDateTime) {
        return show(localDate(localDateTime), WEEK_FORMAT);
    }

    /**
     * 当前时间加上时间值
     * 默认以秒为单位
     * 返回LocalDateTime日期时间类
     * @param time 时间值
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime plus(long time) {
        return plus(time, ChronoUnit.SECONDS);
    }

    /**
     * 当前时间加上时间值
     * 自定义单位
     * 返回LocalDateTime日期时间类
     * @param time 时间值
     * @param unit 单位
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime plus(long time, ChronoUnit unit) {
        return plus(localDateTime(), time, unit);
    }

    /**
     * 传递初始时间，加上时间值
     * 默认以秒为单位
     * 返回LocalDateTime日期时间类
     * @param localDateTime 初始时间
     * @param time 时间值
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime plus(LocalDateTime localDateTime, long time) {
        return plus(localDateTime, time, ChronoUnit.SECONDS);
    }

    /**
     * 传递初始时间，加上时间值
     * 自定义单位
     * 返回LocalDateTime日期时间类
     * @param localDateTime 初始时间
     * @param time 时间值
     * @param unit 时间单位
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime plus(LocalDateTime localDateTime, long time, ChronoUnit unit) {
        if (null == localDateTime)
            return null;
        if (null == unit)
            unit = ChronoUnit.SECONDS;
        return localDateTime.plus(time, unit);
    }

    /**
     * 当前时间减去时间值
     * 默认以秒为单位
     * 返回LocalDateTime日期时间类
     * @param time 时间值
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime minus(long time) {
        return minus(time, ChronoUnit.SECONDS);
    }

    /**
     * 当前时间减去时间值
     * 自定义时间单位
     * 返回LocalDateTime日期时间类
     * @param time 时间值
     * @param unit 时间单位
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime minus(long time, ChronoUnit unit) {
        return minus(localDateTime(), time, unit);
    }

    /**
     * 传递初始时间，减去时间值
     * 默认以秒为单位
     * 返回LocalDateTime日期时间类
     * @param localDateTime 初始时间
     * @param time 时间值
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime minus(LocalDateTime localDateTime, long time) {
        return minus(localDateTime, time, ChronoUnit.SECONDS);
    }

    /**
     * 传递初始时间，减去时间值
     * 自定义时间单位
     * 返回LocalDateTime日期时间类
     * @param localDateTime 初始时间
     * @param time 时间值
     * @param unit 时间单位
     * @return LocalDateTime日期时间类
     */
    public static LocalDateTime minus(LocalDateTime localDateTime, long time, ChronoUnit unit) {
        if (null == localDateTime)
            return null;
        if (null == unit)
            unit = ChronoUnit.SECONDS;
        return localDateTime.minus(time, unit);
    }

    /**
     * 当前时间加上时间值
     * 默认以秒为单位
     * 返回Date时间类
     * @param time 时间值
     * @return Date时间类
     */
    public static Date plusDate(long time) {
        return plusDate(date(), time);
    }

    /**
     * 当前时间加上时间值
     * 自定义时间单位
     * 返回Date时间类
     * @param time 时间值
     * @param unit 时间单位
     * @return Date时间类
     */
    public static Date plusDate(long time, ChronoUnit unit) {
        return plusDate(date(), time, unit);
    }

    /**
     * 传递初始时间，加上时间值
     * 默认以秒为单位
     * 返回Date时间类
     * @param date 初始时间
     * @param time 时间值
     * @return Date时间类
     */
    public static Date plusDate(Date date, long time) {
        return plusDate(date, time, ChronoUnit.SECONDS);
    }

    /**
     * 传递初始时间，加上时间值
     * 自定义时间单位
     * 返回Date时间类
     * @param date 初始时间
     * @param time 时间值
     * @param unit 时间单位
     * @return Date时间类
     */
    public static Date plusDate(Date date, long time, ChronoUnit unit) {
        LocalDateTime localDateTime = localDateTime(date);
        if (null == localDateTime)
            return null;
        LocalDateTime plus = plus(localDateTime, time, unit);
        if (null == plus)
            return null;
        return date(plus);
    }

    /**
     * 当前时间减去时间值
     * 默认以秒为单位
     * 返回Date时间类
     * @param time 时间值
     * @return Date时间类
     */
    public static Date minusDate(long time) {
        return minusDate(date(), time);
    }

    /**
     * 当前时间减去时间值
     * 自定义时间单位
     * 返回Date时间类
     * @param time 时间值
     * @param unit 时间单位
     * @return Date时间类
     */
    public static Date minusDate(long time, ChronoUnit unit) {
        return minusDate(date(), time, unit);
    }

    /**
     * 传递初始时间，减去时间值
     * 默认以秒为单位
     * 返回Date时间类
     * @param date 初始时间
     * @param time 时间值
     * @return Date时间类
     */
    public static Date minusDate(Date date, long time) {
        return minusDate(date, time, ChronoUnit.SECONDS);
    }

    /**
     * 传递初始时间，减去时间值
     * 自定义时间单位
     * 返回Date时间类
     * @param date 初始时间
     * @param time 时间值
     * @param unit 时间单位
     * @return Date时间类
     */
    public static Date minusDate(Date date, long time, ChronoUnit unit) {
        LocalDateTime localDateTime = localDateTime(date);
        if (null == localDateTime)
            return null;
        LocalDateTime minus = minus(localDateTime, time, unit);
        if (null == minus)
            return null;
        return date(minus);
    }

    /**
     * 计算当前时间与传递时间的差值
     * 默认以毫秒为单位
     * 返回时间差数字
     * @param end 时间毫秒值
     * @return 时间差数字
     */
    public static long between(long end) {
        return between(localDateTime(), localDateTime(end));
    }

    /**
     * 计算当前时间与传递时间的差值
     * 自定义时间单位
     * 返回时间差数字
     * @param end 时间毫秒值
     * @param unit 时间单位
     * @return 时间差数字
     */
    public static long between(long end, ChronoUnit unit) {
        return between(localDateTime(), localDateTime(end), unit);
    }

    /**
     * 传递开始时间和结束时间
     * 计算两时间的差值
     * 默认使用毫秒为单位
     * 返回时间差数字
     * @param start 时间毫秒值，开始时间
     * @param end 时间毫秒值，结束时间
     * @return 时间差数字
     */
    public static long between(long start, long end) {
        return between(localDateTime(start), localDateTime(end));
    }

    /**
     * 传递开始时间和结束时间
     * 计算两时间的差值
     * 自定义时间单位
     * 返回时间差数字
     * @param start 时间毫秒值，开始时间
     * @param end 时间毫秒值，结束时间
     * @param unit 时间单位
     * @return 时间差数字
     */
    public static long between(long start, long end, ChronoUnit unit) {
        return between(localDateTime(start), localDateTime(end), unit);
    }

    /**
     * 计算当前时间与传递时间的差值
     * 传递Date时间类
     * 默认以毫秒为单位
     * 返回时间差数字
     * @param end Date时间类，结束时间
     * @return 时间差数字
     */
    public static long between(Date end) {
        return between(localDateTime(), localDateTime(end));
    }

    /**
     * 计算当前时间与传递时间的差值
     * 传递Date时间类
     * 自定义时间单位
     * 返回时间差数字
     * @param end Date时间类，结束时间
     * @param unit 时间单位
     * @return 时间差数字
     */
    public static long between(Date end, ChronoUnit unit) {
        return between(localDateTime(), localDateTime(end), unit);
    }

    /**
     * 传递开始时间和结束时间Date时间类
     * 计算两时间的差值
     * 默认以毫秒为单位
     * 返回时间差数字
     * @param start Date时间类，开始时间
     * @param end Date时间类，结束时间
     * @return 时间差数字
     */
    public static long between(Date start, Date end) {
        return between(localDateTime(start), localDateTime(end));
    }

    /**
     * 传递开始时间和结束时间Date时间类
     * 计算两时间的差值
     * 自定义时间单位
     * 返回时间差数字
     * @param start Date时间类，开始时间
     * @param end Date时间类，结束时间
     * @param unit 时间单位
     * @return 时间差数字
     */
    public static long between(Date start, Date end, ChronoUnit unit) {
        return between(localDateTime(start), localDateTime(end), unit);
    }

    /**
     * 计算当前时间与传递时间的差值
     * 传递LocalDateTime日期时间类
     * 默认以毫秒为单位
     * 返回时间差数字
     * @param end LocalDateTime日期时间类，结束时间
     * @return 时间差数字
     */
    public static long between(LocalDateTime end) {
        return between(localDateTime(), end);
    }

    /**
     * 计算当前时间与传递时间的差值
     * 传递LocalDateTime日期时间类
     * 自定义时间单位
     * 返回时间差数字
     * @param end LocalDateTime日期时间类，结束时间
     * @param unit 时间单位
     * @return 时间差数字
     */
    public static long between(LocalDateTime end, ChronoUnit unit) {
        return between(localDateTime(), end, unit);
    }

    /**
     * 传递开始时间和结束时间LocalDateTime日期时间类
     * 计算两时间的差值
     * 默认以毫秒为单位
     * 返回时间差数字
     * @param start LocalDateTime日期时间类，开始时间
     * @param end LocalDateTime日期时间类，结束时间
     * @return 时间差数字
     */
    public static long between(LocalDateTime start, LocalDateTime end) {
        return between(start, end, ChronoUnit.MILLIS);
    }

    /**
     * 传递开始时间和结束时间LocalDateTime日期时间类
     * 计算两时间的差值
     * 自定义时间单位
     * 返回时间差数字
     * @param start LocalDateTime日期时间类，开始时间
     * @param end LocalDateTime日期时间类，结束时间
     * @param unit 时间单位
     * @return 时间差数字
     */
    public static long between(LocalDateTime start, LocalDateTime end, ChronoUnit unit) {
        if (null == start || null == end)
            return -1;
        if (null == unit)
            unit = ChronoUnit.MILLIS;
        return Math.abs(start.until(end, unit));
    }

    /**
     * 输入 年、月、日
     * 输出 现在时间 距离 输入时间 的天数
     * 如果输入的是以前的日期，则返回的是负数
     * 如果输入的是之后的日期，则返回的是正数
     * 方法不会验证输入参数，如果转换LocalDate异常，请自行解决。
     * @param year 年份
     * @param month 月份
     * @param day 日期
     * @return 距离天数
     */
    public static long betweenDayNoAbs(int year, int month, int day) {
        LocalDate start = LocalDate.of(year, month, day);
        return LocalDate.now().until(start, ChronoUnit.DAYS);
    }

    /**
     * 输入 年、月
     * 返回 这个月的总天数
     * 方法不会判断输入参数的正确性，
     * 如果转化LocalDate类错误，请自行解决
     * @param year 年份
     * @param month 月份
     * @return 月份的总天数
     */
    public static int getMonthDays(int year, int month) {
        LocalDate localDate = LocalDate.of(year, month, 1);
        return localDate.getMonth().maxLength();
    }

}
