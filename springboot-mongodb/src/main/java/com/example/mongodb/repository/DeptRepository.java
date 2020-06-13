package com.example.mongodb.repository;

import com.example.mongodb.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Department> findAll () {
        return mongoTemplate.findAll(Department.class);
    }

    public List<Department> findDepartmentByName (String deptName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(deptName));
        return mongoTemplate.find(query, Department.class);
    }

    public Department save (Department department) {
        mongoTemplate.save(department);
        return department;
    }

    public Department update (Department department) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(department.getId()));
        Update update = new Update();
        update.set("name", department.getName());
        update.set("description", department.getDescription());
        return mongoTemplate.findAndModify(query, update, Department.class);
    }

    public void deleteById (String deptId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(deptId));
        mongoTemplate.remove(query, Department.class);
    }

}
