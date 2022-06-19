package advanced.JavaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author：ZDY
 * @Date：Created on 2022/2/24 9:12
 * @Description:
 */
public class ExecutorServiceTest {
    public void executorTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
    }
}
