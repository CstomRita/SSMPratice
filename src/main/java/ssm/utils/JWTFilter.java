package ssm.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:20 2018/11/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class JWTFilter extends OncePerRequestFilter {
    private Logger logger = Logger.getLogger(JWTFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
       logger.info("begin filter");
        String[] notFilter = new String[]{"/jwt/login"};
        String request = httpServletRequest.getRequestURI();
        boolean doFilter = true;

        //request是否在notFilter中，如果在则不过滤
        for(String s : notFilter) {
            if(request.indexOf(s) != -1) {
                doFilter = false;
                break;
            }
        }
        //过滤
        if(doFilter) {
            try {
//                String authHeader = httpServletRequest.getHeader("Authorization");
//               JWTUtil.verifyToken(authHeader);
            }catch (Exception e){
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        //通过filter之后传递给应有的接口
        ResponseWrapper responseWrapper = new ResponseWrapper(httpServletResponse);
        filterChain.doFilter(httpServletRequest,responseWrapper);

        if(doFilter){
            JSONObject message = JSONObject.parseObject(responseWrapper.getTextContent());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("JWT","123123");
            jsonObject.put("message",message);
            httpServletResponse.getOutputStream().write(jsonObject.toJSONString().getBytes());

        }
    }
}
