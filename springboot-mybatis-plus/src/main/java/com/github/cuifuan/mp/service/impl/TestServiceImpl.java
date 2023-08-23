package com.github.cuifuan.mp.service.impl;

import com.github.cuifuan.mp.mapper.TestMapper;
import com.github.cuifuan.mp.service.TestService;
import com.github.cuifuan.mp.domain.MybatisTest;
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
