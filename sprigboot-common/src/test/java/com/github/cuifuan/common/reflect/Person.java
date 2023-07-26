package com.github.cuifuan.common.reflect;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("你好, 我是" + name + ",我的年龄是 " + age + ".");
    }
}
