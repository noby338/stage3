package priv.noby.notespringboot.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 配置认证异常(全局异常不可捕获认证异常)
 */
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        //因为系统自带的编码过滤器处理优先级低于本过滤器，因此需自定义处理
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(e.getMessage());
        response.setStatus(401);
    }
}
