package com.tech.erueru.trade;

import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.kohsuke.MetaInfServices;
import org.opentest4j.TestAbortedException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@MetaInfServices(org.junit.jupiter.api.extension.Extension.class)
@Slf4j
public class TestExtension implements ExecutionCondition {

  private final Map<String, String> sysEnv = Collections.unmodifiableMap(System.getenv());

  @Override
  public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
    var springEnv = SpringExtension.getApplicationContext(context).getEnvironment();
    return ConditionEvaluationResult.enabled("The test will start soon ...");
  }

  private void checkNotEmpty(String name) {
    var value = this.sysEnv.get(name);
    if (value == null || value.isEmpty()) {
      throw new TestAbortedException("The value of '%s' is required.".formatted(name));
    }
  }

  private void checkValue(String name, String expected) {
    this.checkValue(name, List.of(expected));
  }

  private void checkValue(String name, List<String> expected) {
    var value = this.sysEnv.get(name);
    if (!Objects.isNull(value) && !expected.contains(value)) {
      throw new TestAbortedException("The value of '%s' must be %s.".formatted(name, value));
    }
  }
}
