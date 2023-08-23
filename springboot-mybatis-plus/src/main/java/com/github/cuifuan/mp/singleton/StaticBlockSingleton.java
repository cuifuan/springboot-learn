package com.github.cuifuan.mp.singleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton() {
    }

    // 用于异常处理的静态块初始化
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("创建单例时发生异常!");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
