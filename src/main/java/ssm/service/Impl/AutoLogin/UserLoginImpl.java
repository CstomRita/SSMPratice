package ssm.service.Impl.AutoLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.mapper.AutoLogin.UserMapper;
import ssm.pojo.User;
import ssm.service.AutoLogin.UserLogin;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:05 2018/11/8
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Service
public class UserLoginImpl  implements UserLogin {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User userLogin(String username, String password) {
        User user = userMapper.userlogin(username);
        if(password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
