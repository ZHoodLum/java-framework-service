package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/18
 * @Description:实时监控功能
 */

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
        System.out.println("访问实时监控地址： http://localhost:9001/hystrix ");
    }
}
