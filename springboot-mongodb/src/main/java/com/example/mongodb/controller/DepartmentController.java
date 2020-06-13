package com.example.mongodb.controller;

import com.example.mongodb.model.Department;
import com.example.mongodb.model.Employee;
import com.example.mongodb.repository.DepartmentRepository;
import com.example.mongodb.repository.DeptRepository;
import com.example.mongodb.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    DeptRepository deptRepository;
    @Autowired
    EmpRepository empRepository;

    @PostMapping("/v1/dept/s")
    public Department v1save (@RequestBody Department department) {
        List<Employee> employees = Optional.ofNullable(department.getEmployees()).orElse(Collections.emptyList());
        employees.forEach(employee -> empRepository.save(employee));
        return departmentRepository.save(department);
    }

    @GetMapping("/v1/dept/l")
    public List<Department> v1list () {
        return departmentRepository.findAll();
    }

    @PutMapping("/v1/dept/u/{deptId}")
    public Department v1update (@RequestBody Department department, @PathVariable String deptId) {
        department.setId(deptId);
        List<Employee> employees = Optional.ofNullable(department.getEmployees()).orElse(Collections.emptyList());
        employees.forEach(employee -> empRepository.save(employee));
        return departmentRepository.save(department);
    }

    @DeleteMapping("/v1/dept/d/{deptId}")
    public String v1delete (@PathVariable String deptId) {
        departmentRepository.deleteById(deptId);
        return deptId;
    }

    @GetMapping("/v1/dept/get/{deptName}")
    public List<Department> v1getByName (@PathVariable String deptName) {
        return departmentRepository.findDepartmentByName(deptName);
    }

    @GetMapping("/v1/dept/get/emp/{empName}")
    public Department v1getByEmpName (@PathVariable String empName) {
        return departmentRepository.findDepartmentByEmployeeName(empName);
    }

    @PostMapping("/v2/dept/s")
    public Department v2save (Department department) {
        List<Employee> employees = Optional.ofNullable(department.getEmployees()).orElse(Collections.emptyList());
        employees.forEach(employee -> empRepository.save(employee));
        return deptRepository.save(department);
    }

    @GetMapping("/v2/dept/l")
    public List<Department> v2list () {
        return deptRepository.findAll();
    }

    @PutMapping("/v2/dept/u")
    public Department v2update (Department department) {
        List<Employee> employees = Optional.ofNullable(department.getEmployees()).orElse(Collections.emptyList());
        employees.forEach(employee -> empRepository.save(employee));
        return deptRepository.update(department);
    }

    @DeleteMapping("/v2/dept/d/{deptId}")
    public void v2delete (@PathVariable String deptId) {
        deptRepository.deleteById(deptId);
    }

    @GetMapping("/v2/dept/get/{deptName}")
    public List<Department> v2getByName (@PathVariable String deptName) {
        return deptRepository.findDepartmentByName(deptName);
    }
}
