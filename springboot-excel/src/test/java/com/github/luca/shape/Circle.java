package com.github.luca.shape;

/**
 * 圆形
 */
public class Circle extends Shape {

    double radius; // 半径

    public Circle(String color, double radius) {
        // 调用 Shape 构造函数
        super(color);
        System.out.println("调用圆的构造函数");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "圆圈颜色为" + super.getColor() + "和面积是 : " + area();
    }
}
