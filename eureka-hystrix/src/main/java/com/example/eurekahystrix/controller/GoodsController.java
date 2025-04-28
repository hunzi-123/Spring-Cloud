package com.example.eurekahystrix.controller;

import com.example.eurekahystrix.server.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") // 统一前缀
 public class GoodsController {
    @Autowired
    private GoodsService goodsService; // 商品服务接口

    @GetMapping("/goods/{id}") // 根据id查询商品
    public String testGoods(@PathVariable Integer id) { // @PathVariable使用路径变量来捕获商品ID
        return goodsService.getGoodsById(id); // 调用商品服务
    }
}
