package com.github.gleans;

interface TestLamdaInterface {
    int testSub(int i, int k);
}

public class TestLamda {
    public static void main(String[] args) {
        TestLamdaInterface lamdaInterface = (i, k) -> i - k;
        System.out.println(lamdaInterface.testSub(100, 20));

        // 剩余三种写法
        TestLamdaInterface lamdaInterface1 = (int i,int k) -> i - k;
        TestLamdaInterface lamdaInterface2 = (int i,int k) -> {
            return i - k;
        };
        // 3.单个参数可去除括号
    }
}
