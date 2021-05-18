package com.github.luca.shape;

public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Circle("黑", 10);
        Shape s2 = new Rectangle("白", 10, 10);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
