package com.github.cuifuan.mp.controller;

import com.github.cuifuan.mp.service.TestService;
import com.github.cuifuan.mp.domain.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {

    private TestService testService;

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("getById/{id}")
    public MybatisTest getClient(@PathVariable("id") final Long id) {
        return testService.getMybatisTestById(id);
    }

}
