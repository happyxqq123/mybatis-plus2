package com.mybatis.binding;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * mapper method Invoker chain
 */
public  class MapperMethodInvokerChain {

  private List<MapperExecuteInterceptor> mapperExecuteInterceptors = Lists.newLinkedList();

  public void addMapperMethodInvoker(MapperExecuteInterceptor mapperExecuteInterceptor){
    mapperExecuteInterceptors.add(mapperExecuteInterceptor);
  }


}
