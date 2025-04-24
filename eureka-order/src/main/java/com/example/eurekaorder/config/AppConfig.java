package com.example.eurekaorder.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    //@LoadBalanced注解为RestTemplate添加了服务发现和负载均衡能力，使其能够通过服务名（而非具体IP地址）调用服务。
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
