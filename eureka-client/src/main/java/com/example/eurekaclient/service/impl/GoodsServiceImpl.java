package com.example.eurekaclient.service.impl;

import com.example.eurekaclient.entity.Goods;
import com.example.eurekaclient.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    // 初始化商品集合
    private static final Map<Integer, Goods> goodsMap = new HashMap<>();static {
        goodsMap.put(1, new Goods(1, "手机", 1999.0));// 商品id为1，名称为手机，价格为1999.0
        goodsMap.put(2, new Goods(2, "平板电脑", 3999.0));// 商品id为2，名称为平板电脑，价格为3999.0
        goodsMap.put(3, new Goods(3, "耳机", 99.0));
        goodsMap.put(4, new Goods(4, "相机", 5999.0));
        goodsMap.put(5, new Goods(5, "鼠标", 99.0));
    }

    @Override
    public List<Goods> findAll() {
        return new ArrayList<>(goodsMap.values());// 返回商品集合
    }

    @Override
    public Goods findById(Integer id) {
        return goodsMap.get(id);// 返回商品
    }

    @Override
    public void addGoods(Goods goods) {
        goodsMap.put(goods.getId(), goods);// 添加商品
    }

    @Override
    public void deleteById(Integer id) {
        goodsMap.remove(id);// 删除商品
    }
}
