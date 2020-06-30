package com.github.gleans;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreFilter {
    public static void main(String[] args) {
        List<Student> studentList = IntStream.rangeClosed(0, 20)
                .mapToObj(i -> new Student("Java Pro" + i, 490 + i))
                .collect(Collectors.toList());

        List<Student> studentGiao = studentList.stream()
                .filter(student -> student.score > 500)
                .collect(Collectors.toList());
        System.out.println(studentGiao.toString());
    }

    static class Student {
        private String name;
        private Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name != null ? name.trim() : null;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    "}\n";
        }
    }
}
