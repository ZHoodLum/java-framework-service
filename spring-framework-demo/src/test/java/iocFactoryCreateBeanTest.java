import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/11 7:16
 * @Description: 通过工厂创建bean
 */
public class iocFactoryCreateBeanTest {
    //ApplicationContext 代表IOC容器
    //ClassPathXmlApplicationContext：当前应用XML配置文件在ClassPath下
    //根据Spring的配置文件得到IOC容器对象
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("iocFactoryCreateBean.xml");

    /**
     * 获取容器中的组件
     */
    @Test
    public void gatewayTest(){
        //上面的容器已经帮我们创建好了！！！
        Object gateway = ioc.getBean("gatewayInfo1");
        System.out.println(gateway.toString());
    }
    @Test
    public void gatewayTest1(){
        //上面的容器已经帮我们创建好了！！！
        Object gateway = ioc.getBean("gatewayInfo2");
        System.out.println(gateway.toString());
    }
    @Test
    public void gatewayTest2(){
        //上面的容器已经帮我们创建好了！！！
        Object gateway = ioc.getBean("gatewayInfo4");
        System.out.println(gateway.toString());
    }
    @Test
    public void gatewayTest3(){
        //上面的容器已经帮我们创建好了！！！
        Object gateway = ioc.getBean("SpringInterfaceFactoryBean");
        Object gateway2 = ioc.getBean("SpringInterfaceFactoryBean");
        System.out.println(gateway.toString());
        System.out.println("======也就是说，单例模式下只调用一次创建Bean，非单例模式调用几次就创建几次======");
        System.out.println(gateway.equals(gateway2));
        System.out.println(gateway==gateway2);
    }
}
