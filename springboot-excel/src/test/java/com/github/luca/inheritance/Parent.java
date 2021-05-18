package com.github.luca.inheritance;

class Parent {
    int money = 100;

    public Parent(int money) {
        this.money -= money;
    }

    static class Child extends Parent {
        public Child(int money) {
            super(money);
            System.out.println("儿子花了爸爸" + money + "元钱后剩余" + this.money);
        }
    }

    public static void main(String[] args) {
        new Child(10);
    }
}
