package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class ServerBlockGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) { // 重写 apply 方法
        return (exchange, chain) -> {
            String serviceName = config.getName(); // 第一个参数：服务名
            String flag = config.getValue();
            // 第二个参数：拦截标志（"1" or"0"）
            if ("1".equals(flag)) {
                // 返回拦截提示
                ServerHttpResponse response = exchange.getResponse(); // 获取响应对象
                response.setStatusCode(HttpStatus.OK); // 设置响应状态码
                // 设置响应内容类型为纯文本，UTF-8编码
                response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
                String message = serviceName + " 服务请求被拦截";
                // 构建并返回响应
                return response.writeWith(Mono.just( // // 使用Mono包装响应体
                        response.bufferFactory().wrap( // 创建响应缓冲区
                                message.getBytes(StandardCharsets.UTF_8) // 设置响应体，将消息转换为UTF-8字节数组
                        )
                ));
            }
            // 如果flag不是1，放行请求
            return chain.filter(exchange);
        };
    }
    @Override
    public String name() { // 指定过滤器名称
        return "ServerBlock"; // 在配置中使用ServerBlock作为过滤器标识
    }
}
