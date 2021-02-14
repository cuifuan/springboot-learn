package com.github.demo.service;

import com.github.demo.model.MybatisTest;

import java.util.List;

public interface TestService {

    MybatisTest getMybatisTestById(Long id);

    void createMybatisTest(final MybatisTest mybatisTest);

    List<MybatisTest> getMybatisTests();
}
