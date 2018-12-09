package ssm.service.AutoLogin;

import ssm.pojo.User;

public interface UserLogin {
    User userLogin(String username,String password);
}
