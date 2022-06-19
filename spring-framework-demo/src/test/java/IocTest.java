import com.example.entity.AgentInfo;
import javafx.application.Application;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.fail;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/9 14:52
 * @Description:模拟从容器中获取组件信息
 * 技术细节问题：
 * 1、对象创建是在创建容器时创建的（ApplicationContext 容器一启动，对象就创建了）
 * 2、同一个组件在IOC容器中是单实例的，并且在容器启动完创建好的
 * 3、容器中没有这个组件，获取组件或抛出异常（org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'agentInfo11' available）
 * 4、IOC创建对象组件时，使用property标签时，会使用setter方法为javabean属性进行赋值
 * 5、javabean的属性名是由setter/getter方法决定的，那么赋值时，是set去掉后面那一串字母小写就是属性名
 *    例如：setAgentPort---对应的属性名--->agentPort
 * 6、从IOC容器中获取bean时，除了通过id值获取，还可以通过bean的类型获取。但如果同一个类型的bean在XML文件中配置了多个，则获取时会抛出异常，所以同一个类型的bean在容器中必须是唯一的。
 *    org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.example.entity.AgentInfo' available: expected single matching bean but found 2: agentInfo,agentInfo01
 *
 */
public class IocTest {
    //ApplicationContext 代表IOC容器
    //ClassPathXmlApplicationContext：当前应用XML配置文件在ClassPath下
    //根据Spring的配置文件得到IOC容器对象
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("iocTest.xml");

    /**
     * 获取容器中的组件
     */
    @Test
    public void agentTest(){
        //上面的容器已经帮我们创建好了！！！
        AgentInfo agentInfo = (AgentInfo) ioc.getBean("agentInfo");
        System.out.println(agentInfo.toString());

        System.out.println("=============");

        AgentInfo agentInfo2 = (AgentInfo) ioc.getBean("agentInfo11");
        System.out.println(agentInfo2);
    }

    /**
     * 获取容器中的组件 通过类型获取Bean
     */
    @Test
    public void agentTestByType(){
        AgentInfo agentInfo = (AgentInfo) ioc.getBean(AgentInfo.class);
        System.out.println(agentInfo.toString());
    }

    /**
     * 获取容器中的组件 通过类型获取Bean 具体到某个Bean的ID名
     */
    @Test
    public void agentTestByType01(){
        AgentInfo agentInfo = (AgentInfo) ioc.getBean("agentInfoP",AgentInfo.class);
        System.out.println(agentInfo.toString());
    }
}
