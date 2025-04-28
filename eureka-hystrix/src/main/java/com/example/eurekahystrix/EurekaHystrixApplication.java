package com.example.eurekahystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDiscoveryClient // 声明当前服务是Eureka的客户端
@EnableAspectJAutoProxy // 开启AOP
public class EurekaHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixApplication.class, args);
    }

}
