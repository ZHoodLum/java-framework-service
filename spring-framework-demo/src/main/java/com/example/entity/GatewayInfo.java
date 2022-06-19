package com.example.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/10 10:05
 * @Description:用于测试属性赋值方式
 */
@Data
@Builder
public class GatewayInfo {
    private String gatewayId;
    private String gatewayName;
    private String gatewayType;
    private String flag;

    private AgentInfo agentInfo;
    private List<AgentInfo> agentInfoList;
    private Map<String, AgentInfo> agentInfoMap;
    private Properties properties;

    public GatewayInfo() {
        System.out.println("开始创建对象....");
    }

    public GatewayInfo(String gatewayId, String gatewayName, String gatewayType, String flag, AgentInfo agentInfo, List<AgentInfo> agentInfoList, Map<String, AgentInfo> agentInfoMap, Properties properties) {
        System.out.println("开始创建对象....");
        this.gatewayId = gatewayId;
        this.gatewayName = gatewayName;
        this.gatewayType = gatewayType;
        this.flag = flag;
        this.agentInfo = agentInfo;
        this.agentInfoList = agentInfoList;
        this.agentInfoMap = agentInfoMap;
        this.properties = properties;
    }

    public GatewayInfo(AgentInfo agentInfo) {
        this.agentInfo = agentInfo;
    }

    public void initGatewayInfoBean() {
        System.out.println("初始化方法");
    }

    public void destoryGatewayInfoBean() {
        System.out.println("销毁方法");
    }
}
