package com.springcloud;

import com.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/1/27
 */

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "cloud-provider-payment",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
        System.out.println("访问OrderMain80路径(消费者不需要通过端口访问啦！)：" + "http://127.0.0.1/consumer/");
    }
}
