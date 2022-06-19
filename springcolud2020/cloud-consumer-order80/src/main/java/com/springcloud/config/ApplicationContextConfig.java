package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/1/28
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
//手写负载均衡轮询请求 验证自己的写的代码是否有效，注释掉官方的代码﻿
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
