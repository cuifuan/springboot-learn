package com.github.gleans.ekko.repositories;

import com.github.gleans.ekko.model.IPData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepositories extends JpaRepository<IPData, Long> {

}
