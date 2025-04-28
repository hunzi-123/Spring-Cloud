package com.example.eurekahystrix.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
        // 使用 Spring Cloud LoadBalancerpublic
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
