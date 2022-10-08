package com.mybatis.binding;


import com.mybatis.mapper.BaseMapper;
import com.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler {

  private final SqlSession sqlSession;
  private final Class<T> mapperInterface;
  private final Map<Method, MapperMethodInvoker> methodCache;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {



    return null;
  }

  public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethodInvoker> methodCache) {
    this.sqlSession = sqlSession;
    this.mapperInterface = mapperInterface;
    this.methodCache = methodCache;
  }

  private static class PlainMethodInvoker implements  MapperMethodInvoker{

    private final MapperMethod mapperMethod ;

    public PlainMethodInvoker(MapperMethod mapperMethod){
      this.mapperMethod = mapperMethod;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args, SqlSession sqlSession) throws Throwable {
      return mapperMethod.execute(sqlSession,args);
    }
  }


}
