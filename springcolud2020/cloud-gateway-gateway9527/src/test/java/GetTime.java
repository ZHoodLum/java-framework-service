import java.time.ZonedDateTime;

/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/19
 * @Description:获取当前时区
 */


public class GetTime {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("当前时区" + zonedDateTime);
    }
}
