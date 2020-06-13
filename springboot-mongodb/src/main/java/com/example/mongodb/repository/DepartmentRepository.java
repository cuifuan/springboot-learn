package com.example.mongodb.repository;

import com.example.mongodb.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    @Query(value = "{'Employee.name': ?0}", fields = "{'employees' : 0}")
    Department findDepartmentByEmployeeName (String empName);

    List<Department> findDepartmentByName (String name);
}
