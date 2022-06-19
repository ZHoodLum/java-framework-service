package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/2
 */

@SpringBootApplication
//切记  openfeign是使用在客户端的  也就是消费方
//使用feign  并开启
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
          SpringApplication.run(OrderFeignMain80.class, args);
          System.out.println("访问80地址：  http://localhost/consumer/payment ");
    }
}
