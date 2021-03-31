package com.github.demo.controller;

import com.github.demo.bean.ResponseBean;
import com.github.demo.model.MybatisTest;
import com.github.demo.service.TestService;
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

    @PostMapping("add")
    public ResponseBean createClient(@RequestBody MybatisTest mybatisTest) {
        testService.createMybatisTest(mybatisTest);
        return ResponseBean.ok();
    }
}
