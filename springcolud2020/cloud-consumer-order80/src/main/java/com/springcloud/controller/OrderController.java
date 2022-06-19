package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/1/27
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    //    public static final String PAYMENT_URL = "http://localhost:8001";
//    地址更改为yml中服务的配置名称
//    spring:
//      application:
//        name: cloud-provider-payment
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    /**
     * postForObject方法
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        log.info("调用订单模块方法：payment/addPayment");
        return restTemplate.postForObject(PAYMENT_URL + "payment/addPayment", payment, CommonResult.class);
    }

    /**
     * postForEntity方法
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/addPayment2")
    public CommonResult<Payment> addPayment2(@RequestBody Payment payment) {
        log.info("调用订单模块方法：payment/addPayment");
        return restTemplate.postForEntity(PAYMENT_URL + "payment/addPayment", payment, CommonResult.class).getBody();
    }


    /***
     * 返回对象为响应体中数据转换成的对象 基本可以理解为JSON
     * getForObject方法
     * @param id
     * @return
     */
    @GetMapping("/payment/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Integer id) {
        log.info("调用订单模块方法：payment/getPaymentById");

        //请求方式一
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById?id=" + id, CommonResult.class);
        //请求方式二
        //return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById2/" + id, CommonResult.class);
    }


    /***
     * 返回对象为responseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等等
     * getForEntity
     * @param id
     * @return
     */
    @GetMapping("/payment/getPaymentById2")
    public CommonResult<Payment> getPaymentById2(@RequestParam("id") Integer id) {
        log.info("调用订单模块方法：payment/getPaymentById");

        //请求方式一
        ResponseEntity<CommonResult> resultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById?id=" + id, CommonResult.class);
        if (resultResponseEntity.getStatusCode().is2xxSuccessful()) {
            return resultResponseEntity.getBody();
        } else {
            return new CommonResult(444, "操作失败");
        }
    }


    /**
     * 验证手写负载均衡轮询代码
     *
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "payment/lb", String.class);
    }

    /**
     * 监控微服务交易链接
     * @return
     */
    // ====================> zipkin+sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
        return result;
    }


}

