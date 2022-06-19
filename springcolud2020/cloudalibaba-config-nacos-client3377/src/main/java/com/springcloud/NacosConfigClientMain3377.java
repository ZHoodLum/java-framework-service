package com.springcloud;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/24
 * @Description:
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377
{
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class, args);
        System.out.println("启动成功 NacosConfigClientMain3377");
    }
}