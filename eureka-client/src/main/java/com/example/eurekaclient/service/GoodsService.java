package com.example.eurekaclient.service;

import com.example.eurekaclient.entity.Goods;

import java.util.List;

public interface GoodsService {
    // 查询所有商品
    List<Goods> findAll();// 根据id查询商品
    Goods findById(Integer id);
    // 添加商品
    void addGoods(Goods goods);// 根据id删除商品
    void deleteById(Integer id);
}
