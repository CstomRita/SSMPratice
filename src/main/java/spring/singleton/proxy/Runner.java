package spring.singleton.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.lang.reflect.Proxy;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:59 2018/11/10
 * @ Description： IOC单例多线程ThreadLocal实现线程安全
 * @ Modified By：
 * @Version: $
 */
@ComponentScan(basePackages = {"spring.singleton.proxy"})
class AppliactionConfig {

}

public class Runner {
    static ApplicationContext context = new AnnotationConfigApplicationContext(AppliactionConfig.class);
    static User realUser = (User) context.getBean("user");
    static User user = (User) Proxy.newProxyInstance(realUser.getClass().getClassLoader(),realUser.getClass().getInterfaces(),new InnvocationHandler(realUser));
    static class MyThread implements Runnable{

        @Override
        public void run() {
            user.setUsername("12313");
            System.out.println(Thread.currentThread().getName() +" "+ user.getUsername());
        }
    }
    static class MyThread1 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " "+user.getUsername());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        Thread thread1 = new Thread(new MyThread1());
        thread.start();
        Thread.sleep(5000);
        thread1.start();
    }
}
