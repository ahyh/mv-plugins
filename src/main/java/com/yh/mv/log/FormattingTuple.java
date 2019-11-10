package com.yh.mv.log;

public class FormattingTuple {

  public static FormattingTuple NULL = new FormattingTuple(null);

  private String message;
  private Throwable throwable;
  private Object[] argArray;

  public FormattingTuple(String message) {
    this(message, null, null);
  }

  public FormattingTuple(String message, Object[] argArray, Throwable throwable) {
    this.message = message;
    this.throwable = throwable;
    if (throwable == null) {
      this.argArray = argArray;
    } else {
      this.argArray = trimmedCopy(argArray);
    }
  }

  static Object[] trimmedCopy(Object[] argArray) {
    if (argArray == null || argArray.length == 0) {
      throw new IllegalStateException("non-sensical empty or null argument array");
    }
    final int trimmedLen = argArray.length - 1;
    Object[] trimmed = new Object[trimmedLen];
    System.arraycopy(argArray, 0, trimmed, 0, trimmedLen);
    return trimmed;
  }

  public String getMessage() {
    return message;
  }

  public Object[] getArgArray() {
    return argArray;
  }

  public Throwable getThrowable() {
    return throwable;
  }
}
