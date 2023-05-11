package com.github.cuifuan.redis.dao;

import com.github.cuifuan.redis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 操作数据库
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

}
