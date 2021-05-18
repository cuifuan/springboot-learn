package com.github.luca.inheritance;

public class Human {
    String name;
    int age;
    static int totalCount = 0;

    Human() {
        name = "untitled";
        age = -1;
        totalCount++;
    }

    Human(String str) {
        this();
        this.name = str;
    }

    Human(String str, int a) {
        this(str);
        this.age = a;
    }

    void printInfo() {
        System.out.println(name + " 年齡：" + age + " 目前總人數：" + totalCount);
    }
}
