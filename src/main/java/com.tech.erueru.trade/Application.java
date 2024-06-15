package com.tech.erueru.trade;

import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class Application {

  public static void main(String[] args) throws Exception {
    try (var ctx = SpringApplication.run(Application.class, args)) {
      var app = ctx.getBean(Application.class);
      app.run(args);
    }
  }

  void run(String[] args) throws Exception {
    // 明らかに通常のSpringアプリケーションの用途とは異なるコードだが、メモリにさえ気をつければこれで問題なくトレードシステムを実現できる
    while (true) {
      log.info("rate check ...");
      TimeUnit.MILLISECONDS.sleep(100);
    }
  }
}
