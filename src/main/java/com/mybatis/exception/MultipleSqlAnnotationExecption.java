package com.mybatis.exception;

public class MultipleSqlAnnotationExecption extends Exception{

  public MultipleSqlAnnotationExecption() {
    super();
  }

  public MultipleSqlAnnotationExecption(String message) {
    super(message);
  }

  public MultipleSqlAnnotationExecption(String message, Throwable cause) {
    super(message, cause);
  }

  public MultipleSqlAnnotationExecption(Throwable cause) {
    super(cause);
  }
}
