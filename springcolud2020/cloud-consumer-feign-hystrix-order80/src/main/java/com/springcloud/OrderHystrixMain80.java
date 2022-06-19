package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/4
 * @Description:
 */

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
          SpringApplication.run(OrderHystrixMain80.class, args);
          System.out.println("访问80地址：  http://localhost/consumer/payment ");
     }
}
