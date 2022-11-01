package priv.noby.springsecurity3.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import priv.noby.springsecurity3.entity.ResponseResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置认证异常(全局异常不可捕获认证异常)
 */
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //因为系统自带的编码过滤器处理优先级低于本过滤器，因此需自定义处理
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        //利用jackson对象转换为json
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(httpServletResponse.getWriter(), new ResponseResult<>(4010, e.getMessage(), "自定义认证异常"));
    }
}
