package com.mybatis.mapping;

import com.mybatis.session.Configuration;
import com.mybatis.type.JdbcType;
import com.mybatis.type.TypeHandler;

public class ParameterMapping {

  private Configuration configuration;

  private Class<?> javaType = Object.class;

  private JdbcType jdbcType;

  private TypeHandler<?> typeHandler;




}
