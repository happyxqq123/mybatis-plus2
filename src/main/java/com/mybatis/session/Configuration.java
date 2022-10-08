package com.mybatis.session;

import com.google.common.collect.Maps;
import com.mybatis.binding.MapperExecuteInterceptor;
import com.mybatis.binding.MapperMethodInvokerChain;
import com.mybatis.binding.MapperProxyFactory;
import com.mybatis.binding.MapperRegistry;
import com.mybatis.mapper.BaseMapper;
import com.mybatis.mapping.MappedStatement;
import com.mybatis.transaction.TransactionFactory;
import org.reflections.Reflections;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class Configuration {

  private DataSource dataSource;

  private TransactionFactory transactionFactory;
  private final int parallelCount = 2^13;
  private Set<Class<? extends BaseMapper>> mapperClassSet =  Collections.synchronizedSet(new HashSet<>());
  private Map<Class<? extends BaseMapper>, MapperProxyFactory<? extends BaseMapper>> mapperProxyFactoryMap  = new ConcurrentHashMap<>();

  private Map<String, MappedStatement> mappedStatements = Maps.newHashMap();

  protected final MapperRegistry mapperRegistry  = new MapperRegistry(this) ;
  private MapperMethodInvokerChain mapperMethodInvokerChain = new MapperMethodInvokerChain();




  public void addMapperMethodExecutor(MapperExecuteInterceptor mapperExecuteInterceptor){

  }

  public Configuration(DataSource dataSource){
    this.dataSource = dataSource;
  }

  public void addMapper(BaseMapper baseMapper){

  }

  public void addMappers(String packageName){
    Reflections reflections = new Reflections(packageName);
    Set<Class<? extends BaseMapper>> unloadMapperClassSet = reflections.getSubTypesOf(BaseMapper.class);

    int n = unloadMapperClassSet.size();
    if(n < parallelCount || ForkJoinPool.getCommonPoolParallelism() == 1){
      unloadMapperClassSet.stream().forEach(type -> {
        loadMapper(type);
      });
    }else{
      unloadMapperClassSet.parallelStream().forEach(type->{
        loadMapper(type);
      });
    }
  }

  private void singleThreadLoadMapper(Class<? extends BaseMapper> mapperClass){

  }

  private void loadMapper(Class<? extends BaseMapper> mapperClass){

  }

  protected <T> T getMapper(Class<T> clazz,SqlSession sqlSession){
    return mapperRegistry.getMapper(clazz,sqlSession);
  }

  public boolean hasStatement(String statementId){
    return mappedStatements.containsKey(statementId);
  }



}
