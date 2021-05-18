package com.github.luca.inheritance;

class Dog extends Animal {
    String hairColor = "金黄";
    void eat() {
    }

    void sleep() {
    }

    void bark() {
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.print("狗开始移动:");
        dog.move();
        System.out.println("狗的颜色:"+ dog.hairColor);
    }
}
