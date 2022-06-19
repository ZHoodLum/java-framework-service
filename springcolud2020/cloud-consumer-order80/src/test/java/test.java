import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/2/2
 */


public class test {
    private static final Logger logger = LoggerFactory.getLogger(test.class);

    private static Properties prop = new Properties();

    private static  final  ThreadLocal<Properties> contextHolder = new ThreadLocal<>();

    static {
        try {
            String path = System.getProperty("user.dir");
//        	String fileName = path+"/esc.properties";
            File file = new File(path+"/esc.properties");
            if(logger.isInfoEnabled()) {
                logger.info("esc配置文件路径："+path+"/esc.properties");
            }
            prop.load(new InputStreamReader(new FileInputStream(file),"UTF-8"));
//            PropertiesTool.loadByClasspath(prop, "esc.properties");
//            PropertiesTool.loadByClasspathNullSafe(prop, "esc-local.properties");
        } catch (Exception e) {
            logger.error("初始化ESC配置失败", e);
        }

    }
    public static void main(String[] args) {
        //整型最大值
        System.out.println(Integer.MAX_VALUE);
        System.out.println(getValue("admin"));

    }

    public static String getValue(String key) {
        Properties properties = contextHolder.get();
        if(properties == null || properties.isEmpty()) {
            properties = prop;
        }
        return properties.getProperty(key);
    }
}
