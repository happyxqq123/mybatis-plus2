package com.mybatis.binding;

import com.mybatis.session.SqlSession;
import lombok.Data;

import java.lang.reflect.Method;

@Data
public class MapperMethodInvokerParams {

  private Object proxy;

  private Method method;

  private Object[] args;

  private SqlSession sqlSession;

}
