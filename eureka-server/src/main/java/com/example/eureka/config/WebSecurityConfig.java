package com.example.eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 禁用 CSRF
                .authorizeHttpRequests(auth -> auth
                    // 下面这一行是否放行 /eureka/** 取决于你是否使用 Basic Auth保护
                    .requestMatchers("/eureka/**").permitAll() // ❗不想放行 就删掉
                    .anyRequest().authenticated()
                )
                // 同时启用表单登录和 Basic Auth
                .formLogin(Customizer.withDefaults()) // 启用默认表单登录
                .httpBasic(Customizer.withDefaults());// 启用 Basic Auth

        return http.build();
    }
}
