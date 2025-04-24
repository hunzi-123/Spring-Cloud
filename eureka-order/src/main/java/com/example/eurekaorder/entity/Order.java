package com.example.eurekaorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 标注该类为数据实体类
@AllArgsConstructor // 生成包含所有字段(全参)构造方法
@NoArgsConstructor // 生成无参构造方法
public class Order {
    // 订单id
    private Integer id;
    // 商品id
    private Integer gid;
    // 下单时间
    private String orderTime;
}
