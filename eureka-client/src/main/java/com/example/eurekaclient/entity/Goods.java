package com.example.eurekaclient.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 标注该类为数据实体类
@AllArgsConstructor // 生成包含所有字段(全参)构造方法
@NoArgsConstructor // 生成无参构造方法
public class Goods {
    // 商品ID
    private Integer id;// 商品名称
    private String name;// 商品价格
    private Double price;
}
