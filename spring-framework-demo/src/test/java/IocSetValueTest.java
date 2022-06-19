import com.example.entity.AgentInfo;
import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/9 14:52
 * @Description:模拟从容器中获取组件信息 Bean对象赋值方式
 */
public class IocSetValueTest {
    //ApplicationContext 代表IOC容器
    //ClassPathXmlApplicationContext：当前应用XML配置文件在ClassPath下
    //根据Spring的配置文件得到IOC容器对象
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("iocSetValueTest.xml");

    /**
     * 获取容器中的组件
     */
    @Test
    public void gatewayTest(){
        //上面的容器已经帮我们创建好了！！！
        GatewayInfo gatewayInfo = (GatewayInfo) ioc.getBean("gatewayInfo9");
        System.out.println(gatewayInfo.toString());
    }

}
