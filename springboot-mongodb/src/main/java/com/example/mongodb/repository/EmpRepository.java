package store.zabbix.mongodb.repository;

import store.zabbix.mongodb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Employee employee) {
        mongoTemplate.save(employee);
    }
}
