package com.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/5
 * @Description:
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "返回值 PaymentHystrixService _ paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "返回值 PaymentHystrixService _ paymentInfo_TimeOut";
    }
}
