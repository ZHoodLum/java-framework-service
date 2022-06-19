package com.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
public class GracefulShutdownListener implements ApplicationListener<ContextClosedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(GracefulShutdownListener.class);

    //是否立刻下线
//    private static String eurekaDownInstanceId = Terminal.getInstance().getEurekaFlag();
    private static String eurekaDownInstanceId = "";

    private static final String SPRIT = "/";
    private static final String SEND_INSTANCE_STATUS = "apps/{1}/{2}/status?value={3}";

    //存放eureka的实例信息
//    private List<Map<String, String>> eurekaInstanceMapInfo = Terminal.getInstance().getEurekaInstanceMapInfo();
    private List<Map<String, String>> eurekaInstanceMapInfo ;
//    private Map<String, Object> lastMap = EurekaInstanceConfig.getLastMap();
    private Map<String, Object> lastMap ;

    /**
     * 用于注销eureka中的服务  优雅的实现服务实例下线
     *
     * @param contextClosedEvent
     */
    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        logger.info("停止网关应用......");
        logger.info("开始下线网关应用在eureka中的实例......");

        StringBuffer stringBuffer = new StringBuffer();
        String eurekaZone = (String) lastMap.get("eureka.metadata.zone");
        stringBuffer.append(lastMap.get("eureka.metadata." + eurekaZone));
        stringBuffer.append(lastMap.get("eureka.serviceUrl.all"));
        String[] eurekaServerUrls = stringBuffer.toString().split(",");

        for (String serverUrl : eurekaServerUrls) {
            Status status = Status.DOWN;
            eurekaInstanceMapInfo.forEach(n -> {
                n.forEach((appName, instanceId) -> {
                    logger.info("Request Eureka Refresh InstanceStatus! appID:{}, instanceID:{}, status:{}", appName, instanceId, status);
                    sendInstanceStatusInfo(appName, instanceId, serverUrl, status);
                });
            });
        }
    }

    /**
     * 更新实例状态
     *
     * @param status
     */
    public void sendInstanceStatusInfo(String appName, String instanceId, String serverUrl, Status status) {

        if ("false".equals(eurekaDownInstanceId)) {
            logger.warn("UseFlag is false, can't use Eureka RESTful API! ");
            return;
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "";
        try {
            if (!serverUrl.endsWith(SPRIT)) {
                serverUrl = serverUrl + SPRIT;
            }
            url = serverUrl + SEND_INSTANCE_STATUS;
            restTemplate.put(url, null, appName, instanceId, status);
            logger.info("Success Refresh InstanceStatus! appID:{}, instanceID:{}, status:{}", appName, instanceId, status.getCode());
        } catch (Exception e) {
            logger.error("Error Refresh InstanceStatus! appID:{}, instanceID:{}, status:{} ,error reason:{}", appName, instanceId, status.getCode(), e.getMessage());
        }
    }

}
