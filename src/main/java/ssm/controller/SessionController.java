package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:59 2018/11/7
 * @ Description：Session Controller
 * @ Modified By：
 * @Version: $
 */
@Controller
public class SessionController {

    private Logger logger = Logger.getLogger(SessionController.class);

    @RequestMapping("/session/create")
    @ResponseBody
    public String createSession(HttpServletResponse response, String username, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username",username);

        return session.getId();
    }

    @RequestMapping("/test/*")
    @ResponseBody
    public String getSession(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            logger.info(session.getAttribute("username"));
            return session.getAttribute("username").toString();
        }else {
            logger.info("null");
            return "null";
        }
    }
}
