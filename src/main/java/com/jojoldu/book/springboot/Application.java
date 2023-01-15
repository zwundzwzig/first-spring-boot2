package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaAuditing
@EnableWebMvc
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
  }
}

