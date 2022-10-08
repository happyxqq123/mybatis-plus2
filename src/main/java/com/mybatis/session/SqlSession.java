package com.mybatis.session;

import com.mybatis.mapper.BaseMapper;

public interface SqlSession {

  public <T>  T getMapper(Class<T> mapperClzaa);

}
