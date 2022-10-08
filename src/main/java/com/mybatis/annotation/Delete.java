package com.mybatis.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(Delete.List.class)
public @interface Delete {

  String[] value();

  String databaseId() default "";

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD})
  public @interface List {
    Delete[] value();
  }
}
