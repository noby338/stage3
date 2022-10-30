package priv.noby.vuespringboot.interceptor;

import com.github.pagehelper.util.StringUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import priv.noby.vuespringboot.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置拦截器
 */
public class LoginJwtInterceptor implements HandlerInterceptor {
    /**
     * jwt 验证用户登录
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println("token = " + token);
//        String info = request.getHeader("info");
//        System.out.println("info = " + info);

        //解决前端 OPTIONS 请求问题
        //post 或 put 请求跨域会发送一个 OPTIONS 请求，这个请通过了才会发送真正的 POST 请求，后端对这个请求单独放行
        if (request.getMethod().equals("OPTIONS")) {
            System.out.println("OPTIONS");
            return true;
        }else if (StringUtil.isNotEmpty(token) && JwtUtil.verify(token)) {
            System.out.println("验证通过放行");
            return true;
        } else {
            System.out.println("未授权拦截");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
            throw new RuntimeException("login first");
        }
    }
}


