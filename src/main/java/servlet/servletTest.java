package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:32 2018/11/9
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class servletTest implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("创建");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("12313");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

