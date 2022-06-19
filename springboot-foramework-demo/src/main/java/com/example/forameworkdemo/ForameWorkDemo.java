package com.example.forameworkdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;
//重写SpringApplication类
//import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2019/8/23
 * @SpringBootApplication来标注一个主程序类 说明这是一个springboot 应用
 * @**SpringBootConfiguration**:Spring Boot的配置类；标注在某个类上，表示这是一个Spring Boot的配置类；
 * @**Configuration**:配置类上来标注这个注解；   配置类 -----  配置文件；配置类也是容器中的一个组件；@Component
 * @**EnableAutoConfiguration**：开启自动配置功能；以前我们需要配置的东西，Spring Boot帮我们自动配置
 * @**EnableAutoConfiguration**告诉SpringBoot开启自动配置功能；这样自动配置才能生效；
 * spring Boot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，
 * 将这些值作为自动配置类导入到容器中，自动配置类就生效，帮我们进行自动配置工作；==以前我们需要自己配置的东西，自动配置类都帮我们；
 * J2EE的整体整合解决方案和自动配置都在spring-boot-autoconfigure-1.5.9.RELEASE.jar
 */

//@ImportResource(locations = {"classpath:beans.xml"})//加载自定义的配置bean.xml文件
@SpringBootApplication
public class ForameWorkDemo {

    public static void main(String[] args) {

        SpringApplication.run(ForameWorkDemo.class, args);
        System.out.println("启动成功");
    }

}

/**
 * 使用注解ImportResource  在容器启动时候加载容器
 * 但是 这种方式不可行的
 * 建议采用 在配置类中添加bean
 * //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名 @Bean
 * 详细信息见  config包下的MyAppConfig.java配置类
 */