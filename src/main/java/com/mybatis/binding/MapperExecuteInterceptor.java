package com.mybatis.binding;

/**
 *
 */
public interface MapperExecuteInterceptor {

  public MapperMethodInvokerParams invoke(MapperMethodInvokerParams params,MapperMethodInvokerChain chain);

}
