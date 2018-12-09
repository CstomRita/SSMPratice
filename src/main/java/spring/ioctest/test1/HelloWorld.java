package spring.ioctest.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aoptest1.User;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:48 2018/10/29
 * @ Description：IOC 的HelloWorld
 * @ Modified By：
 * @Version: $
 */
public class HelloWorld {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/springtest.xml");
        User user = (User) applicationContext.getBean("User");
        System.out.println(user.getUserName());

    }
}
