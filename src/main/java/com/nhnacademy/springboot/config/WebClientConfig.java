package com.nhnacademy.springboot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .build();
    }

    @Bean
    WebClient webClient() {
        return WebClient.builder().build();
    }
}
