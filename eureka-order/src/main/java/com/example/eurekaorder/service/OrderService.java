package com.example.eurekaorder.service;

import com.example.eurekaorder.entity.Order;

import java.util.List;

public interface OrderService {
    // 查询所有订单
    List findAll();
    // 根据id查询订单
    Object findById(Integer id);
    // 添加订单
    void addOrder(Order order);
    // 根据id删除订单
    void deleteById(Integer id);
}
