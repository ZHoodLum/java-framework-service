import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/11 7:16
 * @Description: bean生命周期过程
 */
public class iocBeanLifeCycleTest {
    //ApplicationContext 代表IOC容器
    //ClassPathXmlApplicationContext：当前应用XML配置文件在ClassPath下
    //根据Spring的配置文件得到IOC容器对象
    private ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("iocBeanLifeCycle.xml");

    /**
     * 获取容器中的组件
     */
    @Test
    public void gatewayTest(){
        //上面的容器已经帮我们创建好了！！！
        Object gateway = ioc.getBean("gatewayInfo1");
        System.out.println(gateway.toString());
        System.out.println("容器开始关闭");
        ioc.close();
    }

    @Test
    public void gatewayTest2(){
        //上面的容器已经帮我们创建好了！！！
        Object gateway = ioc.getBean("gatewayInfo2");
        System.out.println(gateway.toString());
        System.out.println("容器开始关闭");
        ioc.close();
    }
}
