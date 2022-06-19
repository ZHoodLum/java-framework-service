import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/22 9:08
 * @Description:
 */
public class PropertiesTest {
    GatewayInfo gatewayInfo = new GatewayInfo();

    @Test
    public void test() {
        Resource resource = new ClassPathResource("subApplication.properties");
        try {
            File file = resource.getFile();

            InputStream fileInputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInputStream);

            StringBuffer stringBuffer = new StringBuffer();
            gatewayInfo.setGatewayType(stringBuffer.append(gatewayInfo.getGatewayType()).append("," + "priperoties").toString());
            gatewayInfo.setGatewayId("132123");
            String[] subApp = {"AAA", "BBB"};
            StringJoiner stringJoiner = new StringJoiner(",");
            for (String str : subApp) {
                gatewayInfo.setGatewayId(String.valueOf(stringJoiner.add(properties.getProperty("cn.bosc." + str + ".tdCmSid") + "")));

            }

            System.out.println("对象存在值" + gatewayInfo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过项目resources配置文件subApplication.properties 获取大数据监控日志配置信息
     public void analysisEntityByProperties(SubApplicationDTO subApplicationDTO, String appName) {
     Resource resource = new ClassPathResource("subApplication.properties");
     if (!resource.exists()) {
     log.info("未找到大数据监控日志配置文件.....");
     return;
     }
     try {
     File file = resource.getFile();

     InputStream fileInputStream = new FileInputStream(file);
     Properties properties = new Properties();
     properties.load(fileInputStream);
     if (properties.size() < subApplicationDTO.toString().split(",").length) {
     log.info("大数据监控日志配置缺少值, 请检查如下参数是否缺失： " + subApplicationDTO.toString());
     return;
     }

     if (null != subApplicationDTO) {
     subApplicationDTO.setTdCmSid(subApplicationDTO.getTdCmSid() + "," + properties.getProperty("tdCmSid"));
     subApplicationDTO.setTdCmSn(subApplicationDTO.getTdCmSn() + "," + properties.getProperty("tdCmSn"));
     subApplicationDTO.setTdCsAid(subApplicationDTO.getTdCsAid() + "," + properties.getProperty("tdCsAid"));
     subApplicationDTO.setTdCsAn(subApplicationDTO.getTdCsAn() + "," + properties.getProperty("tdCsAn"));
     subApplicationDTO.setTdCsCid(subApplicationDTO.getTdCsCid() + "," + properties.getProperty("tdCsCid"));
     subApplicationDTO.setTdCsCn(subApplicationDTO.getTdCsCn() + "," + properties.getProperty("tdCsCn"));
     subApplicationDTO.setTrCid(subApplicationDTO.getTrCid() + "," + properties.getProperty("trCid"));
     subApplicationDTO.setTrCn(subApplicationDTO.getTrCn() + "," + properties.getProperty("trCn"));
     } else {
     subApplicationDTO.setTdCmSid(properties.getProperty("tdCmSid"));
     subApplicationDTO.setTdCmSn(properties.getProperty("tdCmSn"));
     subApplicationDTO.setTdCsAid(properties.getProperty("tdCsAid"));
     subApplicationDTO.setTdCsAn(properties.getProperty("tdCsAn"));
     subApplicationDTO.setTdCsCid(properties.getProperty("tdCsCid"));
     subApplicationDTO.setTdCsCn(properties.getProperty("tdCsCn"));
     subApplicationDTO.setTrCid(properties.getProperty("trCid"));
     subApplicationDTO.setTrCn(properties.getProperty("trCn"));
     }
     } catch (IOException e) {
     e.printStackTrace();
     }
     }

     //从apollo获取大数据监控日志信息
     //交易下游渠道应用标识 apollo的key值： "cn.bosc." + 下游系统名称 + ".tdCmSid"
     String tdCmSid = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".tdCmSid");
     //交易下游渠道应用名称 apollo的key值： "cn.bosc." + 下游系统名称 + ".tdCmSn"
     String tdCmSn = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".tdCmSn");
     //交易下游渠道子应用标识 apollo的key值： "cn.bosc." + 下游系统名称 + ".tdCsAid"
     String tdCsAid = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".tdCsAid");
     //交易下游渠道子应用名称 apollo的key值： "cn.bosc." + 下游系统名称 + ".tdCsAn"
     String tdCsAn = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".tdCsAn");
     //交易下游渠道微服务标识 apollo的key值： "cn.bosc." + 下游系统名称 + ".tdCsCid"
     String tdCsCid = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".tdCsCid");
     //交易下游渠道微服务名称 apollo的key值： "cn.bosc." + 下游系统名称 + ".tdCsCn"
     String tdCsCn = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".tdCsCn");
     //交易下游渠道交易类型（或服务场景码）标识 apollo的key值： "cn.bosc." + 下游系统名称 + ".trCid"
     String trCid = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".trCid");
     //交易下游渠道交易类型（或服务场景码）名称 apollo的key值： "cn.bosc." + 下游系统名称 + ".trCn"
     String trCn = BoscApplicationContextUtil.getApplicationContext().getEnvironment().getProperty("cn.bosc." + appName + ".trCn");


     */
}
