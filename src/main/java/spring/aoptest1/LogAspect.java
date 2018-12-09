package spring.aoptest1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:50 2018/10/29
 * @ Description：日志处理的切面类
 * 1 指明这个类是Aspect
 * 2 定义各种
 * @ Modified By：
 * @Version: $
 */
@Aspect
public class LogAspect {


    @Pointcut("execution(* spring.aoptest1.UserManagerImpl.addUser(..))")
    public void cut(){}

    @Before("cut()")
    public void before(){
        System.out.println("调用之前");
    }
    @After("cut()")
    public void after(){
        System.out.println("调用之后");
    }

}
