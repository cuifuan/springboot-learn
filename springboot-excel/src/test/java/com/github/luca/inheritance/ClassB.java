package com.github.luca.inheritance;

class ClassB extends ClassA {
    ClassB() {
        System.out.println("这里是B的构造方法...");
    }

    ClassB(String str) {
        this();
        System.out.println("B：hello " + str);
    }
}
