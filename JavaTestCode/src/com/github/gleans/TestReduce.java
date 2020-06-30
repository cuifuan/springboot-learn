package com.github.gleans;

import java.util.Arrays;
import java.util.List;

public class TestReduce {
    public static void main(String[] args) {
        testOne();
    }

    public static void testOne(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 这里的 10 相当于初始值
        int sum = numbers
                .stream()
                .reduce(10, Integer::sum);
        System.out.println(sum);
    }
}
