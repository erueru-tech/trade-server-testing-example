package com.tech.erueru.trade;

@FunctionalInterface
public interface ThrowableRunnable<E extends Exception> {

  void run() throws E;
}
