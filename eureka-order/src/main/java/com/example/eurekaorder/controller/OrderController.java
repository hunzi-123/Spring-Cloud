package com.example.eurekaorder.controller;

import com.example.eurekaorder.entity.Order;
import com.example.eurekaorder.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("all")
    public Object findAll() {
        return orderService.findAll();
    }

    @RequestMapping("/{id}")
    public Object findById(@PathVariable Integer id) {
        return orderService.findById(id);
    }

    @PostMapping // 相当于 @RequestMapping(method = RequestMethod.POST)
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        orderService.deleteById(id);
    }
}
