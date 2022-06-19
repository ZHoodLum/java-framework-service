package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/2/1
 */


@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/payment/zk")
    public String paymentInfo() {
        log.info("调用订单模块方法：payment/zk");
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}

