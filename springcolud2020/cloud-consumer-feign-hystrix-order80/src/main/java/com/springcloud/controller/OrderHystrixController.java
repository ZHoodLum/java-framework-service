package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/4
 * @Description:
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
//全局异常处理
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok")
    public String paymentInfo_OK(@RequestParam("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //3秒钟以内就是正常的业务逻辑
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_TimeOut(@RequestParam("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }

    /**
     * 处理异常的方法
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "系统繁忙, 请稍候再试! OrderHystrixController_paymentInfo_TimeOutHandler,id：" + id + "秒";
    }


    /**
     * 异常处理模拟测试
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout2")
    @HystrixCommand
    public String paymentInfo_TimeOut2(@RequestParam("id") Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }


    /**
     * hystrix全局异常处理
     * 注意哈，这个方法 没有参数!!! 没有参数!!!   没有参数!!!
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "线程池：" + Thread.currentThread().getName() + "Hystrix全局异常处理_系统繁忙, 请稍候再试! OrderHystrixController_payment_Global_FallbackMethod";
    }
}
