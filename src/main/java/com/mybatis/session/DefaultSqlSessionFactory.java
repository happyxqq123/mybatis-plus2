package com.mybatis.session;

import com.mybatis.mapper.BaseMapper;

public class DefaultSqlSessionFactory implements SqlSessionFactory{

  private Configuration configuration ;

  public DefaultSqlSessionFactory(Configuration configuration){
    this.configuration = configuration;
  }

  @Override
  public SqlSession openSession() {
    return new DefaultSqlSession(configuration);
  }

  private SqlSession openSqlSessionFromDatasource(){
    return new DefaultSqlSession(configuration);
  }
}
