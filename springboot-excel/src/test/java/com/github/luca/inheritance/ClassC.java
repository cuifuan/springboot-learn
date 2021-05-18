package com.github.luca.inheritance;

public class ClassC extends ClassB{
    ClassC() {
        this("tina");
        System.out.println("这里是C的构造方法...");
    }

    ClassC(String str) {
        super(str);
        System.out.println("C: hello "+ str);
    }

    public static void main(String[] args) {
        new ClassC();
    }
}
