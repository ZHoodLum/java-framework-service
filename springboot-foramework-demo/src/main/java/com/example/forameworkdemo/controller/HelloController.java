package com.example.forameworkdemo.controller;

import com.example.forameworkdemo.bean.Dog;
import com.example.forameworkdemo.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2019/8/23
 * 这个类的所有方法返回的数据直接写给浏览器
 * 如果是对象 就转换为json数据
 * @ResponseBody
 * @Controller
 * 使用@RestController 注解 ，可以代替上面两个注解，spring boot专属
 */
@RestController
public class HelloController {

    //使用value注解 场景
    @Value("${person.last-name}")
    private String userName = "spring boot";

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("当前用户名：" + userName);
        return "你好啊 hello world!!!" + userName;
    }
}
