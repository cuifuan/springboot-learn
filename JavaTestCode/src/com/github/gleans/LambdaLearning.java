package com.github.gleans;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaLearning {
    public static void main(String[] args) {
//        testTwo();
int[] ary = {1,2,3,1000};
int maxNum = IntStream.of(ary).parallel().max().getAsInt();
System.out.println(maxNum);

new Thread(() -> System.out.println("test")).start();

Runnable runnable = () -> System.out.println("test2");
new Thread(runnable).start();

    }

    public static void testTwo(){
        List<Double> nums = Arrays.asList(1.01, 2.11, 3.23, 4.222, null, 5.6);
        DoubleSummaryStatistics number = nums.stream()
                .map(num -> Objects.isNull(num) ? 0 : num)
                .mapToDouble(num -> num)
                .summaryStatistics();
        System.out.println("最大值:"+number.getMax());
        System.out.println("最小值:"+number.getMin());
        System.out.println("平均值:"+number.getAverage());
    }

    public static void testOne(){
        List<Double> nums = Arrays.asList(1.01, 2.11, 3.23, 4.222, null, 5.6);
        double resNum = nums.stream()
                .map(num -> Objects.isNull(num) ? 0 : num)
                .mapToDouble(num -> num)
                .sum();
        System.out.println(resNum);
    }
}
