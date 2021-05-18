package com.github.luca.inheritance;

class TestHuman {
    public static void main(String[] args) {
        Human h1 = new Human();
        h1.printInfo();
        Human h2 = new Human("铅华");
        h2.printInfo();
        Human h3 = new Human("小花", 18);
        h3.printInfo();
    }
}
