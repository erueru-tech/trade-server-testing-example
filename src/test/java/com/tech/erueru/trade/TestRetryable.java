package com.tech.erueru.trade;

import dev.failsafe.Failsafe;
import dev.failsafe.RetryPolicy;
import dev.failsafe.function.CheckedPredicate;
import java.time.Duration;

public class TestRetryable {

  private static final CheckedPredicate<? extends Exception> DEFAULT_HANDLE_IF =
      (e) -> e instanceof Exception;
  private static final int DEFAULT_MAX_RETRIES = 5;

  static RetryPolicy retryPolicy(CheckedPredicate<? extends Exception> handleIf, int maxRetries) {
    return RetryPolicy.builder()
        .handleIf(handleIf)
        .withMaxRetries(maxRetries)
        .withDelay(Duration.ofSeconds(2))
        .build();
  }

  public static void retryIfFailed(ThrowableRunnable fn) {
    retryIfFailed(fn, DEFAULT_HANDLE_IF, DEFAULT_MAX_RETRIES);
  }

  public static void retryIfFailed(
      ThrowableRunnable fn, CheckedPredicate<? extends Exception> handleIf, int maxRetries) {
    Failsafe.with(retryPolicy(handleIf, maxRetries)).run(() -> fn.run());
  }

  public static <T> T retryIfFailed(ThrowableSupplier<T, ? extends Exception> fn) {
    return retryIfFailed(fn, DEFAULT_HANDLE_IF, DEFAULT_MAX_RETRIES);
  }

  public static <T> T retryIfFailed(
      ThrowableSupplier<T, ? extends Exception> fn,
      CheckedPredicate<? extends Exception> handleIf,
      int maxRetries) {
    return Failsafe.with(retryPolicy(handleIf, maxRetries)).get(() -> fn.get());
  }
}
