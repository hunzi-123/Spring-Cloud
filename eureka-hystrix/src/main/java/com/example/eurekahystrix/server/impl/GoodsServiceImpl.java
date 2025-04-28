package com.example.eurekahystrix.server.impl;

import com.example.eurekahystrix.server.GoodsService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoodsServiceImpl implements GoodsService {
    // 自动注入RestTemplate对象，用于发起远程HTTP请求（通过服务名调用其他微服务）

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "goodsService", fallbackMethod = "fallbackGetGoods")

    // 熔断注解,声明该方法使用 Resilience4j 的熔断功能
    public String getGoodsById(Integer id) {
        String url = "http://goods/goods/" + id; // 调用商品服务,第一个goods 是服务名，第二个goods是路由路径
// 使用RestTemplate发送GET请求，并将响应结果解析为String返回
        return restTemplate.getForObject(url, String.class);
    }

    // 调用失败后进入备用逻辑，保证系统稳定。
    public String fallbackGetGoods(Integer id, Throwable t) { // 降级方法; 参数1：方法的参数，参数2：异常信息
        return "【Resilience4j降级】商品服务不可用，请稍后重试。ID = " + id; // 返回一个自定义的降级提示信息
    }
}
