package com.example.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    // 模拟服务崩溃，不发送 cancel 请求@PostConstruct
//    public void stopHeartbeatSimulation() {
//        new Thread(() -> {
//            try {
//                Thread.sleep(90000); // 启动后运行90秒
//                System.out.println("模拟 crash：order-service 不再发送心跳！");
//                Runtime.getRuntime().halt(0); // 模拟宕机，不发送 cancel 请求
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();// 启动线程
//    }
}
/**
 @PostConstruct
 作用：Spring容器初始化Bean后自动调用该方法
 类比：类似构造函数，但能保证依赖注入已完成
 new Thread(() -> {...})
 目的：创建独立线程执行模拟崩溃逻辑，避免阻塞主线程
 必要性：防止服务启动过程被阻塞
  * */