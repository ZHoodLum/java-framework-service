package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/4
 * @Description:
 */

@Component
//证明使用的feign调用  value值代表寻找哪个微服务的名称
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok")
    public String paymentInfo_OK(@RequestParam("id") Integer id);

    @GetMapping("/payment/hystrix/timeout")
    public String paymentInfo_TimeOut(@RequestParam("id") Integer id);

}
