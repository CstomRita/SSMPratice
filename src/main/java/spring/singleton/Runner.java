package spring.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:59 2018/11/10
 * @ Description： IOC单例多线程测试类
 * @ Modified By：
 * @Version: $
 */
@ComponentScan(basePackages = {"spring.singleton"})
class AppliactionConfig {

}

public class Runner {
    static ApplicationContext context ;
    static {
        context = new AnnotationConfigApplicationContext(AppliactionConfig.class);
    }

static class MyThread implements Runnable{

    @Override
    public void run() {
        User user = (User) context.getBean(User.class);
        user.setPassword("12312");
        System.out.println(Thread.currentThread().getName()+ " " +user.hashCode());
        System.out.println(Thread.currentThread().getName()+ " " +user.getPassword());
    }
}
static class MyThread1 implements Runnable{

    @Override
    public void run() {
        User user = (User) context.getBean(User.class);
        System.out.println(Thread.currentThread().getName()+ " " +user.hashCode());
        System.out.println(Thread.currentThread().getName()+ " " +user.getPassword());
    }
}

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        Thread thread1 = new Thread(new MyThread1());
        thread.start();
        Thread.sleep(9000);
        thread1.start();
    }
}
