package priv.noby.springsecurity3.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import priv.noby.springsecurity3.entity.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 配置授权异常(全局异常不可捕获授权异常)
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        //因为系统自带的编码过滤器处理优先级低于本过滤器，因此需自定义处理
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //利用jackson对象转换为json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(httpServletResponse.getWriter(), new ResponseResult<>(4030,e.getMessage(),"自定义授权异常"));
    }
}
