package com.mybatis.binding;

import com.google.common.collect.Maps;
import com.mybatis.mapper.BaseMapper;
import com.mybatis.session.SqlSession;
import lombok.Getter;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class MapperProxyFactory<T> {

  @Getter
  private final Class<T> mapperInterface;

  @Getter
  private final Map<Method,MapperMethodInvoker> methodCache = Maps.newConcurrentMap();

  public MapperProxyFactory(Class<T> mapperInterface) {
    this.mapperInterface = mapperInterface;
  }

  protected T newInstance(MapperProxy<T> mapperProxy){
    return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class<?>[]{mapperInterface},mapperProxy);
  }

  protected T newInstance(SqlSession sqlSession){
    final MapperProxy<T>mapperProxy = new MapperProxy<>(sqlSession,mapperInterface,methodCache);
    return newInstance(mapperProxy);
  }




/*  public static <T> T getMapper(Class<T> mapper){



    return null;
  }*/

}
