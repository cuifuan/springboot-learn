package com.example.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employee")
public class Employee {

    @Id
    private String empId;
    private String name;
    private int age;
    private double salary;

    public String getEmpId () {
        return empId;
    }

    public void setEmpId (String empId) {
        this.empId = empId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public double getSalary () {
        return salary;
    }

    public void setSalary (double salary) {
        this.salary = salary;
    }

}
