package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/20
 * @Description:配置中心服务端config配置中心
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
          SpringApplication.run(ConfigCenterMain3344.class, args);
     }
}
