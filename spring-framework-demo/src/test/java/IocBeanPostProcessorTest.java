import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/13 6:59
 * @Description:Bean的后置处理器
 * 接口类是BeanPostProcessor
 */
public class IocBeanPostProcessorTest implements BeanPostProcessor {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("IocBeanPostProcessor.xml");

    @Test
    public void test(){
        GatewayInfo gatewayInfo = (GatewayInfo) applicationContext.getBean("gatewayInfo");
        System.out.println(gatewayInfo);
    }
}
