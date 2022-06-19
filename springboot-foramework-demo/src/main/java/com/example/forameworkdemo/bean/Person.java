package com.example.forameworkdemo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2019/8/23
 * @de:获取配置文件信息
 * 使用批量注解 @Component    @ConfigurationProperties(prefix="person")
 * 或者单个注解 @value
 */
/**
 * //获取配置文件中的值 （1）、（2）  建议使用（1）的方法 ，批量注解即可  @value属于单个注解
 *
 * （1）、使用注解 @Component  @ConfigurationProperties
 * @Component
 * @ConfigurationProperties(prefix="person")
 *
 * （2）、使用注解 @Value 需要在每一个字段前加入注解，并且要保证@value中的值${Person.last-name}必须与配置文件一致
 * 不支持松散语法绑定  比如：配置文件 last-name(松散语法后是：lastName) ,@value中的值必须是@Value("${Person.last-name}")
 * 不支持语法校验功能  比如 ：使用注解@Validated 使用@value注入时，校验规则是不生效的
 * 不支持复杂的数据类型  比如说Map集合等等
 * 一般情况下都是获取配置文件中的某【一个】值时可以使用！！！！！！！！！！！！！！！
 * <bean class="Person">
 *         <property name="lastName" value="字面量/${key} 从环境变量、配置文件中获取值/#{Spel}"></property>
 * </bean>
 */
@Component
@ConfigurationProperties(prefix="person")
@Validated//数据校验功能 配合@Email等注解使用
@PropertySource(value={"classpath:person.properties"})//加载指定的配置文件，只用于propertie文件
public class Person {

    // @Value("${Person.last-name}")
    // 使用email校验功能  校验配置文件中  此字段是email格式
    //@Email
    private String lastName;
    // @Value("#{11*3}")
    private Integer age;
    // @Value("true")
    private Boolean boos;

    private Date birth;
    //@value是不支持负责数据类型的 一般获取一个值的时候使用 例子：见【 HelloController 】中的【 hello 】方法
    //@Value("#{Person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
//    private Dog dog;


    /**
     * 将配置文件汇中的每一个属性的值，映射到这个组件中
     * ConfigurationProperties  如果发现@ConfigurationPropertie不生效，有可能是项目的目录结构问题，
     * 可以通过@EnableConfigurationProperties(ConnectionSettings.class)  来明确指定需要用哪个实体类来装载配置信息。
     * Spring boot 1.5以上去除了location属性，可采用@Component的方式注册为组件， 然后使用@PropertySource来指定自定义的资源目录。
     * @ConfigurationProperties(prefix="person")  不支持 spel表达式
     * @Value  支持 spel 表达式
     * 二者可以同时使用
     *
     * 或者使用下面这个注解  但是 如果使用这个注解不能解决根本问题
     * 如果出现容器注入的功能  必须使用@Component注解（至少目前我发现的是这样的）
     * @EnableConfigurationProperties(Person.class)
     */




    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getBoos() {
        return boos;
    }
    public void setBoos(Boolean boos) {
        this.boos = boos;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public Map<String, Object> getMaps() {
        return maps;
    }
    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
    public List<Object> getLists() {
        return lists;
    }
    public void setLists(List<Object> lists) {
        this.lists = lists;
    }
//    public Dog getDog() {
//        return dog;
//    }
//    public void setDog(Dog dog) {
//        this.dog = dog;
//    }
    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boos=" + boos +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
//                ", dog=" + dog +
                '}';
    }
}
