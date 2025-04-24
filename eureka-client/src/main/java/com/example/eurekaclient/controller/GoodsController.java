package com.example.eurekaclient.controller;

import com.example.eurekaclient.entity.Goods;
import com.example.eurekaclient.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("all")
    public List<Goods> findAll() {// 查询所有商品
        return goodsService.findAll();
    }
    // 根据id查询商品
    @GetMapping("/{id}") // 相当于 @RequestMapping(method = RequestMethod.GET)
    public Goods findById(@PathVariable Integer id) { //@PathVariable使用路径变量来捕获商品ID
        return goodsService.findById(id);
    }
    // 添加商品
    @PostMapping // 相当于 @RequestMapping(method = RequestMethod.POST)
    public void addGoods(@RequestBody Goods goods) { // 用于将请求体中的 JSON 数据绑定到方法参数上
        goodsService.addGoods(goods);
    }
    // 删除商品
    @DeleteMapping("/delete/{id}") // 相当于 @RequestMapping(method =RequestMethod.DELETE)
    public void deleteById(@PathVariable Integer id) { // 根据id删除商品
        goodsService.deleteById(id);
    }
}
