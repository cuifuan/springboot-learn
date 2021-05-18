package com.github.luca.encapsulation;

public class TestStudent {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setName("源十天狗");
        System.out.println("s1设置年龄为-500");
        s1.setAge(-500);
        System.out.println("打印s1:==>"+ s1.toString());

        Student s2 = new Student();
        System.out.println("s2不设置名字");
        s2.setName(null);
        s2.setAge(18);

        System.out.println("打印s2:==>"+ s2.toString());

    }
}
