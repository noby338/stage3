package priv.noby.notespringboot.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 配置授权异常(全局异常不可捕获授权异常)
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        //因为系统自带的编码过滤器处理优先级低于本过滤器，因此需自定义处理
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(e.getMessage());
        response.setStatus(403);
    }
}
