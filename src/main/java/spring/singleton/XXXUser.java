package spring.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:58 2018/11/10
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Component
public class XXXUser {
    @Autowired
    private User user;

    public XXXUser() {
        System.out.println("XXXUser创建");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
