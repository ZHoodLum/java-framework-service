package com.example.controller;

import com.example.service.GatewayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/15 16:39
 * @Description:控制器，控制层的组件使用的注解
 */
@Controller
//@Controller("gateway")
public class GatewayInfoController {
    @Autowired
    private GatewayInfoService gatewayInfoService;
}
