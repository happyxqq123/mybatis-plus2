package com.mybatis.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Select.List.class)
public @interface Select {
  /**
   * Returns an SQL for retrieving record(s).
   *
   * @return an SQL for retrieving record(s)
   */
  String[] value();

  /**
   * @return A database id that correspond this statement
   * @since 3.5.5
   */
  String databaseId() default "";

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD})
  public @interface List {
    Select[] value();
  }
}
