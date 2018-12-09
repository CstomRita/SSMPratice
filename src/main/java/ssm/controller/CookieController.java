package ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午11:26 2018/11/7
 * @ Description：cookie and session
 * @ Modified By：
 * @Version: $
 */
@Controller
public class CookieController {
    private Logger logger = Logger.getLogger(CookieController.class);

    @RequestMapping("cookie/creatcookie")
    @ResponseBody
    public String creatCookie(HttpServletRequest request,HttpServletResponse response) {
        Cookie cookie1 = new Cookie("username","cst");
        Cookie cookie2= new Cookie("password","1234");
        logger.info(request.getRequestURL());
        logger.info(request.getContextPath());
        logger.info(request.getServletPath());
        logger.info(request.getPathInfo());
        logger.info(request.getRequestURI());
        cookie1.setPath(request.getContextPath()+"/ett/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "1234";
    }

    @RequestMapping("cookie/getcookie")
    @ResponseBody
    public void getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            logger.info(cookie.getName() + " " +cookie.getValue());
        }
    }
    @RequestMapping("ett/*.jsp")
    @ResponseBody
    public void getCookie2(HttpServletRequest request) {
        logger.info(request.getRequestURI());
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            logger.info(cookie.getName() + " " +cookie.getValue());
        }
    }


}
