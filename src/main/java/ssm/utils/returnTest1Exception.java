package ssm.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:29 2018/11/6
 * @ Description：自定义异常
 * @ Modified By：
 * @Version: $
 */
@ResponseStatus(value = HttpStatus.IM_USED,reason = "error")
public class returnTest1Exception extends RuntimeException {
}
