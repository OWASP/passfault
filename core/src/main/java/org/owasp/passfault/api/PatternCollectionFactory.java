package org.owasp.passfault.api;

public interface PatternCollectionFactory {
  PatternCollection build(CharSequence password);
}
