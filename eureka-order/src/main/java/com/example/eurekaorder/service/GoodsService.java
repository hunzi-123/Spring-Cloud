package com.example.eurekaorder.service;

import com.example.eurekaorder.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//定义一个Feign客户端接口，用于声明式调用"goods"服务的API
@FeignClient("goods")
public interface GoodsService {
    @RequestMapping("/goods/{id}")
    Goods findById(@PathVariable Integer id);
}
/*接口通过@FeignClient声明服务依赖，@RequestMapping定义HTTP端点路径，@PathVariable实现路径参
数绑定*/
