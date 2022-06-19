package com.example.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/9 14:32
 * @Description:用于测试创建Bean对象
 */
@Data
@Builder
public class AgentInfo {
    private String agentIP;
    private String agentPort;
    private String agentName;
    private String isNormal;
    private Integer isNum;

    public AgentInfo() {
        System.out.println("AgentInfo对象创建成功......");
    }

    public AgentInfo(String agentIP, String agentPort, String agentName, String isNormal, Integer isNum) {
        System.out.println("四个参数的======有参构造器创建Bean.....");
        this.agentIP = agentIP;
        this.agentPort = agentPort;
        this.agentName = agentName;
        this.isNormal = isNormal;
        this.isNum = isNum;
    }

    public AgentInfo(String agentIP, String agentPort, String agentName, String isNormal) {
        System.out.println("四个参数的======有参构造器创建Bean.....");
        this.agentIP = agentIP;
        this.agentPort = agentPort;
        this.agentName = agentName;
        this.isNormal = isNormal;
    }

    public AgentInfo(String agentIP, String agentPort) {
        System.out.println("二个参数的======有参构造器创建Bean.....");
        this.agentIP = agentIP;
        this.agentPort = agentPort;
    }

    public AgentInfo(String agentName, Integer isNum) {
        System.out.println("二个参数的======冲在另一个构造器，参数类型不同，有参构造器创建Bean.....");
        this.agentName = agentName;
        this.isNum = isNum;
    }

}
