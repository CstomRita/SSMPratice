package spring.singleton.proxy;

import org.springframework.stereotype.Component;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:09 2018/11/10
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Component(value = "user")
public class UserImpl implements User {
    public UserImpl() {
        System.out.println("UserImpl实现");
    }
    private String userName;
    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public void setUsername(String userName) {
      this.userName = userName;
    }

}
