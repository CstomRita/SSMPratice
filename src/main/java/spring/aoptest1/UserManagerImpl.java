package spring.aoptest1;

import org.springframework.stereotype.Service;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:58 2018/10/29
 * @ Description：用户管理实现类
 * @ Modified By：
 * @Version: $
 */
@Service
public class UserManagerImpl implements UserManager{
    @Override
    public void addUser(User user) {
        System.out.println("增加用户啦");
    }
}
