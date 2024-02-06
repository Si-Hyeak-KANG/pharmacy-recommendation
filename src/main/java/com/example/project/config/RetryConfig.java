package com.example.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@Configuration
public class RetryConfig {

    /* RetryTemplate을 사용하는 방법
    @Bean
    public RetryTemplate retryTemplate() {
        return new RetryTemplate();
    }*/
}
