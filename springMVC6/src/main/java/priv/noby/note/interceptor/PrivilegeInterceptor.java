package priv.noby.note.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 *
 * 已登录放行
 * @author Noby
 * @since 2022/10/14
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PrivilegeInterceptor.preHandle");
        if (request.getSession().getAttribute("user") != null) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
    }
}
