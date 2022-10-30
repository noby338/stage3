package priv.noby.vuespringboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器
 */
public class LoginSessionInterceptor implements HandlerInterceptor {
    /**
     * 传统的 session 验证用户登录
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginSessionInterceptor.preHandle");
        //解决前端 OPTIONS 请求问题
        //post 或 put 请求跨域会发送一个 OPTIONS 请求，这个请通过了才会发送真正的 POST 请求，后端对这个请求单独放行
        if (request.getMethod().equals("OPTIONS")) {
            System.out.println("OPTIONS放行");
            return true;
        } else if (request.getSession().getAttribute("user") != null) {
            System.out.println("验证成功放行");
            return true;
        } else {
            System.out.println("未验证");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}


