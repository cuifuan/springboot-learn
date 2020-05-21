package com.example.demo;

import com.example.demo.model.SysUser;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void add() {
        userRepository.save(new SysUser("123@qq.com", "root", "root"));
    }

    @Test
    public void contextLoads() {
        System.out.println(userRepository.findAll().toString());
    }

    //修改操作
    @After
    public void update() {
        // ifPresent 如果存在值，则使用值调用指定的使用者，否则不执行任何操作。
        userRepository.findById(1L).ifPresent(user -> {
            user.setUsername("马华云腾");
            userRepository.save(user);
            System.out.println(user.toString());
        });
    }

    //删除
    @After
    public void del() {
        userRepository.findById(2L).ifPresent(user -> userRepository.delete(user));
    }

}
