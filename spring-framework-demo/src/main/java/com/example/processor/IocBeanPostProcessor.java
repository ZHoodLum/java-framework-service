package com.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/13 7:10
 * @Description:Bean后置处理器得实现类 ，然后将后置处理器注册到Bean配置文件中
 */
public class IocBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之前调用" + beanName + "-------postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置处理器" + beanName + "-------postProcessAfterInitialization");
        return bean;
//        return null;
    }

}
