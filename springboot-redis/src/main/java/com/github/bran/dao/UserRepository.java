package store.zabbix.bran.dao;

import store.zabbix.bran.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 操作数据库
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
