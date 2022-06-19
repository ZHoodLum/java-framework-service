package com.springcloud.service;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/2
 */

@Component
//证明使用的feign调用  value值代表寻找哪个微服务的名称
@FeignClient(value = "cloud-provider-payment")
public interface PaymentFeignService {
    //查询订单接口  调用的是提供方的controller接口
    @GetMapping(value = "/payment/getPaymentById")
    CommonResult<Payment> getPaymentByIdOpenFeign(@RequestParam("id") Integer id);

    //超时测试 openfeign
    @GetMapping(value = "/payment/timeout")
    String paymentFeignTiemOut();

}
