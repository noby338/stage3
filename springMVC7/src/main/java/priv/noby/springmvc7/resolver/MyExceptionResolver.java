package priv.noby.springmvc7.resolver;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import priv.noby.springmvc7.exception.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringMVC第二种方式处理异常(第一种直接在配置文件配置)
 *
 * 需生效还需把本类注入Spring容器
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    /**
     * 参数Exception：异常对象
     * 返回值ModelAndView：跳转到错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();

        if(e instanceof MyException){
            modelAndView.setViewName("/my_exception_error.jsp");
        }else if(e instanceof ClassCastException){
            modelAndView.setViewName("/class_cast_error.jsp");
        }else {
            modelAndView.setViewName("/default_error.jsp");
        }

        return modelAndView;
    }
}
