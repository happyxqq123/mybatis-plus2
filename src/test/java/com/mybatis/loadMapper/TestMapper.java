package com.mybatis.loadMapper;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatis.annotation.Insert;
import com.mybatis.annotation.Select;
import com.mybatis.session.Configuration;
import com.mybatis.session.DefaultSqlSessionFactory;
import com.mybatis.session.SqlSession;
import com.mybatis.session.SqlSessionFactory;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestMapper {

  @Test
  public void testLoadingMapper() throws NoSuchMethodException {
//    DruidDataSource dataSource = new DruidDataSource();
//    Configuration configuration = new Configuration(dataSource);
//    configuration.addMappers("com.mybatis.loadMapper");
//
//    SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
//    SqlSession sqlSession =  sqlSessionFactory.openSession();
//    UserMapper userMapper =  sqlSession.getMapper(UserMapper.class);

     Method method =  UserMapper.class.getMethod("selectUser");
     Select  select =  method.getDeclaredAnnotation(Select.class);
    Insert insert = method.getDeclaredAnnotation(Insert.class);
    System.out.println(insert);
    System.out.println(Select.class);
  }
}
