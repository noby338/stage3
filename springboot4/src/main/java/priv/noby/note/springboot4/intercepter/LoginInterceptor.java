package priv.noby.note.springboot4.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义拦截器（要使拦截器生效，必须配置配置类）
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.setContentType("test/html;charset=utf-8");
            response.getWriter().write("未登录");
//            request.setAttribute("msg", "请登录");
//            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }
        return true;
    }
}
