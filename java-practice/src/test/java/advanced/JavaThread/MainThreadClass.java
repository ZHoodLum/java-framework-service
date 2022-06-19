package advanced.JavaThread;

import org.junit.Test;

/**
 * @author：ZDY
 * @Date：Created on 2022/2/23 9:34
 * @Description: 开启线程的方式
 * 1、继承Thread类
 * 2、实现Runnable接口
 */

public class MainThreadClass {
//    @Autowired
//    ExtendThreadClass extendThreadClass;

    @Test
    public void mainTest() {
        ExtendThreadClass extendThreadClass = new ExtendThreadClass();
        extendThreadClass.start();

        ExtendThreadClassTwo extendThreadClassTwo = new ExtendThreadClassTwo();
        Thread thread = new Thread(extendThreadClassTwo);
        thread.start();
    }
}

/**
 * 继承Thread类
 */
class ExtendThreadClass extends Thread {
    public void run() {
        System.out.println("开启新线程ExtendThreadClass，执行任务....");
    }
}

/**
 * 实现Runnable方法
 */
class ExtendThreadClassTwo extends UserInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("开启新线程ExtendThreadClassTwo，执行任务....");
    }
}

class UserInterface{
    public void selectUser() {
        System.out.println("查询用户信息");
    }
}