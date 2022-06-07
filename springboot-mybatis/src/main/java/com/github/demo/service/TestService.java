package store.zabbix.cuifuan.service;

import store.zabbix.cuifuan.model.MybatisTest;

import java.util.List;

public interface TestService {

    MybatisTest getMybatisTestById(Long id);

    void createMybatisTest(final MybatisTest mybatisTest);

    List<MybatisTest> getMybatisTests();
}
