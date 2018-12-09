package spring.singleton.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:12 2018/11/10
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class InnvocationHandler implements InvocationHandler {
    public static ThreadLocal<User> threadLocal = new ThreadLocal<>();
    private  Object realObject;
    public InnvocationHandler(Object real) {
        this.realObject = real;
    }
    private Object getInstance() throws IllegalAccessException, InstantiationException {
        return this.realObject.getClass().newInstance();
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (threadLocal.get() == null) {
            System.out.println(Thread.currentThread().getName()+"threadLocal为空");
            User user = (User)getInstance();
            threadLocal.set(user);
        }
        User user = threadLocal.get();
         Object result = method.invoke(user,args);
         threadLocal.set(user);
         return result;
    }
}
