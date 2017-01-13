package org.owasp.passfault.dictionary;

import org.owasp.passfault.api.PassfaultException;

public class DictionaryException extends PassfaultException {
  public DictionaryException() {
    super();
  }

  public DictionaryException(String message) {
    super(message);
  }

  public DictionaryException(String message, Throwable cause) {
    super(message, cause);
  }

  public DictionaryException(Throwable cause) {
    super(cause);
  }

  protected DictionaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
