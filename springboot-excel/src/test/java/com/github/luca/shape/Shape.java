package com.github.luca.shape;

/**
 * Java程序说明-抽象的概念
 * 形状
 */
public abstract class Shape {
    String color;

    // 这些是抽象方法
    abstract double area();

    public abstract String toString();

    // 抽象类可以有构造函数
    public Shape(String color) {
        System.out.println("调用形状构造函数");
        this.color = color;
    }

    // 这是一个具体的方法
    public String getColor() {
        return color;
    }
}
