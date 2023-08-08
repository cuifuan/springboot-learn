package com.github.cuifuan.mp.service;

import com.github.cuifuan.mp.model.MybatisTest;

import java.util.List;

public interface TestService {

    MybatisTest getMybatisTestById(Long id);

    void createMybatisTest(final MybatisTest mybatisTest);

    List<MybatisTest> getMybatisTests();
}
