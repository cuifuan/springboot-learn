package com.example.springbootkafka.singleton;

public class DclSingleton {
    private volatile static DclSingleton instance;

    /**
     * 增加安全性，防止除自身之外的类访问它
     */
    private DclSingleton() {
    }

    public static DclSingleton getInstance() {
        if (instance == null) {
            synchronized (DclSingleton.class) {
                if (instance == null) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
