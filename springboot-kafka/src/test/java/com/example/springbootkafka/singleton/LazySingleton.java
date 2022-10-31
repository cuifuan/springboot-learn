package com.example.springbootkafka.singleton;

public class LazySingleton {
    @Override
    public String toString() {
        return "";
    }

    private static LazySingleton instance;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (instance != null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
