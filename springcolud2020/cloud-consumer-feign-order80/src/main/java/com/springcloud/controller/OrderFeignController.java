package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/2
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 测试使用open feign请求提供方
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/getPaymentByIdOpenFeign")
    public CommonResult<Payment> getPaymentByIdOpenFeign(@RequestParam("id") Integer id) {
        return paymentFeignService.getPaymentByIdOpenFeign(id);
    }

    /**
     * 测试openfeign超时请求
     * @return
     */
    @GetMapping(value = "/payment/paymentFeignTiemOut")
    public String paymentFeignTiemOut() {
        return paymentFeignService.paymentFeignTiemOut();
    }

}
