package com.github.luca.hide;

public class StudentCheck implements Check {
    @Override
    public void checkIn() {
        System.out.println("滴!学生卡");
    }
}
