package store.zabbix.bran.ekko.repositories;

import store.zabbix.bran.ekko.model.IPData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepositories extends JpaRepository<IPData, Long> {

}
