package priv.noby.note.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器的使用
 *
 * HandlerInterceptor接口中的三个方法都是用default修饰，可不实现
 *
 * @author Noby
 * @since 2022/10/14
 */
public class MyHandlerInterceptor implements HandlerInterceptor {

    /**
     * 方法将在请求处理之前进行调用，该方法的返回值是布尔值Boolean类型的，
     * 当它返回为false 时，表示请求结束，后续的Interceptor 和Controller 都不会
     * 再执行；当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方
     * 法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyHandlerInterceptor.preHandle");
        //true表示放行
        return true;
    }

    /**
     * 该方法是在当前请求进行处理之后被视图对象返回之前调用，前提是preHandle 方法的返回值为
     * true 时才能被调用，且它会在DispatcherServlet 进行视图返回渲染之前被调
     * 用，所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象
     * 进行操作
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyHandlerInterceptor.postHandle");
    }

    /**
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图
     * 之后执行，前提是preHandle 方法的返回值为true 时才能被调用
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyHandlerInterceptor.afterCompletion");
    }
}
