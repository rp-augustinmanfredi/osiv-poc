package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {

  private static final String RANDOM_URL = "http://localhost:8081/random";

  @Bean
  public WebClient webClient() {
    return WebClient.builder().baseUrl(RANDOM_URL).build();
  }
}
