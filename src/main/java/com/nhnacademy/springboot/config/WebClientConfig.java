package com.nhnacademy.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebClientConfig {

    // TODO 1 : RestTemplate 타입의 빈을 선언합니다.
    @Bean
    RestTemplate restTemplate() {
        return null;
    }
}
