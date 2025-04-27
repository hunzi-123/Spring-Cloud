package com.example.eurekaorder.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced // 加上这个注解，才能让 RestTemplate 通过服务名 + 负载均衡工作
    public RestTemplate restTemplate() {
            return new RestTemplate();
    }
}
//使用时只需通过 @Autowired 注入这个 RestTemplate 即可实现基于服务名的负载均衡调用。
