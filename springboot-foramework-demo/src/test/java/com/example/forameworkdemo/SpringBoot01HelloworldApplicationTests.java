package com.example.forameworkdemo;

//import com.example.forameworkdemo.bean.Person;
import com.example.forameworkdemo.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * springboot单元测试类
 * 使用springboot单元测试去跑i项目 @RunWith(SpringRunner.class)
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads() {
        System.out.println(person);
        System.out.println();
    }

    /**
     * 测试容器中是否有helloService
     *
     * 最后返回的是false
     * Spring Boot里面没有Spring的配置文件，我们自己编写的配置文件，也不能自动识别；
     * 想让Spring的配置文件生效，加载进来  @ImportResource 标注在一个配置类上
     */
    @Test
    public void testHelloService() {
        //使用注解ImportResource
        boolean a = ioc.containsBean("helloService");
        //使用配置类的方式
        boolean b = ioc.containsBean("helloService02");
        System.out.println("事实证明到底有没有___a：" + a);
        System.out.println("事实证明到底有没有___b：" + b);
    }




}
