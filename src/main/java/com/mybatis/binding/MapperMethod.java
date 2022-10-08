package com.mybatis.binding;

import com.mybatis.annotation.Delete;
import com.mybatis.annotation.Insert;
import com.mybatis.annotation.Select;
import com.mybatis.annotation.Update;
import com.mybatis.exception.MultipleSqlAnnotationExecption;
import com.mybatis.exception.NoSuchAnnotationExecption;
import com.mybatis.mapping.MappedStatement;
import com.mybatis.mapping.ParameterMapping;
import com.mybatis.mapping.SqlCommandType;
import com.mybatis.session.Configuration;
import com.mybatis.session.SqlSession;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MapperMethod {

  private final boolean returnsMany;

  private final boolean returnsMap;

  private final boolean returnsVoid;

  private final Class<?> returnType;

  public MapperMethod(boolean returnsMany, boolean returnsMap, boolean returnsVoid, Class<?> returnType) {
    this.returnsMany = returnsMany;
    this.returnsMap = returnsMap;
    this.returnsVoid = returnsVoid;
    this.returnType = returnType;
  }

  public Object execute(SqlSession sqlSession,Object[] args){
    return null;
  }

  public static class SqlCommand{

    private final String name;

    private final SqlCommandType type;

    public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) throws NoSuchAnnotationExecption, MultipleSqlAnnotationExecption {
      name = method.getName();
      final Class<?> declaringClass = method.getDeclaringClass();
      SqlCommandType sqlCommandType = SqlCommandType.UNKNOWN;

      int sqlAnnotationCount = 0;
      Select select = method.getAnnotation(Select.class);
      if(select != null){
        sqlCommandType = SqlCommandType.SELECT;
        sqlAnnotationCount++;
      }
      Insert insert = method.getAnnotation(Insert.class);
      if(insert != null){
        sqlCommandType = SqlCommandType.INSERT;
        sqlAnnotationCount++;
      }
      Update update = method.getAnnotation(Update.class);
      if(update != null){
        sqlCommandType = SqlCommandType.UPDATE;
        sqlAnnotationCount++;
      }
      Delete delete = method.getAnnotation(Delete.class);
      if(delete != null){
        sqlCommandType = SqlCommandType.DELETE;
        sqlAnnotationCount++;
      }

      if( sqlAnnotationCount == 0){
        throw new NoSuchAnnotationExecption("type "+mapperInterface.getName()+", method:"+method.getName()+" have no annotation such as @Select @Update @Insert @Delete");
      }
      if(sqlAnnotationCount > 1){
        throw new MultipleSqlAnnotationExecption("sql annotation(select,insert,delete,update) only have one");
      }
      type = sqlCommandType;
    }


    private MappedStatement resolveMappedStatement(Class<?> mapperInterface,Method method,
                                                   Class<?> declaringClass, Configuration configuration) throws NoSuchAnnotationExecption, MultipleSqlAnnotationExecption {
      Annotation [] annotations =  method.getAnnotations();
      if(annotations == null || annotations.length == 0){
        throw new NoSuchAnnotationExecption("type "+mapperInterface.getName()+", method:"+method.getName()+" have no annotation such as @Select @Update @Insert @Delete");
      }
      SqlCommandType tmpType = SqlCommandType.UNKNOWN;

      int sqlAnnotationCount = 0;
      String unhandleSql = null;
      Select select = method.getAnnotation(Select.class);
      if(select != null){
        tmpType = SqlCommandType.SELECT;
        unhandleSql = Arrays.toString(select.value());
        sqlAnnotationCount++;
      }
      Insert insert = method.getAnnotation(Insert.class);
      if(insert != null){
        tmpType = SqlCommandType.INSERT;
        unhandleSql = Arrays.toString(insert.value());
        sqlAnnotationCount++;
      }
      Update update = method.getAnnotation(Update.class);
      if(update != null){
        tmpType = SqlCommandType.UPDATE;
        unhandleSql = Arrays.toString(update.value());
        sqlAnnotationCount++;
      }
      Delete delete = method.getAnnotation(Delete.class);
      if(delete != null){
        tmpType = SqlCommandType.DELETE;
        unhandleSql = Arrays.toString(delete.value());
        sqlAnnotationCount++;
      }

      if( sqlAnnotationCount == 0){
        throw new NoSuchAnnotationExecption("type "+mapperInterface.getName()+", method:"+method.getName()+" have no annotation such as @Select @Update @Insert @Delete");
      }
      if(sqlAnnotationCount > 1){
        throw new MultipleSqlAnnotationExecption("sql annotation(select,insert,delete,update) only have one");
      }
      //start parse sql
      return null;

    }

    private MappedStatement parsePreparedStatementSql(String unhandleSql,SqlCommandType sqlCommandType,Configuration configuration,Method method){

      ParameterMapping parameterMapping = new ParameterMapping();


      return null;
    }


  }

  public static class MethodSignature{

    private final boolean returnsMany;

    private final boolean returnsMap;

    private final boolean returnsVoid;

    private final Class<?> returnType;

    private final
  }
}


