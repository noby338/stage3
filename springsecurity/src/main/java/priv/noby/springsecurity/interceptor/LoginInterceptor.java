package priv.noby.springsecurity.interceptor;

/**
 * 配置拦截器
 */
//public class LoginInterceptor implements HandlerInterceptor {
//    /**
//     * jwt 验证用户登录
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //解决前端 OPTIONS 请求问题
//        //post 请求跨域会发送一个 OPTIONS 请求，这个请通过了才会发送真正的 POST 请求，后端对这个请求单独放行
//        System.out.println("LoginInterceptor.preHandle");
//        if (request.getMethod().equals("OPTIONS")) {
//            System.out.println("OPTIONS");
//            return true;
//        }
//        String token = request.getHeader("token");
//
//        if (StringUtil.isNotEmpty(token) && JwtUtil.verify(token)) {
//            System.out.println("放行");
//            return true;
//        } else {
//            System.out.println("拦截");
//            throw new RuntimeException("login first");
//        }
//    }
//
//}


