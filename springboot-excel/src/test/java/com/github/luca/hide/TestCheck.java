package com.github.luca.hide;

public class TestCheck {
    public static void main(String[] args) {
        Check checkOne = new StudentCheck();
        Check checkTwo = new TeacherCheck();
        checkOne.checkIn();
        checkTwo.checkIn();
    }
}
