package ssm.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:58 2018/11/8
 * @ Description：User
 * @ Modified By：
 * @Version: $
 */
@Component(value = "user")
public class User {
    private String username;
    private String password;
    public User(){
        System.out.println("User创建");
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
