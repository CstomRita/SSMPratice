package ssm.controller.AutoLogin;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import ssm.pojo.User;
import ssm.service.AutoLogin.UserLogin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:22 2018/11/8
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Controller
public class AutoLoginController {

    @Autowired
    private UserLogin userLogin;

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = userLogin.userLogin(username,password);
        if(user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(10*60);
            response.addCookie(cookie);
            return "success";
        }else {
            response.setStatus(HttpStatus.SC_BAD_REQUEST);
            return "login";
        }
    }

    @RequestMapping("get")
    @ResponseBody
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            User user = (User)session.getAttribute("user");
            return user.getUsername();
        }else{
            return  "null please login";
        }
    }
}
