package com.example.springbootkafka.singleton;

public class SingletonEager {

    private static volatile SingletonEager singletonEager = new SingletonEager();

    private SingletonEager() {
        System.out.println("饿汉式单例模式");
    }

    public static SingletonEager getInstance() {
        return singletonEager;
    }

}
