package com.mybatis.session;

import com.mybatis.mapper.BaseMapper;

public class DefaultSqlSession implements  SqlSession{

  private Configuration configuration;

  public DefaultSqlSession(Configuration configuration){
    this.configuration = configuration;
  }


  @Override
  public <T> T getMapper(Class<T> mapperClzaa) {
    return configuration.getMapper(mapperClzaa,this);
  }
}
