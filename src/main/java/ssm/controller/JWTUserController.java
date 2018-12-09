package ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.utils.JWTUtil;
import ssm.utils.returnTest1Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午9:04 2018/11/2
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@Controller
public class JWTUserController {


    private Logger logger = Logger.getLogger(JWTUserController.class);

    @RequestMapping("/jwt/login")
    @ResponseBody
    public Object login(Long userId,String passWord) throws Exception {
        if(userId == 12345 && passWord.equals("123")) {
            return new HashMap<String,String>(){{
                put("token",JWTUtil.createToken(userId));
            }};
        }else if(userId == 1234567 && passWord.equals("123")) {
            return new HashMap<String,String>(){{
                put("token",JWTUtil.createToken(userId));
            }};
        }else{
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping("/getMessage")
    @ResponseBody
    public String getMessage() {

        logger.info("getMessage");
        return "12314";
    }

    @RequestMapping(value = "/returntest", produces = "application/json")
    @ResponseBody
    public JSONObject returnTest(Integer index, HttpServletResponse response, HttpServletRequest request) {
        logger.info(request.getRequestURL());
        if(index == 1) return new JSONObject();
        response.setStatus(org.apache.http.HttpStatus.SC_BAD_REQUEST);
        JSONObject object = new JSONObject();
        object.put("error","error");
        return object;
    }

    @RequestMapping("/returntest1")
    public String returnTest1(Integer index, HttpServletResponse response, HttpServletRequest request) {
        throw new returnTest1Exception();
    }

}
