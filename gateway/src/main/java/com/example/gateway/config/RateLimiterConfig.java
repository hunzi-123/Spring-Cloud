package com.example.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver serviceKeyResolver() { // 限流维度解析器
        return exchange -> {
            // 以路径中的服务名作为限流维度：/order/** → "order"
            String path = exchange.getRequest().getURI().getPath();
            String service = path.split("/")[1]; // 获取 /order/xxx 中的 order
            return Mono.just(service);
        };
    }
}
