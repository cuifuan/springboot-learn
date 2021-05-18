package com.github.luca.encapsulation;

public class Student {

    private String name;
    private int age = -1;

    public void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            System.out.println("ERROR: 名字不能为空！");
        } else {
            this.name = name;
        }
    }

    public void setAge(int a) {
        if (a < 0) {
            System.out.println("ERROR: 年齡不能为负数！");
        } else {
            this.age = a;
        }
    }

    public String getName() {
        return name == null ? "无名氏" : this.name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "名字:'" + this.getName() + '\'' +
                ", 年龄:" + this.getAge() +
                '}';
    }
}