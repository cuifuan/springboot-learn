package com.github.springtools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class SimpleDateFormatTest {
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final ThreadLocal<SimpleDateFormat> THREADLOCAL_FORMAT = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    public static final DateTimeFormatter JAVA8_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static void main(String[] args) throws ParseException {
        System.out.println(FORMAT.parse("2020-06-06"));
        System.out.println("--------单个调用结束--------");
        System.out.println("--------多线程调用开始--------");

        IntStream.rangeClosed(0, 5)
                .forEach(i -> new Thread(() -> {
                    try {
                        System.out.println("ThreadLocal:" + THREADLOCAL_FORMAT.get().parse("2020-06-06"));
                        System.out.println("JAVA8_FORMATTER:" + JAVA8_FORMATTER.parse("2020-06-06"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }).start());
    }
}
