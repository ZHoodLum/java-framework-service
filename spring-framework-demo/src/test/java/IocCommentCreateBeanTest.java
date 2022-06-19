import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/14 15:04
 * @Description:Spring的自动装填功能  : 使用注解创建Bean Bean的ID默认是首字母小写
 */
public class IocCommentCreateBeanTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("IocCommentCreateBean.xml");

    @Test
    public void test(){
        Object gatewayInfo = applicationContext.getBean("gatewayInfoController");
        System.out.println(gatewayInfo);
    }
}
