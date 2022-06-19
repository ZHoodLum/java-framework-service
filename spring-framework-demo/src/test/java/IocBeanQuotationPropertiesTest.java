import com.example.entity.GatewayInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author：ZDY
 * @Date：Created on 2021/10/13 7:23
 * @Description:引用外部配置文件
 */
public class IocBeanQuotationPropertiesTest {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("IocBeanQuotationProperties.xml");

    @Test
    public void test(){
        DataSource druid = (DataSource) applicationContext.getBean("druid");
        System.out.println(druid);
    }
}
