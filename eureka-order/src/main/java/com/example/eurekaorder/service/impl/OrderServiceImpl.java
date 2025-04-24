package com.example.eurekaorder.service.impl;

import com.example.eurekaorder.entity.Goods;
import com.example.eurekaorder.entity.Order;
import com.example.eurekaorder.service.GoodsService;
import com.example.eurekaorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    // 静态订单数据存储
    private static final Map<Integer, Order> ordersMap = new HashMap<>();static {
    // 初始化5个示例订单
        ordersMap.put(1, new Order(1, 1, "2020-01-01"));
        ordersMap.put(2, new Order(2, 2, "2020-01-02"));
        ordersMap.put(3, new Order(3, 3, "2020-01-03"));
        ordersMap.put(4, new Order(4, 4, "2020-01-04"));
        ordersMap.put(5, new Order(5, 5, "2020-01-05"));
    }
    // REST调用工具
//    @Autowired
//    private RestTemplate restTemplate;

    //Feign
    @Autowired
    private GoodsService goodsService;

    // 通过商品服务查询商品信息
//    private Goods findGoodsById(Integer gid) {
//        ResponseEntity<Goods> responseEntity =restTemplate.getForEntity("http://goods/goods/{id}", Goods.class, gid);
//        return responseEntity.getBody();
//    }

    // 获取所有订单及商品详情
    @Override
    public List findAll(){
        List orderList = new ArrayList();
        ordersMap.forEach((k, v) -> {
//            Goods goods = findGoodsById(v.getGid());
            Goods goods = goodsService.findById(v.getGid());
            Map<String, Object> order = new HashMap<>();
            order.put("订单id", k);
            order.put("商品id", v.getGid());
            order.put("商品名称", goods.getName());
            order.put("商品价格", goods.getPrice());
            order.put("下单时间", v.getOrderTime());
            orderList.add(order);
        });
        return orderList;
    }

    // 根据ID查询单个订单详情
    @Override
    public Object findById(Integer id) {
        Order order = ordersMap.get(id);
        if (order == null) {
            throw new RuntimeException("订单ID不存在: " + id);}
//        Goods goods = findGoodsById(order.getGid());
        Goods goods = goodsService.findById(order.getGid());
        if (goods == null) {
            throw new RuntimeException("商品服务不可用或商品ID不存在: " + order.getGid());
        }
        Map<String, Object> result = new HashMap<>();
        result.put("订单id", order.getId());
        result.put("商品id", order.getGid());
        result.put("商品名称", goods.getName());
        result.put("商品价格", goods.getPrice());
        result.put("下单时间", order.getOrderTime());
        return result;
    }

    // 添加新订单
    @Override
    public void addOrder(Order order) {
        ordersMap.put(order.getId(), order);
    }

    // 删除订单
    @Override
    public void deleteById(Integer id) {
        ordersMap.remove(id);
    }
}
