package com.mybatis.binding;

import com.mybatis.session.SqlSession;

import java.lang.reflect.Method;

public interface MapperMethodInvoker {
  Object invoke(Object proxy, Method method, Object[] args, SqlSession sqlSession) throws Throwable;
}
