package ssm.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import ssm.utils.JWTUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:06 2018/11/2
 * @ Description：过滤JWT
 * @ Modified By：
 * @Version: $
 */
@Aspect
public class JWTAspect {

    private Logger logger = Logger.getLogger(JWTAspect.class);
    @Before("execution(* ssm.controller.*.*(..))"+"&& args(request)")
    public void before(HttpServletRequest request) {
        logger.info("执行before");
        String token = request.getHeader("Authorization");
        logger.info(token);
        JWTUtil.verifyToken(token);
    }

}
