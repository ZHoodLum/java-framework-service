package com.springcloud.controller;

import com.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/22
 * @Description:
 */


public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

}

