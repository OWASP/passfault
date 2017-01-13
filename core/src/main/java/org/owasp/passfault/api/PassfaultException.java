package org.owasp.passfault.api;

public class PassfaultException extends RuntimeException {
  public PassfaultException() {
    super();
  }

  public PassfaultException(String message) {
    super(message);
  }

  public PassfaultException(String message, Throwable cause) {
    super(message, cause);
  }

  public PassfaultException(Throwable cause) {
    super(cause);
  }

  protected PassfaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
