package com.github.luca.abs;

public abstract class TestOne{

    static class TestOneChild extends TestOne{
        String color;
        // this is a concrete method
        public String getColor() { return color; }
        public TestOneChild() {
            super();
        }
    }
    public static void main(String[] args) {

    }
}
