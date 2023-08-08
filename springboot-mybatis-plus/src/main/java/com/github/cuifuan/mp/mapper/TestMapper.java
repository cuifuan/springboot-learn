package com.github.cuifuan.mp.mapper;

import com.github.cuifuan.mp.model.MybatisTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    
    @Select("SELECT id, first_name as firstName, en_name as enName FROM mybatis_test WHERE id = #{id}")
    MybatisTest selectOne(long id);

    @Select("SELECT id, first_name as firstName, en_name as enName FROM mybatis_test")
    List<MybatisTest> findAll();

    @Insert("INSERT INTO mybatis_test (id, first_name, en_name) VALUES (#{id}, #{firstName}, #{enName})")
    // 将对象ID设置为数据库中生成的ID
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertMybatisTest(MybatisTest mybatisTest);

    List<MybatisTest> findByFirstName(String value);
}
