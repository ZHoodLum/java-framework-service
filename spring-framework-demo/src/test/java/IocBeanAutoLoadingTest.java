import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/14 15:04
 * @Description:Spring的自动装填功能  : 基座XML的自动装配
 */
public class IocBeanAutoLoadingTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("IocBeanAutoLoading.xml");

    @Test
    public void test(){
        GatewayInfo gatewayInfo = (GatewayInfo) applicationContext.getBean("gatewayInfo4");
        System.out.println(gatewayInfo);
    }
}
