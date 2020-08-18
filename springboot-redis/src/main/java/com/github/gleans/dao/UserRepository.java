package com.github.gleans.dao;

import com.github.gleans.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 操作数据库
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
