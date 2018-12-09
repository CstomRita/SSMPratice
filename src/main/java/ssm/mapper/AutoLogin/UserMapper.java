package ssm.mapper.AutoLogin;

import org.springframework.stereotype.Repository;
import ssm.pojo.User;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:57 2018/11/8
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

public interface UserMapper {
    User userlogin(String username);
}
