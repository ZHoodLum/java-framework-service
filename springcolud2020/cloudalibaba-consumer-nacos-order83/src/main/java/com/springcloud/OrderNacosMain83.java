package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/24
 * @Description:轮询访问提供方9001 9002
 */

@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain83
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderNacosMain83.class,args);
        System.out.println("启动成功 OrderNacosMain83，访问地址： http://localhost:83/consumer/payment/nacos/13");
    }
}


