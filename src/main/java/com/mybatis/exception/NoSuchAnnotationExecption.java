package com.mybatis.exception;

public class NoSuchAnnotationExecption extends Exception{
  public NoSuchAnnotationExecption() {
    super();
  }

  public NoSuchAnnotationExecption(String message) {
    super(message);
  }

  public NoSuchAnnotationExecption(String message, Throwable cause) {
    super(message, cause);
  }

  public NoSuchAnnotationExecption(Throwable cause) {
    super(cause);
  }
}
