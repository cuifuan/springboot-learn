package com.github.cuifuan.redis;

import com.github.cuifuan.redis.dao.UserRepository;
import com.github.cuifuan.redis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
//springboot启动时执行任务CommandLineRunner
@SpringBootApplication
//开启缓存
@EnableCaching
public class SpringBootRedisApplication implements CommandLineRunner {

    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("开始初始化user ->user count ->{}", userRepository.count());
        User james = new User(1L, "James", 2000);
        User potter = new User(2L, "Potter", 4000);
        User dumbledore = new User(3L, "Dumbledore", 999999);

        userRepository.save(james);
        userRepository.save(potter);
        userRepository.save(dumbledore);
        log.info("初始化完成 数据-> {}.", userRepository.findAll());
    }
}
