package com.github.luca.shape;

// 长方形
class Rectangle extends Shape {

    double length, width;

    public Rectangle(String color, double length,
                     double width) {
        // 调用Shape构造函数
        super(color);
        System.out.println("调用长方形构造函数");
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "长方形颜色为" + super.getColor()
                + "和面积是: " + area();
    }
}
