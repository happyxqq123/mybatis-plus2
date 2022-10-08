package com.mybatis.mapping;

import com.mybatis.session.Configuration;

public class MappedStatement {

  private Configuration configuration;

  private String id;
  private String sql; //sql语句
  private SqlCommandType sqlCommandType;

  private ParameterMap parameterMap;





  public MappedStatement(Configuration configuration, String id, String sql, SqlCommandType sqlCommandType) {
    this.configuration = configuration;
    this.id = id;
    this.sql = sql;
    this.sqlCommandType = sqlCommandType;
  }
}
