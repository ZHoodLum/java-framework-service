package com.example.factory;

import com.example.entity.GatewayInfo;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/12 7:18
 * @Description:实现Spring官方接口，作为一个工厂类 实现该接口FactoryBean的类 Sping会认为是一个工厂类
 */
public class SpringInterfaceFactoryBean implements FactoryBean<GatewayInfo> {

    /**
     * 返回值为创建一个对象
     * @return GatewayInfo
     * @throws Exception
     */
    @Override
    public GatewayInfo getObject() throws Exception {
        System.out.println("调用SpringInterfaceFactoryBean");
        GatewayInfo gatewayInfo1 = new GatewayInfo();
        gatewayInfo1.setGatewayId("2141241412515135asfas");
        gatewayInfo1.setGatewayName("SOA架构应用-SpringInterfaceFactoryBean");
        gatewayInfo1.setGatewayType("网关应用");
        return gatewayInfo1;
    }

    /**
     * 返回创建的对象的类型，Spring会自动调用这个方法来确认创建的对象是什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return GatewayInfo.class;
    }

    /**
     * 是否为单例模式
     * true:单例模式 IOC容器启动时不会创建Bean实例，在调用时，不管被调用几次，最终只是在第一次被调用时，创建一次Bean，并不会创建多次，也就是一次创建，多次使用
     * false:不是单例模式 IOC容器启动时不会创建Bean实例 即使XML中注册了Bean信息 也不会调用；也就是调用几次就创建几次
     * 也就是说，单例模式下只调用一次创建Bean，非单例模式调用几次就创建几次
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
