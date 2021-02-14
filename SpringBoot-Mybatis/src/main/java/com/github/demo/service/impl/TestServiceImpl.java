package com.github.demo.service.impl;

import com.github.demo.mapper.TestMapper;
import com.github.demo.model.MybatisTest;
import com.github.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    private TestMapper testMapper;

    @Autowired
    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public MybatisTest getMybatisTestById(Long id) {
        return testMapper.selectOne(id);
    }

    @Override
    public List<MybatisTest> getMybatisTests() {
        return testMapper.findAll();
    }

    @Override
    public void createMybatisTest(final MybatisTest mybatisTest) {
        testMapper.insertMybatisTest(mybatisTest);
    }
}
