package com.example.factory;


import com.example.entity.GatewayInfo;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/12 6:54
 * @Description:实例工厂
 */
public class InstanceFactory {

    private GatewayInfo getGateWayInfo(String gatewayInfoName) {
        System.out.println("实例工厂");
        GatewayInfo gatewayInfo1 = new GatewayInfo();
        gatewayInfo1.setGatewayId("2141241412515135asfas");
        gatewayInfo1.setGatewayName(gatewayInfoName);
        gatewayInfo1.setGatewayType("网关应用");
        return gatewayInfo1;
    }
}
