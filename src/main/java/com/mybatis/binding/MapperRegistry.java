package com.mybatis.binding;

import com.mybatis.exception.BindingException;
import com.mybatis.session.Configuration;
import com.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapperRegistry{

  private final Configuration configuration;

  private final Map<Class<?>,MapperProxyFactory<?>> knowMappers = new ConcurrentHashMap<>();

  public MapperRegistry(Configuration configuration) {
    this.configuration = configuration;
  }

  public <T> T  getMapper(Class<T> clazz, SqlSession sqlSession){
    MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knowMappers.get(clazz);
    if(mapperProxyFactory == null){
      throw new BindingException("Type "+clazz+" is not know to MapperRegistry");
    }
    return  mapperProxyFactory.newInstance(sqlSession);
  }

  protected <T> void loadMapper(Class<T> type){
    Class<?> [] interfaces = type.getInterfaces();
    boolean isMath =  Arrays.stream(interfaces).anyMatch(interfaceTmp->{
      return interfaceTmp == type;
    });
    if(!isMath){
      throw new IllegalArgumentException("Type " +type+" interface dont have BaseMapper");
    }
    Method [] methods =  type.getMethods();
    MapperProxyFactory<T> mapperProxyFactory = new MapperProxyFactory<>(type);
    knowMappers.put(type,mapperProxyFactory);
    Arrays.stream(methods).forEach(method -> {
      method.getAnnotations();
    });


  }



}
