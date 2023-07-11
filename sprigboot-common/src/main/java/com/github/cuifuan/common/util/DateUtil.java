package com.github.cuifuan.common.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.IntStream;

public class DateUtil {

    public final static String DATE_TIME_FMT = "yyyy-MM-dd HH:mm:ss";


    /**
     * desc: 获取起止日期
     * date 2022/9/14 12:57
     *
     * @param isFirst true 表示开始时间，false表示结束时间]
     * @author cuifuan
     **/
    public static LocalDateTime getStartOrEndOfDay(LocalDateTime today, Boolean isFirst) {
        LocalDateTime resDate = LocalDateTime.now();

        if (today == null) {
            today = resDate;
        }

        if (isFirst) {
            resDate = today.withHour(0).withMinute(0).withSecond(0).withNano(0);
        } else {
            resDate = today.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        }

        return resDate;
    }

    /**
     * desc: 获取指定日期的当月开始与结束时间
     * date 2022/9/14 12:57
     *
     * @param isFirst true 表示开始时间，false表示结束时间]
     * @author cuifuan
     **/
    public static LocalDateTime getStartOrEndDayOfMonth(LocalDateTime today, Boolean isFirst) {
        LocalDateTime resDate = LocalDateTime.now();

        if (today == null) {
            today = resDate;
        }

        if (isFirst) {
            resDate = today.with(TemporalAdjusters.firstDayOfMonth());
        } else {
            resDate = today.with(TemporalAdjusters.lastDayOfMonth());
        }

        resDate = DateUtil.getStartOrEndOfDay(resDate, isFirst);

        return resDate;
    }


    /**
     * desc: 获取指定日期的当年开始与结束时间
     * date 2022/9/14 12:57
     *
     * @param isFirst true 表示开始时间，false表示结束时间]
     * @author cuifuan
     **/
    public static LocalDateTime getStartOrEndDayOfYear(LocalDateTime today, Boolean isFirst) {
        LocalDateTime resDate = LocalDateTime.now();

        if (today == null) {
            today = resDate;
        }

        if (isFirst) {
            resDate = today.with(TemporalAdjusters.firstDayOfYear());
        } else {
            resDate = today.with(TemporalAdjusters.lastDayOfYear());
        }

        resDate = DateUtil.getStartOrEndOfDay(resDate, isFirst);

        return resDate;
    }

    /**
     * desc: 获取指定日期的当周开始与结束时间
     * date 2022/9/14 12:57
     *
     * @param isFirst true 表示开始时间，false表示结束时间]
     * @author cuifuan
     **/
    public static LocalDateTime getStartOrEndDayOfWeek(LocalDateTime today, Boolean isFirst) {
        LocalDateTime resDate = LocalDateTime.now();

        if (today == null) {
            today = resDate;
        }

        if (isFirst) {
            resDate = today.with(DayOfWeek.MONDAY);
        } else {
            resDate = today.with(DayOfWeek.SUNDAY);
        }

        resDate = DateUtil.getStartOrEndOfDay(resDate, isFirst);

        return resDate;
    }

    /**
     * 格式化时间格式为字符串
     */
    public static String dateFormat(LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FMT);
        if (null == localDateTime) {
            return null;
        } else {
            return localDateTime.format(dtf);
        }
    }

    public static void main(String[] args) {
//        System.out.printf("获取当周的开始时间:%s\n", dateFormat(getStartOrEndDayOfWeek(null, true)));
//        System.out.printf("获取当周的结束时间:%s\n", dateFormat(getStartOrEndDayOfWeek(null, false)));
        IntStream.range(0, 7)
                .forEach(i -> System.out.println(i));
    }


}
